package d1;

import android.app.Activity;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class o implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f38158b;

    public /* synthetic */ o(Activity activity) {
        this.f38158b = activity;
    }

    public final void accept(Object obj) {
        TraktUserApi.b0(this.f38158b, (Throwable) obj);
    }
}
