package com.achiever.menschenfahren.base.dto.response;

import java.util.Date;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class NotificationDto implements RestOperationDto {

    private static final long serialVersionUID = -696991937724016409L;

    @Schema(description = "The id of the notification")
    @Nonnull
    private String            id;

    @Schema(description = "The sender user information.")
    private UserDto           senderUser;

    @Schema(description = "The receiver user information.")
    private UserDto           receiverUser;

    @Schema(description = "The event information")
    private EventDto          event;

    @Schema(description = "The type of notification.")
    private String            notificationType;

    @Schema(description = "The status of the notification")
    private String            notificationStatus;

    /** The modified timestamp of notification **/
    @Schema(description = "The modified timestamp of notification.")
    private Date              modifiedTimestamp;

    /** Checks if the request is cancelled or not. **/
    @Schema(description = "The notification request is cancelled.")
    private boolean           alsoVoided;

    @Schema(description = "Flag to check if receiver user matches.")
    private boolean           matchedReceiverUserId;

    @Schema(description = "flag to check if sender user matches.")
    private boolean           matchedSenderUserId;

}
