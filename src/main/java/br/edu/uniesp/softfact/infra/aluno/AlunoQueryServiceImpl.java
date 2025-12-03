package br.edu.uniesp.softfact.infra.aluno;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.domain.aluno.AlunoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoQueryServiceImpl implements AlunoQueryService {

    private final AlunoRepository repository;

    @Override
    public List<AlunoResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public AlunoResponse findById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    private AlunoResponse toResponse(AlunoEntity entity) {
        return new AlunoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getCurso(),
                entity.getMatricula(),
                entity.getPeriodo(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}