package dev.vijay.restdemo.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@Getter
@Setter
public class BaseResponse {
    private HttpStatus status;
    private String message;
}
