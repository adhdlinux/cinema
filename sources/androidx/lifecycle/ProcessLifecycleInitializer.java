package androidx.lifecycle;

import android.content.Context;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    /* renamed from: a */
    public LifecycleOwner create(Context context) {
        if (AppInitializer.e(context).g(ProcessLifecycleInitializer.class)) {
            LifecycleDispatcher.a(context);
            ProcessLifecycleOwner.i(context);
            return ProcessLifecycleOwner.h();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
