package com.nobank.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest implements Serializable {

    private String username;
    private String dni;
    private String password;
    private String email;
}
