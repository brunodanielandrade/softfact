package br.edu.uniesp.softfact.infra.aluno;

import br.edu.uniesp.softfact.application.aluno.AlunoCreateRequest;
import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.application.aluno.AlunoUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.UpdateAlunoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateAlunoServiceImpl implements UpdateAlunoService {

    private final AlunoRepository repository;

    @Override
    public AlunoResponse criar(AlunoCreateRequest request) {
        var entity = AlunoEntity.builder()
                .nome(request.nome())
                .email(request.email())
                .telefone(request.telefone())
                .curso(request.curso())
                .matricula(request.matricula())
                .periodo(request.periodo())
                .build();
        
        var saved = repository.save(entity);
        return new AlunoResponse(
                saved.getId(),
                saved.getNome(),
                saved.getEmail(),
                saved.getTelefone(),
                saved.getCurso(),
                saved.getMatricula(),
                saved.getPeriodo(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }

    @Override
    public AlunoResponse atualizar(Long id, AlunoUpdateRequest request) {
        var existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com ID: " + id));

        if (request.nome() != null) existente.setNome(request.nome());
        if (request.email() != null) existente.setEmail(request.email());
        if (request.telefone() != null) existente.setTelefone(request.telefone());
        if (request.curso() != null) existente.setCurso(request.curso());
        if (request.matricula() != null) existente.setMatricula(request.matricula());
        if (request.periodo() != null) existente.setPeriodo(request.periodo());

        var atualizado = repository.save(existente);
        return new AlunoResponse(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getEmail(),
                atualizado.getTelefone(),
                atualizado.getCurso(),
                atualizado.getMatricula(),
                atualizado.getPeriodo(),
                atualizado.getCreatedAt(),
                atualizado.getUpdatedAt()
        );
    }

    @Override
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}