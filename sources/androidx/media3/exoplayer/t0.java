package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class t0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f7318b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f7319c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f7320d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7321e;

    public /* synthetic */ t0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f7318b = forwardingEventListener;
        this.f7319c = pair;
        this.f7320d = loadEventInfo;
        this.f7321e = mediaLoadData;
    }

    public final void run() {
        this.f7318b.i0(this.f7319c, this.f7320d, this.f7321e);
    }
}
