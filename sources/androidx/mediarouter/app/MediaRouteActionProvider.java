package androidx.mediarouter.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ActionProvider;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.mediarouter.media.MediaRouterParams;
import java.lang.ref.WeakReference;

public class MediaRouteActionProvider extends ActionProvider {
    private static final String TAG = "MRActionProvider";
    private boolean mAlwaysVisible;
    private MediaRouteButton mButton;
    private final MediaRouterCallback mCallback;
    private MediaRouteDialogFactory mDialogFactory = MediaRouteDialogFactory.getDefault();
    private final MediaRouter mRouter;
    private MediaRouteSelector mSelector = MediaRouteSelector.f10544c;

    private static final class MediaRouterCallback extends MediaRouter.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<MediaRouteActionProvider> f10210a;

        public MediaRouterCallback(MediaRouteActionProvider mediaRouteActionProvider) {
            this.f10210a = new WeakReference<>(mediaRouteActionProvider);
        }

        private void a(MediaRouter mediaRouter) {
            MediaRouteActionProvider mediaRouteActionProvider = this.f10210a.get();
            if (mediaRouteActionProvider != null) {
                mediaRouteActionProvider.refreshRoute();
            } else {
                mediaRouter.s(this);
            }
        }

        public void onProviderAdded(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
            a(mediaRouter);
        }

        public void onProviderChanged(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
            a(mediaRouter);
        }

        public void onProviderRemoved(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
            a(mediaRouter);
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            a(mediaRouter);
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            a(mediaRouter);
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            a(mediaRouter);
        }
    }

    public MediaRouteActionProvider(Context context) {
        super(context);
        this.mRouter = MediaRouter.j(context);
        this.mCallback = new MediaRouterCallback(this);
    }

    @Deprecated
    public void enableDynamicGroup() {
        MediaRouterParams.Builder builder;
        MediaRouterParams l2 = this.mRouter.l();
        if (l2 == null) {
            builder = new MediaRouterParams.Builder();
        } else {
            builder = new MediaRouterParams.Builder(l2);
        }
        builder.b(2);
        this.mRouter.x(builder.a());
    }

    public MediaRouteDialogFactory getDialogFactory() {
        return this.mDialogFactory;
    }

    public MediaRouteButton getMediaRouteButton() {
        return this.mButton;
    }

    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public boolean isVisible() {
        return this.mAlwaysVisible || this.mRouter.q(this.mSelector, 1);
    }

    public View onCreateActionView() {
        if (this.mButton != null) {
            Log.e(TAG, "onCreateActionView: this ActionProvider is already associated with a menu item. Don't reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
        }
        MediaRouteButton onCreateMediaRouteButton = onCreateMediaRouteButton();
        this.mButton = onCreateMediaRouteButton;
        onCreateMediaRouteButton.setCheatSheetEnabled(true);
        this.mButton.setRouteSelector(this.mSelector);
        this.mButton.setAlwaysVisible(this.mAlwaysVisible);
        this.mButton.setDialogFactory(this.mDialogFactory);
        this.mButton.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return this.mButton;
    }

    public MediaRouteButton onCreateMediaRouteButton() {
        return new MediaRouteButton(getContext());
    }

    public boolean onPerformDefaultAction() {
        MediaRouteButton mediaRouteButton = this.mButton;
        if (mediaRouteButton != null) {
            return mediaRouteButton.d();
        }
        return false;
    }

    public boolean overridesItemVisibility() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void refreshRoute() {
        refreshVisibility();
    }

    public void setAlwaysVisible(boolean z2) {
        if (this.mAlwaysVisible != z2) {
            this.mAlwaysVisible = z2;
            refreshVisibility();
            MediaRouteButton mediaRouteButton = this.mButton;
            if (mediaRouteButton != null) {
                mediaRouteButton.setAlwaysVisible(this.mAlwaysVisible);
            }
        }
    }

    public void setDialogFactory(MediaRouteDialogFactory mediaRouteDialogFactory) {
        if (mediaRouteDialogFactory == null) {
            throw new IllegalArgumentException("factory must not be null");
        } else if (this.mDialogFactory != mediaRouteDialogFactory) {
            this.mDialogFactory = mediaRouteDialogFactory;
            MediaRouteButton mediaRouteButton = this.mButton;
            if (mediaRouteButton != null) {
                mediaRouteButton.setDialogFactory(mediaRouteDialogFactory);
            }
        }
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.mSelector.equals(mediaRouteSelector)) {
            if (!this.mSelector.f()) {
                this.mRouter.s(this.mCallback);
            }
            if (!mediaRouteSelector.f()) {
                this.mRouter.a(mediaRouteSelector, this.mCallback);
            }
            this.mSelector = mediaRouteSelector;
            refreshRoute();
            MediaRouteButton mediaRouteButton = this.mButton;
            if (mediaRouteButton != null) {
                mediaRouteButton.setRouteSelector(mediaRouteSelector);
            }
        }
    }
}
