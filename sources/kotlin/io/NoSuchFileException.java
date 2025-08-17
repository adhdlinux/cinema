package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class NoSuchFileException extends FileSystemException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoSuchFileException(File file, File file2, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoSuchFileException(File file, File file2, String str) {
        super(file, file2, str);
        Intrinsics.f(file, "file");
    }
}
