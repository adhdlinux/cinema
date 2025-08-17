package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;

public final /* synthetic */ class v0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f7581b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f7582c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f7583d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7584e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f7585f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7586g;

    public /* synthetic */ v0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f7581b = forwardingEventListener;
        this.f7582c = pair;
        this.f7583d = loadEventInfo;
        this.f7584e = mediaLoadData;
        this.f7585f = iOException;
        this.f7586g = z2;
    }

    public final void run() {
        this.f7581b.h0(this.f7582c, this.f7583d, this.f7584e, this.f7585f, this.f7586g);
    }
}
