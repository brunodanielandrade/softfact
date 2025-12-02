package br.edu.uniesp.softfact.boundaries.rest.stack;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackResponse;
import br.edu.uniesp.softfact.application.mappers.StackCreateMapper;
import br.edu.uniesp.softfact.application.mappers.StackResponseMapper;
import br.edu.uniesp.softfact.infra.stack.StackRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stacks")
@RequiredArgsConstructor
public class StackCommandController {

    private final StackRepository repository;
    private final StackCreateMapper createMapper;
    private final StackResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<StackResponse> criar(@Valid @RequestBody StackCreateRequest request) {
        var entity = createMapper.toEntity(request);
        var saved = repository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StackResponse> atualizar(@PathVariable Long id, @Valid @RequestBody StackCreateRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNome(request.nome());
                    existing.setCategoria(request.categoria());
                    existing.setDescricao(request.descricao());
                    return repository.save(existing);
                })
                .map(responseMapper::toResponse)
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
