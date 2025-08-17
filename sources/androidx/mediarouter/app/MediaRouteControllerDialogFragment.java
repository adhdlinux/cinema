package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.mediarouter.media.MediaRouteSelector;

public class MediaRouteControllerDialogFragment extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private boolean f10320b = false;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f10321c;

    /* renamed from: d  reason: collision with root package name */
    private MediaRouteSelector f10322d;

    public MediaRouteControllerDialogFragment() {
        setCancelable(true);
    }

    private void ensureRouteSelector() {
        if (this.f10322d == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f10322d = MediaRouteSelector.d(arguments.getBundle("selector"));
            }
            if (this.f10322d == null) {
                this.f10322d = MediaRouteSelector.f10544c;
            }
        }
    }

    public MediaRouteControllerDialog F(Context context, Bundle bundle) {
        return new MediaRouteControllerDialog(context);
    }

    public MediaRouteDynamicControllerDialog G(Context context) {
        return new MediaRouteDynamicControllerDialog(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f10321c;
        if (dialog == null) {
            return;
        }
        if (this.f10320b) {
            ((MediaRouteDynamicControllerDialog) dialog).updateLayout();
        } else {
            ((MediaRouteControllerDialog) dialog).updateLayout();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f10320b) {
            MediaRouteDynamicControllerDialog G = G(getContext());
            this.f10321c = G;
            G.setRouteSelector(this.f10322d);
        } else {
            this.f10321c = F(getContext(), bundle);
        }
        return this.f10321c;
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.f10321c;
        if (dialog != null && !this.f10320b) {
            ((MediaRouteControllerDialog) dialog).k(false);
        }
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector != null) {
            ensureRouteSelector();
            if (!this.f10322d.equals(mediaRouteSelector)) {
                this.f10322d = mediaRouteSelector;
                Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = new Bundle();
                }
                arguments.putBundle("selector", mediaRouteSelector.a());
                setArguments(arguments);
                Dialog dialog = this.f10321c;
                if (dialog != null && this.f10320b) {
                    ((MediaRouteDynamicControllerDialog) dialog).setRouteSelector(mediaRouteSelector);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    /* access modifiers changed from: package-private */
    public void setUseDynamicGroup(boolean z2) {
        if (this.f10321c == null) {
            this.f10320b = z2;
            return;
        }
        throw new IllegalStateException("This must be called before creating dialog");
    }
}
