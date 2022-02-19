package com.achiever.menschenfahren.base.dto.request;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@NoArgsConstructor
public class FilterCreateDto {

    @Schema(description = "The id of the country")
    private String countryId;

    @Schema(description = "The type of the event.")
    private String eventType;

    @Schema(description = "The from date of the filter.")
    private Date   fromDate;

    @Schema(description = "The to date of the filter.")
    private Date   toDate;
}
