package com.google.ar.core;

import android.graphics.Rect;
import android.media.Image;
import com.google.ar.core.dependencies.b;
import com.google.ar.core.exceptions.FatalException;
import java.nio.ByteBuffer;

class ArImage extends b {

    /* renamed from: b  reason: collision with root package name */
    private final Session f30226b;

    /* renamed from: c  reason: collision with root package name */
    private final long f30227c;

    /* renamed from: d  reason: collision with root package name */
    long f30228d;

    ArImage(Session session, long j2) {
        this.f30226b = session;
        this.f30228d = j2;
        this.f30227c = session.nativeSymbolTableHandle;
    }

    private native void nativeClose(long j2, long j3);

    /* access modifiers changed from: private */
    /* renamed from: nativeGetBuffer */
    public native ByteBuffer i(long j2, long j3, int i2);

    private native int nativeGetFormat(long j2, long j3);

    private native int nativeGetHeight(long j2, long j3);

    private native int nativeGetNumberOfPlanes(long j2, long j3);

    /* access modifiers changed from: private */
    /* renamed from: nativeGetPixelStride */
    public native int f(long j2, long j3, int i2);

    /* access modifiers changed from: private */
    /* renamed from: nativeGetRowStride */
    public native int a(long j2, long j3, int i2);

    private native long nativeGetTimestamp(long j2, long j3);

    private native int nativeGetWidth(long j2, long j3);

    static native void nativeLoadSymbols();

    public final void close() {
        nativeClose(this.f30227c, this.f30228d);
        this.f30228d = 0;
    }

    public final Rect getCropRect() {
        return new Rect(0, 0, getWidth(), getHeight());
    }

    public final int getFormat() {
        int nativeGetFormat = nativeGetFormat(this.f30226b.nativeWrapperHandle, this.f30228d);
        if (nativeGetFormat != -1) {
            return nativeGetFormat;
        }
        throw new FatalException("Unknown error in ArImage.getFormat().");
    }

    public final int getHeight() {
        int nativeGetHeight = nativeGetHeight(this.f30226b.nativeWrapperHandle, this.f30228d);
        if (nativeGetHeight != -1) {
            return nativeGetHeight;
        }
        throw new FatalException("Unknown error in ArImage.getHeight().");
    }

    public final Image.Plane[] getPlanes() {
        int nativeGetNumberOfPlanes = nativeGetNumberOfPlanes(this.f30226b.nativeWrapperHandle, this.f30228d);
        if (nativeGetNumberOfPlanes != -1) {
            n[] nVarArr = new n[nativeGetNumberOfPlanes];
            for (int i2 = 0; i2 < nativeGetNumberOfPlanes; i2++) {
                nVarArr[i2] = new n(this, this.f30228d, i2);
            }
            return nVarArr;
        }
        throw new FatalException("Unknown error in ArImage.getPlanes().");
    }

    public final long getTimestamp() {
        long nativeGetTimestamp = nativeGetTimestamp(this.f30226b.nativeWrapperHandle, this.f30228d);
        if (nativeGetTimestamp != -1) {
            return nativeGetTimestamp;
        }
        throw new FatalException("Unknown error in ArImage.getTimestamp().");
    }

    public final int getWidth() {
        int nativeGetWidth = nativeGetWidth(this.f30226b.nativeWrapperHandle, this.f30228d);
        if (nativeGetWidth != -1) {
            return nativeGetWidth;
        }
        throw new FatalException("Unknown error in ArImage.getWidth().");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Session k() {
        return this.f30226b;
    }

    public final void setCropRect(Rect rect) {
        throw new UnsupportedOperationException("This is a read-only image.");
    }

    public final void setTimestamp(long j2) {
        throw new UnsupportedOperationException("This is a read-only image.");
    }
}
