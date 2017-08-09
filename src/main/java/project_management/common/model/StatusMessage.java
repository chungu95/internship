package project_management.common.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;


public enum StatusMessage implements Serializable{
    SUCCESS("Success"), FAIL("Fail");
    private String status;

    StatusMessage(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
