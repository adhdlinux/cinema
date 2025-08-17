package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    private static final Queue<ExceptionCatchingInputStream> f17139d = Util.e(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f17140b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f17141c;

    ExceptionCatchingInputStream() {
    }

    public static ExceptionCatchingInputStream f(InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        Queue<ExceptionCatchingInputStream> queue = f17139d;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.i(inputStream);
        return poll;
    }

    public IOException a() {
        return this.f17141c;
    }

    public int available() throws IOException {
        return this.f17140b.available();
    }

    public void close() throws IOException {
        this.f17140b.close();
    }

    /* access modifiers changed from: package-private */
    public void i(InputStream inputStream) {
        this.f17140b = inputStream;
    }

    public void mark(int i2) {
        this.f17140b.mark(i2);
    }

    public boolean markSupported() {
        return this.f17140b.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f17140b.read(bArr);
        } catch (IOException e2) {
            this.f17141c = e2;
            return -1;
        }
    }

    public void release() {
        this.f17141c = null;
        this.f17140b = null;
        Queue<ExceptionCatchingInputStream> queue = f17139d;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.f17140b.reset();
    }

    public long skip(long j2) {
        try {
            return this.f17140b.skip(j2);
        } catch (IOException e2) {
            this.f17141c = e2;
            return 0;
        }
    }

    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f17140b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f17141c = e2;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f17140b.read();
        } catch (IOException e2) {
            this.f17141c = e2;
            return -1;
        }
    }
}
