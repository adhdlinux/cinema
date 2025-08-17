package com.movie.ui.activity.player;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class CurrentTracks {

    /* renamed from: a  reason: collision with root package name */
    private final VideoTrack f32352a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioTrack f32353b;

    /* renamed from: c  reason: collision with root package name */
    private final List<VideoTrack> f32354c;

    /* renamed from: d  reason: collision with root package name */
    private final List<AudioTrack> f32355d;

    public CurrentTracks(VideoTrack videoTrack, AudioTrack audioTrack, List<VideoTrack> list, List<AudioTrack> list2) {
        Intrinsics.f(list, "allVideoTracks");
        Intrinsics.f(list2, "allAudioTracks");
        this.f32352a = videoTrack;
        this.f32353b = audioTrack;
        this.f32354c = list;
        this.f32355d = list2;
    }

    public final List<AudioTrack> a() {
        return this.f32355d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrentTracks)) {
            return false;
        }
        CurrentTracks currentTracks = (CurrentTracks) obj;
        return Intrinsics.a(this.f32352a, currentTracks.f32352a) && Intrinsics.a(this.f32353b, currentTracks.f32353b) && Intrinsics.a(this.f32354c, currentTracks.f32354c) && Intrinsics.a(this.f32355d, currentTracks.f32355d);
    }

    public int hashCode() {
        VideoTrack videoTrack = this.f32352a;
        int i2 = 0;
        int hashCode = (videoTrack == null ? 0 : videoTrack.hashCode()) * 31;
        AudioTrack audioTrack = this.f32353b;
        if (audioTrack != null) {
            i2 = audioTrack.hashCode();
        }
        return ((((hashCode + i2) * 31) + this.f32354c.hashCode()) * 31) + this.f32355d.hashCode();
    }

    public String toString() {
        return "CurrentTracks(currentVideoTrack=" + this.f32352a + ", currentAudioTrack=" + this.f32353b + ", allVideoTracks=" + this.f32354c + ", allAudioTracks=" + this.f32355d + ')';
    }
}
