package org.example.mydbcontroller.validator;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.projectdatabase.ProjectDatabaseCreateDto;
import org.example.mydbcontroller.dto.projectdatabase.ProjectDatabaseUpdateDto;
import org.example.mydbcontroller.exception.NotFoundException;
import org.example.mydbcontroller.exception.ValidationException;
import org.example.mydbcontroller.model.entity.ProjectDatabase;
import org.example.mydbcontroller.repository.ProjectDatabaseRepository;
import org.example.mydbcontroller.validator.base.BaseValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class ProjectDatabaseValidator implements BaseValidator<ProjectDatabaseCreateDto, ProjectDatabaseUpdateDto, ProjectDatabase> {

    private final ProjectDatabaseRepository repository;

    @Override
    public void validateForCreate(ProjectDatabaseCreateDto dto) {
        validateCommon(dto);
    }

    @Override
    public void validateForUpdate(ProjectDatabaseUpdateDto dto) {
        validateCommon(dto);
    }

    private void validateCommon(Object object) {
        if (object == null)
            throw new ValidationException("Project database ma'lumotlari bo‘sh bo‘lishi mumkin emas");

        ProjectDatabaseCreateDto dto = (ProjectDatabaseCreateDto) object;

        if (!StringUtils.hasText(dto.getName()))
            throw new ValidationException("Project database name bo‘sh bo‘lishi mumkin emas");

        if (dto.getDescription() != null && dto.getDescription().trim().isEmpty())
            throw new ValidationException("Description bo‘sh bo‘lishi mumkin emas");

        if (!StringUtils.hasText(dto.getAgentId()))
            throw new ValidationException("Project agent tanlanmagan");

    }

    @Override
    public ProjectDatabase existsAndGet(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project database '" + id + "' not found"));
    }
}
