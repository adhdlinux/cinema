package org.apache.commons.lang3.exception;

public class ContextedRuntimeException extends RuntimeException implements ExceptionContext {

    /* renamed from: b  reason: collision with root package name */
    private final ExceptionContext f41437b = new DefaultExceptionContext();

    public String a(String str) {
        return this.f41437b.a(str);
    }

    public String getMessage() {
        return a(super.getMessage());
    }
}
