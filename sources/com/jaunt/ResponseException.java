package com.jaunt;

public class ResponseException extends JauntException {

    /* renamed from: b  reason: collision with root package name */
    private String f31842b;

    /* renamed from: c  reason: collision with root package name */
    private String f31843c;

    public String getMessage() {
        return this.f31842b;
    }

    public String toString() {
        return "message: " + this.f31842b + "\nrequestUrl: " + this.f31843c + "\nresponse: [none]";
    }
}
