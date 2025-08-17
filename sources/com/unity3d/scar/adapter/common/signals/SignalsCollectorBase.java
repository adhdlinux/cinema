package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.scar.adapter.common.DispatchGroup;
import java.util.Map;
import org.json.JSONObject;

public abstract class SignalsCollectorBase implements ISignalsCollector {

    private class GMAScarDispatchCompleted implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private ISignalCollectionListener f37062b;

        /* renamed from: c  reason: collision with root package name */
        private SignalsResult f37063c;

        public GMAScarDispatchCompleted(ISignalCollectionListener iSignalCollectionListener, SignalsResult signalsResult) {
            this.f37062b = iSignalCollectionListener;
            this.f37063c = signalsResult;
        }

        public void run() {
            Map<String, String> c2 = this.f37063c.c();
            if (c2.size() > 0) {
                this.f37062b.onSignalsCollected(new JSONObject(c2).toString());
            } else if (this.f37063c.b() == null) {
                this.f37062b.onSignalsCollected("");
            } else {
                this.f37062b.onSignalsCollectionFailed(this.f37063c.b());
            }
        }
    }

    public void a(Context context, String[] strArr, String[] strArr2, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        for (String d2 : strArr) {
            dispatchGroup.a();
            d(context, d2, true, dispatchGroup, signalsResult);
        }
        for (String d3 : strArr2) {
            dispatchGroup.a();
            d(context, d3, false, dispatchGroup, signalsResult);
        }
        dispatchGroup.c(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    public void b(Context context, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        dispatchGroup.a();
        c(context, true, dispatchGroup, signalsResult);
        dispatchGroup.a();
        c(context, false, dispatchGroup, signalsResult);
        dispatchGroup.c(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    public void e(String str, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        signalsResult.d(String.format("Operation Not supported: %s.", new Object[]{str}));
        dispatchGroup.b();
    }
}
