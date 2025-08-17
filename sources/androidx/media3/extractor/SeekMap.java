package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;

public interface SeekMap {

    public static final class SeekPoints {

        /* renamed from: a  reason: collision with root package name */
        public final SeekPoint f8070a;

        /* renamed from: b  reason: collision with root package name */
        public final SeekPoint f8071b;

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
            if (!this.f8070a.equals(seekPoints.f8070a) || !this.f8071b.equals(seekPoints.f8071b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f8070a.hashCode() * 31) + this.f8071b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f8070a);
            if (this.f8070a.equals(this.f8071b)) {
                str = "";
            } else {
                str = ", " + this.f8071b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.f8070a = (SeekPoint) Assertions.f(seekPoint);
            this.f8071b = (SeekPoint) Assertions.f(seekPoint2);
        }
    }

    public static class Unseekable implements SeekMap {

        /* renamed from: a  reason: collision with root package name */
        private final long f8072a;

        /* renamed from: b  reason: collision with root package name */
        private final SeekPoints f8073b;

        public Unseekable(long j2) {
            this(j2, 0);
        }

        public SeekPoints d(long j2) {
            return this.f8073b;
        }

        public boolean f() {
            return false;
        }

        public long h() {
            return this.f8072a;
        }

        public Unseekable(long j2, long j3) {
            this.f8072a = j2;
            this.f8073b = new SeekPoints(j3 == 0 ? SeekPoint.f8074c : new SeekPoint(0, j3));
        }
    }

    SeekPoints d(long j2);

    boolean f();

    long h();
}
