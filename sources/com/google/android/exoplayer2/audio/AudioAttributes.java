package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;

public final class AudioAttributes implements Bundleable {

    /* renamed from: h  reason: collision with root package name */
    public static final AudioAttributes f23655h = new Builder().a();

    /* renamed from: i  reason: collision with root package name */
    private static final String f23656i = Util.u0(0);

    /* renamed from: j  reason: collision with root package name */
    private static final String f23657j = Util.u0(1);

    /* renamed from: k  reason: collision with root package name */
    private static final String f23658k = Util.u0(2);

    /* renamed from: l  reason: collision with root package name */
    private static final String f23659l = Util.u0(3);

    /* renamed from: m  reason: collision with root package name */
    private static final String f23660m = Util.u0(4);

    /* renamed from: n  reason: collision with root package name */
    public static final Bundleable.Creator<AudioAttributes> f23661n = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f23662b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23663c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23664d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23665e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23666f;

    /* renamed from: g  reason: collision with root package name */
    private AudioAttributesV21 f23667g;

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
        public final android.media.AudioAttributes f23668a;

        private AudioAttributesV21(AudioAttributes audioAttributes) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(audioAttributes.f23662b).setFlags(audioAttributes.f23663c).setUsage(audioAttributes.f23664d);
            int i2 = Util.f28808a;
            if (i2 >= 29) {
                Api29.a(usage, audioAttributes.f23665e);
            }
            if (i2 >= 32) {
                Api32.a(usage, audioAttributes.f23666f);
            }
            this.f23668a = usage.build();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f23669a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f23670b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f23671c = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f23672d = 1;

        /* renamed from: e  reason: collision with root package name */
        private int f23673e = 0;

        public AudioAttributes a() {
            return new AudioAttributes(this.f23669a, this.f23670b, this.f23671c, this.f23672d, this.f23673e);
        }

        public Builder b(int i2) {
            this.f23672d = i2;
            return this;
        }

        public Builder c(int i2) {
            this.f23669a = i2;
            return this;
        }

        public Builder d(int i2) {
            this.f23670b = i2;
            return this;
        }

        public Builder e(int i2) {
            this.f23673e = i2;
            return this;
        }

        public Builder f(int i2) {
            this.f23671c = i2;
            return this;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ AudioAttributes c(Bundle bundle) {
        Builder builder = new Builder();
        String str = f23656i;
        if (bundle.containsKey(str)) {
            builder.c(bundle.getInt(str));
        }
        String str2 = f23657j;
        if (bundle.containsKey(str2)) {
            builder.d(bundle.getInt(str2));
        }
        String str3 = f23658k;
        if (bundle.containsKey(str3)) {
            builder.f(bundle.getInt(str3));
        }
        String str4 = f23659l;
        if (bundle.containsKey(str4)) {
            builder.b(bundle.getInt(str4));
        }
        String str5 = f23660m;
        if (bundle.containsKey(str5)) {
            builder.e(bundle.getInt(str5));
        }
        return builder.a();
    }

    public AudioAttributesV21 b() {
        if (this.f23667g == null) {
            this.f23667g = new AudioAttributesV21();
        }
        return this.f23667g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        if (this.f23662b == audioAttributes.f23662b && this.f23663c == audioAttributes.f23663c && this.f23664d == audioAttributes.f23664d && this.f23665e == audioAttributes.f23665e && this.f23666f == audioAttributes.f23666f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f23662b) * 31) + this.f23663c) * 31) + this.f23664d) * 31) + this.f23665e) * 31) + this.f23666f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f23656i, this.f23662b);
        bundle.putInt(f23657j, this.f23663c);
        bundle.putInt(f23658k, this.f23664d);
        bundle.putInt(f23659l, this.f23665e);
        bundle.putInt(f23660m, this.f23666f);
        return bundle;
    }

    private AudioAttributes(int i2, int i3, int i4, int i5, int i6) {
        this.f23662b = i2;
        this.f23663c = i3;
        this.f23664d = i4;
        this.f23665e = i5;
        this.f23666f = i6;
    }
}
