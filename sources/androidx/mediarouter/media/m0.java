package androidx.mediarouter.media;

import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.RegisteredMediaRouteProvider;

public final /* synthetic */ class m0 implements RegisteredMediaRouteProvider.ControllerCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RegisteredMediaRouteProviderWatcher f10742a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegisteredMediaRouteProvider f10743b;

    public /* synthetic */ m0(RegisteredMediaRouteProviderWatcher registeredMediaRouteProviderWatcher, RegisteredMediaRouteProvider registeredMediaRouteProvider) {
        this.f10742a = registeredMediaRouteProviderWatcher;
        this.f10743b = registeredMediaRouteProvider;
    }

    public final void a(MediaRouteProvider.RouteController routeController) {
        this.f10742a.d(this.f10743b, routeController);
    }
}
