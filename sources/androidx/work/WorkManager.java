package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {
    protected WorkManager() {
    }

    public static WorkManager d(Context context) {
        return WorkManagerImpl.k(context);
    }

    public static void e(Context context, Configuration configuration) {
        WorkManagerImpl.e(context, configuration);
    }

    public abstract Operation a(String str);

    public final Operation b(WorkRequest workRequest) {
        return c(Collections.singletonList(workRequest));
    }

    public abstract Operation c(List<? extends WorkRequest> list);
}
