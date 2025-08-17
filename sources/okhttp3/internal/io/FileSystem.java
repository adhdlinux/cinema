package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private static final class SystemFileSystem implements FileSystem {
            public Sink appendingSink(File file) throws FileNotFoundException {
                Intrinsics.f(file, "file");
                try {
                    return Okio.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.a(file);
                }
            }

            public void delete(File file) throws IOException {
                Intrinsics.f(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException("failed to delete " + file);
                }
            }

            public void deleteContents(File file) throws IOException {
                Intrinsics.f(file, "directory");
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i2 = 0;
                    while (i2 < length) {
                        File file2 = listFiles[i2];
                        if (file2.isDirectory()) {
                            Intrinsics.e(file2, "file");
                            deleteContents(file2);
                        }
                        if (file2.delete()) {
                            i2++;
                        } else {
                            throw new IOException("failed to delete " + file2);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + file);
            }

            public boolean exists(File file) {
                Intrinsics.f(file, "file");
                return file.exists();
            }

            public void rename(File file, File file2) throws IOException {
                Intrinsics.f(file, "from");
                Intrinsics.f(file2, "to");
                delete(file2);
                if (!file.renameTo(file2)) {
                    throw new IOException("failed to rename " + file + " to " + file2);
                }
            }

            public Sink sink(File file) throws FileNotFoundException {
                Intrinsics.f(file, "file");
                try {
                    return Okio__JvmOkioKt.h(file, false, 1, (Object) null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio__JvmOkioKt.h(file, false, 1, (Object) null);
                }
            }

            public long size(File file) {
                Intrinsics.f(file, "file");
                return file.length();
            }

            public Source source(File file) throws FileNotFoundException {
                Intrinsics.f(file, "file");
                return Okio.k(file);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
