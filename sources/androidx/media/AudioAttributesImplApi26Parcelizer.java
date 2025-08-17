package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f3838a = (AudioAttributes) versionedParcel.r(audioAttributesImplApi26.f3838a, 1);
        audioAttributesImplApi26.f3839b = versionedParcel.p(audioAttributesImplApi26.f3839b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.H(audioAttributesImplApi26.f3838a, 1);
        versionedParcel.F(audioAttributesImplApi26.f3839b, 2);
    }
}
