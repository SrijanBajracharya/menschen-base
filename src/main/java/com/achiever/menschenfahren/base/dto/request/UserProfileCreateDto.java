package com.achiever.menschenfahren.base.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class UserProfileCreateDto extends UserProfileEditDto {

    private static final long serialVersionUID = 1786328631219102604L;

    @Schema(description = "The id of an user")
    @JsonIgnore
    private String            userId;

}
