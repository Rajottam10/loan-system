package com.fl.cbs.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime date;
    private String message;

    public ErrorResponse(LocalDateTime date, String message){
        this.date =  date;
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
