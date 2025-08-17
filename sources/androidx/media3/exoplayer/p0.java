package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class p0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6792b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6793c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f6794d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f6795e;

    public /* synthetic */ p0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f6792b = forwardingEventListener;
        this.f6793c = pair;
        this.f6794d = loadEventInfo;
        this.f6795e = mediaLoadData;
    }

    public final void run() {
        this.f6792b.g0(this.f6793c, this.f6794d, this.f6795e);
    }
}
