package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class l implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38153b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38154c;

    public /* synthetic */ l(MvDatabase mvDatabase, String str) {
        this.f38153b = mvDatabase;
        this.f38154c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().D(this.f38153b, this.f38154c);
    }
}
