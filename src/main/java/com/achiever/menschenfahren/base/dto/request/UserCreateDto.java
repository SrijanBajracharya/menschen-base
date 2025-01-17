package com.achiever.menschenfahren.base.dto.request;

import javax.annotation.Nonnull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Srijan Bajracharya
 *
 */
@Schema
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserCreateDto extends UserEditDto {

    private static final long serialVersionUID = 3704232114446756938L;
    /**
     * password of an user.
     */
    @Schema(description = "password of an user")
    @Nonnull
    private String            password;

}
