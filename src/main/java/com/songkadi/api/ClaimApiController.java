package com.songkadi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.songkadi.db.connection.ClaimRepository;
import com.songkadi.db.entity.Claim;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Controller
public class ClaimApiController implements ClaimApi {

    private static final Logger log = LoggerFactory.getLogger(ClaimApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    public ClaimApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Claim> getClaim(
            @ApiParam(value = "", required = true)
            @PathVariable("claimNumber") String claimNumber) {
        Claim claim = claimRepository.findOne(claimNumber);
        return new ResponseEntity<Claim>(claim, claim == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    public ResponseEntity<List<Claim>> getClaimList() {
        List<Claim> claims = new ArrayList<>();
        claims.addAll(claimRepository.findAll());
        return new ResponseEntity<>(claims, HttpStatus.OK);
    }

    public ResponseEntity<Claim> saveClaim(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true)
            @Valid @RequestBody
                    Claim claim) {
        Claim save = claimRepository.save(claim);
        return new ResponseEntity<Claim>(save, claim == null ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.CREATED);
    }
}
