package r1;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;

public final /* synthetic */ class b implements EventListener.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventListener f41478a;

    public /* synthetic */ b(EventListener eventListener) {
        this.f41478a = eventListener;
    }

    public final EventListener create(Call call) {
        return Util.asFactory$lambda$8(this.f41478a, call);
    }
}
