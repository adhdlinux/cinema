package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConcatenatingMediaSource f7187b;

    public /* synthetic */ c(ConcatenatingMediaSource concatenatingMediaSource) {
        this.f7187b = concatenatingMediaSource;
    }

    public final boolean handleMessage(Message message) {
        return this.f7187b.f0(message);
    }
}
