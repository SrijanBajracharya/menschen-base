package com.achiever.menschenfahren.base.dto.request;

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
public class SearchConfigCreateDto extends SearchConfigEditDto {

    private static final long serialVersionUID = 3072613068096281263L;

}
