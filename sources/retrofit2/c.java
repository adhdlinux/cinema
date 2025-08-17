package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f42056b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f42057c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Response f42058d;

    public /* synthetic */ c(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Response response) {
        this.f42056b = r12;
        this.f42057c = callback;
        this.f42058d = response;
    }

    public final void run() {
        this.f42056b.lambda$onResponse$0(this.f42057c, this.f42058d);
    }
}
