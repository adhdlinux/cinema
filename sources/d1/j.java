package d1;

import com.database.MvDatabase;
import com.original.tase.api.TraktUserApi;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class j implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TraktUserApi f38150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MvDatabase f38151c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f38152d;

    public /* synthetic */ j(TraktUserApi traktUserApi, MvDatabase mvDatabase, String str) {
        this.f38150b = traktUserApi;
        this.f38151c = mvDatabase;
        this.f38152d = str;
    }

    public final Object apply(Object obj) {
        return this.f38150b.R(this.f38151c, this.f38152d, (List) obj);
    }
}
