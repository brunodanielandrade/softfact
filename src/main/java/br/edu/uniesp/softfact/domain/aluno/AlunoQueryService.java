package br.edu.uniesp.softfact.domain.aluno;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;

import java.util.List;

public interface AlunoQueryService {
    List<AlunoResponse> findAll();
    AlunoResponse findById(Long id);
}
