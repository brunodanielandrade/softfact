package br.edu.uniesp.softfact.infra.tarefa;



import br.edu.uniesp.softfact.application.tarefa.TarefaCreateRequest;
import br.edu.uniesp.softfact.application.tarefa.TarefaResponse;
import br.edu.uniesp.softfact.application.tarefa.TarefaUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.tarefa.Tarefa;
import br.edu.uniesp.softfact.domain.aluno.tarefa.UpdateTarefaService;
import br.edu.uniesp.softfact.infra.mapper.TarefaEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateTarefaServiceImpl implements UpdateTarefaService {

    private final TarefaRepository repository;
    private final TarefaEntityMapper mapper;

    @Override
    public TarefaResponse create(TarefaCreateRequest request) {
        Tarefa domain = mapper.toDomain(request);

        TarefaEntity entity = mapper.toEntity(domain);
        TarefaEntity saved = repository.save(entity);

        return mapper.toResponse(saved);
    }

    @Override
    public TarefaResponse update(TarefaUpdateRequest request) {

        TarefaEntity existente = repository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada: " + request.getId()));

        Tarefa domain = mapper.toDomain(request);

        mapper.updateEntityFromDomain(domain, existente);

        TarefaEntity atualizado = repository.save(existente);

        return mapper.toResponse(atualizado);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
