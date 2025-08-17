package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;

public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public MainCoroutineDispatcher b(List<? extends MainDispatcherFactory> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new HandlerContext(HandlerDispatcherKt.a(mainLooper, true), (String) null, 2, (DefaultConstructorMarker) null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    public int c() {
        return 1073741823;
    }
}
