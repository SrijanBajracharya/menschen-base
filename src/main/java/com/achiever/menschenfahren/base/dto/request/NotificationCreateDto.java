package com.achiever.menschenfahren.base.dto.request;

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
public class NotificationCreateDto extends NotificationEditDto {

    private static final long serialVersionUID = 91004448822488149L;

    /**
     * The id of a receiver.
     */
    @Schema(description = "The user who approves or request to join")
    private String            originalReceiverId;

    /** The id of an event. **/
    @Schema(description = "The id of an event.")
    private String            eventId;

    /**
     * Notification type of notification.
     */
    @Schema(description = "The type of notification.")
    private String            notificationType;

}
