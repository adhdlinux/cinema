package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38138b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38139c;

    public /* synthetic */ a(MvDatabase mvDatabase, String str) {
        this.f38138b = mvDatabase;
        this.f38139c = str;
    }

    public final Object apply(Object obj) {
        return TraktUserApi.M().C(this.f38138b, this.f38139c);
    }
}
