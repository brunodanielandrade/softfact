package br.edu.uniesp.softfact.infra.tarefa;

import br.edu.uniesp.softfact.application.tarefa.TarefaCreateRequest;
import br.edu.uniesp.softfact.application.tarefa.TarefaResponse;
import br.edu.uniesp.softfact.application.tarefa.TarefaUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.tarefa.UpdateTarefaService;
import br.edu.uniesp.softfact.infra.aluno.AlunoRepository;
import br.edu.uniesp.softfact.infra.projeto.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateTarefaServiceImpl implements UpdateTarefaService {

    private final TarefaRepository repository;
    private final ProjetoRepository projetoRepository;
    private final AlunoRepository alunoRepository;

    @Override
    public TarefaResponse create(TarefaCreateRequest request) {
        var entity = new TarefaEntity();
        entity.setTitulo(request.titulo());
        entity.setDescricao(request.descricao());
        entity.setDataEntrega(request.dataEntrega());
        entity.setObservacoes(request.observacoes());
        
        if (request.prioridade() != null) {
            entity.setPrioridade(request.prioridade());
        }
        
        var projeto = projetoRepository.findById(request.projetoId())
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado: " + request.projetoId()));
        entity.setProjeto(projeto);
        
        var responsavel = alunoRepository.findById(request.responsavelId())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado: " + request.responsavelId()));
        entity.setResponsavel(responsavel);
        
        var saved = repository.save(entity);
        
        return new TarefaResponse(
                saved.getId(),
                saved.getTitulo(),
                saved.getDescricao(),
                saved.getDataEntrega(),
                saved.getStatus(),
                saved.getPrioridade(),
                saved.getProjeto().getId(),
                saved.getResponsavel().getNome(),
                saved.getObservacoes(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }

    @Override
    public TarefaResponse update(TarefaUpdateRequest request) {
        var existente = repository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada: " + request.getId()));

        if (request.getTitulo() != null && !request.getTitulo().trim().isEmpty()) {
            existente.setTitulo(request.getTitulo());
        }
        if (request.getDescricao() != null) {
            existente.setDescricao(request.getDescricao());
        }
        if (request.getDataEntrega() != null) {
            existente.setDataEntrega(request.getDataEntrega());
        }
        if (request.getStatus() != null && !request.getStatus().trim().isEmpty()) {
            existente.setStatus(br.edu.uniesp.softfact.shared.enums.StatusTarefa.valueOf(request.getStatus().toUpperCase()));
        }
        if (request.getPrioridade() != null) {
            existente.setPrioridade(request.getPrioridade());
        }
        if (request.getObservacoes() != null) {
            existente.setObservacoes(request.getObservacoes());
        }
        
        if (request.getProjetoId() != null) {
            var projeto = projetoRepository.findById(request.getProjetoId())
                    .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado: " + request.getProjetoId()));
            existente.setProjeto(projeto);
        }
        
        if (request.getAlunoId() != null) {
            var responsavel = alunoRepository.findById(request.getAlunoId())
                    .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado: " + request.getAlunoId()));
            existente.setResponsavel(responsavel);
        }
        
        var atualizado = repository.save(existente);
        
        return new TarefaResponse(
                atualizado.getId(),
                atualizado.getTitulo(),
                atualizado.getDescricao(),
                atualizado.getDataEntrega(),
                atualizado.getStatus(),
                atualizado.getPrioridade(),
                atualizado.getProjeto().getId(),
                atualizado.getResponsavel().getNome(),
                atualizado.getObservacoes(),
                atualizado.getCreatedAt(),
                atualizado.getUpdatedAt()
        );
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
