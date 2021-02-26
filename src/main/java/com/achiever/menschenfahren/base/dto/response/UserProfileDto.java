package com.achiever.menschenfahren.base.dto.response;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.request.UserEditDto;
import com.achiever.menschenfahren.base.dto.request.UserProfileCreateDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserProfileDto extends UserProfileCreateDto {

    private static final long serialVersionUID = 6537394434980008873L;

    @Schema(description = "The id of the user")
    @Nonnull
    private String            id;

    @Schema(description = "If the user is voided", example = "false")
    @Nonnull
    private boolean           voided;

    @Schema(description = "The user object")
    @Nonnull
    private UserEditDto       user;

}
