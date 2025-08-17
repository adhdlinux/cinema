package d1;

import android.app.Activity;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Action;

public final /* synthetic */ class i implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f38149b;

    public /* synthetic */ i(Activity activity) {
        this.f38149b = activity;
    }

    public final void run() {
        TraktUserApi.h0(this.f38149b);
    }
}
