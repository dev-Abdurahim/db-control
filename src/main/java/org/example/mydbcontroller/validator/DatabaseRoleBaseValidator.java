package org.example.mydbcontroller.validator;

import org.example.mydbcontroller.dto.databserole.DatabaseRoleCreateDto;
import org.example.mydbcontroller.dto.databserole.DatabaseRoleUpdateDto;
import org.example.mydbcontroller.exception.ValidationException;
import org.example.mydbcontroller.model.entity.DatabaseRole;
import org.example.mydbcontroller.validator.base.BaseValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DatabaseRoleBaseValidator implements
        BaseValidator<DatabaseRoleCreateDto, DatabaseRoleUpdateDto, DatabaseRole> {

    @Override
    public void validateForCreate(DatabaseRoleCreateDto dto) {
        validateCommon(dto);
    }

    @Override
    public void validateForUpdate(DatabaseRoleUpdateDto dto) {
        validateCommon(dto);
    }
    private void validateCommon(Object object) {
        if (object == null)
            throw new ValidationException("Database role ma'lumotlari bo‘sh bo‘lishi mumkin emas");

        DatabaseRoleCreateDto dto = (DatabaseRoleCreateDto) object;

        if (!StringUtils.hasText(dto.getName()))
            throw new ValidationException("Database role name bo‘sh bo‘lishi mumkin emas");

        if (!StringUtils.hasText(dto.getCode()))
            throw new ValidationException("Database role code bo‘sh bo‘lishi mumkin emas");

        if (!dto.getCode().matches("^[A-Z_]+$"))
            throw new ValidationException("Database role code faqat katta harf va '_' dan iborat bo‘lishi kerak");

        // description optional, lekin agar berilgan bo‘lsa bo‘sh bo‘lmasin
        if (dto.getDescription() != null && dto.getDescription().trim().isEmpty())
            throw new ValidationException("Description bo‘sh bo‘lishi mumkin emas");
    }
}
