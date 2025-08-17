package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class b implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f47a;

    public /* synthetic */ b(ComponentActivity componentActivity) {
        this.f47a = componentActivity;
    }

    public final Bundle b() {
        return this.f47a.lambda$new$0();
    }
}
