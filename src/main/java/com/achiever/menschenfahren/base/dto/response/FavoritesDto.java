package com.achiever.menschenfahren.base.dto.response;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.request.FavoriteCreateDto;

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
public class FavoritesDto extends FavoriteCreateDto {

    @Nonnull
    @Schema(description = "The id of favorite.")
    private String id;
}
