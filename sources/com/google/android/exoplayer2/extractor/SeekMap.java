package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public interface SeekMap {

    public static final class SeekPoints {

        /* renamed from: a  reason: collision with root package name */
        public final SeekPoint f24232a;

        /* renamed from: b  reason: collision with root package name */
        public final SeekPoint f24233b;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            if (!this.f24232a.equals(seekPoints.f24232a) || !this.f24233b.equals(seekPoints.f24233b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f24232a.hashCode() * 31) + this.f24233b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f24232a);
            if (this.f24232a.equals(this.f24233b)) {
                str = "";
            } else {
                str = ", " + this.f24233b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.f24232a = (SeekPoint) Assertions.e(seekPoint);
            this.f24233b = (SeekPoint) Assertions.e(seekPoint2);
        }
    }

    public static class Unseekable implements SeekMap {

        /* renamed from: a  reason: collision with root package name */
        private final long f24234a;

        /* renamed from: b  reason: collision with root package name */
        private final SeekPoints f24235b;

        public Unseekable(long j2) {
            this(j2, 0);
        }

        public SeekPoints d(long j2) {
            return this.f24235b;
        }

        public boolean f() {
            return false;
        }

        public long h() {
            return this.f24234a;
        }

        public Unseekable(long j2, long j3) {
            this.f24234a = j2;
            this.f24235b = new SeekPoints(j3 == 0 ? SeekPoint.f24236c : new SeekPoint(0, j3));
        }
    }

    SeekPoints d(long j2);

    boolean f();

    long h();
}
