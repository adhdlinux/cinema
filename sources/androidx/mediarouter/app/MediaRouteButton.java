package androidx.mediarouter.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$string;
import androidx.mediarouter.R$styleable;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.mediarouter.media.MediaRouterParams;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;

public class MediaRouteButton extends View {

    /* renamed from: s  reason: collision with root package name */
    private static ConnectivityReceiver f10211s;

    /* renamed from: t  reason: collision with root package name */
    static final SparseArray<Drawable.ConstantState> f10212t = new SparseArray<>(2);

    /* renamed from: u  reason: collision with root package name */
    private static final int[] f10213u = {16842912};

    /* renamed from: v  reason: collision with root package name */
    private static final int[] f10214v = {16842911};

    /* renamed from: b  reason: collision with root package name */
    private final MediaRouter f10215b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaRouterCallback f10216c;

    /* renamed from: d  reason: collision with root package name */
    private MediaRouteSelector f10217d;

    /* renamed from: e  reason: collision with root package name */
    private MediaRouteDialogFactory f10218e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10219f;

    /* renamed from: g  reason: collision with root package name */
    private int f10220g;

    /* renamed from: h  reason: collision with root package name */
    boolean f10221h;

    /* renamed from: i  reason: collision with root package name */
    RemoteIndicatorLoader f10222i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f10223j;

    /* renamed from: k  reason: collision with root package name */
    private int f10224k;

    /* renamed from: l  reason: collision with root package name */
    private int f10225l;

    /* renamed from: m  reason: collision with root package name */
    private int f10226m;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f10227n;

    /* renamed from: o  reason: collision with root package name */
    private int f10228o;

    /* renamed from: p  reason: collision with root package name */
    private int f10229p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10230q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10231r;

    private static final class ConnectivityReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Context f10232a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10233b = true;

        /* renamed from: c  reason: collision with root package name */
        private List<MediaRouteButton> f10234c;

        ConnectivityReceiver(Context context) {
            this.f10232a = context;
            this.f10234c = new ArrayList();
        }

        public boolean a() {
            return this.f10233b;
        }

        public void b(MediaRouteButton mediaRouteButton) {
            if (this.f10234c.size() == 0) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f10232a.registerReceiver(this, intentFilter);
            }
            this.f10234c.add(mediaRouteButton);
        }

        public void c(MediaRouteButton mediaRouteButton) {
            this.f10234c.remove(mediaRouteButton);
            if (this.f10234c.size() == 0) {
                this.f10232a.unregisterReceiver(this);
            }
        }

        public void onReceive(Context context, Intent intent) {
            boolean z2;
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && this.f10233b != (!intent.getBooleanExtra("noConnectivity", false))) {
                this.f10233b = z2;
                for (MediaRouteButton c2 : this.f10234c) {
                    c2.c();
                }
            }
        }
    }

    private final class MediaRouterCallback extends MediaRouter.Callback {
        MediaRouterCallback() {
        }

        public void onProviderAdded(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
            MediaRouteButton.this.b();
        }

        public void onProviderChanged(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
            MediaRouteButton.this.b();
        }

        public void onProviderRemoved(MediaRouter mediaRouter, MediaRouter.ProviderInfo providerInfo) {
            MediaRouteButton.this.b();
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteButton.this.b();
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteButton.this.b();
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteButton.this.b();
        }

        public void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteButton.this.b();
        }

        public void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteButton.this.b();
        }

        public void onRouterParamsChanged(MediaRouter mediaRouter, MediaRouterParams mediaRouterParams) {
            boolean z2;
            if (mediaRouterParams != null) {
                z2 = mediaRouterParams.b().getBoolean("androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON");
            } else {
                z2 = false;
            }
            MediaRouteButton mediaRouteButton = MediaRouteButton.this;
            if (mediaRouteButton.f10221h != z2) {
                mediaRouteButton.f10221h = z2;
                mediaRouteButton.refreshDrawableState();
            }
        }
    }

    private final class RemoteIndicatorLoader extends AsyncTask<Void, Void, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        private final int f10236a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f10237b;

        RemoteIndicatorLoader(int i2, Context context) {
            this.f10236a = i2;
            this.f10237b = context;
        }

        private void a(Drawable drawable) {
            if (drawable != null) {
                MediaRouteButton.f10212t.put(this.f10236a, drawable.getConstantState());
            }
            MediaRouteButton.this.f10222i = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Drawable doInBackground(Void... voidArr) {
            if (MediaRouteButton.f10212t.get(this.f10236a) == null) {
                return AppCompatResources.b(this.f10237b, this.f10236a);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onCancelled(Drawable drawable) {
            a(drawable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void onPostExecute(Drawable drawable) {
            if (drawable != null) {
                a(drawable);
            } else {
                Drawable.ConstantState constantState = MediaRouteButton.f10212t.get(this.f10236a);
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                MediaRouteButton.this.f10222i = null;
            }
            MediaRouteButton.this.setRemoteIndicatorDrawableInternal(drawable);
        }
    }

    public MediaRouteButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a() {
        if (this.f10224k > 0) {
            RemoteIndicatorLoader remoteIndicatorLoader = this.f10222i;
            if (remoteIndicatorLoader != null) {
                remoteIndicatorLoader.cancel(false);
            }
            RemoteIndicatorLoader remoteIndicatorLoader2 = new RemoteIndicatorLoader(this.f10224k, getContext());
            this.f10222i = remoteIndicatorLoader2;
            this.f10224k = 0;
            remoteIndicatorLoader2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    private boolean e(int i2) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            if (this.f10215b.n().w()) {
                if (fragmentManager.i0("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                    Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                    return false;
                }
                MediaRouteChooserDialogFragment onCreateChooserDialogFragment = this.f10218e.onCreateChooserDialogFragment();
                onCreateChooserDialogFragment.setRouteSelector(this.f10217d);
                if (i2 == 2) {
                    onCreateChooserDialogFragment.setUseDynamicGroup(true);
                }
                FragmentTransaction n2 = fragmentManager.n();
                n2.e(onCreateChooserDialogFragment, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
                n2.i();
            } else if (fragmentManager.i0("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
                return false;
            } else {
                MediaRouteControllerDialogFragment onCreateControllerDialogFragment = this.f10218e.onCreateControllerDialogFragment();
                onCreateControllerDialogFragment.setRouteSelector(this.f10217d);
                if (i2 == 2) {
                    onCreateControllerDialogFragment.setUseDynamicGroup(true);
                }
                FragmentTransaction n3 = fragmentManager.n();
                n3.e(onCreateControllerDialogFragment, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
                n3.i();
            }
            return true;
        }
        throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
    }

    private boolean f() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            boolean h2 = h();
            if (!h2) {
                return g();
            }
            return h2;
        } else if (i2 == 30) {
            return g();
        } else {
            return false;
        }
    }

    private boolean g() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        Intent putExtra = new Intent().setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", context.getPackageName()).putExtra("key_media_session_token", this.f10215b.k());
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(putExtra, 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE) != 0) {
                context.startActivity(putExtra);
                return true;
            }
        }
        return false;
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private FragmentManager getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            return ((FragmentActivity) activity).getSupportFragmentManager();
        }
        return null;
    }

    private boolean h() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        Intent putExtra = new Intent().setAction("com.android.systemui.action.LAUNCH_MEDIA_OUTPUT_DIALOG").setPackage("com.android.systemui").putExtra("package_name", context.getPackageName()).putExtra("key_media_session_token", this.f10215b.k());
        for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(putExtra, 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE) != 0) {
                context.sendBroadcast(putExtra);
                return true;
            }
        }
        return false;
    }

    private void i() {
        int i2;
        int i3 = this.f10226m;
        if (i3 == 1) {
            i2 = R$string.mr_cast_button_connecting;
        } else if (i3 != 2) {
            i2 = R$string.mr_cast_button_disconnected;
        } else {
            i2 = R$string.mr_cast_button_connected;
        }
        String string = getContext().getString(i2);
        setContentDescription(string);
        if (!this.f10231r || TextUtils.isEmpty(string)) {
            string = null;
        }
        TooltipCompat.a(this, string);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2;
        MediaRouter.RouteInfo n2 = this.f10215b.n();
        boolean z2 = true;
        boolean z3 = !n2.w();
        if (z3) {
            i2 = n2.c();
        } else {
            i2 = 0;
        }
        if (this.f10226m != i2) {
            this.f10226m = i2;
            i();
            refreshDrawableState();
        }
        if (i2 == 1) {
            a();
        }
        if (this.f10219f) {
            if (!this.f10230q && !z3 && !this.f10215b.q(this.f10217d, 1)) {
                z2 = false;
            }
            setEnabled(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int i2;
        boolean z2;
        if (this.f10220g != 0 || this.f10230q || f10211s.a()) {
            i2 = this.f10220g;
        } else {
            i2 = 4;
        }
        super.setVisibility(i2);
        Drawable drawable = this.f10223j;
        if (drawable != null) {
            if (getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            drawable.setVisible(z2, false);
        }
    }

    public boolean d() {
        if (!this.f10219f) {
            return false;
        }
        MediaRouterParams l2 = this.f10215b.l();
        if (l2 == null) {
            return e(1);
        }
        if (!l2.d() || !MediaRouter.p() || !f()) {
            return e(l2.a());
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f10223j != null) {
            this.f10223j.setState(getDrawableState());
            if (this.f10223j.getCurrent() instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f10223j.getCurrent();
                int i2 = this.f10226m;
                if (i2 == 1 || this.f10225l != i2) {
                    if (!animationDrawable.isRunning()) {
                        animationDrawable.start();
                    }
                } else if (i2 == 2 && !animationDrawable.isRunning()) {
                    animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
                }
            }
            invalidate();
        }
        this.f10225l = this.f10226m;
    }

    public MediaRouteDialogFactory getDialogFactory() {
        return this.f10218e;
    }

    public MediaRouteSelector getRouteSelector() {
        return this.f10217d;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f10223j;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.f10219f = true;
            if (!this.f10217d.f()) {
                this.f10215b.a(this.f10217d, this.f10216c);
            }
            b();
            f10211s.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.f10215b == null || this.f10221h) {
            return onCreateDrawableState;
        }
        int i3 = this.f10226m;
        if (i3 == 1) {
            View.mergeDrawableStates(onCreateDrawableState, f10214v);
        } else if (i3 == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f10213u);
        }
        return onCreateDrawableState;
    }

    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f10219f = false;
            if (!this.f10217d.f()) {
                this.f10215b.s(this.f10216c);
            }
            f10211s.c(this);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10223j != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.f10223j.getIntrinsicWidth();
            int intrinsicHeight = this.f10223j.getIntrinsicHeight();
            int i2 = paddingLeft + (((width - paddingLeft) - intrinsicWidth) / 2);
            int i3 = paddingTop + (((height - paddingTop) - intrinsicHeight) / 2);
            this.f10223j.setBounds(i2, i3, intrinsicWidth + i2, intrinsicHeight + i3);
            this.f10223j.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i5 = this.f10228o;
        Drawable drawable = this.f10223j;
        int i6 = 0;
        if (drawable != null) {
            i4 = drawable.getIntrinsicWidth() + getPaddingLeft() + getPaddingRight();
        } else {
            i4 = 0;
        }
        int max = Math.max(i5, i4);
        int i7 = this.f10229p;
        Drawable drawable2 = this.f10223j;
        if (drawable2 != null) {
            i6 = drawable2.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom();
        }
        int max2 = Math.max(i7, i6);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, max);
        } else if (mode != 1073741824) {
            size = max;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, max2);
        } else if (mode2 != 1073741824) {
            size2 = max2;
        }
        setMeasuredDimension(size, size2);
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        a();
        if (d() || performClick) {
            return true;
        }
        return false;
    }

    public void setAlwaysVisible(boolean z2) {
        if (z2 != this.f10230q) {
            this.f10230q = z2;
            c();
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCheatSheetEnabled(boolean z2) {
        if (z2 != this.f10231r) {
            this.f10231r = z2;
            i();
        }
    }

    public void setDialogFactory(MediaRouteDialogFactory mediaRouteDialogFactory) {
        if (mediaRouteDialogFactory != null) {
            this.f10218e = mediaRouteDialogFactory;
            return;
        }
        throw new IllegalArgumentException("factory must not be null");
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        this.f10224k = 0;
        setRemoteIndicatorDrawableInternal(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setRemoteIndicatorDrawableInternal(Drawable drawable) {
        boolean z2;
        RemoteIndicatorLoader remoteIndicatorLoader = this.f10222i;
        if (remoteIndicatorLoader != null) {
            remoteIndicatorLoader.cancel(false);
        }
        Drawable drawable2 = this.f10223j;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f10223j);
        }
        if (drawable != null) {
            if (this.f10227n != null) {
                drawable = DrawableCompat.r(drawable.mutate());
                DrawableCompat.o(drawable, this.f10227n);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            if (getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            drawable.setVisible(z2, false);
        }
        this.f10223j = drawable;
        refreshDrawableState();
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f10217d.equals(mediaRouteSelector)) {
            if (this.f10219f) {
                if (!this.f10217d.f()) {
                    this.f10215b.s(this.f10216c);
                }
                if (!mediaRouteSelector.f()) {
                    this.f10215b.a(mediaRouteSelector, this.f10216c);
                }
            }
            this.f10217d = mediaRouteSelector;
            b();
        }
    }

    public void setVisibility(int i2) {
        this.f10220g = i2;
        c();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10223j;
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.mediaRouteButtonStyle);
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet, int i2) {
        super(MediaRouterThemeHelper.a(context), attributeSet, i2);
        Drawable.ConstantState constantState;
        this.f10217d = MediaRouteSelector.f10544c;
        this.f10218e = MediaRouteDialogFactory.getDefault();
        this.f10220g = 0;
        Context context2 = getContext();
        int[] iArr = R$styleable.f10204a;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        ViewCompat.p0(this, context2, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        if (isInEditMode()) {
            this.f10215b = null;
            this.f10216c = null;
            this.f10223j = AppCompatResources.b(context2, obtainStyledAttributes.getResourceId(R$styleable.f10208e, 0));
            return;
        }
        MediaRouter j2 = MediaRouter.j(context2);
        this.f10215b = j2;
        this.f10216c = new MediaRouterCallback();
        MediaRouter.RouteInfo n2 = j2.n();
        int c2 = n2.w() ^ true ? n2.c() : 0;
        this.f10226m = c2;
        this.f10225l = c2;
        if (f10211s == null) {
            f10211s = new ConnectivityReceiver(context2.getApplicationContext());
        }
        this.f10227n = obtainStyledAttributes.getColorStateList(R$styleable.f10209f);
        this.f10228o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10205b, 0);
        this.f10229p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10206c, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f10208e, 0);
        this.f10224k = obtainStyledAttributes.getResourceId(R$styleable.f10207d, 0);
        obtainStyledAttributes.recycle();
        int i3 = this.f10224k;
        if (!(i3 == 0 || (constantState = f10212t.get(i3)) == null)) {
            setRemoteIndicatorDrawable(constantState.newDrawable());
        }
        if (this.f10223j == null) {
            if (resourceId != 0) {
                Drawable.ConstantState constantState2 = f10212t.get(resourceId);
                if (constantState2 != null) {
                    setRemoteIndicatorDrawableInternal(constantState2.newDrawable());
                } else {
                    RemoteIndicatorLoader remoteIndicatorLoader = new RemoteIndicatorLoader(resourceId, getContext());
                    this.f10222i = remoteIndicatorLoader;
                    remoteIndicatorLoader.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            } else {
                a();
            }
        }
        i();
        setClickable(true);
    }
}
