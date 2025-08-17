package b0;

import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.events.StartError;
import com.chartboost.sdk.impl.qa;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StartCallback f12749b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StartError f12750c;

    public /* synthetic */ n0(StartCallback startCallback, StartError startError) {
        this.f12749b = startCallback;
        this.f12750c = startError;
    }

    public final void run() {
        qa.a(this.f12749b, this.f12750c);
    }
}
