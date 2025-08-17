package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.framework.media.NotificationOptions;

final class AudioTimestampPoller {

    /* renamed from: a  reason: collision with root package name */
    private final AudioTimestampV19 f23697a;

    /* renamed from: b  reason: collision with root package name */
    private int f23698b;

    /* renamed from: c  reason: collision with root package name */
    private long f23699c;

    /* renamed from: d  reason: collision with root package name */
    private long f23700d;

    /* renamed from: e  reason: collision with root package name */
    private long f23701e;

    /* renamed from: f  reason: collision with root package name */
    private long f23702f;

    private static final class AudioTimestampV19 {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f23703a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f23704b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f23705c;

        /* renamed from: d  reason: collision with root package name */
        private long f23706d;

        /* renamed from: e  reason: collision with root package name */
        private long f23707e;

        public AudioTimestampV19(AudioTrack audioTrack) {
            this.f23703a = audioTrack;
        }

        public long a() {
            return this.f23707e;
        }

        public long b() {
            return this.f23704b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f23703a.getTimestamp(this.f23704b);
            if (timestamp) {
                long j2 = this.f23704b.framePosition;
                if (this.f23706d > j2) {
                    this.f23705c++;
                }
                this.f23706d = j2;
                this.f23707e = j2 + (this.f23705c << 32);
            }
            return timestamp;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util.f28808a >= 19) {
            this.f23697a = new AudioTimestampV19(audioTrack);
            g();
            return;
        }
        this.f23697a = null;
        h(3);
    }

    private void h(int i2) {
        this.f23698b = i2;
        if (i2 == 0) {
            this.f23701e = 0;
            this.f23702f = -1;
            this.f23699c = System.nanoTime() / 1000;
            this.f23700d = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        } else if (i2 == 1) {
            this.f23700d = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        } else if (i2 == 2 || i2 == 3) {
            this.f23700d = 10000000;
        } else if (i2 == 4) {
            this.f23700d = 500000;
        } else {
            throw new IllegalStateException();
        }
    }

    public void a() {
        if (this.f23698b == 4) {
            g();
        }
    }

    @TargetApi(19)
    public long b() {
        AudioTimestampV19 audioTimestampV19 = this.f23697a;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.a();
        }
        return -1;
    }

    @TargetApi(19)
    public long c() {
        AudioTimestampV19 audioTimestampV19 = this.f23697a;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.f23698b == 2;
    }

    @TargetApi(19)
    public boolean e(long j2) {
        AudioTimestampV19 audioTimestampV19 = this.f23697a;
        if (audioTimestampV19 == null || j2 - this.f23701e < this.f23700d) {
            return false;
        }
        this.f23701e = j2;
        boolean c2 = audioTimestampV19.c();
        int i2 = this.f23698b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (c2) {
                        g();
                    }
                } else if (!c2) {
                    g();
                }
            } else if (!c2) {
                g();
            } else if (this.f23697a.a() > this.f23702f) {
                h(2);
            }
        } else if (c2) {
            if (this.f23697a.b() < this.f23699c) {
                return false;
            }
            this.f23702f = this.f23697a.a();
            h(1);
        } else if (j2 - this.f23699c > 500000) {
            h(3);
        }
        return c2;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f23697a != null) {
            h(0);
        }
    }
}
