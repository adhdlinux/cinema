package androidx.media3.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class AtomicFile {

    /* renamed from: a  reason: collision with root package name */
    private final File f4612a;

    /* renamed from: b  reason: collision with root package name */
    private final File f4613b;

    private static final class AtomicFileOutputStream extends OutputStream {

        /* renamed from: b  reason: collision with root package name */
        private final FileOutputStream f4614b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4615c = false;

        public AtomicFileOutputStream(File file) throws FileNotFoundException {
            this.f4614b = new FileOutputStream(file);
        }

        public void close() throws IOException {
            if (!this.f4615c) {
                this.f4615c = true;
                flush();
                try {
                    this.f4614b.getFD().sync();
                } catch (IOException e2) {
                    Log.i("AtomicFile", "Failed to sync file descriptor:", e2);
                }
                this.f4614b.close();
            }
        }

        public void flush() throws IOException {
            this.f4614b.flush();
        }

        public void write(int i2) throws IOException {
            this.f4614b.write(i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.f4614b.write(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.f4614b.write(bArr, i2, i3);
        }
    }

    public AtomicFile(File file) {
        this.f4612a = file;
        this.f4613b = new File(file.getPath() + ".bak");
    }

    private void e() {
        if (this.f4613b.exists()) {
            this.f4612a.delete();
            this.f4613b.renameTo(this.f4612a);
        }
    }

    public void a() {
        this.f4612a.delete();
        this.f4613b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f4613b.delete();
    }

    public boolean c() {
        return this.f4612a.exists() || this.f4613b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f4612a);
    }

    public OutputStream f() throws IOException {
        if (this.f4612a.exists()) {
            if (this.f4613b.exists()) {
                this.f4612a.delete();
            } else if (!this.f4612a.renameTo(this.f4613b)) {
                Log.h("AtomicFile", "Couldn't rename file " + this.f4612a + " to backup file " + this.f4613b);
            }
        }
        try {
            return new AtomicFileOutputStream(this.f4612a);
        } catch (FileNotFoundException e2) {
            File parentFile = this.f4612a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f4612a, e2);
            }
            try {
                return new AtomicFileOutputStream(this.f4612a);
            } catch (FileNotFoundException e3) {
                throw new IOException("Couldn't create " + this.f4612a, e3);
            }
        }
    }
}
