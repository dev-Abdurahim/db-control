package org.example.mydbcontroller.service.base;

import java.util.List;

/**
 * @param <D>
 * @param <CD>>
 * @param <UD>
 * @param <C> criteria class. Bu filterlar uchun kerak
 * @param <K>
 */
public interface CrudService<D,CD,UD,C,K> {

    D create(CD dto);
    D get(K id);
    List<D> getAll(C criteria);
    D update(UD dto, K id);
    void delete(K id);


}
