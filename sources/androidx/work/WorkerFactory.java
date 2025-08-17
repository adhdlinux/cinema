package androidx.work;

import android.content.Context;

public abstract class WorkerFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12228a = Logger.f("WorkerFactory");

    public static WorkerFactory c() {
        return new WorkerFactory() {
            public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        Class<? extends U> cls;
        ListenableWorker a2 = a(context, str, workerParameters);
        if (a2 == null) {
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                Logger c2 = Logger.c();
                String str2 = f12228a;
                c2.b(str2, "Invalid class: " + str, th);
                cls = null;
            }
            if (cls != null) {
                try {
                    a2 = (ListenableWorker) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
                } catch (Throwable th2) {
                    Logger c3 = Logger.c();
                    String str3 = f12228a;
                    c3.b(str3, "Could not instantiate " + str, th2);
                }
            }
        }
        if (a2 == null || !a2.isUsed()) {
            return a2;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", new Object[]{getClass().getName(), str}));
    }
}
