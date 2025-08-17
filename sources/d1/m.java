package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TraktUserApi f38155b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38156c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f38157d;

    public /* synthetic */ m(TraktUserApi traktUserApi, MvDatabase mvDatabase, String str) {
        this.f38155b = traktUserApi;
        this.f38156c = mvDatabase;
        this.f38157d = str;
    }

    public final Object apply(Object obj) {
        return this.f38155b.O(this.f38156c, this.f38157d, (List) obj);
    }
}
