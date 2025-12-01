package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.aluno.AlunoUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoUpdateMapper {

    @Mapping(target = "stacks", ignore = true)
    @Mapping(target = "certificados", ignore = true)
    @Mapping(target = "id", ignore = true)
    Aluno toDomain(AlunoUpdateRequest request);
}
