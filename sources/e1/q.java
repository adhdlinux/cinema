package e1;

import com.original.tase.helper.PlayerHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f38197b;

    public /* synthetic */ q(Function1 function1) {
        this.f38197b = function1;
    }

    public final void accept(Object obj) {
        PlayerHelper.Q(this.f38197b, obj);
    }
}
