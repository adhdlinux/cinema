package com.facebook.ads.internal.p.b.a;

import com.facebook.ads.internal.p.b.a;
import com.facebook.ads.internal.p.b.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public File f20479a;

    /* renamed from: b  reason: collision with root package name */
    private final a f20480b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f20481c;

    public b(File file, a aVar) {
        File file2;
        if (aVar != null) {
            try {
                this.f20480b = aVar;
                d.a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.f20479a = file2;
                this.f20481c = new RandomAccessFile(this.f20479a, exists ? "r" : "rw");
            } catch (IOException e2) {
                throw new l("Error using file " + file + " as disc cache", e2);
            }
        } else {
            throw new NullPointerException();
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    public synchronized int a() {
        try {
        } catch (IOException e2) {
            throw new l("Error reading length of file " + this.f20479a, e2);
        }
        return (int) this.f20481c.length();
    }

    public synchronized int a(byte[] bArr, long j2, int i2) {
        try {
            this.f20481c.seek(j2);
        } catch (IOException e2) {
            throw new l(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(a()), Integer.valueOf(bArr.length)}), e2);
        }
        return this.f20481c.read(bArr, 0, i2);
    }

    public synchronized void a(byte[] bArr, int i2) {
        try {
            if (!d()) {
                this.f20481c.seek((long) a());
                this.f20481c.write(bArr, 0, i2);
            } else {
                throw new l("Error append cache: cache file " + this.f20479a + " is completed!");
            }
        } catch (IOException e2) {
            throw new l(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i2), this.f20481c, Integer.valueOf(bArr.length)}), e2);
        }
    }

    public synchronized void b() {
        try {
            this.f20481c.close();
            this.f20480b.a(this.f20479a);
        } catch (IOException e2) {
            throw new l("Error closing file " + this.f20479a, e2);
        }
    }

    public synchronized void c() {
        if (!d()) {
            b();
            File file = new File(this.f20479a.getParentFile(), this.f20479a.getName().substring(0, this.f20479a.getName().length() - 9));
            if (this.f20479a.renameTo(file)) {
                this.f20479a = file;
                try {
                    this.f20481c = new RandomAccessFile(this.f20479a, "r");
                } catch (IOException e2) {
                    throw new l("Error opening " + this.f20479a + " as disc cache", e2);
                }
            } else {
                throw new l("Error renaming file " + this.f20479a + " to " + file + " for completion!");
            }
        }
    }

    public synchronized boolean d() {
        return !a(this.f20479a);
    }
}
