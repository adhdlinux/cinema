package androidx.recyclerview.widget;

import android.annotation.SuppressLint;

public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: b  reason: collision with root package name */
    final ListUpdateCallback f11022b;

    /* renamed from: c  reason: collision with root package name */
    int f11023c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f11024d = -1;

    /* renamed from: e  reason: collision with root package name */
    int f11025e = -1;

    /* renamed from: f  reason: collision with root package name */
    Object f11026f = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.f11022b = listUpdateCallback;
    }

    public void a(int i2, int i3) {
        int i4;
        if (this.f11023c == 1 && i2 >= (i4 = this.f11024d)) {
            int i5 = this.f11025e;
            if (i2 <= i4 + i5) {
                this.f11025e = i5 + i3;
                this.f11024d = Math.min(i2, i4);
                return;
            }
        }
        e();
        this.f11024d = i2;
        this.f11025e = i3;
        this.f11023c = 1;
    }

    public void b(int i2, int i3) {
        int i4;
        if (this.f11023c != 2 || (i4 = this.f11024d) < i2 || i4 > i2 + i3) {
            e();
            this.f11024d = i2;
            this.f11025e = i3;
            this.f11023c = 2;
            return;
        }
        this.f11025e += i3;
        this.f11024d = i2;
    }

    @SuppressLint({"UnknownNullness"})
    public void c(int i2, int i3, Object obj) {
        int i4;
        if (this.f11023c == 3) {
            int i5 = this.f11024d;
            int i6 = this.f11025e;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f11026f == obj) {
                this.f11024d = Math.min(i2, i5);
                this.f11025e = Math.max(i6 + i5, i4) - this.f11024d;
                return;
            }
        }
        e();
        this.f11024d = i2;
        this.f11025e = i3;
        this.f11026f = obj;
        this.f11023c = 3;
    }

    public void d(int i2, int i3) {
        e();
        this.f11022b.d(i2, i3);
    }

    public void e() {
        int i2 = this.f11023c;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f11022b.a(this.f11024d, this.f11025e);
            } else if (i2 == 2) {
                this.f11022b.b(this.f11024d, this.f11025e);
            } else if (i2 == 3) {
                this.f11022b.c(this.f11024d, this.f11025e, this.f11026f);
            }
            this.f11026f = null;
            this.f11023c = 0;
        }
    }
}
