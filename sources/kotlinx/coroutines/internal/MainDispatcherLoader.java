package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.MainCoroutineDispatcher;

public final class MainDispatcherLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final MainDispatcherLoader f40761a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f40762b = SystemPropsKt.f("kotlinx.coroutines.fast.service.loader", true);

    /* renamed from: c  reason: collision with root package name */
    public static final MainCoroutineDispatcher f40763c;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        f40761a = mainDispatcherLoader;
        f40763c = mainDispatcherLoader.a();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher a() {
        List<MainDispatcherFactory> list;
        Object obj;
        MainCoroutineDispatcher e2;
        Class<MainDispatcherFactory> cls = MainDispatcherFactory.class;
        try {
            if (f40762b) {
                list = FastServiceLoader.f40735a.c();
            } else {
                list = SequencesKt___SequencesKt.l(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            }
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                obj = null;
            } else {
                obj = it2.next();
                if (it2.hasNext()) {
                    int c2 = ((MainDispatcherFactory) obj).c();
                    do {
                        Object next = it2.next();
                        int c3 = ((MainDispatcherFactory) next).c();
                        if (c2 < c3) {
                            obj = next;
                            c2 = c3;
                        }
                    } while (it2.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
            if (mainDispatcherFactory == null || (e2 = MainDispatchersKt.e(mainDispatcherFactory, list)) == null) {
                return MainDispatchersKt.b((Throwable) null, (String) null, 3, (Object) null);
            }
            return e2;
        } catch (Throwable th) {
            return MainDispatchersKt.b(th, (String) null, 2, (Object) null);
        }
    }
}
