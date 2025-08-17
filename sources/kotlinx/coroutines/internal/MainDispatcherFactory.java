package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher;

public interface MainDispatcherFactory {
    String a();

    MainCoroutineDispatcher b(List<? extends MainDispatcherFactory> list);

    int c();
}
