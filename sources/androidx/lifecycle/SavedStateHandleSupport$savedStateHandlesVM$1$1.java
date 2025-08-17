package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends Lambda implements Function1<CreationExtras, SavedStateHandlesVM> {

    /* renamed from: f  reason: collision with root package name */
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 f3734f = new SavedStateHandleSupport$savedStateHandlesVM$1$1();

    SavedStateHandleSupport$savedStateHandlesVM$1$1() {
        super(1);
    }

    /* renamed from: a */
    public final SavedStateHandlesVM invoke(CreationExtras creationExtras) {
        Intrinsics.f(creationExtras, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
