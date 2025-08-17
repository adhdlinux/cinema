package b0;

import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.impl.e3;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e3 f12751b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12752c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12753d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ StartCallback f12754e;

    public /* synthetic */ o(e3 e3Var, String str, String str2, StartCallback startCallback) {
        this.f12751b = e3Var;
        this.f12752c = str;
        this.f12753d = str2;
        this.f12754e = startCallback;
    }

    public final void run() {
        e3.a(this.f12751b, this.f12752c, this.f12753d, this.f12754e);
    }
}
