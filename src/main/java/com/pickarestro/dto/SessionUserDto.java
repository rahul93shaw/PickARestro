package com.pickarestro.dto;

import com.pickarestro.model.InviteStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionUserDto {
    private Long sessionId;
    private UserDto user;
    private InviteStatus status;
}
