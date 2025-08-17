package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;

final class AviMainHeaderChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final int f8160a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8161b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8162c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8163d;

    private AviMainHeaderChunk(int i2, int i3, int i4, int i5) {
        this.f8160a = i2;
        this.f8161b = i3;
        this.f8162c = i4;
        this.f8163d = i5;
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
        return (this.f8161b & 16) == 16;
    }

    public int getType() {
        return 1751742049;
    }
}
