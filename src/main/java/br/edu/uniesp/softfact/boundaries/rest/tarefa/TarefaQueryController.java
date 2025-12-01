package br.edu.uniesp.softfact.boundaries.rest.tarefa;
import br.edu.uniesp.softfact.domain.aluno.tarefa.Tarefa;
import br.edu.uniesp.softfact.domain.aluno.tarefa.TarefaQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tarefas")
public class TarefaQueryController {
    private final TarefaQueryService tarefaQueryService;

    public TarefaQueryController(TarefaQueryService tarefaQueryService) {
        this.tarefaQueryService = tarefaQueryService;
    }

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaQueryService.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa findById(@PathVariable Long id) {
        return tarefaQueryService.findById(id);
    }
}
