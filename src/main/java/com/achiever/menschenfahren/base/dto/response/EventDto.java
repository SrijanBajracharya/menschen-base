package com.achiever.menschenfahren.base.dto.response;

import java.util.Date;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.request.EventCreateDto;
import com.achiever.menschenfahren.base.dto.request.UserEditDto;
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
public class EventDto extends EventCreateDto {

    private static final long serialVersionUID = 6716632698180385976L;

    @Schema(description = "The id of the user")
    @Nonnull
    private String            id;

    @Schema(description = "If the user is voided", example = "false")
    @Nonnull
    private boolean           voided;

    @Schema(description = "Created time of an event")
    @Nonnull
    private Date              createdTimestamp;

    @Schema(description = "Event Type of an event")
    private EventTypeDto      eventType;

    @Schema(description = "The user creating the event")
    private UserDto       user;
    
    @JsonIgnore
    private String userId;
    
    @JsonIgnore
    private String eventTypeId;

}
