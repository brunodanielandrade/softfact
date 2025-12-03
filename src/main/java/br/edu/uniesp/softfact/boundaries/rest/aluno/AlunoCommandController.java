package br.edu.uniesp.softfact.boundaries.rest.aluno;

import br.edu.uniesp.softfact.application.aluno.AlunoCreateRequest;
import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.application.aluno.AlunoUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.UpdateAlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoCommandController {

    private final UpdateAlunoService service;

    @PostMapping
    public AlunoResponse criar(@RequestBody @Valid AlunoCreateRequest request) {
        return service.criar(request);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AlunoUpdateRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
