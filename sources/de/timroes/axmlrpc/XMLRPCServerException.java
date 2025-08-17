package de.timroes.axmlrpc;

public class XMLRPCServerException extends XMLRPCException {

    /* renamed from: b  reason: collision with root package name */
    private final int f38172b;

    public String getMessage() {
        return super.getMessage() + " [" + this.f38172b + "]";
    }
}
