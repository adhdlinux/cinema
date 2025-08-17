package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TraktUserApi f38141b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38142c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f38143d;

    public /* synthetic */ d(TraktUserApi traktUserApi, MvDatabase mvDatabase, String str) {
        this.f38141b = traktUserApi;
        this.f38142c = mvDatabase;
        this.f38143d = str;
    }

    public final Object apply(Object obj) {
        return this.f38141b.Q(this.f38142c, this.f38143d, (List) obj);
    }
}
