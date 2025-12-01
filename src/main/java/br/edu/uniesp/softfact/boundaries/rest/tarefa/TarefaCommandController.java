package br.edu.uniesp.softfact.boundaries.rest.tarefa;

import br.edu.uniesp.softfact.application.tarefa.TarefaCreateRequest;
import br.edu.uniesp.softfact.application.tarefa.TarefaResponse;
import br.edu.uniesp.softfact.application.tarefa.TarefaUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.tarefa.UpdateTarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaCommandController {

    private final UpdateTarefaService service;

    @PostMapping
    public TarefaResponse criar(@Valid @RequestBody TarefaCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public TarefaResponse atualizar(@PathVariable Long id,
                                    @Valid @RequestBody TarefaUpdateRequest request) {
        request.setId(id);
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}
