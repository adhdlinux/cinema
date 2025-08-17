package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38145c;

    public /* synthetic */ e(MvDatabase mvDatabase, String str) {
        this.f38144b = mvDatabase;
        this.f38145c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().F(this.f38144b, this.f38145c);
    }
}
