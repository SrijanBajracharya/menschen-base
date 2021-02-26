package com.achiever.menschenfahren.base.dto.request;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@NoArgsConstructor
public class FavoriteCreateDto implements RestOperationDto {

    private static final long serialVersionUID = 6633824602173708473L;

    @Nonnull
    @Schema(description = "The id of the user.")
    private String            userId;

    @Nonnull
    @Schema(description = "The id of an event.")
    private String            eventId;
}
