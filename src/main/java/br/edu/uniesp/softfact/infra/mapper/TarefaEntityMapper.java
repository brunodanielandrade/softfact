package br.edu.uniesp.softfact.infra.mapper;


import br.edu.uniesp.softfact.application.tarefa.TarefaCreateRequest;
import br.edu.uniesp.softfact.application.tarefa.TarefaResponse;
import br.edu.uniesp.softfact.application.tarefa.TarefaUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.tarefa.Tarefa;
import br.edu.uniesp.softfact.infra.tarefa.TarefaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TarefaEntityMapper {

    Tarefa toDomain(TarefaCreateRequest request);
    Tarefa toDomain(TarefaUpdateRequest request);
    TarefaEntity toEntity(Tarefa domain);

    TarefaResponse toResponse(TarefaEntity entity);

    void updateEntityFromDomain(Tarefa domain, @MappingTarget TarefaEntity entity);
}


