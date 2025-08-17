package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38161c;

    public /* synthetic */ q(MvDatabase mvDatabase, String str) {
        this.f38160b = mvDatabase;
        this.f38161c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().F(this.f38160b, this.f38161c);
    }
}
