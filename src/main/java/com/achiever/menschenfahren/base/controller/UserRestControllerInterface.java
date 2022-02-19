package com.achiever.menschenfahren.base.controller;

import java.util.List;

import javax.annotation.Nonnull;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.achiever.menschenfahren.base.constants.CommonConstants;
import com.achiever.menschenfahren.base.dto.request.FriendsDto;
import com.achiever.menschenfahren.base.dto.request.JwtRequest;
import com.achiever.menschenfahren.base.dto.request.UserCreateDto;
import com.achiever.menschenfahren.base.dto.request.UserEditDto;
import com.achiever.menschenfahren.base.dto.response.DataResponse;
import com.achiever.menschenfahren.base.dto.response.UserDto;
import com.achiever.menschenfahren.base.exception.InvalidEventException;
import com.achiever.menschenfahren.base.exception.InvalidUserException;
import com.achiever.menschenfahren.base.exception.ResourceNotFoundException;

import io.swagger.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 *
 * @author Srijan Bajracharya
 *
 */
public interface UserRestControllerInterface {

    public static final String PATH_USER             = "user";

    public static final String PATH_USERS            = "users";

    public static final String PATH_USER_BY_ID       = PATH_USERS + "/{" + CommonConstants.Params.USER_ID + "}";

    public static final String PATH_USER_EDIT        = PATH_USER + "/edit";

    public static final String PATH_FRIENDS          = PATH_USER_BY_ID + "/friends";

    public static final String PATH_FRIENDS_BY_TOKEN = PATH_USER + "/friends";

    public static final String PATH_AUTHENTICATE     = "authenticate";

    /**
     * Creates a new User.
     *
     * @param request
     *            The object to create a new user.
     * @return
     * @throws InvalidEventException
     */
    @Operation(description = "Creates a new User.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User was successfully created", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Returned if the User data contained invalid field") })
    @PostMapping(PATH_USER)
    ResponseEntity<DataResponse<UserDto>> createUser(@RequestBody(required = true) @Valid final UserCreateDto request,
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided)
            throws InvalidUserException;

    /**
     * Returns all the users based on the voided filter.
     *
     * @param alsoVoided
     *            Checks if the user is active or deactivated.
     * @return
     * @throws InvalidEventException
     */
    @Operation(description = "Return All Users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Users", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)) }),
            @ApiResponse(responseCode = "204", description = "Found no visible User", content = @Content()),
            @ApiResponse(responseCode = "400", description = "The user details is incomplete"),
            @ApiResponse(responseCode = "410", description = "The user has been voided") })
    @Parameters(value = {
            @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "Optional filter if voided events are also considered and returned.") })
    @GetMapping(PATH_USERS)
    ResponseEntity<DataResponse<List<UserDto>>> getUsers(
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided)
            throws InvalidUserException;

    /**
     * Returns the user based on userId
     *
     * @param userId
     *            The identifier of the user
     * @param alsoVoided
     *            Active or deactive user.
     * @return
     * @throws InvalidEventException
     */
    @Operation(description = "Returns the user  with the given userId.")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.USER_ID, description = "An identifier for a user"),
            @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "If voided users are also considered and returned.") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the User", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The user details is incomplete"),
            @ApiResponse(responseCode = "410", description = "The user has been voided"),
            @ApiResponse(responseCode = "404", description = "No user found with the userId") })
    @GetMapping(PATH_USER_BY_ID)
    ResponseEntity<DataResponse<UserDto>> getUser(@PathVariable(name = CommonConstants.Params.USER_ID, required = true) @Nonnull final String userId,
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided)
            throws InvalidUserException;

    /**
     * Returns the user based on userId
     *
     * @param alsoVoided
     *            Active or deactive user.
     * @return
     * @throws InvalidEventException
     */
    @Operation(description = "Returns the user identified by token")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "If voided users are also considered and returned.") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the User", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The user details is incomplete"),
            @ApiResponse(responseCode = "410", description = "The user has been voided"),
            @ApiResponse(responseCode = "404", description = "No user found with the userId") })
    @GetMapping(PATH_USER)
    ResponseEntity<DataResponse<UserDto>> getUserByToken(
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided)
            throws InvalidUserException;

    /**
     * Returns the updated User.
     *
     * @param request
     * @return
     * @throws ResourceNotFoundException
     */
    @Operation(description = "Updates an exisiting user data.")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.ALSO_VOIDED, description = "If voided users are also considered and returned.") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User profile was successfully edited", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The given user wasn't valid for an update operation."),
            @ApiResponse(responseCode = "404", description = "The user with the given id doesn't exist", content = @Content()) })
    @PatchMapping(PATH_USER_EDIT)
    ResponseEntity<DataResponse<UserDto>> editUser(@RequestBody(required = true) @Valid final UserEditDto request,
            @RequestParam(name = CommonConstants.Params.ALSO_VOIDED, defaultValue = "false", required = false) final boolean alsoVoided)
            throws ResourceNotFoundException;

    @Operation(description = "Get list of Friend for a given user id")
    @Parameters(value = { @Parameter(name = CommonConstants.Params.USER_ID, description = "An identifier for a user") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Friends for a user.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FriendsDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The given user wasn't valid for an update operation."),
            @ApiResponse(responseCode = "404", description = "The user with the given id doesn't exist", content = @Content()) })
    @GetMapping(PATH_FRIENDS)
    ResponseEntity<DataResponse<List<FriendsDto>>> getFriendList(
            @PathVariable(name = CommonConstants.Params.USER_ID, required = true) @Nonnull final String userId) throws ResourceNotFoundException;

    @Operation(description = "Get list of Friend for a given user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Friends for a user.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FriendsDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The given user wasn't valid for an update operation."),
            @ApiResponse(responseCode = "404", description = "The user with the given id doesn't exist", content = @Content()) })
    @GetMapping(PATH_FRIENDS_BY_TOKEN)
    ResponseEntity<DataResponse<List<FriendsDto>>> getFriendListByToken() throws ResourceNotFoundException;

    /**
     * Returns the token if the credentials are correct.
     *
     * @param authenticationRequest
     * @return
     * @throws Exception
     */
    @Operation(description = "Returns the authentication token.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credentials matches", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)) }),
            @ApiResponse(responseCode = "401", description = "Credential not matched. Unauthorized") })
    @PostMapping(PATH_AUTHENTICATE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception;
}
