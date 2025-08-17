package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38146b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38147c;

    public /* synthetic */ f(MvDatabase mvDatabase, String str) {
        this.f38146b = mvDatabase;
        this.f38147c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().I(this.f38146b, this.f38147c);
    }
}
