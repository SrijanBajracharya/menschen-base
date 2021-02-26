package com.achiever.menschenfahren.base.dto.request;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@NoArgsConstructor
public class SearchConfigEditDto implements RestOperationDto {

    private static final long serialVersionUID = -4385653528766314561L;

    @Schema(description = "The id of user.")
    @Nonnull
    private String            userId;

    @Schema(description = "The id of the event type.")
    @Nullable
    private String            eventTypeId;

    @Schema(description = "The id of country.")
    @Nullable
    private String            countryId;

    @Schema(description = "The destination.")
    @Nullable
    private String            destination;

    @Schema(description = "The age group.")
    @Nullable
    private String            ageGroup;
}
