package br.edu.uniesp.softfact.boundaries.rest.projeto;

import br.edu.uniesp.softfact.infra.aluno.AlunoRepository;
import br.edu.uniesp.softfact.infra.projeto.ProjetoEntity;
import br.edu.uniesp.softfact.infra.projeto.ProjetoRepository;
import br.edu.uniesp.softfact.infra.stack.StackRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoRepository repository;
    private final AlunoRepository alunoRepository;
    private final StackRepository stackRepository;

    @GetMapping
    public List<ProjetoEntity> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoEntity> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProjetoEntity> criar(@RequestBody Map<String, Object> request) {
        var projeto = ProjetoEntity.builder()
                .nome((String) request.get("nome"))
                .descricao((String) request.get("descricao"))
                .dataInicio(LocalDate.parse((String) request.get("dataInicio")))
                .dataFim(request.get("dataFim") != null ? LocalDate.parse((String) request.get("dataFim")) : null)
                .build();

        if (request.get("alunoIds") != null) {
            @SuppressWarnings("unchecked")
            var alunoIds = (List<Integer>) request.get("alunoIds");
            var alunos = alunoRepository.findAllById(alunoIds.stream().map(Long::valueOf).toList());
            projeto.getAlunos().addAll(alunos);
        }

        if (request.get("stackIds") != null) {
            @SuppressWarnings("unchecked")
            var stackIds = (List<Integer>) request.get("stackIds");
            var stacks = stackRepository.findAllById(stackIds.stream().map(Long::valueOf).toList());
            projeto.getStacks().addAll(stacks);
        }

        var saved = repository.save(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoEntity> atualizar(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        return repository.findById(id)
                .map(existing -> {
                    if (request.get("nome") != null) {
                        existing.setNome((String) request.get("nome"));
                    }
                    if (request.get("descricao") != null) {
                        existing.setDescricao((String) request.get("descricao"));
                    }
                    if (request.get("dataInicio") != null) {
                        existing.setDataInicio(LocalDate.parse((String) request.get("dataInicio")));
                    }
                    if (request.get("dataFim") != null) {
                        existing.setDataFim(LocalDate.parse((String) request.get("dataFim")));
                    }
                    
                    if (request.get("alunoIds") != null) {
                        existing.getAlunos().clear();
                        @SuppressWarnings("unchecked")
                        var alunoIds = (List<Integer>) request.get("alunoIds");
                        var alunos = alunoRepository.findAllById(alunoIds.stream().map(Long::valueOf).toList());
                        existing.getAlunos().addAll(alunos);
                    }
                    
                    if (request.get("stackIds") != null) {
                        existing.getStacks().clear();
                        @SuppressWarnings("unchecked")
                        var stackIds = (List<Integer>) request.get("stackIds");
                        var stacks = stackRepository.findAllById(stackIds.stream().map(Long::valueOf).toList());
                        existing.getStacks().addAll(stacks);
                    }
                    
                    return repository.save(existing);
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}