package com.swapniltiwari.daily_syncup.enums;

public enum ErrorMessages {
    FAILED_DEPENDENCY("External dependency failed to respond or returned an error"),
    BAD_REQUEST("Invalid request parameters or payload provided"),
    FORBIDDEN("Access is denied. You do not have permission to perform this action"),
    NOT_FOUND("Requested resource could not be found"),
    UNAUTHORIZED("Authentication failed or user is not authorized"),
    INTERNAL_SERVER_ERROR("An unexpected error occurred on the server"),
    NOT_IMPLEMENTED("This functionality is not yet implemented"),
    INVALID_METHOD_ARGUMENT("Invalid Method Arguments"),
    RESOURCE_NOT_FOUND("Requested resource is not available"),
    INVALID_OPERATION("Invalid Operation");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
