package org.example.mydbcontroller.validator;

import org.example.mydbcontroller.dto.projectdatabaseuser.ProjectDatabaseUserCreateDto;
import org.example.mydbcontroller.dto.projectdatabaseuser.ProjectDatabaseUserUpdateDto;
import org.example.mydbcontroller.exception.ValidationException;
import org.example.mydbcontroller.model.entity.ProjectDatabaseUser;
import org.example.mydbcontroller.validator.base.BaseValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
public class ProjectDatabaseUserBaseValidator implements
        BaseValidator<ProjectDatabaseUserCreateDto, ProjectDatabaseUserUpdateDto, ProjectDatabaseUser> {
    @Override
    public void validateForCreate(ProjectDatabaseUserCreateDto dto) {
        validateCommon(dto);
    }

    @Override
    public void validateForUpdate(ProjectDatabaseUserUpdateDto dto) {
        validateCommon(dto);
    }
    private void validateCommon(Object object) {
        if (object == null)
            throw new ValidationException("Project database user ma'lumotlari bo‘sh bo‘lishi mumkin emas");

        ProjectDatabaseUserCreateDto dto = (ProjectDatabaseUserCreateDto) object;

        if (!StringUtils.hasText(dto.getAuthUserId()))
            throw new ValidationException("Auth user tanlanmagan");

        if (!StringUtils.hasText(dto.getDatabaseId()))
            throw new ValidationException("Database tanlanmagan");

        if (dto.getRoleIds() == null || dto.getRoleIds().isEmpty())
            throw new ValidationException("Kamida bitta role tanlanishi kerak");
    }
}
