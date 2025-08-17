package d1;

import android.app.Activity;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f38168b;

    public /* synthetic */ u(Activity activity) {
        this.f38168b = activity;
    }

    public final void accept(Object obj) {
        TraktUserApi.X(this.f38168b, (Boolean) obj);
    }
}
