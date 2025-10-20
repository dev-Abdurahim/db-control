package org.example.mydbcontroller.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Bu klass pagination va qidiruv uchun ishlatiladi.
//Ya’ni page, size, search — har bir REST API’ga query param sifatida keladigan umumiy maydonlar
// ya’ni criteria (so‘rovni filtrlash)
public class BaseCriteria {
    private Integer size;
    private Integer page;
    private String search;
}
