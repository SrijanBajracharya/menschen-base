package com.achiever.menschenfahren.base.dto;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
public class EventTypeEditDto implements RestOperationDto {

    private static final long serialVersionUID = -9066178501885844421L;

    @Schema(description = "Name of Event type.")
    @Nonnull
    private String            name;

    @Schema(description = "Description of Event Type")
    @Nullable
    private String            description;

    @Schema(description = "Event type is voided or not.")
    @Nonnull
    private boolean           voided;

}
