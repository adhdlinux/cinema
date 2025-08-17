package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class s implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38164b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38165c;

    public /* synthetic */ s(MvDatabase mvDatabase, String str) {
        this.f38164b = mvDatabase;
        this.f38165c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().C(this.f38164b, this.f38165c);
    }
}
