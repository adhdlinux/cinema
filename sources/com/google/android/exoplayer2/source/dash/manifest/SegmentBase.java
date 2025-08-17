package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public abstract class SegmentBase {

    /* renamed from: a  reason: collision with root package name */
    final RangedUri f26341a;

    /* renamed from: b  reason: collision with root package name */
    final long f26342b;

    /* renamed from: c  reason: collision with root package name */
    final long f26343c;

    public static abstract class MultiSegmentBase extends SegmentBase {

        /* renamed from: d  reason: collision with root package name */
        final long f26344d;

        /* renamed from: e  reason: collision with root package name */
        final long f26345e;

        /* renamed from: f  reason: collision with root package name */
        final List<SegmentTimelineElement> f26346f;

        /* renamed from: g  reason: collision with root package name */
        private final long f26347g;

        /* renamed from: h  reason: collision with root package name */
        private final long f26348h;

        /* renamed from: i  reason: collision with root package name */
        final long f26349i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultiSegmentBase(RangedUri rangedUri, long j2, long j3, long j4, long j5, List<SegmentTimelineElement> list, long j6, long j7, long j8) {
            super(rangedUri, j2, j3);
            this.f26344d = j4;
            this.f26345e = j5;
            this.f26346f = list;
            this.f26349i = j6;
            this.f26347g = j7;
            this.f26348h = j8;
        }

        public long c(long j2, long j3) {
            long g2 = g(j2);
            if (g2 != -1) {
                return g2;
            }
            return (long) ((int) (i((j3 - this.f26348h) + this.f26349i, j2) - d(j2, j3)));
        }

        public long d(long j2, long j3) {
            if (g(j2) == -1) {
                long j4 = this.f26347g;
                if (j4 != -9223372036854775807L) {
                    return Math.max(e(), i((j3 - this.f26348h) - j4, j2));
                }
            }
            return e();
        }

        public long e() {
            return this.f26344d;
        }

        public long f(long j2, long j3) {
            if (this.f26346f != null) {
                return -9223372036854775807L;
            }
            long d2 = d(j2, j3) + c(j2, j3);
            return (j(d2) + h(d2, j2)) - this.f26349i;
        }

        public abstract long g(long j2);

        public final long h(long j2, long j3) {
            List<SegmentTimelineElement> list = this.f26346f;
            if (list != null) {
                return (list.get((int) (j2 - this.f26344d)).f26355b * 1000000) / this.f26342b;
            }
            long g2 = g(j3);
            if (g2 == -1 || j2 != (e() + g2) - 1) {
                return (this.f26345e * 1000000) / this.f26342b;
            }
            return j3 - j(j2);
        }

        public long i(long j2, long j3) {
            long e2 = e();
            long g2 = g(j3);
            if (g2 == 0) {
                return e2;
            }
            if (this.f26346f == null) {
                long j4 = this.f26344d + (j2 / ((this.f26345e * 1000000) / this.f26342b));
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
            List<SegmentTimelineElement> list = this.f26346f;
            if (list != null) {
                j3 = list.get((int) (j2 - this.f26344d)).f26354a - this.f26343c;
            } else {
                j3 = (j2 - this.f26344d) * this.f26345e;
            }
            return Util.R0(j3, 1000000, this.f26342b);
        }

        public abstract RangedUri k(Representation representation, long j2);

        public boolean l() {
            return this.f26346f != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {

        /* renamed from: j  reason: collision with root package name */
        final List<RangedUri> f26350j;

        public SegmentList(RangedUri rangedUri, long j2, long j3, long j4, long j5, List<SegmentTimelineElement> list, long j6, List<RangedUri> list2, long j7, long j8) {
            super(rangedUri, j2, j3, j4, j5, list, j6, j7, j8);
            this.f26350j = list2;
        }

        public long g(long j2) {
            return (long) this.f26350j.size();
        }

        public RangedUri k(Representation representation, long j2) {
            return this.f26350j.get((int) (j2 - this.f26344d));
        }

        public boolean l() {
            return true;
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {

        /* renamed from: j  reason: collision with root package name */
        final UrlTemplate f26351j;

        /* renamed from: k  reason: collision with root package name */
        final UrlTemplate f26352k;

        /* renamed from: l  reason: collision with root package name */
        final long f26353l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SegmentTemplate(RangedUri rangedUri, long j2, long j3, long j4, long j5, long j6, List<SegmentTimelineElement> list, long j7, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j8, long j9) {
            super(rangedUri, j2, j3, j4, j6, list, j7, j8, j9);
            this.f26351j = urlTemplate;
            this.f26352k = urlTemplate2;
            this.f26353l = j5;
        }

        public RangedUri a(Representation representation) {
            UrlTemplate urlTemplate = this.f26351j;
            if (urlTemplate == null) {
                return SegmentBase.super.a(representation);
            }
            Format format = representation.f26328b;
            return new RangedUri(urlTemplate.a(format.f23060b, 0, format.f23067i, 0), 0, -1);
        }

        public long g(long j2) {
            List<SegmentTimelineElement> list = this.f26346f;
            if (list != null) {
                return (long) list.size();
            }
            long j3 = this.f26353l;
            if (j3 != -1) {
                return (j3 - this.f26344d) + 1;
            }
            if (j2 != -9223372036854775807L) {
                return BigIntegerMath.a(BigInteger.valueOf(j2).multiply(BigInteger.valueOf(this.f26342b)), BigInteger.valueOf(this.f26345e).multiply(BigInteger.valueOf(1000000)), RoundingMode.CEILING).longValue();
            }
            return -1;
        }

        public RangedUri k(Representation representation, long j2) {
            long j3;
            List<SegmentTimelineElement> list = this.f26346f;
            if (list != null) {
                j3 = list.get((int) (j2 - this.f26344d)).f26354a;
            } else {
                j3 = (j2 - this.f26344d) * this.f26345e;
            }
            long j4 = j3;
            UrlTemplate urlTemplate = this.f26352k;
            Format format = representation.f26328b;
            return new RangedUri(urlTemplate.a(format.f23060b, j2, format.f23067i, j4), 0, -1);
        }
    }

    public static final class SegmentTimelineElement {

        /* renamed from: a  reason: collision with root package name */
        final long f26354a;

        /* renamed from: b  reason: collision with root package name */
        final long f26355b;

        public SegmentTimelineElement(long j2, long j3) {
            this.f26354a = j2;
            this.f26355b = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SegmentTimelineElement.class != obj.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
            if (this.f26354a == segmentTimelineElement.f26354a && this.f26355b == segmentTimelineElement.f26355b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.f26354a) * 31) + ((int) this.f26355b);
        }
    }

    public SegmentBase(RangedUri rangedUri, long j2, long j3) {
        this.f26341a = rangedUri;
        this.f26342b = j2;
        this.f26343c = j3;
    }

    public RangedUri a(Representation representation) {
        return this.f26341a;
    }

    public long b() {
        return Util.R0(this.f26343c, 1000000, this.f26342b);
    }

    public static class SingleSegmentBase extends SegmentBase {

        /* renamed from: d  reason: collision with root package name */
        final long f26356d;

        /* renamed from: e  reason: collision with root package name */
        final long f26357e;

        public SingleSegmentBase(RangedUri rangedUri, long j2, long j3, long j4, long j5) {
            super(rangedUri, j2, j3);
            this.f26356d = j4;
            this.f26357e = j5;
        }

        public RangedUri c() {
            long j2 = this.f26357e;
            if (j2 <= 0) {
                return null;
            }
            return new RangedUri((String) null, this.f26356d, j2);
        }

        public SingleSegmentBase() {
            this((RangedUri) null, 1, 0, 0, 0);
        }
    }
}
