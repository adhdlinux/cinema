package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi26;
import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcelable;

public class AudioAttributesCompat implements VersionedParcelable {

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f3833b;

    /* renamed from: c  reason: collision with root package name */
    static boolean f3834c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f3835d = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributesImpl f3836a;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final AudioAttributesImpl.Builder f3837a;

        public Builder() {
            if (AudioAttributesCompat.f3834c) {
                this.f3837a = new AudioAttributesImplBase.Builder();
            } else if (Build.VERSION.SDK_INT >= 26) {
                this.f3837a = new AudioAttributesImplApi26.Builder();
            } else {
                this.f3837a = new AudioAttributesImplApi21.Builder();
            }
        }

        public AudioAttributesCompat a() {
            return new AudioAttributesCompat(this.f3837a.build());
        }

        public Builder b(int i2) {
            this.f3837a.a(i2);
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3833b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    static int b(boolean z2, int i2, int i3) {
        if ((i2 & 1) == 1) {
            return z2 ? 1 : 7;
        }
        if ((i2 & 4) == 4) {
            return z2 ? 0 : 6;
        }
        switch (i3) {
            case 0:
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z2 ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                if (!z2) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i3 + " in audio attributes");
        }
    }

    static String c(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage " + i2;
        }
    }

    public static AudioAttributesCompat d(Object obj) {
        if (f3834c) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return new AudioAttributesCompat(new AudioAttributesImplApi26((AudioAttributes) obj));
        }
        return new AudioAttributesCompat(new AudioAttributesImplApi21((AudioAttributes) obj));
    }

    public int a() {
        return this.f3836a.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f3836a;
        if (audioAttributesImpl != null) {
            return audioAttributesImpl.equals(audioAttributesCompat.f3836a);
        }
        if (audioAttributesCompat.f3836a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f3836a.hashCode();
    }

    public String toString() {
        return this.f3836a.toString();
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f3836a = audioAttributesImpl;
    }
}
