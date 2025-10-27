package org.example.mydbcontroller.service;

import org.example.mydbcontroller.criteria.BaseCriteria;
import org.example.mydbcontroller.mapper.ProjectAgentMapper;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentCreateDto;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentDto;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentUpdateDto;
import org.example.mydbcontroller.mapper.ProjectAgentMapperOld;
import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.example.mydbcontroller.repository.ProjectAgentRepository;
import org.example.mydbcontroller.service.base.AbstractService;
import org.example.mydbcontroller.service.base.CrudService;
import org.example.mydbcontroller.validator.ProjectAgentValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectAgentService extends AbstractService<ProjectAgentRepository, ProjectAgentMapperOld,ProjectAgentValidator>
        implements CrudService<ProjectAgentDto, ProjectAgentCreateDto, ProjectAgentUpdateDto, BaseCriteria,String> {

    protected ProjectAgentService(ProjectAgentRepository repository, ProjectAgentMapperOld mapper, ProjectAgentValidator validator) {
        super(repository, mapper, validator);
    }


    @Override
    public ProjectAgentDto create(ProjectAgentCreateDto dto) {
        validator.validateOnCreate(dto);
//        ProjectAgent projectAgent = mapper.fromDto(dto);
        ProjectAgent projectAgent = ProjectAgentMapper.INSTANCE.fromDto(dto);
        return mapper.toDto(repository.save(projectAgent));
    }

    @Override
    public ProjectAgentDto get(String id) {
        ProjectAgent projectAgent = validator.existAndGet(id);
        return mapper.toDto(projectAgent);

    }

    @Override
    public List<ProjectAgentDto> getAll(BaseCriteria criteria) {
        return List.of();
    }

    @Override
    public ProjectAgentDto update(ProjectAgentUpdateDto dto, String id) {
        ProjectAgent projectAgent = validator.existAndGet(id);
        mapper.fromDto(dto,projectAgent);
        return mapper.toDto(repository.save(projectAgent));
    }

    @Override
    public void delete(String id) {
        ProjectAgent projectAgent = validator.existAndGet(id);
        projectAgent.setDeleted(true);
        repository.save(projectAgent);
    }
}
