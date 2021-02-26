package com.achiever.menschenfahren.base.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String            email;
    private String            password;
}
