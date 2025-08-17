package com.google.android.exoplayer2.source.rtsp;

import com.google.common.collect.ImmutableList;
import java.util.List;

final class RtspPlayResponse {

    /* renamed from: a  reason: collision with root package name */
    public final int f26913a;

    /* renamed from: b  reason: collision with root package name */
    public final RtspSessionTiming f26914b;

    /* renamed from: c  reason: collision with root package name */
    public final ImmutableList<RtspTrackTiming> f26915c;

    public RtspPlayResponse(int i2, RtspSessionTiming rtspSessionTiming, List<RtspTrackTiming> list) {
        this.f26913a = i2;
        this.f26914b = rtspSessionTiming;
        this.f26915c = ImmutableList.n(list);
    }
}
