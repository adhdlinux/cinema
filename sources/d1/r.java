package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class r implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38162b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38163c;

    public /* synthetic */ r(MvDatabase mvDatabase, String str) {
        this.f38162b = mvDatabase;
        this.f38163c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().I(this.f38162b, this.f38163c);
    }
}
