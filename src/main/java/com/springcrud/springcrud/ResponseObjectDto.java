package com.springcrud.springcrud;

import java.io.Serializable;

public class ResponseObjectDto implements Serializable  {
    private Boolean status;
    private Object data;
    private String message;

    public ResponseObjectDto(Object data, String message) {
        this.status = true;
        this.data = data;
        this.message = message;
    }

    public ResponseObjectDto(String message) {
        this.status = false;
        this.data = null;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
