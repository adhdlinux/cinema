package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService extends Service implements LifecycleOwner {

    /* renamed from: b  reason: collision with root package name */
    private final ServiceLifecycleDispatcher f3682b = new ServiceLifecycleDispatcher(this);

    public Lifecycle getLifecycle() {
        return this.f3682b.a();
    }

    public IBinder onBind(Intent intent) {
        this.f3682b.b();
        return null;
    }

    public void onCreate() {
        this.f3682b.c();
        super.onCreate();
    }

    public void onDestroy() {
        this.f3682b.d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i2) {
        this.f3682b.e();
        super.onStart(intent, i2);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
