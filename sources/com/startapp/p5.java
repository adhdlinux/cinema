package com.startapp;

import android.content.Context;
import android.os.Handler;
import com.startapp.sdk.ads.video.VideoMode;
import com.startapp.sdk.ads.video.player.NativeVideoPlayer;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.sdk.adsbase.AdsCommonMetaData;

public class p5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35604a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoMode f35606c;

    public p5(VideoMode videoMode) {
        this.f35606c = videoMode;
        this.f35605b = videoMode.d(AdsCommonMetaData.k().G().k());
    }

    public void run() {
        int i2;
        try {
            VideoPlayerInterface videoPlayerInterface = this.f35606c.M;
            if (videoPlayerInterface != null) {
                i2 = ((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition();
            } else {
                i2 = 0;
            }
            int i3 = i2 + 50;
            long c2 = this.f35606c.c(i3);
            long j2 = 0;
            int i4 = (c2 > 0 ? 1 : (c2 == 0 ? 0 : -1));
            if (i4 >= 0 && !this.f35604a) {
                if (i4 != 0) {
                    VideoMode videoMode = this.f35606c;
                    if (((long) videoMode.S) < videoMode.y().g()) {
                        VideoMode videoMode2 = this.f35606c;
                        lb.a(videoMode2.f36800w, true, "videoApi.setSkipTimer", Long.valueOf(c2));
                    }
                }
                this.f35604a = true;
                Object[] objArr = {0};
                lb.a(this.f35606c.f36800w, true, "videoApi.setSkipTimer", objArr);
            }
            VideoMode videoMode3 = this.f35606c;
            if (videoMode3.f36073g0 && i2 >= this.f35605b) {
                videoMode3.u();
            }
            int i5 = i3 / 1000;
            VideoMode videoMode4 = this.f35606c;
            lb.a(videoMode4.f36800w, true, "videoApi.setVideoCurrentPosition", Integer.valueOf(i5));
            if (i5 < ((NativeVideoPlayer) this.f35606c.M).f36113g.getDuration() / 1000) {
                VideoMode videoMode5 = this.f35606c;
                Handler handler = videoMode5.f36081o0;
                VideoPlayerInterface videoPlayerInterface2 = videoMode5.M;
                if (videoPlayerInterface2 != null) {
                    j2 = (long) (1000 - (((NativeVideoPlayer) videoPlayerInterface2).f36113g.getCurrentPosition() % 1000));
                }
                handler.postDelayed(this, j2);
            }
        } catch (Throwable th) {
            y8.a((Context) this.f35606c.f36704b, th);
        }
    }
}
