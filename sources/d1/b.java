package d1;

import android.app.Activity;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f38140b;

    public /* synthetic */ b(Activity activity) {
        this.f38140b = activity;
    }

    public final void accept(Object obj) {
        TraktUserApi.S(this.f38140b, (Throwable) obj);
    }
}
