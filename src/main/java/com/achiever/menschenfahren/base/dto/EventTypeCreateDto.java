package com.achiever.menschenfahren.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Srijan Bajracharya
 *
 */
@Schema
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EventTypeCreateDto extends EventTypeEditDto {

    private static final long serialVersionUID = 8706303539338148371L;

}
