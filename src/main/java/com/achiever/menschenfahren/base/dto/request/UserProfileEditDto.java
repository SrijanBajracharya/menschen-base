package com.achiever.menschenfahren.base.dto.request;

import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.achiever.menschenfahren.base.dto.RestOperationDto;
import com.achiever.menschenfahren.base.model.Gender;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@NoArgsConstructor
public class UserProfileEditDto implements RestOperationDto {

    private static final long serialVersionUID  = -8301953007353045091L;

    @Schema(description = "The id of role")
    private String            roleId;

    @Schema(description = "The DOB of user must be in yyyy-MM-dd format.")
    @Nonnull
    private Date              dateOfBirth;

    @Schema(description = "If the terms and agreement is agreed")
    private boolean           termsAndAgreement = true;

    @Schema(description = "Country of user")
    @Nonnull
    private String            country;

    @Schema(description = "Photo of user")
    @Nullable
    private String            photo;

    @Schema(description = "The address of user")
    @Nonnull
    private String            address;

    @Schema(description = "Gender of an user")
    @Nonnull
    private Gender            gender;

    @Schema(description = "Phone number of an user")
    @Nonnull
    private String            phoneNumber;

    @Schema(description = "About the user.")
    @Nullable
    private String            description;

    @Schema(description = "Education of an user")
    @Nullable
    private String            education;

    @Schema(description = "Hobbies of an user")
    @Nullable
    private String            hobbies;

    @Schema(description = "The experiences of an user")
    @Nullable
    private String            experiences;

}
