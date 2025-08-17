package d1;

import android.app.Activity;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Action;

public final /* synthetic */ class p implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f38159b;

    public /* synthetic */ p(Activity activity) {
        this.f38159b = activity;
    }

    public final void run() {
        TraktUserApi.c0(this.f38159b);
    }
}
