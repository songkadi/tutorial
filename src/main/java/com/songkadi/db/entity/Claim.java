package com.songkadi.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "claim")
public class Claim implements Serializable {

    @Id
    @Column(name = "claim_number")
    @JsonProperty("claimNumber")
    @ApiModelProperty(required = true)
    @NotNull
    private String claimNumber;

    @Column(name = "latitude")
    @JsonProperty("latitude")
    private Double latitude;

    @Column(name = "longitude")
    @JsonProperty("longitude")
    private Double longitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "incident_type")
    @JsonProperty("incidentType")
    private IncidentType incidentType;

    public Claim() {
    }

    public Claim(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public Claim(String claimNumber, Double latitude, Double longitude) {
        this.claimNumber = claimNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Claim(String claimNumber, Double latitude, Double longitude, IncidentType incidentType) {
        this.claimNumber = claimNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.incidentType = incidentType;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }
}
