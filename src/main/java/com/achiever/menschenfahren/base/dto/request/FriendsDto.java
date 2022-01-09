package com.achiever.menschenfahren.base.dto.request;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@NoArgsConstructor
public class FriendsDto implements RestOperationDto {

    private static final long serialVersionUID = -7020672754167322225L;

    @Schema(description = "The id of the user")
    @Nonnull
    private String            id;

    /** First name of user **/
    @Schema(description = "First name of an user")
    private String            firstName;

    /**
     * Last name of user
     */
    @Schema(description = "Last name of an user")
    private String            lastName;

    /**
     * Email id of user.
     */
    @Schema(description = "Email id of an user")
    private String            email;

    @Schema(description = "display name of an user")
    @Nonnull
    private String            username;

}
