package org.example.mydbcontroller.mapper;

import org.example.mydbcontroller.dto.ProjectAgentCreateDto;
import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProjectAgentMapper {

      ProjectAgentMapper INSTANCE = Mappers.getMapper(ProjectAgentMapper.class);
    ProjectAgent fromDto(ProjectAgentCreateDto dto);



    }

