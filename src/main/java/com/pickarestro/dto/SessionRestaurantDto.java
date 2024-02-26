package com.pickarestro.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionRestaurantDto {
    private Long sessionId;
    private RestaurantDto restaurant;
    private Long submittedByUserId;
}