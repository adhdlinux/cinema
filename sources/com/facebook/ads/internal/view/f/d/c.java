package com.facebook.ads.internal.view.f.d;

import android.net.Uri;
import android.view.View;
import com.facebook.ads.internal.view.f.a.a;

public interface c {
    void a(int i2);

    void a(a aVar);

    void a(boolean z2);

    void b();

    void c();

    boolean d();

    void e();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    a getStartReason();

    d getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void setBackgroundPlaybackEnabled(boolean z2);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z2);

    void setRequestedVolume(float f2);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(e eVar);

    void setup(Uri uri);
}
