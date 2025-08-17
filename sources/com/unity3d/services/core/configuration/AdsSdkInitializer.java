package com.unity3d.services.core.configuration;

import android.content.Context;
import androidx.startup.Initializer;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class AdsSdkInitializer implements Initializer<Unit> {
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt__CollectionsKt.f();
    }

    public void create(Context context) {
        Intrinsics.f(context, "context");
        ClientProperties.setApplicationContext(context.getApplicationContext());
    }
}
