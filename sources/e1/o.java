package e1;

import com.original.tase.helper.PlayerHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class o implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f38195b;

    public /* synthetic */ o(Function1 function1) {
        this.f38195b = function1;
    }

    public final void accept(Object obj) {
        PlayerHelper.O(this.f38195b, obj);
    }
}
