package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class AndroidMainExecutor implements Executor {
    private final Handler handler = new Handler(Looper.getMainLooper());

    AndroidMainExecutor() {
    }

    public void execute(Runnable runnable) {
        this.handler.post(runnable);
    }
}
