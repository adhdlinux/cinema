package b0;

import com.chartboost.sdk.impl.b2;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12686a;

    public /* synthetic */ a(Function1 function1) {
        this.f12686a = function1;
    }

    public final void onSuccess(Object obj) {
        b2.a(this.f12686a, obj);
    }
}
