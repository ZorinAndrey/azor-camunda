package ru.azor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Model json user payload.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPayloadJsonRoot {

    @JsonProperty("preferred_username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("sub")
    private String uuid;

    @JsonProperty("given_name")
    private String firstName;

    @JsonProperty("family_name")
    private String lastName;

}
