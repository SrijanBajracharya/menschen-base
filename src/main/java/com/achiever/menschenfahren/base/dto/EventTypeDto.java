package com.achiever.menschenfahren.base.dto;

import java.util.Date;

import javax.annotation.Nonnull;

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
public class EventTypeDto extends EventTypeCreateDto {

    private static final long serialVersionUID = -1406103640084221723L;

    @Schema(description = "Created Timestamp of Event type.")
    @Nonnull
    private Date              createdTimestamp;

    @Nonnull
    @Schema(description = "Modified timestamp of Event type.")
    private Date              modifiedTimestamp;

}