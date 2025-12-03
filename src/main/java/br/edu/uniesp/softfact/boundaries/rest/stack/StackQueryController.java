package br.edu.uniesp.softfact.boundaries.rest.stack;

import br.edu.uniesp.softfact.application.stack.StackResponse;
import br.edu.uniesp.softfact.infra.stack.StackEntity;
import br.edu.uniesp.softfact.infra.stack.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stacks")
@RequiredArgsConstructor
public class StackQueryController {

    private final StackRepository repository;

    @GetMapping
    public List<StackResponse> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public StackResponse buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    private StackResponse toResponse(StackEntity entity) {
        return new StackResponse(
                entity.getId(),
                entity.getNome(),
                entity.getCategoria(),
                entity.getDescricao(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}