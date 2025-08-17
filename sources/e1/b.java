package e1;

import com.original.tase.helper.PlayerHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f38176b;

    public /* synthetic */ b(Function1 function1) {
        this.f38176b = function1;
    }

    public final void accept(Object obj) {
        PlayerHelper.S(this.f38176b, obj);
    }
}
