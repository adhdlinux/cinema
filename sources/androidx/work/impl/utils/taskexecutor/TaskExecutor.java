package androidx.work.impl.utils.taskexecutor;

import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

public interface TaskExecutor {
    Executor a();

    void b(Runnable runnable);

    SerialExecutor getBackgroundExecutor();
}
