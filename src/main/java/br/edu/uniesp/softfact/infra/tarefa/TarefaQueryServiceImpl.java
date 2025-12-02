package br.edu.uniesp.softfact.infra.tarefa;
import br.edu.uniesp.softfact.domain.aluno.tarefa.Tarefa;
import br.edu.uniesp.softfact.domain.aluno.tarefa.TarefaQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaQueryServiceImpl implements TarefaQueryService {

    private final TarefaRepository repository;

    public TarefaQueryServiceImpl(TarefaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tarefa> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Tarefa findById(Long id) {
        return repository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }

    private Tarefa toDomain(TarefaEntity entity) {
        return new Tarefa(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescricao(),
                entity.getDataEntrega(),
                entity.getStatus().name().equals("CONCLUIDA")
        );
    }
}