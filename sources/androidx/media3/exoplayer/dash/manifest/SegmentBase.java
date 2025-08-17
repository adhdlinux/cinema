package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public abstract class SegmentBase {

    /* renamed from: a  reason: collision with root package name */
    final RangedUri f6112a;

    /* renamed from: b  reason: collision with root package name */
    final long f6113b;

    /* renamed from: c  reason: collision with root package name */
    final long f6114c;

    public static abstract class MultiSegmentBase extends SegmentBase {

        /* renamed from: d  reason: collision with root package name */
        final long f6115d;

        /* renamed from: e  reason: collision with root package name */
        final long f6116e;

        /* renamed from: f  reason: collision with root package name */
        final List<SegmentTimelineElement> f6117f;

        /* renamed from: g  reason: collision with root package name */
        private final long f6118g;

        /* renamed from: h  reason: collision with root package name */
        private final long f6119h;

        /* renamed from: i  reason: collision with root package name */
        final long f6120i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultiSegmentBase(RangedUri rangedUri, long j2, long j3, long j4, long j5, List<SegmentTimelineElement> list, long j6, long j7, long j8) {
            super(rangedUri, j2, j3);
            this.f6115d = j4;
            this.f6116e = j5;
            this.f6117f = list;
            this.f6120i = j6;
            this.f6118g = j7;
            this.f6119h = j8;
        }

        public long c(long j2, long j3) {
            long g2 = g(j2);
            if (g2 != -1) {
                return g2;
            }
            return (long) ((int) (i((j3 - this.f6119h) + this.f6120i, j2) - d(j2, j3)));
        }

        public long d(long j2, long j3) {
            if (g(j2) == -1) {
                long j4 = this.f6118g;
                if (j4 != -9223372036854775807L) {
                    return Math.max(e(), i((j3 - this.f6119h) - j4, j2));
                }
            }
            return e();
        }

        public long e() {
            return this.f6115d;
        }

        public long f(long j2, long j3) {
            if (this.f6117f != null) {
                return -9223372036854775807L;
            }
            long d2 = d(j2, j3) + c(j2, j3);
            return (j(d2) + h(d2, j2)) - this.f6120i;
        }

        public abstract long g(long j2);

        public final long h(long j2, long j3) {
            List<SegmentTimelineElement> list = this.f6117f;
            if (list != null) {
                return (list.get((int) (j2 - this.f6115d)).f6126b * 1000000) / this.f6113b;
            }
            long g2 = g(j3);
            if (g2 == -1 || j2 != (e() + g2) - 1) {
                return (this.f6116e * 1000000) / this.f6113b;
            }
            return j3 - j(j2);
        }

        public long i(long j2, long j3) {
            long e2 = e();
            long g2 = g(j3);
            if (g2 == 0) {
                return e2;
            }
            if (this.f6117f == null) {
                long j4 = this.f6115d + (j2 / ((this.f6116e * 1000000) / this.f6113b));
                if (j4 < e2) {
                    return e2;
                }
                if (g2 == -1) {
                    return j4;
                }
                return Math.min(j4, (e2 + g2) - 1);
            }
            long j5 = (g2 + e2) - 1;
            long j6 = e2;
            while (j6 <= j5) {
                long j7 = ((j5 - j6) / 2) + j6;
                int i2 = (j(j7) > j2 ? 1 : (j(j7) == j2 ? 0 : -1));
                if (i2 < 0) {
                    j6 = j7 + 1;
                } else if (i2 <= 0) {
                    return j7;
                } else {
                    j5 = j7 - 1;
                }
            }
            if (j6 == e2) {
                return j6;
            }
            return j5;
        }

        public final long j(long j2) {
            long j3;
            List<SegmentTimelineElement> list = this.f6117f;
            if (list != null) {
                j3 = list.get((int) (j2 - this.f6115d)).f6125a - this.f6114c;
            } else {
                j3 = (j2 - this.f6115d) * this.f6116e;
            }
            return Util.c1(j3, 1000000, this.f6113b);
        }

        public abstract RangedUri k(Representation representation, long j2);

        public boolean l() {
            return this.f6117f != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {

        /* renamed from: j  reason: collision with root package name */
        final List<RangedUri> f6121j;

        public SegmentList(RangedUri rangedUri, long j2, long j3, long j4, long j5, List<SegmentTimelineElement> list, long j6, List<RangedUri> list2, long j7, long j8) {
            super(rangedUri, j2, j3, j4, j5, list, j6, j7, j8);
            this.f6121j = list2;
        }

        public long g(long j2) {
            return (long) this.f6121j.size();
        }

        public RangedUri k(Representation representation, long j2) {
            return this.f6121j.get((int) (j2 - this.f6115d));
        }

        public boolean l() {
            return true;
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {

        /* renamed from: j  reason: collision with root package name */
        final UrlTemplate f6122j;

        /* renamed from: k  reason: collision with root package name */
        final UrlTemplate f6123k;

        /* renamed from: l  reason: collision with root package name */
        final long f6124l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SegmentTemplate(RangedUri rangedUri, long j2, long j3, long j4, long j5, long j6, List<SegmentTimelineElement> list, long j7, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j8, long j9) {
            super(rangedUri, j2, j3, j4, j6, list, j7, j8, j9);
            this.f6122j = urlTemplate;
            this.f6123k = urlTemplate2;
            this.f6124l = j5;
        }

        public RangedUri a(Representation representation) {
            UrlTemplate urlTemplate = this.f6122j;
            if (urlTemplate == null) {
                return SegmentBase.super.a(representation);
            }
            Format format = representation.f6099b;
            return new RangedUri(urlTemplate.a(format.f4002a, 0, format.f4010i, 0), 0, -1);
        }

        public long g(long j2) {
            List<SegmentTimelineElement> list = this.f6117f;
            if (list != null) {
                return (long) list.size();
            }
            long j3 = this.f6124l;
            if (j3 != -1) {
                return (j3 - this.f6115d) + 1;
            }
            if (j2 != -9223372036854775807L) {
                return BigIntegerMath.a(BigInteger.valueOf(j2).multiply(BigInteger.valueOf(this.f6113b)), BigInteger.valueOf(this.f6116e).multiply(BigInteger.valueOf(1000000)), RoundingMode.CEILING).longValue();
            }
            return -1;
        }

        public RangedUri k(Representation representation, long j2) {
            long j3;
            List<SegmentTimelineElement> list = this.f6117f;
            if (list != null) {
                j3 = list.get((int) (j2 - this.f6115d)).f6125a;
            } else {
                j3 = (j2 - this.f6115d) * this.f6116e;
            }
            long j4 = j3;
            UrlTemplate urlTemplate = this.f6123k;
            Format format = representation.f6099b;
            return new RangedUri(urlTemplate.a(format.f4002a, j2, format.f4010i, j4), 0, -1);
        }
    }

    public static final class SegmentTimelineElement {

        /* renamed from: a  reason: collision with root package name */
        final long f6125a;

        /* renamed from: b  reason: collision with root package name */
        final long f6126b;

        public SegmentTimelineElement(long j2, long j3) {
            this.f6125a = j2;
            this.f6126b = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SegmentTimelineElement.class != obj.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
            if (this.f6125a == segmentTimelineElement.f6125a && this.f6126b == segmentTimelineElement.f6126b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.f6125a) * 31) + ((int) this.f6126b);
        }
    }

    public SegmentBase(RangedUri rangedUri, long j2, long j3) {
        this.f6112a = rangedUri;
        this.f6113b = j2;
        this.f6114c = j3;
    }

    public RangedUri a(Representation representation) {
        return this.f6112a;
    }

    public long b() {
        return Util.c1(this.f6114c, 1000000, this.f6113b);
    }

    public static class SingleSegmentBase extends SegmentBase {

        /* renamed from: d  reason: collision with root package name */
        final long f6127d;

        /* renamed from: e  reason: collision with root package name */
        final long f6128e;

        public SingleSegmentBase(RangedUri rangedUri, long j2, long j3, long j4, long j5) {
            super(rangedUri, j2, j3);
            this.f6127d = j4;
            this.f6128e = j5;
        }

        public RangedUri c() {
            long j2 = this.f6128e;
            if (j2 <= 0) {
                return null;
            }
            return new RangedUri((String) null, this.f6127d, j2);
        }

        public SingleSegmentBase() {
            this((RangedUri) null, 1, 0, 0, 0);
        }
    }
}
