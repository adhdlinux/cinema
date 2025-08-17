package com.google.ar.core;

import com.google.ar.core.dependencies.a;
import com.google.ar.core.exceptions.FatalException;
import java.nio.ByteBuffer;

final class n extends a {

    /* renamed from: a  reason: collision with root package name */
    private final long f30344a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30345b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ArImage f30346c;

    public n(ArImage arImage, long j2, int i2) {
        this.f30346c = arImage;
        this.f30344a = j2;
        this.f30345b = i2;
    }

    public final ByteBuffer getBuffer() {
        ArImage arImage = this.f30346c;
        return arImage.i(arImage.k().nativeWrapperHandle, this.f30344a, this.f30345b).asReadOnlyBuffer();
    }

    public final int getPixelStride() {
        ArImage arImage = this.f30346c;
        int f2 = arImage.f(arImage.k().nativeWrapperHandle, this.f30344a, this.f30345b);
        if (f2 != -1) {
            return f2;
        }
        throw new FatalException("Unknown error in ArImage.Plane.getPixelStride().");
    }

    public final int getRowStride() {
        ArImage arImage = this.f30346c;
        int a2 = arImage.a(arImage.k().nativeWrapperHandle, this.f30344a, this.f30345b);
        if (a2 != -1) {
            return a2;
        }
        throw new FatalException("Unknown error in ArImage.Plane.getRowStride().");
    }
}
