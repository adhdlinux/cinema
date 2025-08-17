package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6797b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6798c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f6799d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f6800e;

    public /* synthetic */ q0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f6797b = forwardingEventListener;
        this.f6798c = pair;
        this.f6799d = loadEventInfo;
        this.f6800e = mediaLoadData;
    }

    public final void run() {
        this.f6797b.f0(this.f6798c, this.f6799d, this.f6800e);
    }
}
