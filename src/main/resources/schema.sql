DROP TABLE IF EXISTS claim;
CREATE TABLE claim(
    claim_number VARCHAR(256) PRIMARY KEY,
    latitude DOUBLE,
    longitude DOUBLE,
    incident_type VARCHAR(256)
);
