package e1;

import com.original.tase.helper.PlayerHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f38198b;

    public /* synthetic */ r(Function1 function1) {
        this.f38198b = function1;
    }

    public final void accept(Object obj) {
        PlayerHelper.R(this.f38198b, obj);
    }
}
