package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class d implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f3771a;

    public /* synthetic */ d(SavedStateHandle savedStateHandle) {
        this.f3771a = savedStateHandle;
    }

    public final Bundle b() {
        return SavedStateHandle.e(this.f3771a);
    }
}
