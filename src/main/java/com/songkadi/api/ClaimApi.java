package com.songkadi.api;

import com.songkadi.db.entity.Claim;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(value = "claim", description = "the claim API")
public interface ClaimApi {

    @ApiOperation(value = "", nickname = "getClaim", notes = "", response = Claim.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Claim.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Pet not found")})
    @GetMapping(value = "/claim/{claimNumber}",
            produces = "application/json")
    ResponseEntity<Claim> getClaim(
            @ApiParam(value = "", required = true)
            @PathVariable("claimNumber")
                    String claimNumber);

    @ApiOperation(value = "", nickname = "getClaimList", notes = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Claim[].class),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Pet not found"),
            @ApiResponse(code = 405, message = "Validation exception")})
    @GetMapping(value = "/claim",
            produces = "application/json")
    ResponseEntity<List<Claim>> getClaimList();

    @ApiOperation(value = "", nickname = "saveClaim", notes = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "successful operation", response = Claim.class),
            @ApiResponse(code = 405, message = "Invalid input")})
    @PostMapping(value = "/claim",
            consumes = "application/json",
            produces = "application/json")
    ResponseEntity<Claim> saveClaim(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true)
            @Valid @RequestBody
                    Claim claim);
}
