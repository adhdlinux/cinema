package e1;

import com.original.tase.helper.PlayerHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f38196b;

    public /* synthetic */ p(Function1 function1) {
        this.f38196b = function1;
    }

    public final void accept(Object obj) {
        PlayerHelper.P(this.f38196b, obj);
    }
}
