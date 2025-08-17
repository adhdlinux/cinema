package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f42059b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f42060c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f42061d;

    public /* synthetic */ d(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Throwable th) {
        this.f42059b = r12;
        this.f42060c = callback;
        this.f42061d = th;
    }

    public final void run() {
        this.f42059b.lambda$onFailure$1(this.f42060c, this.f42061d);
    }
}
