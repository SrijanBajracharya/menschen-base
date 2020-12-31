package com.achiever.menschenfahren.base.dto.response;

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
@ToString(callSuper = true)
@EqualsAndHashCode
public class AllFavoritesResponse implements RestOperationDto {

    private static final long serialVersionUID = -8709588222461768008L;

    @Nonnull
    @Schema(description = "The id of favorite.")
    private String            id;

    @Nonnull
    @Schema(description = "The id of the user.")
    private String            userId;

    @Nonnull
    @Schema(description = "The id of an event.")
    private EventDto          event;
}
