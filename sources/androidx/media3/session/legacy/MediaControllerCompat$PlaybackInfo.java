package androidx.media3.session.legacy;

import androidx.media3.session.legacy.AudioAttributesCompat;

public final class MediaControllerCompat$PlaybackInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f9692a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioAttributesCompat f9693b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9694c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9695d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9696e;

    MediaControllerCompat$PlaybackInfo(int i2, int i3, int i4, int i5, int i6) {
        this(i2, new AudioAttributesCompat.Builder().b(i3).a(), i4, i5, i6);
    }

    MediaControllerCompat$PlaybackInfo(int i2, AudioAttributesCompat audioAttributesCompat, int i3, int i4, int i5) {
        this.f9692a = i2;
        this.f9693b = audioAttributesCompat;
        this.f9694c = i3;
        this.f9695d = i4;
        this.f9696e = i5;
    }
}
