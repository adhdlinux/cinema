package androidx.media;

import androidx.versionedparcelable.VersionedParcelable;

public interface AudioAttributesImpl extends VersionedParcelable {

    public interface Builder {
        Builder a(int i2);

        AudioAttributesImpl build();
    }

    int a();
}
