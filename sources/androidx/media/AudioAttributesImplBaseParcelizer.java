package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3841a = versionedParcel.p(audioAttributesImplBase.f3841a, 1);
        audioAttributesImplBase.f3842b = versionedParcel.p(audioAttributesImplBase.f3842b, 2);
        audioAttributesImplBase.f3843c = versionedParcel.p(audioAttributesImplBase.f3843c, 3);
        audioAttributesImplBase.f3844d = versionedParcel.p(audioAttributesImplBase.f3844d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.f3841a, 1);
        versionedParcel.F(audioAttributesImplBase.f3842b, 2);
        versionedParcel.F(audioAttributesImplBase.f3843c, 3);
        versionedParcel.F(audioAttributesImplBase.f3844d, 4);
    }
}
