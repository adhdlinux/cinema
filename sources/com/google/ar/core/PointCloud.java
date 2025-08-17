package com.google.ar.core;

import com.google.ar.core.exceptions.DeadlineExceededException;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class PointCloud implements Closeable {
    private long nativeHandle;
    private final long nativeSymbolTableHandle;
    private final Session session;

    protected PointCloud() {
        this.nativeHandle = 0;
        this.session = null;
        this.nativeSymbolTableHandle = 0;
    }

    PointCloud(Session session2, long j2) {
        this.session = session2;
        this.nativeHandle = j2;
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    private native ByteBuffer nativeGetData(long j2, long j3);

    private native ByteBuffer nativeGetIds(long j2, long j3);

    private native long nativeGetTimestamp(long j2, long j3);

    private native void nativeReleasePointCloud(long j2, long j3);

    public void close() {
        release();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeReleasePointCloud(this.nativeSymbolTableHandle, j2);
        }
        super.finalize();
    }

    public IntBuffer getIds() {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            return Session.directByteBufferOrDefault(nativeGetIds(this.session.nativeWrapperHandle, j2)).asIntBuffer();
        }
        throw new DeadlineExceededException();
    }

    public FloatBuffer getPoints() {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            return Session.directByteBufferOrDefault(nativeGetData(this.session.nativeWrapperHandle, j2)).asFloatBuffer();
        }
        throw new DeadlineExceededException();
    }

    public long getTimestamp() {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            return nativeGetTimestamp(this.session.nativeWrapperHandle, j2);
        }
        throw new DeadlineExceededException();
    }

    public void release() {
        nativeReleasePointCloud(this.nativeSymbolTableHandle, this.nativeHandle);
        this.nativeHandle = 0;
    }
}
