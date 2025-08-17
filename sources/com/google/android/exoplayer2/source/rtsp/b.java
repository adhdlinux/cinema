package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpPacketReorderingQueue;
import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return RtpPacketReorderingQueue.c(((RtpPacketReorderingQueue.RtpPacketContainer) obj).f26783a.f26766g, ((RtpPacketReorderingQueue.RtpPacketContainer) obj2).f26783a.f26766g);
    }
}
