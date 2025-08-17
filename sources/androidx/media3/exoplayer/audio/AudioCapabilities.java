package androidx.media3.exoplayer.audio;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import com.unity3d.services.core.device.MimeTypes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AudioCapabilities {

    /* renamed from: c  reason: collision with root package name */
    public static final AudioCapabilities f5623c = new AudioCapabilities(ImmutableList.s(AudioProfile.f5628d));
    @SuppressLint({"InlinedApi"})

    /* renamed from: d  reason: collision with root package name */
    private static final ImmutableList<Integer> f5624d = ImmutableList.u(2, 5, 6);

    /* renamed from: e  reason: collision with root package name */
    static final ImmutableMap<Integer, Integer> f5625e = new ImmutableMap.Builder().f(5, 6).f(17, 6).f(7, 6).f(30, 10).f(18, 6).f(6, 8).f(8, 8).f(14, 8).c();

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<AudioProfile> f5626a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5627b;

    private static final class Api23 {
        private Api23() {
        }

        private static ImmutableSet<Integer> a() {
            ImmutableSet.Builder i2 = new ImmutableSet.Builder().i(8, 7);
            int i3 = Util.f4714a;
            if (i3 >= 31) {
                i2.i(26, 27);
            }
            if (i3 >= 33) {
                i2.d(30);
            }
            return i2.l();
        }

        public static boolean b(AudioManager audioManager, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo[] a2 = audioDeviceInfoApi23 == null ? ((AudioManager) Assertions.f(audioManager)).getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfoApi23.f5647a};
            ImmutableSet<Integer> a3 = a();
            for (AudioDeviceInfo a4 : a2) {
                if (a3.contains(Integer.valueOf(a4.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class Api29 {
        private Api29() {
        }

        public static ImmutableList<Integer> a(AudioAttributes audioAttributes) {
            ImmutableList.Builder k2 = ImmutableList.k();
            UnmodifiableIterator<Integer> h2 = AudioCapabilities.f5625e.keySet().iterator();
            while (h2.hasNext()) {
                int intValue = h2.next().intValue();
                if (Util.f4714a >= Util.K(intValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), audioAttributes.a().f3921a)) {
                    k2.d(Integer.valueOf(intValue));
                }
            }
            k2.d(2);
            return k2.k();
        }

        public static int b(int i2, int i3, AudioAttributes audioAttributes) {
            for (int i4 = 10; i4 > 0; i4--) {
                int M = Util.M(i4);
                if (M != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i3).setChannelMask(M).build(), audioAttributes.a().f3921a)) {
                    return i4;
                }
            }
            return 0;
        }
    }

    private static final class Api33 {
        private Api33() {
        }

        public static AudioCapabilities a(AudioManager audioManager, AudioAttributes audioAttributes) {
            return new AudioCapabilities(AudioCapabilities.c(audioManager.getDirectProfilesForAttributes(audioAttributes.a().f3921a)));
        }

        public static AudioDeviceInfoApi23 b(AudioManager audioManager, AudioAttributes audioAttributes) {
            try {
                List audioDevicesForAttributes = ((AudioManager) Assertions.f(audioManager)).getAudioDevicesForAttributes(audioAttributes.a().f3921a);
                if (audioDevicesForAttributes.isEmpty()) {
                    return null;
                }
                return new AudioDeviceInfoApi23((AudioDeviceInfo) audioDevicesForAttributes.get(0));
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    private static boolean b() {
        String str = Util.f4716c;
        return "Amazon".equals(str) || "Xiaomi".equals(str);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"WrongConstant"})
    public static ImmutableList<AudioProfile> c(List<android.media.AudioProfile> list) {
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(Ints.c(12)));
        for (int i2 = 0; i2 < list.size(); i2++) {
            android.media.AudioProfile audioProfile = list.get(i2);
            if (audioProfile.getEncapsulationType() != 1) {
                int a2 = audioProfile.getFormat();
                if (Util.F0(a2) || f5625e.containsKey(Integer.valueOf(a2))) {
                    if (hashMap.containsKey(Integer.valueOf(a2))) {
                        ((Set) Assertions.f((Set) hashMap.get(Integer.valueOf(a2)))).addAll(Ints.c(audioProfile.getChannelMasks()));
                    } else {
                        hashMap.put(Integer.valueOf(a2), new HashSet(Ints.c(audioProfile.getChannelMasks())));
                    }
                }
            }
        }
        ImmutableList.Builder k2 = ImmutableList.k();
        for (Map.Entry entry : hashMap.entrySet()) {
            k2.d(new AudioProfile(((Integer) entry.getKey()).intValue(), (Set<Integer>) (Set) entry.getValue()));
        }
        return k2.k();
    }

    private static ImmutableList<AudioProfile> d(int[] iArr, int i2) {
        ImmutableList.Builder k2 = ImmutableList.k();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int audioProfile : iArr) {
            k2.d(new AudioProfile(audioProfile, i2));
        }
        return k2.k();
    }

    public static AudioCapabilities e(Context context, AudioAttributes audioAttributes, AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23;
        if (Util.f4714a < 23 || audioDeviceInfo == null) {
            audioDeviceInfoApi23 = null;
        } else {
            audioDeviceInfoApi23 = new AudioDeviceInfoApi23(audioDeviceInfo);
        }
        return g(context, audioAttributes, audioDeviceInfoApi23);
    }

    @SuppressLint({"InlinedApi"})
    static AudioCapabilities f(Context context, Intent intent, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        boolean z2;
        AudioManager audioManager = (AudioManager) Assertions.f(context.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        if (audioDeviceInfoApi23 == null) {
            if (Util.f4714a >= 33) {
                audioDeviceInfoApi23 = Api33.b(audioManager, audioAttributes);
            } else {
                audioDeviceInfoApi23 = null;
            }
        }
        int i2 = Util.f4714a;
        if (i2 >= 33 && (Util.J0(context) || Util.C0(context))) {
            return Api33.a(audioManager, audioAttributes);
        }
        if (i2 >= 23 && Api23.b(audioManager, audioDeviceInfoApi23)) {
            return f5623c;
        }
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        builder.d(2);
        if (i2 < 29 || (!Util.J0(context) && !Util.C0(context))) {
            ContentResolver contentResolver = context.getContentResolver();
            if (Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((z2 || b()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
                builder.j(f5624d);
            }
            if (intent == null || z2 || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
                return new AudioCapabilities(d(Ints.n(builder.l()), 10));
            }
            int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
            if (intArrayExtra != null) {
                builder.j(Ints.c(intArrayExtra));
            }
            return new AudioCapabilities(d(Ints.n(builder.l()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
        }
        builder.j(Api29.a(audioAttributes));
        return new AudioCapabilities(d(Ints.n(builder.l()), 10));
    }

    @SuppressLint({"UnprotectedReceiver"})
    static AudioCapabilities g(Context context, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        return f(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes, audioDeviceInfoApi23);
    }

    private static int h(int i2) {
        int i3 = Util.f4714a;
        if (i3 <= 28) {
            if (i2 == 7) {
                i2 = 8;
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                i2 = 6;
            }
        }
        if (i3 <= 26 && "fugu".equals(Util.f4715b) && i2 == 1) {
            i2 = 2;
        }
        return Util.M(i2);
    }

    static Uri j() {
        if (b()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (!Util.t(this.f5626a, audioCapabilities.f5626a) || this.f5627b != audioCapabilities.f5627b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f5627b + (Util.u(this.f5626a) * 31);
    }

    public Pair<Integer, Integer> i(Format format, AudioAttributes audioAttributes) {
        int f2 = androidx.media3.common.MimeTypes.f((String) Assertions.f(format.f4015n), format.f4011j);
        if (!f5625e.containsKey(Integer.valueOf(f2))) {
            return null;
        }
        if (f2 == 18 && !l(18)) {
            f2 = 6;
        } else if ((f2 == 8 && !l(8)) || (f2 == 30 && !l(30))) {
            f2 = 7;
        }
        if (!l(f2)) {
            return null;
        }
        AudioProfile audioProfile = (AudioProfile) Assertions.f(this.f5626a.get(f2));
        int i2 = format.B;
        if (i2 == -1 || f2 == 18) {
            int i3 = format.C;
            if (i3 == -1) {
                i3 = 48000;
            }
            i2 = audioProfile.b(i3, audioAttributes);
        } else if (!format.f4015n.equals("audio/vnd.dts.uhd;profile=p2") || Util.f4714a >= 33) {
            if (!audioProfile.c(i2)) {
                return null;
            }
        } else if (i2 > 10) {
            return null;
        }
        int h2 = h(i2);
        if (h2 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f2), Integer.valueOf(h2));
    }

    public boolean k(Format format, AudioAttributes audioAttributes) {
        return i(format, audioAttributes) != null;
    }

    public boolean l(int i2) {
        return Util.r(this.f5626a, i2);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f5627b + ", audioProfiles=" + this.f5626a + "]";
    }

    private AudioCapabilities(List<AudioProfile> list) {
        this.f5626a = new SparseArray<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AudioProfile audioProfile = list.get(i2);
            this.f5626a.put(audioProfile.f5629a, audioProfile);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f5626a.size(); i4++) {
            i3 = Math.max(i3, this.f5626a.valueAt(i4).f5630b);
        }
        this.f5627b = i3;
    }

    private static final class AudioProfile {

        /* renamed from: d  reason: collision with root package name */
        public static final AudioProfile f5628d;

        /* renamed from: a  reason: collision with root package name */
        public final int f5629a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5630b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableSet<Integer> f5631c;

        static {
            AudioProfile audioProfile;
            if (Util.f4714a >= 33) {
                audioProfile = new AudioProfile(2, (Set<Integer>) a(10));
            } else {
                audioProfile = new AudioProfile(2, 10);
            }
            f5628d = audioProfile;
        }

        public AudioProfile(int i2, Set<Integer> set) {
            this.f5629a = i2;
            ImmutableSet<Integer> m2 = ImmutableSet.m(set);
            this.f5631c = m2;
            UnmodifiableIterator<Integer> h2 = m2.iterator();
            int i3 = 0;
            while (h2.hasNext()) {
                i3 = Math.max(i3, Integer.bitCount(h2.next().intValue()));
            }
            this.f5630b = i3;
        }

        private static ImmutableSet<Integer> a(int i2) {
            ImmutableSet.Builder builder = new ImmutableSet.Builder();
            for (int i3 = 1; i3 <= i2; i3++) {
                builder.d(Integer.valueOf(Util.M(i3)));
            }
            return builder.l();
        }

        public int b(int i2, AudioAttributes audioAttributes) {
            if (this.f5631c != null) {
                return this.f5630b;
            }
            if (Util.f4714a >= 29) {
                return Api29.b(this.f5629a, i2, audioAttributes);
            }
            return ((Integer) Assertions.f(AudioCapabilities.f5625e.getOrDefault(Integer.valueOf(this.f5629a), 0))).intValue();
        }

        public boolean c(int i2) {
            if (this.f5631c != null) {
                int M = Util.M(i2);
                if (M == 0) {
                    return false;
                }
                return this.f5631c.contains(Integer.valueOf(M));
            } else if (i2 <= this.f5630b) {
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioProfile)) {
                return false;
            }
            AudioProfile audioProfile = (AudioProfile) obj;
            if (this.f5629a == audioProfile.f5629a && this.f5630b == audioProfile.f5630b && Util.c(this.f5631c, audioProfile.f5631c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int i3 = ((this.f5629a * 31) + this.f5630b) * 31;
            ImmutableSet<Integer> immutableSet = this.f5631c;
            if (immutableSet == null) {
                i2 = 0;
            } else {
                i2 = immutableSet.hashCode();
            }
            return i3 + i2;
        }

        public String toString() {
            return "AudioProfile[format=" + this.f5629a + ", maxChannelCount=" + this.f5630b + ", channelMasks=" + this.f5631c + "]";
        }

        public AudioProfile(int i2, int i3) {
            this.f5629a = i2;
            this.f5630b = i3;
            this.f5631c = null;
        }
    }
}
