package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.gms.cast.framework.media.NotificationOptions;

final class AudioTimestampPoller {

    /* renamed from: a  reason: collision with root package name */
    private final AudioTimestampWrapper f5672a;

    /* renamed from: b  reason: collision with root package name */
    private int f5673b;

    /* renamed from: c  reason: collision with root package name */
    private long f5674c;

    /* renamed from: d  reason: collision with root package name */
    private long f5675d;

    /* renamed from: e  reason: collision with root package name */
    private long f5676e;

    /* renamed from: f  reason: collision with root package name */
    private long f5677f;

    private static final class AudioTimestampWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f5678a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f5679b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f5680c;

        /* renamed from: d  reason: collision with root package name */
        private long f5681d;

        /* renamed from: e  reason: collision with root package name */
        private long f5682e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5683f;

        /* renamed from: g  reason: collision with root package name */
        private long f5684g;

        public AudioTimestampWrapper(AudioTrack audioTrack) {
            this.f5678a = audioTrack;
        }

        public void a() {
            this.f5683f = true;
        }

        public long b() {
            return this.f5682e;
        }

        public long c() {
            return this.f5679b.nanoTime / 1000;
        }

        public boolean d() {
            boolean timestamp = this.f5678a.getTimestamp(this.f5679b);
            if (timestamp) {
                long j2 = this.f5679b.framePosition;
                long j3 = this.f5681d;
                if (j3 > j2) {
                    if (this.f5683f) {
                        this.f5684g += j3;
                        this.f5683f = false;
                    } else {
                        this.f5680c++;
                    }
                }
                this.f5681d = j2;
                this.f5682e = j2 + this.f5684g + (this.f5680c << 32);
            }
            return timestamp;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        this.f5672a = new AudioTimestampWrapper(audioTrack);
        h();
    }

    private void i(int i2) {
        this.f5673b = i2;
        if (i2 == 0) {
            this.f5676e = 0;
            this.f5677f = -1;
            this.f5674c = System.nanoTime() / 1000;
            this.f5675d = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        } else if (i2 == 1) {
            this.f5675d = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        } else if (i2 == 2 || i2 == 3) {
            this.f5675d = 10000000;
        } else if (i2 == 4) {
            this.f5675d = 500000;
        } else {
            throw new IllegalStateException();
        }
    }

    public void a() {
        if (this.f5673b == 4) {
            h();
        }
    }

    public void b() {
        AudioTimestampWrapper audioTimestampWrapper = this.f5672a;
        if (audioTimestampWrapper != null) {
            audioTimestampWrapper.a();
        }
    }

    public long c() {
        AudioTimestampWrapper audioTimestampWrapper = this.f5672a;
        if (audioTimestampWrapper != null) {
            return audioTimestampWrapper.b();
        }
        return -1;
    }

    public long d() {
        AudioTimestampWrapper audioTimestampWrapper = this.f5672a;
        if (audioTimestampWrapper != null) {
            return audioTimestampWrapper.c();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f5673b == 2;
    }

    public boolean f(long j2) {
        AudioTimestampWrapper audioTimestampWrapper = this.f5672a;
        if (audioTimestampWrapper == null || j2 - this.f5676e < this.f5675d) {
            return false;
        }
        this.f5676e = j2;
        boolean d2 = audioTimestampWrapper.d();
        int i2 = this.f5673b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (d2) {
                        h();
                    }
                } else if (!d2) {
                    h();
                }
            } else if (!d2) {
                h();
            } else if (this.f5672a.b() > this.f5677f) {
                i(2);
            }
        } else if (d2) {
            if (this.f5672a.c() < this.f5674c) {
                return false;
            }
            this.f5677f = this.f5672a.b();
            i(1);
        } else if (j2 - this.f5674c > 500000) {
            i(3);
        }
        return d2;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f5672a != null) {
            i(0);
        }
    }
}
