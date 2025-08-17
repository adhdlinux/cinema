package androidx.media3.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.common.util.concurrent.SettableFuture;

class MediaControllerImplLegacy$1 extends ResultReceiver {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SettableFuture f9601b;

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        SettableFuture settableFuture = this.f9601b;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        settableFuture.A(new SessionResult(i2, bundle));
    }
}
