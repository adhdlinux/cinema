package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Table {

    /* renamed from: a  reason: collision with root package name */
    protected int f3142a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteBuffer f3143b;

    /* renamed from: c  reason: collision with root package name */
    private int f3144c;

    /* renamed from: d  reason: collision with root package name */
    private int f3145d;

    /* renamed from: e  reason: collision with root package name */
    Utf8 f3146e = Utf8.a();

    /* access modifiers changed from: protected */
    public int a(int i2) {
        return i2 + this.f3143b.getInt(i2);
    }

    /* access modifiers changed from: protected */
    public int b(int i2) {
        if (i2 < this.f3145d) {
            return this.f3143b.getShort(this.f3144c + i2);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void c(int i2, ByteBuffer byteBuffer) {
        this.f3143b = byteBuffer;
        if (byteBuffer != null) {
            this.f3142a = i2;
            int i3 = i2 - byteBuffer.getInt(i2);
            this.f3144c = i3;
            this.f3145d = this.f3143b.getShort(i3);
            return;
        }
        this.f3142a = 0;
        this.f3144c = 0;
        this.f3145d = 0;
    }

    /* access modifiers changed from: protected */
    public int d(int i2) {
        int i3 = i2 + this.f3142a;
        return i3 + this.f3143b.getInt(i3) + 4;
    }

    /* access modifiers changed from: protected */
    public int e(int i2) {
        int i3 = i2 + this.f3142a;
        return this.f3143b.getInt(i3 + this.f3143b.getInt(i3));
    }
}
