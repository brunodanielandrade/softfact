package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.infra.stack.StackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StackCreateMapper {
    StackEntity toEntity(StackCreateRequest request);
}