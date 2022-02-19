package com.achiever.menschenfahren.base.dto.request;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Srijan Bajracharya
 *
 */
@Schema
@Data
@NoArgsConstructor
public class UserEditDto implements RestOperationDto {

    private static final long serialVersionUID = 5572192286629553275L;

    /** First name of user **/
    @Schema(description = "First name of an user")
    @Nonnull
    private String            firstName;

    /**
     * Last name of user
     */
    @Schema(description = "Last name of an user")
    @Nonnull
    private String            lastName;

    /**
     * Email id of user.
     */
    @Schema(description = "Email id of an user")
    @Nonnull
    private String            email;

    @Schema(description = "display name of an user")
    @Nonnull
    private String            username;

    // @Schema(description = "authentication type of an user")
    // private AuthProviderType authenticationType;

}
