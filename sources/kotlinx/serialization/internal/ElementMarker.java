package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class ElementMarker {

    /* renamed from: e  reason: collision with root package name */
    private static final Companion f40978e = new Companion((DefaultConstructorMarker) null);
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    private static final long[] f40979f = new long[0];

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f40980a;

    /* renamed from: b  reason: collision with root package name */
    private final Function2<SerialDescriptor, Integer, Boolean> f40981b;

    /* renamed from: c  reason: collision with root package name */
    private long f40982c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f40983d;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ElementMarker(SerialDescriptor serialDescriptor, Function2<? super SerialDescriptor, ? super Integer, Boolean> function2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(function2, "readIfAbsent");
        this.f40980a = serialDescriptor;
        this.f40981b = function2;
        int e2 = serialDescriptor.e();
        long j2 = 0;
        if (e2 <= 64) {
            this.f40982c = e2 != 64 ? -1 << e2 : j2;
            this.f40983d = f40979f;
            return;
        }
        this.f40982c = 0;
        this.f40983d = e(e2);
    }

    private final void b(int i2) {
        int i3 = (i2 >>> 6) - 1;
        long[] jArr = this.f40983d;
        jArr[i3] = jArr[i3] | (1 << (i2 & 63));
    }

    private final int c() {
        int length = this.f40983d.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int i4 = i3 * 64;
            long j2 = this.f40983d[i2];
            while (j2 != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j2);
                j2 |= 1 << numberOfTrailingZeros;
                int i5 = numberOfTrailingZeros + i4;
                if (this.f40981b.invoke(this.f40980a, Integer.valueOf(i5)).booleanValue()) {
                    this.f40983d[i2] = j2;
                    return i5;
                }
            }
            this.f40983d[i2] = j2;
            i2 = i3;
        }
        return -1;
    }

    private final long[] e(int i2) {
        long[] jArr = new long[((i2 - 1) >>> 6)];
        if ((i2 & 63) != 0) {
            jArr[ArraysKt___ArraysKt.x(jArr)] = -1 << i2;
        }
        return jArr;
    }

    public final void a(int i2) {
        if (i2 < 64) {
            this.f40982c |= 1 << i2;
        } else {
            b(i2);
        }
    }

    public final int d() {
        int numberOfTrailingZeros;
        int e2 = this.f40980a.e();
        do {
            long j2 = this.f40982c;
            if (j2 != -1) {
                numberOfTrailingZeros = Long.numberOfTrailingZeros(~j2);
                this.f40982c |= 1 << numberOfTrailingZeros;
            } else if (e2 > 64) {
                return c();
            } else {
                return -1;
            }
        } while (!this.f40981b.invoke(this.f40980a, Integer.valueOf(numberOfTrailingZeros)).booleanValue());
        return numberOfTrailingZeros;
    }
}
