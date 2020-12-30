package com.achiever.menschenfahren.base.dto.response;

import com.achiever.menschenfahren.base.dto.request.FeedbackCreateDto;

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
public class FeedbackDto extends FeedbackCreateDto {

    @Schema
    private String id;

}
