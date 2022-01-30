package com.achiever.menschenfahren.base.controller;

import java.util.List;

import javax.annotation.Nonnull;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.achiever.menschenfahren.base.constants.CommonConstants;
import com.achiever.menschenfahren.base.dto.request.EventCreateDto;
import com.achiever.menschenfahren.base.dto.request.EventEditDto;
import com.achiever.menschenfahren.base.dto.request.FilterCreateDto;
import com.achiever.menschenfahren.base.dto.response.DataResponse;
import com.achiever.menschenfahren.base.dto.response.EventDto;
import com.achiever.menschenfahren.base.exception.InvalidEventException;
import com.achiever.menschenfahren.base.exception.InvalidEventTypeException;
import com.achiever.menschenfahren.base.exception.ResourceNotFoundException;

import io.swagger.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface EventRestControllerInterface {

    // Path for Events.
    public static final String PATH_EVENTS          = "events";

    // Path for Event by Id.
    public static final String PATH_GET_EVENT_BY_ID = PATH_EVENTS + "/{" + CommonConstants.Params.EVENT_ID + "}";

    // Path for Event for a User.
    public static final String PATH_EVENT_USER      = PATH_EVENTS + "/user";

    // path to make event private.
    public static final String PATH_EVENT_PRIVATE   = PATH_GET_EVENT_BY_ID + "/private";

    // path to make event public.
    public static final String PATH_EVENT_PUBLIC    = PATH_GET_EVENT_BY_ID + "/public";

    // path to edit event.
    public static final String PATH_EDIT_EVENT      = PATH_GET_EVENT_BY_ID + "/edit";

    // path to filter event.
    public static final String PATH_FILTER_EVENT    = PATH_EVENTS + "/filter";

    /**
     * Returns the events a specific event can see.
     *
     * @param alsoVoided
     *            If voided events are also considered.
     * @return The list of events, an empty list and code 204 or an error code.
     */
    @Operation(description = "Return All Events.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Events", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "204", description = "Found no visible Event", content = @Content()),
            @ApiResponse(responseCode = "400", description = "The event details is incomplete"),
            @ApiResponse(responseCode = "410", description = "The event has been voided") })
    @Parameters(value = {
            @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "Optional filter if voided events are also considered and returned.") })
    @GetMapping(PATH_EVENTS)
    @NonNull
    ResponseEntity<DataResponse<List<EventDto>>> getEvents(
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided,
            @RequestParam(name = CommonConstants.Params.ALSO_PRIVATE, defaultValue = "false", required = false) final boolean alsoPrivate)
            throws InvalidEventException;

    /**
     * Returns a specific event based on eventId.
     *
     * @param eventId
     *            The identifier for the event.
     * @param alsoVoided
     *            If voided spaces are returned.
     * @return
     */
    @Operation(description = "Returns the event  with the given eventId.")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.EVENT_ID, description = "An identifier for an event"),
            @Parameter(name = CommonConstants.Params.ALSO_PRIVATE, description = "Boolean to/not to consider Private events "),
            @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "If voided events are also considered and returned.") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Event", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The event details is incomplete"),
            @ApiResponse(responseCode = "410", description = "The event has been voided"),
            @ApiResponse(responseCode = "404", description = "No Event found with the eventId") })
    @GetMapping(PATH_GET_EVENT_BY_ID)
    @NonNull
    ResponseEntity<DataResponse<EventDto>> getEvent(@PathVariable(name = CommonConstants.Params.EVENT_ID, required = true) @Nonnull final String eventId,
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided,
            @RequestParam(name = CommonConstants.Params.ALSO_PRIVATE, defaultValue = "false", required = false) final boolean alsoPrivate)
            throws InvalidEventException;

    /**
     * Creates a new Event.
     *
     * @param request
     *            The request for creating an event.
     * @return
     * @throws InvalidEventException
     * @throws InvalidEventTypeException
     */
    @Operation(description = "Creates a new Event.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Event was successfully created", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Returned if the event data contained invalid field") })
    @PostMapping(PATH_EVENTS)
    @NonNull
    ResponseEntity<DataResponse<EventDto>> createEvent(@RequestBody(required = true) @Valid final EventCreateDto request)
            throws InvalidEventException, InvalidEventTypeException;

    /**
     * Finds events for an user.
     *
     * @param userId
     *            The identifier of an user.
     * @param alsoVoided
     *            If voided events are also considered.
     * @return {@link List} of events.
     * @throws InvalidEventException
     */
    @Operation(description = "Returns all Events for an user")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "If voided events are also considered and returned.") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Events for an user", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Returned if the event data contained invalid field"),
            @ApiResponse(responseCode = "410", description = "The event has been voided"),
            @ApiResponse(responseCode = "204", description = "Found no visible Event", content = @Content()) })
    @GetMapping(PATH_EVENT_USER)
    @NonNull
    ResponseEntity<DataResponse<List<EventDto>>> getUserEvents(
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided)
            throws InvalidEventException;

    /**
     * Makes the event private based on the eventId.
     *
     * @param eventId
     *            The identifier of an event.
     * @return The updated Event.
     */
    @Operation(description = "Makes event private and Returns the event.")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.EVENT_ID, description = "An identifier for an event") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event successfully made private.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Returned if the event data contained invalid field"),
            @ApiResponse(responseCode = "410", description = "The event is already private."),
            @ApiResponse(responseCode = "404", description = "Found no Event with given eventId", content = @Content()) })
    @PutMapping(PATH_EVENT_PRIVATE)
    @NonNull
    ResponseEntity<DataResponse<EventDto>> makeEventPrivate(@PathVariable(name = "eventId", required = true) @Nonnull final String eventId)
            throws ResourceNotFoundException;

    /**
     * Makes teh event public based on the eventId.
     *
     * @param eventId
     *            The identifier of an event.
     * @return The updated Event.
     */
    @Operation(description = "Makes event public and Returns the event.")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.EVENT_ID, description = "An identifier for an event") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event successfully made public.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Returned if the event data contained invalid field"),
            @ApiResponse(responseCode = "410", description = "The event is already private."),
            @ApiResponse(responseCode = "404", description = "Found no Event with given eventId", content = @Content()) })
    @PutMapping(PATH_EVENT_PUBLIC)
    @NonNull
    ResponseEntity<DataResponse<EventDto>> makeEventPublic(@PathVariable(name = "eventId", required = true) @Nonnull final String eventId)
            throws ResourceNotFoundException;

    /**
     * Updates the given Event.
     *
     * @param eventId
     *            The id of the event as part of the path.
     * @param request
     *            The set of updated values.
     * @return The updated event or an error code.
     * @throws ResourceNotFoundException
     *             If the referenced Id wasn't found. Will be returned as code 404.
     */
    @Operation(description = "Updates an exisiting Event.")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.EVENT_ID, description = "An identifier for an event") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event was successfully edited", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The given event wasn't valid for an update operation."),
            @ApiResponse(responseCode = "404", description = "The event with the given id doesn't exist", content = @Content()) })
    @PatchMapping(PATH_EDIT_EVENT)
    @NonNull
    ResponseEntity<DataResponse<EventDto>> editEvent(@PathVariable(name = CommonConstants.Params.EVENT_ID, required = true) @Nonnull final String eventId,
            @RequestBody(required = true) @Valid final EventEditDto request) throws ResourceNotFoundException;

    /**
     * Filter path based on various parameters.
     *
     * @param request
     *            Filter request.
     * @return The filtered events.
     */
    @Operation(description = "Returns list of filtered event.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event successfully filtered.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EventDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Returned if the event data contained invalid field") })
    @PostMapping(PATH_FILTER_EVENT)
    @NonNull
    ResponseEntity<DataResponse<List<EventDto>>> filterEvent(@RequestBody(required = true) @Valid final FilterCreateDto request);
}
