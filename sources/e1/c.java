package e1;

import com.original.tase.helper.PlayerHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f38177b;

    public /* synthetic */ c(Function1 function1) {
        this.f38177b = function1;
    }

    public final void accept(Object obj) {
        PlayerHelper.T(this.f38177b, obj);
    }
}
