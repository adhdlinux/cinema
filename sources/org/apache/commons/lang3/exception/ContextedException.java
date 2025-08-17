package org.apache.commons.lang3.exception;

public class ContextedException extends Exception implements ExceptionContext {

    /* renamed from: b  reason: collision with root package name */
    private final ExceptionContext f41436b = new DefaultExceptionContext();

    public String a(String str) {
        return this.f41436b.a(str);
    }

    public String getMessage() {
        return a(super.getMessage());
    }
}
