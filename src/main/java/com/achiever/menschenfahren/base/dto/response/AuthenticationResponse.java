package com.achiever.menschenfahren.base.dto.response;

import java.util.Date;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.request.EventCreateDto;
import com.achiever.menschenfahren.base.dto.request.UserEditDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class AuthenticationResponse {

    private static final long serialVersionUID = 6716632698180385976L;

    @Schema(description = "Access token")
    @Nonnull
    private String            accessToken;

    @Schema(description = "type of the token", example = "Bearer")
    @Nonnull
    private String           tokenType;
    
    @Schema(description = "Date of expiry of the token")
    @Nonnull
    private Date           expiryDate;
}
