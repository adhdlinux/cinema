package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;

public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: b  reason: collision with root package name */
    public final String f25428b;

    public Id3Frame(String str) {
        this.f25428b = str;
    }

    public /* synthetic */ Format D() {
        return a.b(this);
    }

    public /* synthetic */ byte[] E() {
        return a.a(this);
    }

    public /* synthetic */ void a(MediaMetadata.Builder builder) {
        a.c(this, builder);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f25428b;
    }
}
