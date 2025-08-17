package com.startapp;

import com.startapp.sdk.ads.video.VideoMode;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

public class y5 implements VideoPlayerInterface.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoMode f36947a;

    public y5(VideoMode videoMode) {
        this.f36947a = videoMode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        r4 = r3.f36947a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r4) {
        /*
            r3 = this;
            com.startapp.sdk.ads.video.VideoMode r0 = r3.f36947a
            com.startapp.sdk.ads.video.player.VideoPlayerInterface r0 = r0.M
            if (r0 == 0) goto L_0x000f
            com.startapp.sdk.ads.video.player.NativeVideoPlayer r0 = (com.startapp.sdk.ads.video.player.NativeVideoPlayer) r0
            android.widget.VideoView r0 = r0.f36113g
            int r0 = r0.getDuration()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            com.startapp.sdk.ads.video.VideoMode r1 = r3.f36947a
            boolean r2 = r1.f36073g0
            if (r2 == 0) goto L_0x0087
            boolean r2 = r1.f36074h0
            if (r2 == 0) goto L_0x0087
            if (r0 <= 0) goto L_0x0087
            r1.f36072f0 = r4
            com.startapp.sdk.ads.video.player.VideoPlayerInterface r4 = r1.M
            com.startapp.sdk.ads.video.player.NativeVideoPlayer r4 = (com.startapp.sdk.ads.video.player.NativeVideoPlayer) r4
            android.widget.VideoView r4 = r4.f36113g
            int r4 = r4.getCurrentPosition()
            r1 = 100
            int r4 = r4 * 100
            int r4 = r4 / r0
            com.startapp.sdk.ads.video.VideoMode r0 = r3.f36947a
            boolean r0 = r0.F()
            if (r0 == 0) goto L_0x0063
            com.startapp.sdk.ads.video.VideoMode r0 = r3.f36947a
            boolean r2 = r0.f36075i0
            if (r2 != 0) goto L_0x0047
            boolean r0 = r0.D()
            if (r0 == 0) goto L_0x0047
            com.startapp.sdk.ads.video.VideoMode r4 = r3.f36947a
            r4.Q()
            goto L_0x0087
        L_0x0047:
            com.startapp.sdk.ads.video.VideoMode r0 = r3.f36947a
            int r0 = r0.f36072f0
            if (r0 == r1) goto L_0x005a
            int r0 = r0 - r4
            com.startapp.sdk.adsbase.AdsCommonMetaData r4 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            com.startapp.sdk.adsbase.VideoConfig r4 = r4.G()
            int r4 = r4.h()
            if (r0 <= r4) goto L_0x0087
        L_0x005a:
            com.startapp.sdk.ads.video.VideoMode r4 = r3.f36947a
            r4.P()
            r4.R()
            goto L_0x0087
        L_0x0063:
            com.startapp.sdk.ads.video.VideoMode r0 = r3.f36947a
            int r0 = r0.f36072f0
            if (r0 >= r1) goto L_0x0087
            int r0 = r0 - r4
            com.startapp.sdk.adsbase.AdsCommonMetaData r4 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            com.startapp.sdk.adsbase.VideoConfig r4 = r4.G()
            int r4 = r4.i()
            if (r0 > r4) goto L_0x0087
            com.startapp.sdk.ads.video.VideoMode r4 = r3.f36947a
            com.startapp.sdk.ads.video.player.VideoPlayerInterface r0 = r4.M
            if (r0 != 0) goto L_0x007d
            goto L_0x0087
        L_0x007d:
            com.startapp.sdk.ads.video.player.NativeVideoPlayer r0 = (com.startapp.sdk.ads.video.player.NativeVideoPlayer) r0
            android.widget.VideoView r0 = r0.f36113g
            r0.pause()
            r4.O()
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.y5.a(int):void");
    }
}
