package com.original.tase.model.debrid.premiumize;

public class PremiumizeTransferPesponse {
    private String error;
    private String id;
    private String message;
    private String name;
    private String status;
    private String type;

    public String getError() {
        return this.error;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public String getType() {
        return this.type;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
