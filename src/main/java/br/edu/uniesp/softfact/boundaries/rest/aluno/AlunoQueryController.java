package br.edu.uniesp.softfact.boundaries.rest.aluno;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.domain.aluno.AlunoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoQueryController {

    private final AlunoQueryService service;

    @GetMapping
    public List<AlunoResponse> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id) {
        return service.findById(id);
    }
}