package org.example.mydbcontroller.validator.base;

public interface BaseValidator <CD,UD, E>{
    void validateForCreate(CD dto);
    void validateForUpdate(UD dto);
    default E existsAndGet(String id) {
        return null;
    }
}
