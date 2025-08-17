package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Arrays;

public final class AudioCapabilities {

    /* renamed from: c  reason: collision with root package name */
    public static final AudioCapabilities f23674c = new AudioCapabilities(new int[]{2}, 8);

    /* renamed from: d  reason: collision with root package name */
    private static final AudioCapabilities f23675d = new AudioCapabilities(new int[]{2, 5, 6}, 8);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final ImmutableMap<Integer, Integer> f23676e = new ImmutableMap.Builder().f(5, 6).f(17, 6).f(7, 6).f(18, 6).f(6, 8).f(8, 8).f(14, 8).c();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f23677a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23678b;

    private static final class Api29 {

        /* renamed from: a  reason: collision with root package name */
        private static final AudioAttributes f23679a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        private Api29() {
        }

        public static int[] a() {
            ImmutableList.Builder k2 = ImmutableList.k();
            UnmodifiableIterator h2 = AudioCapabilities.f23676e.keySet().iterator();
            while (h2.hasNext()) {
                int intValue = ((Integer) h2.next()).intValue();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), f23679a)) {
                    k2.d(Integer.valueOf(intValue));
                }
            }
            k2.d(2);
            return Ints.n(k2.k());
        }

        public static int b(int i2, int i3) {
            for (int i4 = 8; i4 > 0; i4--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i3).setChannelMask(Util.G(i4)).build(), f23679a)) {
                    return i4;
                }
            }
            return 0;
        }
    }

    public AudioCapabilities(int[] iArr, int i2) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f23677a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f23677a = new int[0];
        }
        this.f23678b = i2;
    }

    private static boolean b() {
        if (Util.f28808a >= 17) {
            String str = Util.f28810c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static AudioCapabilities c(Context context) {
        return d(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static AudioCapabilities d(Context context, Intent intent) {
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f23675d;
        }
        if (Util.f28808a >= 29 && (Util.A0(context) || Util.v0(context))) {
            return new AudioCapabilities(Api29.a(), 8);
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return f23674c;
        }
        return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    private static int e(int i2) {
        int i3 = Util.f28808a;
        if (i3 <= 28) {
            if (i2 == 7) {
                i2 = 8;
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                i2 = 6;
            }
        }
        if (i3 <= 26 && "fugu".equals(Util.f28809b) && i2 == 1) {
            i2 = 2;
        }
        return Util.G(i2);
    }

    private static int g(int i2, int i3) {
        if (Util.f28808a >= 29) {
            return Api29.b(i2, i3);
        }
        return ((Integer) Assertions.e(f23676e.getOrDefault(Integer.valueOf(i2), 0))).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (!Arrays.equals(this.f23677a, audioCapabilities.f23677a) || this.f23678b != audioCapabilities.f23678b) {
            return false;
        }
        return true;
    }

    public Pair<Integer, Integer> f(Format format) {
        int f2 = MimeTypes.f((String) Assertions.e(format.f23071m), format.f23068j);
        if (!f23676e.containsKey(Integer.valueOf(f2))) {
            return null;
        }
        if (f2 == 18 && !i(18)) {
            f2 = 6;
        } else if (f2 == 8 && !i(8)) {
            f2 = 7;
        }
        if (!i(f2)) {
            return null;
        }
        int i2 = format.f23084z;
        if (i2 == -1 || f2 == 18) {
            int i3 = format.A;
            if (i3 == -1) {
                i3 = 48000;
            }
            i2 = g(f2, i3);
        } else if (i2 > this.f23678b) {
            return null;
        }
        int e2 = e(i2);
        if (e2 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f2), Integer.valueOf(e2));
    }

    public boolean h(Format format) {
        return f(format) != null;
    }

    public int hashCode() {
        return this.f23678b + (Arrays.hashCode(this.f23677a) * 31);
    }

    public boolean i(int i2) {
        return Arrays.binarySearch(this.f23677a, i2) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f23678b + ", supportedEncodings=" + Arrays.toString(this.f23677a) + "]";
    }
}
