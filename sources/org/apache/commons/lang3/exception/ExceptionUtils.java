package org.apache.commons.lang3.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f41439a = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }
}
