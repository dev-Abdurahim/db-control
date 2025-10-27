package org.example.mydbcontroller.validator;


import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.authuser.AuthUserCreateDto;
import org.example.mydbcontroller.dto.authuser.AuthUserUpdateDto;
import org.example.mydbcontroller.exception.NotFoundException;
import org.example.mydbcontroller.exception.ValidationException;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.example.mydbcontroller.repository.AuthUserRepository;
import org.example.mydbcontroller.validator.base.BaseValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class AuthUserValidator implements
        BaseValidator<AuthUserCreateDto, AuthUserUpdateDto, AuthUser> {
    private final AuthUserRepository repository;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+?[0-9]{9,15}$");



    @Override
    public void validateForCreate(AuthUserCreateDto dto) {
        validateCommon(dto);
    }

    @Override
    public void validateForUpdate(AuthUserUpdateDto dto) {
        validateCommon(dto);
    }
    private void validateCommon(Object object) {
        if (object == null)
            throw new ValidationException("User ma'lumotlari bo‘sh bo‘lishi mumkin emas");

        AuthUserCreateDto dto = (AuthUserCreateDto) object;

        if (!StringUtils.hasText(dto.getUsername()))
            throw new ValidationException("Username bo‘sh bo‘lishi mumkin emas");

        if (!StringUtils.hasText(dto.getPassword()) || dto.getPassword().length() < 6)
            throw new ValidationException("Parol kamida 6 ta belgidan iborat bo‘lishi kerak");

        if (!StringUtils.hasText(dto.getDbUsername()))
            throw new ValidationException("Database username bo‘sh bo‘lishi mumkin emas");

        if (!StringUtils.hasText(dto.getDbPassword()))
            throw new ValidationException("Database password bo‘sh bo‘lishi mumkin emas");

        if (!StringUtils.hasText(dto.getEmail()) || !EMAIL_PATTERN.matcher(dto.getEmail()).matches())
            throw new ValidationException("Email noto‘g‘ri formatda kiritilgan");

        if (!StringUtils.hasText(dto.getPhone()) || !PHONE_PATTERN.matcher(dto.getPhone()).matches())
            throw new ValidationException("Telefon raqam noto‘g‘ri formatda kiritilgan");

        if (!StringUtils.hasText(dto.getRoleId()))
            throw new ValidationException("User uchun role tanlanmagan");
    }



    @Override
    public AuthUser existsAndGet(String id) {
       return repository.findById(id).orElseThrow(
               () -> new NotFoundException("User with id " + id + "not found")
       );
    }
}
