package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;

public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: b  reason: collision with root package name */
    public final String f8328b;

    public Id3Frame(String str) {
        this.f8328b = str;
    }

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public /* synthetic */ void H(MediaMetadata.Builder builder) {
        d.c(this, builder);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f8328b;
    }
}
