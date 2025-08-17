package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class AtomicFile {

    /* renamed from: a  reason: collision with root package name */
    private final File f28645a;

    /* renamed from: b  reason: collision with root package name */
    private final File f28646b;

    private static final class AtomicFileOutputStream extends OutputStream {

        /* renamed from: b  reason: collision with root package name */
        private final FileOutputStream f28647b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f28648c = false;

        public AtomicFileOutputStream(File file) throws FileNotFoundException {
            this.f28647b = new FileOutputStream(file);
        }

        public void close() throws IOException {
            if (!this.f28648c) {
                this.f28648c = true;
                flush();
                try {
                    this.f28647b.getFD().sync();
                } catch (IOException e2) {
                    Log.j("AtomicFile", "Failed to sync file descriptor:", e2);
                }
                this.f28647b.close();
            }
        }

        public void flush() throws IOException {
            this.f28647b.flush();
        }

        public void write(int i2) throws IOException {
            this.f28647b.write(i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.f28647b.write(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.f28647b.write(bArr, i2, i3);
        }
    }

    public AtomicFile(File file) {
        this.f28645a = file;
        this.f28646b = new File(file.getPath() + ".bak");
    }

    private void e() {
        if (this.f28646b.exists()) {
            this.f28645a.delete();
            this.f28646b.renameTo(this.f28645a);
        }
    }

    public void a() {
        this.f28645a.delete();
        this.f28646b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f28646b.delete();
    }

    public boolean c() {
        return this.f28645a.exists() || this.f28646b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f28645a);
    }

    public OutputStream f() throws IOException {
        if (this.f28645a.exists()) {
            if (this.f28646b.exists()) {
                this.f28645a.delete();
            } else if (!this.f28645a.renameTo(this.f28646b)) {
                Log.i("AtomicFile", "Couldn't rename file " + this.f28645a + " to backup file " + this.f28646b);
            }
        }
        try {
            return new AtomicFileOutputStream(this.f28645a);
        } catch (FileNotFoundException e2) {
            File parentFile = this.f28645a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f28645a, e2);
            }
            try {
                return new AtomicFileOutputStream(this.f28645a);
            } catch (FileNotFoundException e3) {
                throw new IOException("Couldn't create " + this.f28645a, e3);
            }
        }
    }
}
