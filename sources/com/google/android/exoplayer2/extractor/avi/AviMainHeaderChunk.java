package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class AviMainHeaderChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final int f24316a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24317b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24318c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24319d;

    private AviMainHeaderChunk(int i2, int i3, int i4, int i5) {
        this.f24316a = i2;
        this.f24317b = i3;
        this.f24318c = i4;
        this.f24319d = i5;
    }

    public static AviMainHeaderChunk b(ParsableByteArray parsableByteArray) {
        int u2 = parsableByteArray.u();
        parsableByteArray.V(8);
        int u3 = parsableByteArray.u();
        int u4 = parsableByteArray.u();
        parsableByteArray.V(4);
        int u5 = parsableByteArray.u();
        parsableByteArray.V(12);
        return new AviMainHeaderChunk(u2, u3, u4, u5);
    }

    public boolean a() {
        return (this.f24317b & 16) == 16;
    }

    public int getType() {
        return 1751742049;
    }
}
