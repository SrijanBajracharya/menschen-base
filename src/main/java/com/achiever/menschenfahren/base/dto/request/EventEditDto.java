package com.achiever.menschenfahren.base.dto.request;

import java.util.Date;

import javax.annotation.Nonnull;

import com.achiever.menschenfahren.base.dto.RestOperationDto;

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
    private String            userId;

    @Schema(description = "The user creating the event")
    private UserEditDto       user;

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
    private String            countryCode;

    // @Schema(description = "The type of event")
    // private EventTypes eventTypes;

    @Schema(description = "The description about the event")
    private String            description;

    @Schema(description = "Age group suitable for the event")
    private String            ageGroup;

    @Schema(description = "The start date of the event")
    private Date              startDate;

    @Schema(description = "The end date of the event")
    private Date              endDate;

    @Schema(description = "Max Number of participants allowed for the event")
    private int               numberOfParticipants;

    @Schema(description = "The event if it is private or not")
    private boolean           isPrivate;

}
