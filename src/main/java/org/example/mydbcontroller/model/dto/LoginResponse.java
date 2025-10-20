package org.example.mydbcontroller.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class LoginResponse {
    private String accessToken;
    private Date accessTokenExpiration;
}
