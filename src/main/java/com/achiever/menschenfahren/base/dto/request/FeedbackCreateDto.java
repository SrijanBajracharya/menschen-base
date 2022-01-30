package com.achiever.menschenfahren.base.dto.request;

import javax.annotation.Nonnull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema
@Data
@NoArgsConstructor
public class FeedbackCreateDto {
    @Nonnull
    private String subject;

    @Nonnull
    private String description;

}
