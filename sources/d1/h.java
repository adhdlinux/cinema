package d1;

import android.app.Activity;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f38148b;

    public /* synthetic */ h(Activity activity) {
        this.f38148b = activity;
    }

    public final void accept(Object obj) {
        TraktUserApi.g0(this.f38148b, (Throwable) obj);
    }
}
