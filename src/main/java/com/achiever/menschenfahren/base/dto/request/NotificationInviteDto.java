package com.achiever.menschenfahren.base.dto.request;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto class for invite request.
 * 
 * @author Srijan Bajracharya
 *
 */
@Schema
@Data
@NoArgsConstructor
public class NotificationInviteDto implements RestOperationDto {

    private static final long serialVersionUID = 2114767010770480699L;

    @Schema(description = "The email to whom invite is sent.")
    @Nonnull
    private String            receiverEmailId;

    @Schema(description = "The event id of for which invite is sent.")
    @Nonnull
    private String            eventId;

}
