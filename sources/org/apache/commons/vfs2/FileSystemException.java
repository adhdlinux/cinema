package org.apache.commons.vfs2;

import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.commons.vfs2.util.Messages;

public class FileSystemException extends IOException {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f41467c = Pattern.compile("[a-z]+://.*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f41468d = Pattern.compile(":(?:[^/]+)@");

    /* renamed from: b  reason: collision with root package name */
    private final String[] f41469b;

    public String[] a() {
        return this.f41469b;
    }

    public String getMessage() {
        return Messages.b(super.getMessage(), a());
    }
}
