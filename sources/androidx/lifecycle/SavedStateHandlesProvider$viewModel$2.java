package androidx.lifecycle;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SavedStateHandlesProvider$viewModel$2 extends Lambda implements Function0<SavedStateHandlesVM> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ViewModelStoreOwner f3739f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedStateHandlesProvider$viewModel$2(ViewModelStoreOwner viewModelStoreOwner) {
        super(0);
        this.f3739f = viewModelStoreOwner;
    }

    /* renamed from: b */
    public final SavedStateHandlesVM invoke() {
        return SavedStateHandleSupport.e(this.f3739f);
    }
}
