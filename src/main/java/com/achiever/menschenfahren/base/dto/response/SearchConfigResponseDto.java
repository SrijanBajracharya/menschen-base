package com.achiever.menschenfahren.base.dto.response;

import java.util.Date;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.request.SearchConfigCreateDto;

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
public class SearchConfigResponseDto extends SearchConfigCreateDto {

    private static final long serialVersionUID = -6331054781484842593L;

    @Nonnull
    @Schema(description = "The id of the search config.")
    private String            id;

    @Nonnull
    @Schema(description = "The modified timestamp.")
    private Date              modifiedTimestamp;

}
