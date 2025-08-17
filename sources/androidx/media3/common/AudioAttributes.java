package androidx.media3.common;

import android.media.AudioAttributes;
import androidx.media3.common.util.Util;

public final class AudioAttributes {

    /* renamed from: g  reason: collision with root package name */
    public static final AudioAttributes f3909g = new Builder().a();

    /* renamed from: h  reason: collision with root package name */
    private static final String f3910h = Util.B0(0);

    /* renamed from: i  reason: collision with root package name */
    private static final String f3911i = Util.B0(1);

    /* renamed from: j  reason: collision with root package name */
    private static final String f3912j = Util.B0(2);

    /* renamed from: k  reason: collision with root package name */
    private static final String f3913k = Util.B0(3);

    /* renamed from: l  reason: collision with root package name */
    private static final String f3914l = Util.B0(4);

    /* renamed from: a  reason: collision with root package name */
    public final int f3915a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3916b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3917c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3918d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3919e;

    /* renamed from: f  reason: collision with root package name */
    private AudioAttributesV21 f3920f;

    private static final class Api29 {
        private Api29() {
        }

        public static void a(AudioAttributes.Builder builder, int i2) {
            AudioAttributes.Builder unused = builder.setAllowedCapturePolicy(i2);
        }
    }

    private static final class Api32 {
        private Api32() {
        }

        public static void a(AudioAttributes.Builder builder, int i2) {
            builder.setSpatializationBehavior(i2);
        }
    }

    public static final class AudioAttributesV21 {

        /* renamed from: a  reason: collision with root package name */
        public final android.media.AudioAttributes f3921a;

        private AudioAttributesV21(AudioAttributes audioAttributes) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(audioAttributes.f3915a).setFlags(audioAttributes.f3916b).setUsage(audioAttributes.f3917c);
            int i2 = Util.f4714a;
            if (i2 >= 29) {
                Api29.a(usage, audioAttributes.f3918d);
            }
            if (i2 >= 32) {
                Api32.a(usage, audioAttributes.f3919e);
            }
            this.f3921a = usage.build();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f3922a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f3923b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f3924c = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f3925d = 1;

        /* renamed from: e  reason: collision with root package name */
        private int f3926e = 0;

        public AudioAttributes a() {
            return new AudioAttributes(this.f3922a, this.f3923b, this.f3924c, this.f3925d, this.f3926e);
        }
    }

    public AudioAttributesV21 a() {
        if (this.f3920f == null) {
            this.f3920f = new AudioAttributesV21();
        }
        return this.f3920f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        if (this.f3915a == audioAttributes.f3915a && this.f3916b == audioAttributes.f3916b && this.f3917c == audioAttributes.f3917c && this.f3918d == audioAttributes.f3918d && this.f3919e == audioAttributes.f3919e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f3915a) * 31) + this.f3916b) * 31) + this.f3917c) * 31) + this.f3918d) * 31) + this.f3919e;
    }

    private AudioAttributes(int i2, int i3, int i4, int i5, int i6) {
        this.f3915a = i2;
        this.f3916b = i3;
        this.f3917c = i4;
        this.f3918d = i5;
        this.f3919e = i6;
    }
}
