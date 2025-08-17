package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.util.ObjectsCompat;
import androidx.mediarouter.R$dimen;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$integer;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MediaRouteDynamicControllerDialog extends AppCompatDialog {
    static final boolean Q = Log.isLoggable("MediaRouteCtrlDialog", 3);
    private ImageView A;
    private View B;
    ImageView C;
    private TextView D;
    private TextView E;
    private String F;
    MediaControllerCompat G;
    MediaControllerCallback H;
    MediaDescriptionCompat I;
    FetchArtTask J;
    Bitmap K;
    Uri L;
    boolean M;
    Bitmap N;
    int O;
    final boolean P;

    /* renamed from: b  reason: collision with root package name */
    final MediaRouter f10359b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaRouterCallback f10360c;

    /* renamed from: d  reason: collision with root package name */
    private MediaRouteSelector f10361d;

    /* renamed from: e  reason: collision with root package name */
    MediaRouter.RouteInfo f10362e;

    /* renamed from: f  reason: collision with root package name */
    final List<MediaRouter.RouteInfo> f10363f;

    /* renamed from: g  reason: collision with root package name */
    final List<MediaRouter.RouteInfo> f10364g;

    /* renamed from: h  reason: collision with root package name */
    final List<MediaRouter.RouteInfo> f10365h;

    /* renamed from: i  reason: collision with root package name */
    final List<MediaRouter.RouteInfo> f10366i;

    /* renamed from: j  reason: collision with root package name */
    Context f10367j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10368k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10369l;

    /* renamed from: m  reason: collision with root package name */
    private long f10370m;

    /* renamed from: n  reason: collision with root package name */
    final Handler f10371n;

    /* renamed from: o  reason: collision with root package name */
    RecyclerView f10372o;

    /* renamed from: p  reason: collision with root package name */
    RecyclerAdapter f10373p;

    /* renamed from: q  reason: collision with root package name */
    VolumeChangeListener f10374q;

    /* renamed from: r  reason: collision with root package name */
    Map<String, MediaRouteVolumeSliderHolder> f10375r;

    /* renamed from: s  reason: collision with root package name */
    MediaRouter.RouteInfo f10376s;

    /* renamed from: t  reason: collision with root package name */
    Map<String, Integer> f10377t;

    /* renamed from: u  reason: collision with root package name */
    boolean f10378u;

    /* renamed from: v  reason: collision with root package name */
    boolean f10379v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10380w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f10381x;

    /* renamed from: y  reason: collision with root package name */
    private ImageButton f10382y;

    /* renamed from: z  reason: collision with root package name */
    private Button f10383z;

    private class FetchArtTask extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f10387a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f10388b;

        /* renamed from: c  reason: collision with root package name */
        private int f10389c;

        FetchArtTask() {
            Bitmap bitmap;
            MediaDescriptionCompat mediaDescriptionCompat = MediaRouteDynamicControllerDialog.this.I;
            Uri uri = null;
            if (mediaDescriptionCompat == null) {
                bitmap = null;
            } else {
                bitmap = mediaDescriptionCompat.getIconBitmap();
            }
            if (MediaRouteDynamicControllerDialog.e(bitmap)) {
                Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
                bitmap = null;
            }
            this.f10387a = bitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = MediaRouteDynamicControllerDialog.this.I;
            this.f10388b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : uri;
        }

        private InputStream e(Uri uri) throws IOException {
            InputStream inputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                inputStream = MediaRouteDynamicControllerDialog.this.f10367j.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                openConnection.setConnectTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
                openConnection.setReadTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
                inputStream = openConnection.getInputStream();
            }
            if (inputStream == null) {
                return null;
            }
            return new BufferedInputStream(inputStream);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0048 */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ IOException -> 0x00a3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00bf A[SYNTHETIC, Splitter:B:54:0x00bf] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00c9 A[SYNTHETIC, Splitter:B:60:0x00c9] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00e9 A[ADDED_TO_REGION] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r9) {
            /*
                r8 = this;
                java.lang.String r9 = "Unable to open: "
                android.graphics.Bitmap r0 = r8.f10387a
                r1 = 0
                r2 = 1
                java.lang.String r3 = "MediaRouteCtrlDialog"
                r4 = 0
                if (r0 == 0) goto L_0x000d
                goto L_0x00ce
            L_0x000d:
                android.net.Uri r0 = r8.f10388b
                if (r0 == 0) goto L_0x00cd
                java.io.InputStream r0 = r8.e(r0)     // Catch:{ IOException -> 0x00a7, all -> 0x00a5 }
                if (r0 != 0) goto L_0x0031
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a3 }
                r5.<init>()     // Catch:{ IOException -> 0x00a3 }
                r5.append(r9)     // Catch:{ IOException -> 0x00a3 }
                android.net.Uri r6 = r8.f10388b     // Catch:{ IOException -> 0x00a3 }
                r5.append(r6)     // Catch:{ IOException -> 0x00a3 }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00a3 }
                android.util.Log.w(r3, r5)     // Catch:{ IOException -> 0x00a3 }
                if (r0 == 0) goto L_0x0030
                r0.close()     // Catch:{ IOException -> 0x0030 }
            L_0x0030:
                return r4
            L_0x0031:
                android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x00a3 }
                r5.<init>()     // Catch:{ IOException -> 0x00a3 }
                r5.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x00a3 }
                android.graphics.BitmapFactory.decodeStream(r0, r4, r5)     // Catch:{ IOException -> 0x00a3 }
                int r6 = r5.outWidth     // Catch:{ IOException -> 0x00a3 }
                if (r6 == 0) goto L_0x009f
                int r6 = r5.outHeight     // Catch:{ IOException -> 0x00a3 }
                if (r6 != 0) goto L_0x0044
                goto L_0x009f
            L_0x0044:
                r0.reset()     // Catch:{ IOException -> 0x0048 }
                goto L_0x006d
            L_0x0048:
                r0.close()     // Catch:{ IOException -> 0x00a3 }
                android.net.Uri r6 = r8.f10388b     // Catch:{ IOException -> 0x00a3 }
                java.io.InputStream r0 = r8.e(r6)     // Catch:{ IOException -> 0x00a3 }
                if (r0 != 0) goto L_0x006d
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a3 }
                r5.<init>()     // Catch:{ IOException -> 0x00a3 }
                r5.append(r9)     // Catch:{ IOException -> 0x00a3 }
                android.net.Uri r6 = r8.f10388b     // Catch:{ IOException -> 0x00a3 }
                r5.append(r6)     // Catch:{ IOException -> 0x00a3 }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00a3 }
                android.util.Log.w(r3, r5)     // Catch:{ IOException -> 0x00a3 }
                if (r0 == 0) goto L_0x006c
                r0.close()     // Catch:{ IOException -> 0x006c }
            L_0x006c:
                return r4
            L_0x006d:
                r5.inJustDecodeBounds = r1     // Catch:{ IOException -> 0x00a3 }
                androidx.mediarouter.app.MediaRouteDynamicControllerDialog r6 = androidx.mediarouter.app.MediaRouteDynamicControllerDialog.this     // Catch:{ IOException -> 0x00a3 }
                android.content.Context r6 = r6.f10367j     // Catch:{ IOException -> 0x00a3 }
                android.content.res.Resources r6 = r6.getResources()     // Catch:{ IOException -> 0x00a3 }
                int r7 = androidx.mediarouter.R$dimen.mr_cast_meta_art_size     // Catch:{ IOException -> 0x00a3 }
                int r6 = r6.getDimensionPixelSize(r7)     // Catch:{ IOException -> 0x00a3 }
                int r7 = r5.outHeight     // Catch:{ IOException -> 0x00a3 }
                int r7 = r7 / r6
                int r6 = java.lang.Integer.highestOneBit(r7)     // Catch:{ IOException -> 0x00a3 }
                int r6 = java.lang.Math.max(r2, r6)     // Catch:{ IOException -> 0x00a3 }
                r5.inSampleSize = r6     // Catch:{ IOException -> 0x00a3 }
                boolean r6 = r8.isCancelled()     // Catch:{ IOException -> 0x00a3 }
                if (r6 == 0) goto L_0x0094
                r0.close()     // Catch:{ IOException -> 0x0093 }
            L_0x0093:
                return r4
            L_0x0094:
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r0, r4, r5)     // Catch:{ IOException -> 0x00a3 }
                r0.close()     // Catch:{ IOException -> 0x009c }
                goto L_0x009d
            L_0x009c:
            L_0x009d:
                r0 = r9
                goto L_0x00ce
            L_0x009f:
                r0.close()     // Catch:{ IOException -> 0x00a2 }
            L_0x00a2:
                return r4
            L_0x00a3:
                r5 = move-exception
                goto L_0x00a9
            L_0x00a5:
                r9 = move-exception
                goto L_0x00c7
            L_0x00a7:
                r5 = move-exception
                r0 = r4
            L_0x00a9:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
                r6.<init>()     // Catch:{ all -> 0x00c5 }
                r6.append(r9)     // Catch:{ all -> 0x00c5 }
                android.net.Uri r9 = r8.f10388b     // Catch:{ all -> 0x00c5 }
                r6.append(r9)     // Catch:{ all -> 0x00c5 }
                java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00c5 }
                android.util.Log.w(r3, r9, r5)     // Catch:{ all -> 0x00c5 }
                if (r0 == 0) goto L_0x00cd
                r0.close()     // Catch:{ IOException -> 0x00c3 }
                goto L_0x00cd
            L_0x00c3:
                goto L_0x00cd
            L_0x00c5:
                r9 = move-exception
                r4 = r0
            L_0x00c7:
                if (r4 == 0) goto L_0x00cc
                r4.close()     // Catch:{ IOException -> 0x00cc }
            L_0x00cc:
                throw r9
            L_0x00cd:
                r0 = r4
            L_0x00ce:
                boolean r9 = androidx.mediarouter.app.MediaRouteDynamicControllerDialog.e(r0)
                if (r9 == 0) goto L_0x00e9
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r1 = "Can't use recycled bitmap: "
                r9.append(r1)
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                android.util.Log.w(r3, r9)
                return r4
            L_0x00e9:
                if (r0 == 0) goto L_0x011d
                int r9 = r0.getWidth()
                int r3 = r0.getHeight()
                if (r9 >= r3) goto L_0x011d
                androidx.palette.graphics.Palette$Builder r9 = new androidx.palette.graphics.Palette$Builder
                r9.<init>(r0)
                androidx.palette.graphics.Palette$Builder r9 = r9.d(r2)
                androidx.palette.graphics.Palette r9 = r9.b()
                java.util.List r2 = r9.n()
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x010d
                goto L_0x011b
            L_0x010d:
                java.util.List r9 = r9.n()
                java.lang.Object r9 = r9.get(r1)
                androidx.palette.graphics.Palette$Swatch r9 = (androidx.palette.graphics.Palette.Swatch) r9
                int r1 = r9.e()
            L_0x011b:
                r8.f10389c = r1
            L_0x011d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.FetchArtTask.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        /* access modifiers changed from: package-private */
        public Bitmap b() {
            return this.f10387a;
        }

        /* access modifiers changed from: package-private */
        public Uri c() {
            return this.f10388b;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void onPostExecute(Bitmap bitmap) {
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            mediaRouteDynamicControllerDialog.J = null;
            if (!ObjectsCompat.a(mediaRouteDynamicControllerDialog.K, this.f10387a) || !ObjectsCompat.a(MediaRouteDynamicControllerDialog.this.L, this.f10388b)) {
                MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog2 = MediaRouteDynamicControllerDialog.this;
                mediaRouteDynamicControllerDialog2.K = this.f10387a;
                mediaRouteDynamicControllerDialog2.N = bitmap;
                mediaRouteDynamicControllerDialog2.L = this.f10388b;
                mediaRouteDynamicControllerDialog2.O = this.f10389c;
                mediaRouteDynamicControllerDialog2.M = true;
                mediaRouteDynamicControllerDialog2.j();
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            MediaRouteDynamicControllerDialog.this.c();
        }
    }

    private final class MediaControllerCallback extends MediaControllerCompat.Callback {
        MediaControllerCallback() {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaDescriptionCompat mediaDescriptionCompat;
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            if (mediaMetadataCompat == null) {
                mediaDescriptionCompat = null;
            } else {
                mediaDescriptionCompat = mediaMetadataCompat.getDescription();
            }
            mediaRouteDynamicControllerDialog.I = mediaDescriptionCompat;
            MediaRouteDynamicControllerDialog.this.f();
            MediaRouteDynamicControllerDialog.this.j();
        }

        public void onSessionDestroyed() {
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            MediaControllerCompat mediaControllerCompat = mediaRouteDynamicControllerDialog.G;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.unregisterCallback(mediaRouteDynamicControllerDialog.H);
                MediaRouteDynamicControllerDialog.this.G = null;
            }
        }
    }

    private abstract class MediaRouteVolumeSliderHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        MediaRouter.RouteInfo f10392j;

        /* renamed from: k  reason: collision with root package name */
        final ImageButton f10393k;

        /* renamed from: l  reason: collision with root package name */
        final MediaRouteVolumeSlider f10394l;

        MediaRouteVolumeSliderHolder(View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
            super(view);
            this.f10393k = imageButton;
            this.f10394l = mediaRouteVolumeSlider;
            imageButton.setImageDrawable(MediaRouterThemeHelper.k(MediaRouteDynamicControllerDialog.this.f10367j));
            MediaRouterThemeHelper.v(MediaRouteDynamicControllerDialog.this.f10367j, mediaRouteVolumeSlider);
        }

        /* access modifiers changed from: package-private */
        public void a(MediaRouter.RouteInfo routeInfo) {
            boolean z2;
            this.f10392j = routeInfo;
            int s2 = routeInfo.s();
            if (s2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f10393k.setActivated(z2);
            this.f10393k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int i2;
                    MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
                    if (mediaRouteDynamicControllerDialog.f10376s != null) {
                        mediaRouteDynamicControllerDialog.f10371n.removeMessages(2);
                    }
                    MediaRouteVolumeSliderHolder mediaRouteVolumeSliderHolder = MediaRouteVolumeSliderHolder.this;
                    MediaRouteDynamicControllerDialog.this.f10376s = mediaRouteVolumeSliderHolder.f10392j;
                    boolean z2 = !view.isActivated();
                    if (z2) {
                        i2 = 0;
                    } else {
                        i2 = MediaRouteVolumeSliderHolder.this.b();
                    }
                    MediaRouteVolumeSliderHolder.this.c(z2);
                    MediaRouteVolumeSliderHolder.this.f10394l.setProgress(i2);
                    MediaRouteVolumeSliderHolder.this.f10392j.G(i2);
                    MediaRouteDynamicControllerDialog.this.f10371n.sendEmptyMessageDelayed(2, 500);
                }
            });
            this.f10394l.setTag(this.f10392j);
            this.f10394l.setMax(routeInfo.u());
            this.f10394l.setProgress(s2);
            this.f10394l.setOnSeekBarChangeListener(MediaRouteDynamicControllerDialog.this.f10374q);
        }

        /* access modifiers changed from: package-private */
        public int b() {
            Integer num = MediaRouteDynamicControllerDialog.this.f10377t.get(this.f10392j.k());
            if (num == null) {
                return 1;
            }
            return Math.max(1, num.intValue());
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z2) {
            if (this.f10393k.isActivated() != z2) {
                this.f10393k.setActivated(z2);
                if (z2) {
                    MediaRouteDynamicControllerDialog.this.f10377t.put(this.f10392j.k(), Integer.valueOf(this.f10394l.getProgress()));
                } else {
                    MediaRouteDynamicControllerDialog.this.f10377t.remove(this.f10392j.k());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z2;
            int s2 = this.f10392j.s();
            if (s2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c(z2);
            this.f10394l.setProgress(s2);
        }
    }

    private final class MediaRouterCallback extends MediaRouter.Callback {
        MediaRouterCallback() {
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog.this.l();
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            boolean z2;
            MediaRouter.RouteInfo.DynamicGroupState h2;
            if (routeInfo == MediaRouteDynamicControllerDialog.this.f10362e && routeInfo.g() != null) {
                Iterator<MediaRouter.RouteInfo> it2 = routeInfo.q().f().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    MediaRouter.RouteInfo next = it2.next();
                    if (!MediaRouteDynamicControllerDialog.this.f10362e.l().contains(next) && (h2 = MediaRouteDynamicControllerDialog.this.f10362e.h(next)) != null && h2.b() && !MediaRouteDynamicControllerDialog.this.f10364g.contains(next)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (z2) {
                MediaRouteDynamicControllerDialog.this.m();
                MediaRouteDynamicControllerDialog.this.k();
                return;
            }
            MediaRouteDynamicControllerDialog.this.l();
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog.this.l();
        }

        public void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            mediaRouteDynamicControllerDialog.f10362e = routeInfo;
            mediaRouteDynamicControllerDialog.f10378u = false;
            mediaRouteDynamicControllerDialog.m();
            MediaRouteDynamicControllerDialog.this.k();
        }

        public void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicControllerDialog.this.l();
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteVolumeSliderHolder mediaRouteVolumeSliderHolder;
            int s2 = routeInfo.s();
            if (MediaRouteDynamicControllerDialog.Q) {
                Log.d("MediaRouteCtrlDialog", "onRouteVolumeChanged(), route.getVolume:" + s2);
            }
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            if (mediaRouteDynamicControllerDialog.f10376s != routeInfo && (mediaRouteVolumeSliderHolder = mediaRouteDynamicControllerDialog.f10375r.get(routeInfo.k())) != null) {
                mediaRouteVolumeSliderHolder.d();
            }
        }
    }

    private final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        private final ArrayList<Item> f10398n = new ArrayList<>();

        /* renamed from: o  reason: collision with root package name */
        private final LayoutInflater f10399o;

        /* renamed from: p  reason: collision with root package name */
        private final Drawable f10400p;

        /* renamed from: q  reason: collision with root package name */
        private final Drawable f10401q;

        /* renamed from: r  reason: collision with root package name */
        private final Drawable f10402r;

        /* renamed from: s  reason: collision with root package name */
        private final Drawable f10403s;

        /* renamed from: t  reason: collision with root package name */
        private Item f10404t;

        /* renamed from: u  reason: collision with root package name */
        private final int f10405u;

        /* renamed from: v  reason: collision with root package name */
        private final Interpolator f10406v;

        private class GroupViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: j  reason: collision with root package name */
            final View f10413j;

            /* renamed from: k  reason: collision with root package name */
            final ImageView f10414k;

            /* renamed from: l  reason: collision with root package name */
            final ProgressBar f10415l;

            /* renamed from: m  reason: collision with root package name */
            final TextView f10416m;

            /* renamed from: n  reason: collision with root package name */
            final float f10417n;

            /* renamed from: o  reason: collision with root package name */
            MediaRouter.RouteInfo f10418o;

            GroupViewHolder(View view) {
                super(view);
                this.f10413j = view;
                this.f10414k = (ImageView) view.findViewById(R$id.mr_cast_group_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_cast_group_progress_bar);
                this.f10415l = progressBar;
                this.f10416m = (TextView) view.findViewById(R$id.mr_cast_group_name);
                this.f10417n = MediaRouterThemeHelper.h(MediaRouteDynamicControllerDialog.this.f10367j);
                MediaRouterThemeHelper.t(MediaRouteDynamicControllerDialog.this.f10367j, progressBar);
            }

            private boolean b(MediaRouter.RouteInfo routeInfo) {
                List<MediaRouter.RouteInfo> l2 = MediaRouteDynamicControllerDialog.this.f10362e.l();
                if (l2.size() == 1 && l2.get(0) == routeInfo) {
                    return false;
                }
                return true;
            }

            /* access modifiers changed from: package-private */
            public void a(Item item) {
                float f2;
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) item.a();
                this.f10418o = routeInfo;
                this.f10414k.setVisibility(0);
                this.f10415l.setVisibility(4);
                boolean b2 = b(routeInfo);
                View view = this.f10413j;
                if (b2) {
                    f2 = 1.0f;
                } else {
                    f2 = this.f10417n;
                }
                view.setAlpha(f2);
                this.f10413j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        GroupViewHolder groupViewHolder = GroupViewHolder.this;
                        MediaRouteDynamicControllerDialog.this.f10359b.y(groupViewHolder.f10418o);
                        GroupViewHolder.this.f10414k.setVisibility(4);
                        GroupViewHolder.this.f10415l.setVisibility(0);
                    }
                });
                this.f10414k.setImageDrawable(RecyclerAdapter.this.e(routeInfo));
                this.f10416m.setText(routeInfo.m());
            }
        }

        private class GroupVolumeViewHolder extends MediaRouteVolumeSliderHolder {

            /* renamed from: n  reason: collision with root package name */
            private final TextView f10421n;

            /* renamed from: o  reason: collision with root package name */
            private final int f10422o;

            GroupVolumeViewHolder(View view) {
                super(view, (ImageButton) view.findViewById(R$id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R$id.mr_cast_volume_slider));
                this.f10421n = (TextView) view.findViewById(R$id.mr_group_volume_route_name);
                Resources resources = MediaRouteDynamicControllerDialog.this.f10367j.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R$dimen.mr_dynamic_volume_group_list_item_height, typedValue, true);
                this.f10422o = (int) typedValue.getDimension(displayMetrics);
            }

            /* access modifiers changed from: package-private */
            public void e(Item item) {
                int i2;
                View view = this.itemView;
                if (RecyclerAdapter.this.g()) {
                    i2 = this.f10422o;
                } else {
                    i2 = 0;
                }
                MediaRouteDynamicControllerDialog.g(view, i2);
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) item.a();
                super.a(routeInfo);
                this.f10421n.setText(routeInfo.m());
            }

            /* access modifiers changed from: package-private */
            public int f() {
                return this.f10422o;
            }
        }

        private class HeaderViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: j  reason: collision with root package name */
            private final TextView f10424j;

            HeaderViewHolder(View view) {
                super(view);
                this.f10424j = (TextView) view.findViewById(R$id.mr_cast_header_name);
            }

            /* access modifiers changed from: package-private */
            public void a(Item item) {
                this.f10424j.setText(item.a().toString());
            }
        }

        private class Item {

            /* renamed from: a  reason: collision with root package name */
            private final Object f10426a;

            /* renamed from: b  reason: collision with root package name */
            private final int f10427b;

            Item(Object obj, int i2) {
                this.f10426a = obj;
                this.f10427b = i2;
            }

            public Object a() {
                return this.f10426a;
            }

            public int b() {
                return this.f10427b;
            }
        }

        private class RouteViewHolder extends MediaRouteVolumeSliderHolder {

            /* renamed from: n  reason: collision with root package name */
            final View f10429n;

            /* renamed from: o  reason: collision with root package name */
            final ImageView f10430o;

            /* renamed from: p  reason: collision with root package name */
            final ProgressBar f10431p;

            /* renamed from: q  reason: collision with root package name */
            final TextView f10432q;

            /* renamed from: r  reason: collision with root package name */
            final RelativeLayout f10433r;

            /* renamed from: s  reason: collision with root package name */
            final CheckBox f10434s;

            /* renamed from: t  reason: collision with root package name */
            final float f10435t;

            /* renamed from: u  reason: collision with root package name */
            final int f10436u;

            /* renamed from: v  reason: collision with root package name */
            final int f10437v;

            /* renamed from: w  reason: collision with root package name */
            final View.OnClickListener f10438w = new View.OnClickListener() {
                public void onClick(View view) {
                    RouteViewHolder routeViewHolder = RouteViewHolder.this;
                    boolean z2 = !routeViewHolder.g(routeViewHolder.f10392j);
                    boolean y2 = RouteViewHolder.this.f10392j.y();
                    if (z2) {
                        RouteViewHolder routeViewHolder2 = RouteViewHolder.this;
                        MediaRouteDynamicControllerDialog.this.f10359b.c(routeViewHolder2.f10392j);
                    } else {
                        RouteViewHolder routeViewHolder3 = RouteViewHolder.this;
                        MediaRouteDynamicControllerDialog.this.f10359b.t(routeViewHolder3.f10392j);
                    }
                    RouteViewHolder.this.h(z2, !y2);
                    if (y2) {
                        List<MediaRouter.RouteInfo> l2 = MediaRouteDynamicControllerDialog.this.f10362e.l();
                        for (MediaRouter.RouteInfo next : RouteViewHolder.this.f10392j.l()) {
                            if (l2.contains(next) != z2) {
                                MediaRouteVolumeSliderHolder mediaRouteVolumeSliderHolder = MediaRouteDynamicControllerDialog.this.f10375r.get(next.k());
                                if (mediaRouteVolumeSliderHolder instanceof RouteViewHolder) {
                                    ((RouteViewHolder) mediaRouteVolumeSliderHolder).h(z2, true);
                                }
                            }
                        }
                    }
                    RouteViewHolder routeViewHolder4 = RouteViewHolder.this;
                    RecyclerAdapter.this.h(routeViewHolder4.f10392j, z2);
                }
            };

            RouteViewHolder(View view) {
                super(view, (ImageButton) view.findViewById(R$id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R$id.mr_cast_volume_slider));
                this.f10429n = view;
                this.f10430o = (ImageView) view.findViewById(R$id.mr_cast_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_cast_route_progress_bar);
                this.f10431p = progressBar;
                this.f10432q = (TextView) view.findViewById(R$id.mr_cast_route_name);
                this.f10433r = (RelativeLayout) view.findViewById(R$id.mr_cast_volume_layout);
                CheckBox checkBox = (CheckBox) view.findViewById(R$id.mr_cast_checkbox);
                this.f10434s = checkBox;
                checkBox.setButtonDrawable(MediaRouterThemeHelper.e(MediaRouteDynamicControllerDialog.this.f10367j));
                MediaRouterThemeHelper.t(MediaRouteDynamicControllerDialog.this.f10367j, progressBar);
                this.f10435t = MediaRouterThemeHelper.h(MediaRouteDynamicControllerDialog.this.f10367j);
                Resources resources = MediaRouteDynamicControllerDialog.this.f10367j.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R$dimen.mr_dynamic_dialog_row_height, typedValue, true);
                this.f10436u = (int) typedValue.getDimension(displayMetrics);
                this.f10437v = 0;
            }

            private boolean f(MediaRouter.RouteInfo routeInfo) {
                if (MediaRouteDynamicControllerDialog.this.f10366i.contains(routeInfo)) {
                    return false;
                }
                if (g(routeInfo) && MediaRouteDynamicControllerDialog.this.f10362e.l().size() < 2) {
                    return false;
                }
                if (!g(routeInfo)) {
                    return true;
                }
                MediaRouter.RouteInfo.DynamicGroupState h2 = MediaRouteDynamicControllerDialog.this.f10362e.h(routeInfo);
                if (h2 == null || !h2.d()) {
                    return false;
                }
                return true;
            }

            /* access modifiers changed from: package-private */
            public void e(Item item) {
                boolean z2;
                int i2;
                float f2;
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) item.a();
                if (routeInfo == MediaRouteDynamicControllerDialog.this.f10362e && routeInfo.l().size() > 0) {
                    Iterator<MediaRouter.RouteInfo> it2 = routeInfo.l().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        MediaRouter.RouteInfo next = it2.next();
                        if (!MediaRouteDynamicControllerDialog.this.f10364g.contains(next)) {
                            routeInfo = next;
                            break;
                        }
                    }
                }
                a(routeInfo);
                this.f10430o.setImageDrawable(RecyclerAdapter.this.e(routeInfo));
                this.f10432q.setText(routeInfo.m());
                boolean z3 = false;
                this.f10434s.setVisibility(0);
                boolean g2 = g(routeInfo);
                boolean f3 = f(routeInfo);
                this.f10434s.setChecked(g2);
                this.f10431p.setVisibility(4);
                this.f10430o.setVisibility(0);
                this.f10429n.setEnabled(f3);
                this.f10434s.setEnabled(f3);
                ImageButton imageButton = this.f10393k;
                if (f3 || g2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                imageButton.setEnabled(z2);
                MediaRouteVolumeSlider mediaRouteVolumeSlider = this.f10394l;
                if (f3 || g2) {
                    z3 = true;
                }
                mediaRouteVolumeSlider.setEnabled(z3);
                this.f10429n.setOnClickListener(this.f10438w);
                this.f10434s.setOnClickListener(this.f10438w);
                RelativeLayout relativeLayout = this.f10433r;
                if (!g2 || this.f10392j.y()) {
                    i2 = this.f10437v;
                } else {
                    i2 = this.f10436u;
                }
                MediaRouteDynamicControllerDialog.g(relativeLayout, i2);
                View view = this.f10429n;
                float f4 = 1.0f;
                if (f3 || g2) {
                    f2 = 1.0f;
                } else {
                    f2 = this.f10435t;
                }
                view.setAlpha(f2);
                CheckBox checkBox = this.f10434s;
                if (!f3 && g2) {
                    f4 = this.f10435t;
                }
                checkBox.setAlpha(f4);
            }

            /* access modifiers changed from: package-private */
            public boolean g(MediaRouter.RouteInfo routeInfo) {
                if (routeInfo.C()) {
                    return true;
                }
                MediaRouter.RouteInfo.DynamicGroupState h2 = MediaRouteDynamicControllerDialog.this.f10362e.h(routeInfo);
                if (h2 == null || h2.a() != 3) {
                    return false;
                }
                return true;
            }

            /* access modifiers changed from: package-private */
            public void h(boolean z2, boolean z3) {
                int i2;
                this.f10434s.setEnabled(false);
                this.f10429n.setEnabled(false);
                this.f10434s.setChecked(z2);
                if (z2) {
                    this.f10430o.setVisibility(4);
                    this.f10431p.setVisibility(0);
                }
                if (z3) {
                    RecyclerAdapter recyclerAdapter = RecyclerAdapter.this;
                    RelativeLayout relativeLayout = this.f10433r;
                    if (z2) {
                        i2 = this.f10436u;
                    } else {
                        i2 = this.f10437v;
                    }
                    recyclerAdapter.c(relativeLayout, i2);
                }
            }
        }

        RecyclerAdapter() {
            this.f10399o = LayoutInflater.from(MediaRouteDynamicControllerDialog.this.f10367j);
            this.f10400p = MediaRouterThemeHelper.g(MediaRouteDynamicControllerDialog.this.f10367j);
            this.f10401q = MediaRouterThemeHelper.q(MediaRouteDynamicControllerDialog.this.f10367j);
            this.f10402r = MediaRouterThemeHelper.m(MediaRouteDynamicControllerDialog.this.f10367j);
            this.f10403s = MediaRouterThemeHelper.n(MediaRouteDynamicControllerDialog.this.f10367j);
            this.f10405u = MediaRouteDynamicControllerDialog.this.f10367j.getResources().getInteger(R$integer.mr_cast_volume_slider_layout_animation_duration_ms);
            this.f10406v = new AccelerateDecelerateInterpolator();
            j();
        }

        private Drawable d(MediaRouter.RouteInfo routeInfo) {
            int f2 = routeInfo.f();
            if (f2 == 1) {
                return this.f10401q;
            }
            if (f2 == 2) {
                return this.f10402r;
            }
            if (routeInfo.y()) {
                return this.f10403s;
            }
            return this.f10400p;
        }

        /* access modifiers changed from: package-private */
        public void c(final View view, final int i2) {
            final int i3 = view.getLayoutParams().height;
            AnonymousClass1 r12 = new Animation() {
                /* access modifiers changed from: protected */
                public void applyTransformation(float f2, Transformation transformation) {
                    int i2 = i2;
                    int i3 = i3;
                    MediaRouteDynamicControllerDialog.g(view, i3 + ((int) (((float) (i2 - i3)) * f2)));
                }
            };
            r12.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
                    mediaRouteDynamicControllerDialog.f10379v = false;
                    mediaRouteDynamicControllerDialog.m();
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    MediaRouteDynamicControllerDialog.this.f10379v = true;
                }
            });
            r12.setDuration((long) this.f10405u);
            r12.setInterpolator(this.f10406v);
            view.startAnimation(r12);
        }

        /* access modifiers changed from: package-private */
        public Drawable e(MediaRouter.RouteInfo routeInfo) {
            Uri j2 = routeInfo.j();
            if (j2 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(MediaRouteDynamicControllerDialog.this.f10367j.getContentResolver().openInputStream(j2), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException e2) {
                    Log.w("MediaRouteCtrlDialog", "Failed to load " + j2, e2);
                }
            }
            return d(routeInfo);
        }

        public Item f(int i2) {
            if (i2 == 0) {
                return this.f10404t;
            }
            return this.f10398n.get(i2 - 1);
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            return mediaRouteDynamicControllerDialog.P && mediaRouteDynamicControllerDialog.f10362e.l().size() > 1;
        }

        public int getItemCount() {
            return this.f10398n.size() + 1;
        }

        public int getItemViewType(int i2) {
            return f(i2).b();
        }

        /* access modifiers changed from: package-private */
        public void h(MediaRouter.RouteInfo routeInfo, boolean z2) {
            int i2;
            List<MediaRouter.RouteInfo> l2 = MediaRouteDynamicControllerDialog.this.f10362e.l();
            boolean z3 = true;
            int max = Math.max(1, l2.size());
            int i3 = -1;
            if (routeInfo.y()) {
                for (MediaRouter.RouteInfo contains : routeInfo.l()) {
                    if (l2.contains(contains) != z2) {
                        if (z2) {
                            i2 = 1;
                        } else {
                            i2 = -1;
                        }
                        max += i2;
                    }
                }
            } else {
                if (z2) {
                    i3 = 1;
                }
                max += i3;
            }
            boolean g2 = g();
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            int i4 = 0;
            if (!mediaRouteDynamicControllerDialog.P || max < 2) {
                z3 = false;
            }
            if (g2 != z3) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = mediaRouteDynamicControllerDialog.f10372o.findViewHolderForAdapterPosition(0);
                if (findViewHolderForAdapterPosition instanceof GroupVolumeViewHolder) {
                    GroupVolumeViewHolder groupVolumeViewHolder = (GroupVolumeViewHolder) findViewHolderForAdapterPosition;
                    View view = groupVolumeViewHolder.itemView;
                    if (z3) {
                        i4 = groupVolumeViewHolder.f();
                    }
                    c(view, i4);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            MediaRouteDynamicControllerDialog.this.f10366i.clear();
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            mediaRouteDynamicControllerDialog.f10366i.addAll(MediaRouteDialogHelper.g(mediaRouteDynamicControllerDialog.f10364g, mediaRouteDynamicControllerDialog.d()));
            notifyDataSetChanged();
        }

        /* access modifiers changed from: package-private */
        public void j() {
            String str;
            String str2;
            this.f10398n.clear();
            this.f10404t = new Item(MediaRouteDynamicControllerDialog.this.f10362e, 1);
            if (!MediaRouteDynamicControllerDialog.this.f10363f.isEmpty()) {
                for (MediaRouter.RouteInfo item : MediaRouteDynamicControllerDialog.this.f10363f) {
                    this.f10398n.add(new Item(item, 3));
                }
            } else {
                this.f10398n.add(new Item(MediaRouteDynamicControllerDialog.this.f10362e, 3));
            }
            boolean z2 = false;
            if (!MediaRouteDynamicControllerDialog.this.f10364g.isEmpty()) {
                boolean z3 = false;
                for (MediaRouter.RouteInfo next : MediaRouteDynamicControllerDialog.this.f10364g) {
                    if (!MediaRouteDynamicControllerDialog.this.f10363f.contains(next)) {
                        if (!z3) {
                            MediaRouteProvider.DynamicGroupRouteController g2 = MediaRouteDynamicControllerDialog.this.f10362e.g();
                            if (g2 != null) {
                                str2 = g2.j();
                            } else {
                                str2 = null;
                            }
                            if (TextUtils.isEmpty(str2)) {
                                str2 = MediaRouteDynamicControllerDialog.this.f10367j.getString(R$string.mr_dialog_groupable_header);
                            }
                            this.f10398n.add(new Item(str2, 2));
                            z3 = true;
                        }
                        this.f10398n.add(new Item(next, 3));
                    }
                }
            }
            if (!MediaRouteDynamicControllerDialog.this.f10365h.isEmpty()) {
                for (MediaRouter.RouteInfo next2 : MediaRouteDynamicControllerDialog.this.f10365h) {
                    MediaRouter.RouteInfo routeInfo = MediaRouteDynamicControllerDialog.this.f10362e;
                    if (routeInfo != next2) {
                        if (!z2) {
                            MediaRouteProvider.DynamicGroupRouteController g3 = routeInfo.g();
                            if (g3 != null) {
                                str = g3.k();
                            } else {
                                str = null;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = MediaRouteDynamicControllerDialog.this.f10367j.getString(R$string.mr_dialog_transferable_header);
                            }
                            this.f10398n.add(new Item(str, 2));
                            z2 = true;
                        }
                        this.f10398n.add(new Item(next2, 4));
                    }
                }
            }
            i();
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            int itemViewType = getItemViewType(i2);
            Item f2 = f(i2);
            if (itemViewType == 1) {
                MediaRouteDynamicControllerDialog.this.f10375r.put(((MediaRouter.RouteInfo) f2.a()).k(), (MediaRouteVolumeSliderHolder) viewHolder);
                ((GroupVolumeViewHolder) viewHolder).e(f2);
            } else if (itemViewType == 2) {
                ((HeaderViewHolder) viewHolder).a(f2);
            } else if (itemViewType == 3) {
                MediaRouteDynamicControllerDialog.this.f10375r.put(((MediaRouter.RouteInfo) f2.a()).k(), (MediaRouteVolumeSliderHolder) viewHolder);
                ((RouteViewHolder) viewHolder).e(f2);
            } else if (itemViewType != 4) {
                Log.w("MediaRouteCtrlDialog", "Cannot bind item to ViewHolder because of wrong view type");
            } else {
                ((GroupViewHolder) viewHolder).a(f2);
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                return new GroupVolumeViewHolder(this.f10399o.inflate(R$layout.mr_cast_group_volume_item, viewGroup, false));
            }
            if (i2 == 2) {
                return new HeaderViewHolder(this.f10399o.inflate(R$layout.mr_cast_header_item, viewGroup, false));
            }
            if (i2 == 3) {
                return new RouteViewHolder(this.f10399o.inflate(R$layout.mr_cast_route_item, viewGroup, false));
            }
            if (i2 == 4) {
                return new GroupViewHolder(this.f10399o.inflate(R$layout.mr_cast_group_item, viewGroup, false));
            }
            Log.w("MediaRouteCtrlDialog", "Cannot create ViewHolder because of wrong view type");
            return null;
        }

        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            super.onViewRecycled(viewHolder);
            MediaRouteDynamicControllerDialog.this.f10375r.values().remove(viewHolder);
        }
    }

    static final class RouteComparator implements Comparator<MediaRouter.RouteInfo> {

        /* renamed from: b  reason: collision with root package name */
        static final RouteComparator f10441b = new RouteComparator();

        RouteComparator() {
        }

        /* renamed from: a */
        public int compare(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2) {
            return routeInfo.m().compareToIgnoreCase(routeInfo2.m());
        }
    }

    private class VolumeChangeListener implements SeekBar.OnSeekBarChangeListener {
        VolumeChangeListener() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            boolean z3;
            if (z2) {
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) seekBar.getTag();
                MediaRouteVolumeSliderHolder mediaRouteVolumeSliderHolder = MediaRouteDynamicControllerDialog.this.f10375r.get(routeInfo.k());
                if (mediaRouteVolumeSliderHolder != null) {
                    if (i2 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    mediaRouteVolumeSliderHolder.c(z3);
                }
                routeInfo.G(i2);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog = MediaRouteDynamicControllerDialog.this;
            if (mediaRouteDynamicControllerDialog.f10376s != null) {
                mediaRouteDynamicControllerDialog.f10371n.removeMessages(2);
            }
            MediaRouteDynamicControllerDialog.this.f10376s = (MediaRouter.RouteInfo) seekBar.getTag();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaRouteDynamicControllerDialog.this.f10371n.sendEmptyMessageDelayed(2, 500);
        }
    }

    public MediaRouteDynamicControllerDialog(Context context) {
        this(context, 0);
    }

    private static Bitmap b(Bitmap bitmap, float f2, Context context) {
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setRadius(f2);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        createTyped.copyTo(copy);
        createFromBitmap.destroy();
        createTyped.destroy();
        create2.destroy();
        create.destroy();
        return copy;
    }

    static boolean e(Bitmap bitmap) {
        return bitmap != null && bitmap.isRecycled();
    }

    static void g(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    private void h(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.G;
        MediaDescriptionCompat mediaDescriptionCompat = null;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.H);
            this.G = null;
        }
        if (token != null && this.f10369l) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f10367j, token);
            this.G = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(this.H);
            MediaMetadataCompat metadata = this.G.getMetadata();
            if (metadata != null) {
                mediaDescriptionCompat = metadata.getDescription();
            }
            this.I = mediaDescriptionCompat;
            f();
            j();
        }
    }

    private boolean i() {
        if (this.f10376s != null || this.f10378u || this.f10379v) {
            return true;
        }
        return !this.f10368k;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.M = false;
        this.N = null;
        this.O = 0;
    }

    /* access modifiers changed from: package-private */
    public List<MediaRouter.RouteInfo> d() {
        ArrayList arrayList = new ArrayList();
        for (MediaRouter.RouteInfo next : this.f10362e.q().f()) {
            MediaRouter.RouteInfo.DynamicGroupState h2 = this.f10362e.h(next);
            if (h2 != null && h2.b()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.I;
        Uri uri2 = null;
        if (mediaDescriptionCompat == null) {
            bitmap = null;
        } else {
            bitmap = mediaDescriptionCompat.getIconBitmap();
        }
        MediaDescriptionCompat mediaDescriptionCompat2 = this.I;
        if (mediaDescriptionCompat2 != null) {
            uri2 = mediaDescriptionCompat2.getIconUri();
        }
        FetchArtTask fetchArtTask = this.J;
        if (fetchArtTask == null) {
            bitmap2 = this.K;
        } else {
            bitmap2 = fetchArtTask.b();
        }
        FetchArtTask fetchArtTask2 = this.J;
        if (fetchArtTask2 == null) {
            uri = this.L;
        } else {
            uri = fetchArtTask2.c();
        }
        if (bitmap2 != bitmap || (bitmap2 == null && !ObjectsCompat.a(uri, uri2))) {
            FetchArtTask fetchArtTask3 = this.J;
            if (fetchArtTask3 != null) {
                fetchArtTask3.cancel(true);
            }
            FetchArtTask fetchArtTask4 = new FetchArtTask();
            this.J = fetchArtTask4;
            fetchArtTask4.execute(new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        CharSequence charSequence;
        if (i()) {
            this.f10381x = true;
            return;
        }
        this.f10381x = false;
        if (!this.f10362e.C() || this.f10362e.w()) {
            dismiss();
        }
        CharSequence charSequence2 = null;
        if (!this.M || e(this.N) || this.N == null) {
            if (e(this.N)) {
                Log.w("MediaRouteCtrlDialog", "Can't set artwork image with recycled bitmap: " + this.N);
            }
            this.C.setVisibility(8);
            this.B.setVisibility(8);
            this.A.setImageBitmap((Bitmap) null);
        } else {
            this.C.setVisibility(0);
            this.C.setImageBitmap(this.N);
            this.C.setBackgroundColor(this.O);
            this.B.setVisibility(0);
            this.A.setImageBitmap(b(this.N, 10.0f, this.f10367j));
        }
        c();
        MediaDescriptionCompat mediaDescriptionCompat = this.I;
        if (mediaDescriptionCompat == null) {
            charSequence = null;
        } else {
            charSequence = mediaDescriptionCompat.getTitle();
        }
        boolean z2 = !TextUtils.isEmpty(charSequence);
        MediaDescriptionCompat mediaDescriptionCompat2 = this.I;
        if (mediaDescriptionCompat2 != null) {
            charSequence2 = mediaDescriptionCompat2.getSubtitle();
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(charSequence2);
        if (z2) {
            this.D.setText(charSequence);
        } else {
            this.D.setText(this.F);
        }
        if (isEmpty) {
            this.E.setText(charSequence2);
            this.E.setVisibility(0);
            return;
        }
        this.E.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f10363f.clear();
        this.f10364g.clear();
        this.f10365h.clear();
        this.f10363f.addAll(this.f10362e.l());
        for (MediaRouter.RouteInfo next : this.f10362e.q().f()) {
            MediaRouter.RouteInfo.DynamicGroupState h2 = this.f10362e.h(next);
            if (h2 != null) {
                if (h2.b()) {
                    this.f10364g.add(next);
                }
                if (h2.c()) {
                    this.f10365h.add(next);
                }
            }
        }
        onFilterRoutes(this.f10364g);
        onFilterRoutes(this.f10365h);
        List<MediaRouter.RouteInfo> list = this.f10363f;
        RouteComparator routeComparator = RouteComparator.f10441b;
        Collections.sort(list, routeComparator);
        Collections.sort(this.f10364g, routeComparator);
        Collections.sort(this.f10365h, routeComparator);
        this.f10373p.j();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (!this.f10369l) {
            return;
        }
        if (SystemClock.uptimeMillis() - this.f10370m < 300) {
            this.f10371n.removeMessages(1);
            this.f10371n.sendEmptyMessageAtTime(1, this.f10370m + 300);
        } else if (i()) {
            this.f10380w = true;
        } else {
            this.f10380w = false;
            if (!this.f10362e.C() || this.f10362e.w()) {
                dismiss();
            }
            this.f10370m = SystemClock.uptimeMillis();
            this.f10373p.i();
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (this.f10380w) {
            l();
        }
        if (this.f10381x) {
            j();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10369l = true;
        this.f10359b.b(this.f10361d, this.f10360c, 1);
        k();
        h(this.f10359b.k());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_cast_dialog);
        MediaRouterThemeHelper.s(this.f10367j, this);
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_cast_close_button);
        this.f10382y = imageButton;
        imageButton.setColorFilter(-1);
        this.f10382y.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaRouteDynamicControllerDialog.this.dismiss();
            }
        });
        Button button = (Button) findViewById(R$id.mr_cast_stop_button);
        this.f10383z = button;
        button.setTextColor(-1);
        this.f10383z.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaRouteDynamicControllerDialog.this.f10362e.C()) {
                    MediaRouteDynamicControllerDialog.this.f10359b.z(2);
                }
                MediaRouteDynamicControllerDialog.this.dismiss();
            }
        });
        this.f10373p = new RecyclerAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.mr_cast_list);
        this.f10372o = recyclerView;
        recyclerView.setAdapter(this.f10373p);
        this.f10372o.setLayoutManager(new LinearLayoutManager(this.f10367j));
        this.f10374q = new VolumeChangeListener();
        this.f10375r = new HashMap();
        this.f10377t = new HashMap();
        this.A = (ImageView) findViewById(R$id.mr_cast_meta_background);
        this.B = findViewById(R$id.mr_cast_meta_black_scrim);
        this.C = (ImageView) findViewById(R$id.mr_cast_meta_art);
        TextView textView = (TextView) findViewById(R$id.mr_cast_meta_title);
        this.D = textView;
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById(R$id.mr_cast_meta_subtitle);
        this.E = textView2;
        textView2.setTextColor(-1);
        this.F = this.f10367j.getResources().getString(R$string.mr_cast_dialog_title_view_placeholder);
        this.f10368k = true;
        updateLayout();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10369l = false;
        this.f10359b.s(this.f10360c);
        this.f10371n.removeCallbacksAndMessages((Object) null);
        h((MediaSessionCompat.Token) null);
    }

    public boolean onFilterRoute(MediaRouter.RouteInfo routeInfo) {
        if (routeInfo.w() || !routeInfo.x() || !routeInfo.E(this.f10361d) || this.f10362e == routeInfo) {
            return false;
        }
        return true;
    }

    public void onFilterRoutes(List<MediaRouter.RouteInfo> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (!onFilterRoute(list.get(size))) {
                list.remove(size);
            }
        }
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f10361d.equals(mediaRouteSelector)) {
            this.f10361d = mediaRouteSelector;
            if (this.f10369l) {
                this.f10359b.s(this.f10360c);
                this.f10359b.b(mediaRouteSelector, this.f10360c, 1);
                k();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLayout() {
        getWindow().setLayout(MediaRouteDialogHelper.c(this.f10367j), MediaRouteDialogHelper.a(this.f10367j));
        this.K = null;
        this.L = null;
        f();
        j();
        l();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaRouteDynamicControllerDialog(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.MediaRouterThemeHelper.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.MediaRouterThemeHelper.c(r2)
            r1.<init>(r2, r3)
            androidx.mediarouter.media.MediaRouteSelector r2 = androidx.mediarouter.media.MediaRouteSelector.f10544c
            r1.f10361d = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f10363f = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f10364g = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f10365h = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f10366i = r2
            androidx.mediarouter.app.MediaRouteDynamicControllerDialog$1 r2 = new androidx.mediarouter.app.MediaRouteDynamicControllerDialog$1
            r2.<init>()
            r1.f10371n = r2
            android.content.Context r2 = r1.getContext()
            r1.f10367j = r2
            androidx.mediarouter.media.MediaRouter r2 = androidx.mediarouter.media.MediaRouter.j(r2)
            r1.f10359b = r2
            boolean r3 = androidx.mediarouter.media.MediaRouter.o()
            r1.P = r3
            androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaRouterCallback r3 = new androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaRouterCallback
            r3.<init>()
            r1.f10360c = r3
            androidx.mediarouter.media.MediaRouter$RouteInfo r3 = r2.n()
            r1.f10362e = r3
            androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaControllerCallback r3 = new androidx.mediarouter.app.MediaRouteDynamicControllerDialog$MediaControllerCallback
            r3.<init>()
            r1.H = r3
            android.support.v4.media.session.MediaSessionCompat$Token r2 = r2.k()
            r1.h(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteDynamicControllerDialog.<init>(android.content.Context, int):void");
    }
}
