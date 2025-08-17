package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Mesh {
    long nativeHandle;
    final long nativeSymbolTableHandle;
    private final Session session;

    Mesh(long j2, Session session2) {
        this.session = session2;
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
        this.nativeHandle = j2;
    }

    private native ByteBuffer nativeGetIndexList(long j2, long j3);

    private native int nativeGetIndexListSize(long j2, long j3);

    private native ByteBuffer nativeGetVertexList(long j2, long j3);

    private native int nativeGetVertexListSize(long j2, long j3);

    public IntBuffer getIndexList() {
        return Session.directByteBufferOrDefault(nativeGetIndexList(this.session.nativeWrapperHandle, this.nativeHandle)).asIntBuffer();
    }

    public int getIndexListSize() {
        return nativeGetIndexListSize(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public FloatBuffer getVertexList() {
        return Session.directByteBufferOrDefault(nativeGetVertexList(this.session.nativeWrapperHandle, this.nativeHandle)).asFloatBuffer();
    }

    public int getVertexListSize() {
        return nativeGetVertexListSize(this.session.nativeWrapperHandle, this.nativeHandle);
    }
}
