package androidx.media3.common.util;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenerSet f4731b;

    public /* synthetic */ a(ListenerSet listenerSet) {
        this.f4731b = listenerSet;
    }

    public final boolean handleMessage(Message message) {
        return this.f4731b.g(message);
    }
}
