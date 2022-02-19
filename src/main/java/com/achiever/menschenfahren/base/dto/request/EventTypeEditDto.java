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
public class EventTypeEditDto implements RestOperationDto {

    private static final long serialVersionUID = -9066178501885844421L;

    @Schema(description = "Name of Event type.")
    @Nonnull
    private String            name;

    @Schema(description = "Description of Event Type")
    @Nonnull
    private String            description;

    @Schema(description = "Event type is voided or not.")
    @Nonnull
    private boolean           voided;

}
