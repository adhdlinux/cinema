package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class t implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38166b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38167c;

    public /* synthetic */ t(MvDatabase mvDatabase, String str) {
        this.f38166b = mvDatabase;
        this.f38167c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().D(this.f38166b, this.f38167c);
    }
}
