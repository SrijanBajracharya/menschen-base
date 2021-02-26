package com.achiever.menschenfahren.base.dto.request;

import java.util.Date;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@NoArgsConstructor
public class NotificationEditDto implements RestOperationDto {

    private static final long serialVersionUID = 7528302636009898809L;

    /**
     * The status of the notification.
     */
    @Schema(description = "The status of the notification")
    private String            notificationStatus;

    /** The modified timestamp of notification **/
    @Schema(description = "The modified timestamp of notification.")
    private Date              modifiedTimestamp;

    /** Checks if the request is cancelled or not. **/
    @Schema(description = "The notification request is cancelled.")
    private boolean           alsoVoided;

}
