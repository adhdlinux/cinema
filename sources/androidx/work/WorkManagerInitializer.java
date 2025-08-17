package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import java.util.Collections;
import java.util.List;

public final class WorkManagerInitializer implements Initializer<WorkManager> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12218a = Logger.f("WrkMgrInitializer");

    /* renamed from: a */
    public WorkManager create(Context context) {
        Logger.c().a(f12218a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        WorkManager.e(context, new Configuration.Builder().a());
        return WorkManager.d(context);
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
