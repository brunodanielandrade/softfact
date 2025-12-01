package br.edu.uniesp.softfact.domain.aluno.tarefa;



import br.edu.uniesp.softfact.application.tarefa.TarefaCreateRequest;
import br.edu.uniesp.softfact.application.tarefa.TarefaUpdateRequest;
import br.edu.uniesp.softfact.application.tarefa.TarefaResponse;

public interface UpdateTarefaService {

    TarefaResponse create(TarefaCreateRequest request);

    TarefaResponse update(TarefaUpdateRequest request);

    void delete(Long id);
}
