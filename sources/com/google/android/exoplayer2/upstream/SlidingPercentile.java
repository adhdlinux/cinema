package com.google.android.exoplayer2.upstream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator<Sample> f28500h = new d();

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<Sample> f28501i = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f28502a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Sample> f28503b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Sample[] f28504c = new Sample[5];

    /* renamed from: d  reason: collision with root package name */
    private int f28505d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f28506e;

    /* renamed from: f  reason: collision with root package name */
    private int f28507f;

    /* renamed from: g  reason: collision with root package name */
    private int f28508g;

    private static class Sample {

        /* renamed from: a  reason: collision with root package name */
        public int f28509a;

        /* renamed from: b  reason: collision with root package name */
        public int f28510b;

        /* renamed from: c  reason: collision with root package name */
        public float f28511c;

        private Sample() {
        }
    }

    public SlidingPercentile(int i2) {
        this.f28502a = i2;
    }

    private void d() {
        if (this.f28505d != 1) {
            Collections.sort(this.f28503b, f28500h);
            this.f28505d = 1;
        }
    }

    private void e() {
        if (this.f28505d != 0) {
            Collections.sort(this.f28503b, f28501i);
            this.f28505d = 0;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(Sample sample, Sample sample2) {
        return sample.f28509a - sample2.f28509a;
    }

    public void c(int i2, float f2) {
        Sample sample;
        d();
        int i3 = this.f28508g;
        if (i3 > 0) {
            Sample[] sampleArr = this.f28504c;
            int i4 = i3 - 1;
            this.f28508g = i4;
            sample = sampleArr[i4];
        } else {
            sample = new Sample();
        }
        int i5 = this.f28506e;
        this.f28506e = i5 + 1;
        sample.f28509a = i5;
        sample.f28510b = i2;
        sample.f28511c = f2;
        this.f28503b.add(sample);
        this.f28507f += i2;
        while (true) {
            int i6 = this.f28507f;
            int i7 = this.f28502a;
            if (i6 > i7) {
                int i8 = i6 - i7;
                Sample sample2 = this.f28503b.get(0);
                int i9 = sample2.f28510b;
                if (i9 <= i8) {
                    this.f28507f -= i9;
                    this.f28503b.remove(0);
                    int i10 = this.f28508g;
                    if (i10 < 5) {
                        Sample[] sampleArr2 = this.f28504c;
                        this.f28508g = i10 + 1;
                        sampleArr2[i10] = sample2;
                    }
                } else {
                    sample2.f28510b = i9 - i8;
                    this.f28507f -= i8;
                }
            } else {
                return;
            }
        }
    }

    public float f(float f2) {
        e();
        float f3 = f2 * ((float) this.f28507f);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f28503b.size(); i3++) {
            Sample sample = this.f28503b.get(i3);
            i2 += sample.f28510b;
            if (((float) i2) >= f3) {
                return sample.f28511c;
            }
        }
        if (this.f28503b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<Sample> arrayList = this.f28503b;
        return arrayList.get(arrayList.size() - 1).f28511c;
    }

    public void i() {
        this.f28503b.clear();
        this.f28505d = -1;
        this.f28506e = 0;
        this.f28507f = 0;
    }
}
