package br.edu.uniesp.softfact.domain.aluno;

import br.edu.uniesp.softfact.application.aluno.AlunoCreateRequest;
import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.application.aluno.AlunoUpdateRequest;

public interface UpdateAlunoService {
    AlunoResponse criar(AlunoCreateRequest request);
    AlunoResponse atualizar(Long id, AlunoUpdateRequest request);
    void excluir(Long id);
}
