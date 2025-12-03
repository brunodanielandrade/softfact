package br.edu.uniesp.softfact.boundaries.rest.stack;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackResponse;
import br.edu.uniesp.softfact.infra.stack.StackEntity;
import br.edu.uniesp.softfact.infra.stack.StackRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stacks")
@RequiredArgsConstructor
public class StackCommandController {

    private final StackRepository repository;

    @PostMapping
    public StackResponse criar(@RequestBody @Valid StackCreateRequest request) {
        var entity = StackEntity.builder()
                .nome(request.nome())
                .categoria(request.categoria())
                .descricao(request.descricao())
                .build();
        
        var saved = repository.save(entity);
        return new StackResponse(
                saved.getId(),
                saved.getNome(),
                saved.getCategoria(),
                saved.getDescricao(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }

    @PutMapping("/{id}")
    public StackResponse atualizar(@PathVariable Long id, @RequestBody StackCreateRequest request) {
        var existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stack não encontrada: " + id));
        
        if (request.nome() != null) existente.setNome(request.nome());
        if (request.categoria() != null) existente.setCategoria(request.categoria());
        if (request.descricao() != null) existente.setDescricao(request.descricao());
        
        var atualizado = repository.save(existente);
        return new StackResponse(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getCategoria(),
                atualizado.getDescricao(),
                atualizado.getCreatedAt(),
                atualizado.getUpdatedAt()
        );
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Stack não encontrada: " + id);
        }
        repository.deleteById(id);
    }
}