package androidx.media3.exoplayer.upstream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator<Sample> f7558h = new b();

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<Sample> f7559i = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f7560a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Sample> f7561b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Sample[] f7562c = new Sample[5];

    /* renamed from: d  reason: collision with root package name */
    private int f7563d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f7564e;

    /* renamed from: f  reason: collision with root package name */
    private int f7565f;

    /* renamed from: g  reason: collision with root package name */
    private int f7566g;

    private static class Sample {

        /* renamed from: a  reason: collision with root package name */
        public int f7567a;

        /* renamed from: b  reason: collision with root package name */
        public int f7568b;

        /* renamed from: c  reason: collision with root package name */
        public float f7569c;

        private Sample() {
        }
    }

    public SlidingPercentile(int i2) {
        this.f7560a = i2;
    }

    private void d() {
        if (this.f7563d != 1) {
            Collections.sort(this.f7561b, f7558h);
            this.f7563d = 1;
        }
    }

    private void e() {
        if (this.f7563d != 0) {
            Collections.sort(this.f7561b, f7559i);
            this.f7563d = 0;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(Sample sample, Sample sample2) {
        return sample.f7567a - sample2.f7567a;
    }

    public void c(int i2, float f2) {
        Sample sample;
        d();
        int i3 = this.f7566g;
        if (i3 > 0) {
            Sample[] sampleArr = this.f7562c;
            int i4 = i3 - 1;
            this.f7566g = i4;
            sample = sampleArr[i4];
        } else {
            sample = new Sample();
        }
        int i5 = this.f7564e;
        this.f7564e = i5 + 1;
        sample.f7567a = i5;
        sample.f7568b = i2;
        sample.f7569c = f2;
        this.f7561b.add(sample);
        this.f7565f += i2;
        while (true) {
            int i6 = this.f7565f;
            int i7 = this.f7560a;
            if (i6 > i7) {
                int i8 = i6 - i7;
                Sample sample2 = this.f7561b.get(0);
                int i9 = sample2.f7568b;
                if (i9 <= i8) {
                    this.f7565f -= i9;
                    this.f7561b.remove(0);
                    int i10 = this.f7566g;
                    if (i10 < 5) {
                        Sample[] sampleArr2 = this.f7562c;
                        this.f7566g = i10 + 1;
                        sampleArr2[i10] = sample2;
                    }
                } else {
                    sample2.f7568b = i9 - i8;
                    this.f7565f -= i8;
                }
            } else {
                return;
            }
        }
    }

    public float f(float f2) {
        e();
        float f3 = f2 * ((float) this.f7565f);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7561b.size(); i3++) {
            Sample sample = this.f7561b.get(i3);
            i2 += sample.f7568b;
            if (((float) i2) >= f3) {
                return sample.f7569c;
            }
        }
        if (this.f7561b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<Sample> arrayList = this.f7561b;
        return arrayList.get(arrayList.size() - 1).f7569c;
    }

    public void i() {
        this.f7561b.clear();
        this.f7563d = -1;
        this.f7564e = 0;
        this.f7565f = 0;
    }
}
