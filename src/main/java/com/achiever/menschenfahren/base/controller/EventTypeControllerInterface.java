package com.achiever.menschenfahren.base.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.achiever.menschenfahren.base.constants.CommonConstants;
import com.achiever.menschenfahren.base.dto.request.EventTypeCreateDto;
import com.achiever.menschenfahren.base.dto.response.DataResponse;
import com.achiever.menschenfahren.base.dto.response.EventTypeDto;
import com.achiever.menschenfahren.base.exception.InvalidEventTypeException;

import io.swagger.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface EventTypeControllerInterface {

    // path to get eventTypes.
    public static final String PATH_EVENT_TYPES       = "eventTypes";

    // path to create eventType.
    public static final String PATH_CREATE_EVENT_TYPE = "eventType";

    /**
     * Returns all EventTypes.
     *
     * @param alsoVoided
     *            flag to get alsoVoided eventTypes.
     * @return all eventTypes.
     */
    @Operation(description = "Return All Event type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Event types.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventTypeDto.class)) }),
            @ApiResponse(responseCode = "204", description = "Found no visible Event type", content = @Content()),
            @ApiResponse(responseCode = "400", description = "The event type is incomplete"),
            @ApiResponse(responseCode = "410", description = "The event has been voided") })
    @Parameters(value = {
            @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "Optional filter if voided events are also considered and returned.") })
    @GetMapping(PATH_EVENT_TYPES)
    ResponseEntity<DataResponse<List<EventTypeDto>>> getEventTypes(
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided);

    /**
     * Creates a new EventType.
     * 
     * @param request
     *            The body to create EventType.
     * @param alsoVoided
     *            flag to void the eventType.
     * @return The created eventType
     * @throws InvalidEventTypeException
     *             Thrown if same eventType is created.
     */
    @Operation(description = "Creates a new Event type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Event type was successfully created", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventTypeDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Returned if the Event type data contained invalid field") })
    @PostMapping(PATH_CREATE_EVENT_TYPE)
    ResponseEntity<DataResponse<EventTypeDto>> createEventType(@RequestBody(required = true) @Valid final EventTypeCreateDto request,
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided)
            throws InvalidEventTypeException;

}
