package com.tdd.eCommerceApp.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    String status;
    private Error error;
    private T payload;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public ApiResponse getSuccessResponse(T payload) {
        ApiResponse response = new ApiResponse();
        response.status = "success";
        response.setPayload(payload);
        return response;
    }

    public ApiResponse getErrorResponse(String errorMessage) {
        ApiResponse response = new ApiResponse();
        response.status = "fail";
        Error error = new Error();
        error.setCode("1");
        error.setMessage(errorMessage);
        response.setError(error);
        return response;
    }


    public ApiResponse getErrorResponseWithPayload(T payload, String errorMessage) {
        ApiResponse response = new ApiResponse();
        response.status = "fail";
        Error error = new Error();
        error.setCode("1");
        error.setMessage(errorMessage);
        response.setError(error);
        response.setPayload(payload);
        return response;
    }

    @Override
    public String toString() {
        return "GenericResponse [error=" + error + ", payload=" + payload + "]";
    }
}
