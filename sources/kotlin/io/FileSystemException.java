package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

public class FileSystemException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    private final File f40387b;

    /* renamed from: c  reason: collision with root package name */
    private final File f40388c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40389d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file, File file2, String str) {
        super(ExceptionsKt.a(file, file2, str));
        Intrinsics.f(file, "file");
        this.f40387b = file;
        this.f40388c = file2;
        this.f40389d = str;
    }
}
