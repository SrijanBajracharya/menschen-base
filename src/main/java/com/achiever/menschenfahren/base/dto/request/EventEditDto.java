package com.achiever.menschenfahren.base.dto.request;

import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.achiever.menschenfahren.base.dto.RestOperationDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Srijan Bajracharya
 *
 */
@Schema
@Data
@NoArgsConstructor
public class EventEditDto implements RestOperationDto {

    private static final long serialVersionUID = 1956092870757115263L;

    @Schema(description = "The id of user creating the event")
    @JsonIgnore
    private String            userId;

    @Schema(description = "The name of event")
    @Nonnull
    private String            name;

    @Schema(description = "The location of event")
    @Nonnull
    private String            location;

    // @Schema(description = "The photos of the event")
    // private List<EventGallery> gallery;
    //
    // @Schema(description = "Route to the event location")
    // private List<EventRoute> routes;

    @Schema(description = "Country code of the location")
    @Nonnull
    private String            country;

    @Schema(description = "The type of event")
    private String            eventTypeId;

    @Schema(description = "The description about the event")
    @Nonnull
    private String            description;

    @Schema(description = "Age group suitable for the event")
    @Nullable
    private String            ageGroup;

    @Schema(description = "The start date of the event")
    @Nonnull
    private Date              startDate;

    @Schema(description = "The end date of the event")
    @Nonnull
    private Date              endDate;

    @Schema(description = "Max Number of participants allowed for the event")
    private int               numberOfParticipants;

    @Schema(description = "The event if it is private or not")
    private boolean           isPrivate;

    @Schema(description = "The event if it is void or not")
    private boolean           voided;

}
