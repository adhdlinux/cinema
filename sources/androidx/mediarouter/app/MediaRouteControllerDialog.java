package androidx.mediarouter.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.util.ObjectsCompat;
import androidx.mediarouter.R$dimen;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$integer;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.mediarouter.app.OverlayListView;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.Http2;

public class MediaRouteControllerDialog extends AlertDialog {

    /* renamed from: p0  reason: collision with root package name */
    static final boolean f10247p0 = Log.isLoggable("MediaRouteCtrlDialog", 3);

    /* renamed from: q0  reason: collision with root package name */
    static final int f10248q0 = ((int) TimeUnit.SECONDS.toMillis(30));
    private RelativeLayout A;
    LinearLayout B;
    private View C;
    OverlayListView D;
    VolumeGroupAdapter E;
    private List<MediaRouter.RouteInfo> F;
    Set<MediaRouter.RouteInfo> G;
    private Set<MediaRouter.RouteInfo> H;
    Set<MediaRouter.RouteInfo> I;
    SeekBar J;
    VolumeChangeListener K;
    MediaRouter.RouteInfo L;
    private int M;
    private int N;
    private int O;
    private final int P;
    Map<MediaRouter.RouteInfo, SeekBar> Q;
    MediaControllerCompat R;
    MediaControllerCallback S;
    PlaybackStateCompat T;
    MediaDescriptionCompat U;
    FetchArtTask V;
    Bitmap W;
    Uri X;
    boolean Y;
    Bitmap Z;

    /* renamed from: a0  reason: collision with root package name */
    int f10249a0;

    /* renamed from: b0  reason: collision with root package name */
    boolean f10250b0;

    /* renamed from: c  reason: collision with root package name */
    final MediaRouter f10251c;

    /* renamed from: c0  reason: collision with root package name */
    boolean f10252c0;

    /* renamed from: d  reason: collision with root package name */
    private final MediaRouterCallback f10253d;

    /* renamed from: d0  reason: collision with root package name */
    boolean f10254d0;

    /* renamed from: e  reason: collision with root package name */
    final MediaRouter.RouteInfo f10255e;

    /* renamed from: e0  reason: collision with root package name */
    boolean f10256e0;

    /* renamed from: f  reason: collision with root package name */
    Context f10257f;

    /* renamed from: f0  reason: collision with root package name */
    boolean f10258f0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10259g;

    /* renamed from: g0  reason: collision with root package name */
    int f10260g0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10261h;

    /* renamed from: h0  reason: collision with root package name */
    private int f10262h0;

    /* renamed from: i  reason: collision with root package name */
    private int f10263i;

    /* renamed from: i0  reason: collision with root package name */
    private int f10264i0;

    /* renamed from: j  reason: collision with root package name */
    private View f10265j;

    /* renamed from: j0  reason: collision with root package name */
    private Interpolator f10266j0;

    /* renamed from: k  reason: collision with root package name */
    private Button f10267k;

    /* renamed from: k0  reason: collision with root package name */
    private Interpolator f10268k0;

    /* renamed from: l  reason: collision with root package name */
    private Button f10269l;

    /* renamed from: l0  reason: collision with root package name */
    private Interpolator f10270l0;

    /* renamed from: m  reason: collision with root package name */
    private ImageButton f10271m;

    /* renamed from: m0  reason: collision with root package name */
    private Interpolator f10272m0;

    /* renamed from: n  reason: collision with root package name */
    private ImageButton f10273n;

    /* renamed from: n0  reason: collision with root package name */
    final AccessibilityManager f10274n0;

    /* renamed from: o  reason: collision with root package name */
    private MediaRouteExpandCollapseButton f10275o;

    /* renamed from: o0  reason: collision with root package name */
    Runnable f10276o0;

    /* renamed from: p  reason: collision with root package name */
    private FrameLayout f10277p;

    /* renamed from: q  reason: collision with root package name */
    private LinearLayout f10278q;

    /* renamed from: r  reason: collision with root package name */
    FrameLayout f10279r;

    /* renamed from: s  reason: collision with root package name */
    private FrameLayout f10280s;

    /* renamed from: t  reason: collision with root package name */
    private ImageView f10281t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f10282u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f10283v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f10284w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f10285x;

    /* renamed from: y  reason: collision with root package name */
    final boolean f10286y;

    /* renamed from: z  reason: collision with root package name */
    private LinearLayout f10287z;

    private final class ClickListener implements View.OnClickListener {
        ClickListener() {
        }

        public void onClick(View view) {
            PlaybackStateCompat playbackStateCompat;
            int id = view.getId();
            int i2 = 1;
            if (id == 16908313 || id == 16908314) {
                if (MediaRouteControllerDialog.this.f10255e.C()) {
                    MediaRouter mediaRouter = MediaRouteControllerDialog.this.f10251c;
                    if (id == 16908313) {
                        i2 = 2;
                    }
                    mediaRouter.z(i2);
                }
                MediaRouteControllerDialog.this.dismiss();
            } else if (id == R$id.mr_control_playback_ctrl) {
                MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
                if (mediaRouteControllerDialog.R != null && (playbackStateCompat = mediaRouteControllerDialog.T) != null) {
                    int i3 = 0;
                    if (playbackStateCompat.getState() != 3) {
                        i2 = 0;
                    }
                    if (i2 != 0 && MediaRouteControllerDialog.this.u()) {
                        MediaRouteControllerDialog.this.R.getTransportControls().pause();
                        i3 = R$string.mr_controller_pause;
                    } else if (i2 != 0 && MediaRouteControllerDialog.this.w()) {
                        MediaRouteControllerDialog.this.R.getTransportControls().stop();
                        i3 = R$string.mr_controller_stop;
                    } else if (i2 == 0 && MediaRouteControllerDialog.this.v()) {
                        MediaRouteControllerDialog.this.R.getTransportControls().play();
                        i3 = R$string.mr_controller_play;
                    }
                    AccessibilityManager accessibilityManager = MediaRouteControllerDialog.this.f10274n0;
                    if (accessibilityManager != null && accessibilityManager.isEnabled() && i3 != 0) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain(Http2.INITIAL_MAX_FRAME_SIZE);
                        obtain.setPackageName(MediaRouteControllerDialog.this.f10257f.getPackageName());
                        obtain.setClassName(ClickListener.class.getName());
                        obtain.getText().add(MediaRouteControllerDialog.this.f10257f.getString(i3));
                        MediaRouteControllerDialog.this.f10274n0.sendAccessibilityEvent(obtain);
                    }
                }
            } else if (id == R$id.mr_close) {
                MediaRouteControllerDialog.this.dismiss();
            }
        }
    }

    private class FetchArtTask extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f10308a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f10309b;

        /* renamed from: c  reason: collision with root package name */
        private int f10310c;

        /* renamed from: d  reason: collision with root package name */
        private long f10311d;

        FetchArtTask() {
            Bitmap bitmap;
            MediaDescriptionCompat mediaDescriptionCompat = MediaRouteControllerDialog.this.U;
            Uri uri = null;
            if (mediaDescriptionCompat == null) {
                bitmap = null;
            } else {
                bitmap = mediaDescriptionCompat.getIconBitmap();
            }
            if (MediaRouteControllerDialog.r(bitmap)) {
                Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
                bitmap = null;
            }
            this.f10308a = bitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = MediaRouteControllerDialog.this.U;
            this.f10309b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : uri;
        }

        private InputStream e(Uri uri) throws IOException {
            InputStream inputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                inputStream = MediaRouteControllerDialog.this.f10257f.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                int i2 = MediaRouteControllerDialog.f10248q0;
                openConnection.setConnectTimeout(i2);
                openConnection.setReadTimeout(i2);
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
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ IOException -> 0x009f }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00bb A[SYNTHETIC, Splitter:B:54:0x00bb] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00c5 A[SYNTHETIC, Splitter:B:60:0x00c5] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00e5 A[ADDED_TO_REGION] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r10) {
            /*
                r9 = this;
                java.lang.String r10 = "Unable to open: "
                android.graphics.Bitmap r0 = r9.f10308a
                r1 = 0
                r2 = 1
                java.lang.String r3 = "MediaRouteCtrlDialog"
                r4 = 0
                if (r0 == 0) goto L_0x000d
                goto L_0x00ca
            L_0x000d:
                android.net.Uri r0 = r9.f10309b
                if (r0 == 0) goto L_0x00c9
                java.io.InputStream r0 = r9.e(r0)     // Catch:{ IOException -> 0x00a3, all -> 0x00a1 }
                if (r0 != 0) goto L_0x0031
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009f }
                r5.<init>()     // Catch:{ IOException -> 0x009f }
                r5.append(r10)     // Catch:{ IOException -> 0x009f }
                android.net.Uri r6 = r9.f10309b     // Catch:{ IOException -> 0x009f }
                r5.append(r6)     // Catch:{ IOException -> 0x009f }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x009f }
                android.util.Log.w(r3, r5)     // Catch:{ IOException -> 0x009f }
                if (r0 == 0) goto L_0x0030
                r0.close()     // Catch:{ IOException -> 0x0030 }
            L_0x0030:
                return r4
            L_0x0031:
                android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x009f }
                r5.<init>()     // Catch:{ IOException -> 0x009f }
                r5.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x009f }
                android.graphics.BitmapFactory.decodeStream(r0, r4, r5)     // Catch:{ IOException -> 0x009f }
                int r6 = r5.outWidth     // Catch:{ IOException -> 0x009f }
                if (r6 == 0) goto L_0x009b
                int r6 = r5.outHeight     // Catch:{ IOException -> 0x009f }
                if (r6 != 0) goto L_0x0044
                goto L_0x009b
            L_0x0044:
                r0.reset()     // Catch:{ IOException -> 0x0048 }
                goto L_0x006d
            L_0x0048:
                r0.close()     // Catch:{ IOException -> 0x009f }
                android.net.Uri r6 = r9.f10309b     // Catch:{ IOException -> 0x009f }
                java.io.InputStream r0 = r9.e(r6)     // Catch:{ IOException -> 0x009f }
                if (r0 != 0) goto L_0x006d
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009f }
                r5.<init>()     // Catch:{ IOException -> 0x009f }
                r5.append(r10)     // Catch:{ IOException -> 0x009f }
                android.net.Uri r6 = r9.f10309b     // Catch:{ IOException -> 0x009f }
                r5.append(r6)     // Catch:{ IOException -> 0x009f }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x009f }
                android.util.Log.w(r3, r5)     // Catch:{ IOException -> 0x009f }
                if (r0 == 0) goto L_0x006c
                r0.close()     // Catch:{ IOException -> 0x006c }
            L_0x006c:
                return r4
            L_0x006d:
                r5.inJustDecodeBounds = r1     // Catch:{ IOException -> 0x009f }
                androidx.mediarouter.app.MediaRouteControllerDialog r6 = androidx.mediarouter.app.MediaRouteControllerDialog.this     // Catch:{ IOException -> 0x009f }
                int r7 = r5.outWidth     // Catch:{ IOException -> 0x009f }
                int r8 = r5.outHeight     // Catch:{ IOException -> 0x009f }
                int r6 = r6.o(r7, r8)     // Catch:{ IOException -> 0x009f }
                int r7 = r5.outHeight     // Catch:{ IOException -> 0x009f }
                int r7 = r7 / r6
                int r6 = java.lang.Integer.highestOneBit(r7)     // Catch:{ IOException -> 0x009f }
                int r6 = java.lang.Math.max(r2, r6)     // Catch:{ IOException -> 0x009f }
                r5.inSampleSize = r6     // Catch:{ IOException -> 0x009f }
                boolean r6 = r9.isCancelled()     // Catch:{ IOException -> 0x009f }
                if (r6 == 0) goto L_0x0090
                r0.close()     // Catch:{ IOException -> 0x008f }
            L_0x008f:
                return r4
            L_0x0090:
                android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r0, r4, r5)     // Catch:{ IOException -> 0x009f }
                r0.close()     // Catch:{ IOException -> 0x0098 }
                goto L_0x0099
            L_0x0098:
            L_0x0099:
                r0 = r10
                goto L_0x00ca
            L_0x009b:
                r0.close()     // Catch:{ IOException -> 0x009e }
            L_0x009e:
                return r4
            L_0x009f:
                r5 = move-exception
                goto L_0x00a5
            L_0x00a1:
                r10 = move-exception
                goto L_0x00c3
            L_0x00a3:
                r5 = move-exception
                r0 = r4
            L_0x00a5:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
                r6.<init>()     // Catch:{ all -> 0x00c1 }
                r6.append(r10)     // Catch:{ all -> 0x00c1 }
                android.net.Uri r10 = r9.f10309b     // Catch:{ all -> 0x00c1 }
                r6.append(r10)     // Catch:{ all -> 0x00c1 }
                java.lang.String r10 = r6.toString()     // Catch:{ all -> 0x00c1 }
                android.util.Log.w(r3, r10, r5)     // Catch:{ all -> 0x00c1 }
                if (r0 == 0) goto L_0x00c9
                r0.close()     // Catch:{ IOException -> 0x00bf }
                goto L_0x00c9
            L_0x00bf:
                goto L_0x00c9
            L_0x00c1:
                r10 = move-exception
                r4 = r0
            L_0x00c3:
                if (r4 == 0) goto L_0x00c8
                r4.close()     // Catch:{ IOException -> 0x00c8 }
            L_0x00c8:
                throw r10
            L_0x00c9:
                r0 = r4
            L_0x00ca:
                boolean r10 = androidx.mediarouter.app.MediaRouteControllerDialog.r(r0)
                if (r10 == 0) goto L_0x00e5
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r1 = "Can't use recycled bitmap: "
                r10.append(r1)
                r10.append(r0)
                java.lang.String r10 = r10.toString()
                android.util.Log.w(r3, r10)
                return r4
            L_0x00e5:
                if (r0 == 0) goto L_0x0119
                int r10 = r0.getWidth()
                int r3 = r0.getHeight()
                if (r10 >= r3) goto L_0x0119
                androidx.palette.graphics.Palette$Builder r10 = new androidx.palette.graphics.Palette$Builder
                r10.<init>(r0)
                androidx.palette.graphics.Palette$Builder r10 = r10.d(r2)
                androidx.palette.graphics.Palette r10 = r10.b()
                java.util.List r2 = r10.n()
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0109
                goto L_0x0117
            L_0x0109:
                java.util.List r10 = r10.n()
                java.lang.Object r10 = r10.get(r1)
                androidx.palette.graphics.Palette$Swatch r10 = (androidx.palette.graphics.Palette.Swatch) r10
                int r1 = r10.e()
            L_0x0117:
                r9.f10310c = r1
            L_0x0119:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteControllerDialog.FetchArtTask.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        public Bitmap b() {
            return this.f10308a;
        }

        public Uri c() {
            return this.f10309b;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void onPostExecute(Bitmap bitmap) {
            MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
            mediaRouteControllerDialog.V = null;
            if (!ObjectsCompat.a(mediaRouteControllerDialog.W, this.f10308a) || !ObjectsCompat.a(MediaRouteControllerDialog.this.X, this.f10309b)) {
                MediaRouteControllerDialog mediaRouteControllerDialog2 = MediaRouteControllerDialog.this;
                mediaRouteControllerDialog2.W = this.f10308a;
                mediaRouteControllerDialog2.Z = bitmap;
                mediaRouteControllerDialog2.X = this.f10309b;
                mediaRouteControllerDialog2.f10249a0 = this.f10310c;
                boolean z2 = true;
                mediaRouteControllerDialog2.Y = true;
                long uptimeMillis = SystemClock.uptimeMillis() - this.f10311d;
                MediaRouteControllerDialog mediaRouteControllerDialog3 = MediaRouteControllerDialog.this;
                if (uptimeMillis <= 120) {
                    z2 = false;
                }
                mediaRouteControllerDialog3.F(z2);
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.f10311d = SystemClock.uptimeMillis();
            MediaRouteControllerDialog.this.l();
        }
    }

    private final class MediaControllerCallback extends MediaControllerCompat.Callback {
        MediaControllerCallback() {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaDescriptionCompat mediaDescriptionCompat;
            MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
            if (mediaMetadataCompat == null) {
                mediaDescriptionCompat = null;
            } else {
                mediaDescriptionCompat = mediaMetadataCompat.getDescription();
            }
            mediaRouteControllerDialog.U = mediaDescriptionCompat;
            MediaRouteControllerDialog.this.G();
            MediaRouteControllerDialog.this.F(false);
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
            mediaRouteControllerDialog.T = playbackStateCompat;
            mediaRouteControllerDialog.F(false);
        }

        public void onSessionDestroyed() {
            MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
            MediaControllerCompat mediaControllerCompat = mediaRouteControllerDialog.R;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.unregisterCallback(mediaRouteControllerDialog.S);
                MediaRouteControllerDialog.this.R = null;
            }
        }
    }

    private final class MediaRouterCallback extends MediaRouter.Callback {
        MediaRouterCallback() {
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteControllerDialog.this.F(true);
        }

        public void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteControllerDialog.this.F(false);
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            SeekBar seekBar = MediaRouteControllerDialog.this.Q.get(routeInfo);
            int s2 = routeInfo.s();
            if (MediaRouteControllerDialog.f10247p0) {
                Log.d("MediaRouteCtrlDialog", "onRouteVolumeChanged(), route.getVolume:" + s2);
            }
            if (seekBar != null && MediaRouteControllerDialog.this.L != routeInfo) {
                seekBar.setProgress(s2);
            }
        }
    }

    private class VolumeChangeListener implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f10315a = new Runnable() {
            public void run() {
                MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
                if (mediaRouteControllerDialog.L != null) {
                    mediaRouteControllerDialog.L = null;
                    if (mediaRouteControllerDialog.f10250b0) {
                        mediaRouteControllerDialog.F(mediaRouteControllerDialog.f10252c0);
                    }
                }
            }
        };

        VolumeChangeListener() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            if (z2) {
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) seekBar.getTag();
                if (MediaRouteControllerDialog.f10247p0) {
                    Log.d("MediaRouteCtrlDialog", "onProgressChanged(): calling MediaRouter.RouteInfo.requestSetVolume(" + i2 + ")");
                }
                routeInfo.G(i2);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
            if (mediaRouteControllerDialog.L != null) {
                mediaRouteControllerDialog.J.removeCallbacks(this.f10315a);
            }
            MediaRouteControllerDialog.this.L = (MediaRouter.RouteInfo) seekBar.getTag();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaRouteControllerDialog.this.J.postDelayed(this.f10315a, 500);
        }
    }

    private class VolumeGroupAdapter extends ArrayAdapter<MediaRouter.RouteInfo> {

        /* renamed from: b  reason: collision with root package name */
        final float f10318b;

        public VolumeGroupAdapter(Context context, List<MediaRouter.RouteInfo> list) {
            super(context, 0, list);
            this.f10318b = MediaRouterThemeHelper.h(context);
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            int i3;
            int i4 = 0;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mr_controller_volume_item, viewGroup, false);
            } else {
                MediaRouteControllerDialog.this.M(view);
            }
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) getItem(i2);
            if (routeInfo != null) {
                boolean x2 = routeInfo.x();
                TextView textView = (TextView) view.findViewById(R$id.mr_name);
                textView.setEnabled(x2);
                textView.setText(routeInfo.m());
                MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) view.findViewById(R$id.mr_volume_slider);
                MediaRouterThemeHelper.w(viewGroup.getContext(), mediaRouteVolumeSlider, MediaRouteControllerDialog.this.D);
                mediaRouteVolumeSlider.setTag(routeInfo);
                MediaRouteControllerDialog.this.Q.put(routeInfo, mediaRouteVolumeSlider);
                mediaRouteVolumeSlider.c(!x2);
                mediaRouteVolumeSlider.setEnabled(x2);
                if (x2) {
                    if (MediaRouteControllerDialog.this.x(routeInfo)) {
                        mediaRouteVolumeSlider.setMax(routeInfo.u());
                        mediaRouteVolumeSlider.setProgress(routeInfo.s());
                        mediaRouteVolumeSlider.setOnSeekBarChangeListener(MediaRouteControllerDialog.this.K);
                    } else {
                        mediaRouteVolumeSlider.setMax(100);
                        mediaRouteVolumeSlider.setProgress(100);
                        mediaRouteVolumeSlider.setEnabled(false);
                    }
                }
                ImageView imageView = (ImageView) view.findViewById(R$id.mr_volume_item_icon);
                if (x2) {
                    i3 = JfifUtil.MARKER_FIRST_BYTE;
                } else {
                    i3 = (int) (this.f10318b * 255.0f);
                }
                imageView.setAlpha(i3);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.volume_item_container);
                if (MediaRouteControllerDialog.this.I.contains(routeInfo)) {
                    i4 = 4;
                }
                linearLayout.setVisibility(i4);
                Set<MediaRouter.RouteInfo> set = MediaRouteControllerDialog.this.G;
                if (set != null && set.contains(routeInfo)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnimation.setDuration(0);
                    alphaAnimation.setFillEnabled(true);
                    alphaAnimation.setFillAfter(true);
                    view.clearAnimation();
                    view.startAnimation(alphaAnimation);
                }
            }
            return view;
        }

        public boolean isEnabled(int i2) {
            return false;
        }
    }

    public MediaRouteControllerDialog(Context context) {
        this(context, 0);
    }

    private void A(boolean z2) {
        HashMap hashMap;
        HashMap hashMap2;
        List<MediaRouter.RouteInfo> l2 = this.f10255e.l();
        if (l2.isEmpty()) {
            this.F.clear();
            this.E.notifyDataSetChanged();
        } else if (MediaRouteDialogHelper.i(this.F, l2)) {
            this.E.notifyDataSetChanged();
        } else {
            if (z2) {
                hashMap = MediaRouteDialogHelper.e(this.D, this.E);
            } else {
                hashMap = null;
            }
            if (z2) {
                hashMap2 = MediaRouteDialogHelper.d(this.f10257f, this.D, this.E);
            } else {
                hashMap2 = null;
            }
            this.G = MediaRouteDialogHelper.f(this.F, l2);
            this.H = MediaRouteDialogHelper.g(this.F, l2);
            this.F.addAll(0, this.G);
            this.F.removeAll(this.H);
            this.E.notifyDataSetChanged();
            if (!z2 || !this.f10254d0 || this.G.size() + this.H.size() <= 0) {
                this.G = null;
                this.H = null;
                return;
            }
            g(hashMap, hashMap2);
        }
    }

    static void B(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    private void C(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.R;
        MediaDescriptionCompat mediaDescriptionCompat = null;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.S);
            this.R = null;
        }
        if (token != null && this.f10261h) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f10257f, token);
            this.R = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(this.S);
            MediaMetadataCompat metadata = this.R.getMetadata();
            if (metadata != null) {
                mediaDescriptionCompat = metadata.getDescription();
            }
            this.U = mediaDescriptionCompat;
            this.T = this.R.getPlaybackState();
            G();
            F(false);
        }
    }

    private void J(boolean z2) {
        int i2;
        View view = this.C;
        int i3 = 0;
        if (this.B.getVisibility() != 0 || !z2) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        LinearLayout linearLayout = this.f10287z;
        if (this.B.getVisibility() == 8 && !z2) {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void K() {
        /*
            r8 = this;
            boolean r0 = r8.j()
            if (r0 == 0) goto L_0x00ed
            android.support.v4.media.MediaDescriptionCompat r0 = r8.U
            r1 = 0
            if (r0 != 0) goto L_0x000d
            r0 = r1
            goto L_0x0011
        L_0x000d:
            java.lang.CharSequence r0 = r0.getTitle()
        L_0x0011:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 1
            r2 = r2 ^ r3
            android.support.v4.media.MediaDescriptionCompat r4 = r8.U
            if (r4 != 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            java.lang.CharSequence r1 = r4.getSubtitle()
        L_0x0020:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            r4 = r4 ^ r3
            androidx.mediarouter.media.MediaRouter$RouteInfo r5 = r8.f10255e
            int r5 = r5.p()
            r6 = -1
            r7 = 0
            if (r5 == r6) goto L_0x0039
            android.widget.TextView r0 = r8.f10282u
            int r1 = androidx.mediarouter.R$string.mr_controller_casting_screen
            r0.setText(r1)
        L_0x0036:
            r0 = 1
        L_0x0037:
            r1 = 0
            goto L_0x006b
        L_0x0039:
            android.support.v4.media.session.PlaybackStateCompat r5 = r8.T
            if (r5 == 0) goto L_0x0063
            int r5 = r5.getState()
            if (r5 != 0) goto L_0x0044
            goto L_0x0063
        L_0x0044:
            if (r2 != 0) goto L_0x0050
            if (r4 != 0) goto L_0x0050
            android.widget.TextView r0 = r8.f10282u
            int r1 = androidx.mediarouter.R$string.mr_controller_no_info_available
            r0.setText(r1)
            goto L_0x0036
        L_0x0050:
            if (r2 == 0) goto L_0x0059
            android.widget.TextView r2 = r8.f10282u
            r2.setText(r0)
            r0 = 1
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r4 == 0) goto L_0x0037
            android.widget.TextView r2 = r8.f10283v
            r2.setText(r1)
            r1 = 1
            goto L_0x006b
        L_0x0063:
            android.widget.TextView r0 = r8.f10282u
            int r1 = androidx.mediarouter.R$string.mr_controller_no_media_selected
            r0.setText(r1)
            goto L_0x0036
        L_0x006b:
            android.widget.TextView r2 = r8.f10282u
            r4 = 8
            if (r0 == 0) goto L_0x0073
            r0 = 0
            goto L_0x0075
        L_0x0073:
            r0 = 8
        L_0x0075:
            r2.setVisibility(r0)
            android.widget.TextView r0 = r8.f10283v
            if (r1 == 0) goto L_0x007e
            r1 = 0
            goto L_0x0080
        L_0x007e:
            r1 = 8
        L_0x0080:
            r0.setVisibility(r1)
            android.support.v4.media.session.PlaybackStateCompat r0 = r8.T
            if (r0 == 0) goto L_0x00ed
            int r0 = r0.getState()
            r1 = 6
            if (r0 == r1) goto L_0x009a
            android.support.v4.media.session.PlaybackStateCompat r0 = r8.T
            int r0 = r0.getState()
            r1 = 3
            if (r0 != r1) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r0 = 0
            goto L_0x009b
        L_0x009a:
            r0 = 1
        L_0x009b:
            android.widget.ImageButton r1 = r8.f10271m
            android.content.Context r1 = r1.getContext()
            if (r0 == 0) goto L_0x00ae
            boolean r2 = r8.u()
            if (r2 == 0) goto L_0x00ae
            int r0 = androidx.mediarouter.R$attr.mediaRoutePauseDrawable
            int r2 = androidx.mediarouter.R$string.mr_controller_pause
            goto L_0x00cb
        L_0x00ae:
            if (r0 == 0) goto L_0x00bb
            boolean r2 = r8.w()
            if (r2 == 0) goto L_0x00bb
            int r0 = androidx.mediarouter.R$attr.mediaRouteStopDrawable
            int r2 = androidx.mediarouter.R$string.mr_controller_stop
            goto L_0x00cb
        L_0x00bb:
            if (r0 != 0) goto L_0x00c8
            boolean r0 = r8.v()
            if (r0 == 0) goto L_0x00c8
            int r0 = androidx.mediarouter.R$attr.mediaRoutePlayDrawable
            int r2 = androidx.mediarouter.R$string.mr_controller_play
            goto L_0x00cb
        L_0x00c8:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x00cb:
            android.widget.ImageButton r5 = r8.f10271m
            if (r3 == 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r7 = 8
        L_0x00d2:
            r5.setVisibility(r7)
            if (r3 == 0) goto L_0x00ed
            android.widget.ImageButton r3 = r8.f10271m
            int r0 = androidx.mediarouter.app.MediaRouterThemeHelper.p(r1, r0)
            r3.setImageResource(r0)
            android.widget.ImageButton r0 = r8.f10271m
            android.content.res.Resources r1 = r1.getResources()
            java.lang.CharSequence r1 = r1.getText(r2)
            r0.setContentDescription(r1)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteControllerDialog.K():void");
    }

    private void L() {
        int i2 = 0;
        if (!this.f10286y && s()) {
            this.B.setVisibility(8);
            this.f10254d0 = true;
            this.D.setVisibility(0);
            y();
            H(false);
        } else if ((this.f10254d0 && !this.f10286y) || !x(this.f10255e)) {
            this.B.setVisibility(8);
        } else if (this.B.getVisibility() == 8) {
            this.B.setVisibility(0);
            this.J.setMax(this.f10255e.u());
            this.J.setProgress(this.f10255e.s());
            MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = this.f10275o;
            if (!s()) {
                i2 = 8;
            }
            mediaRouteExpandCollapseButton.setVisibility(i2);
        }
    }

    private static boolean N(Uri uri, Uri uri2) {
        if (uri == null || !uri.equals(uri2)) {
            return uri == null && uri2 == null;
        }
        return true;
    }

    private void g(final Map<MediaRouter.RouteInfo, Rect> map, final Map<MediaRouter.RouteInfo, BitmapDrawable> map2) {
        this.D.setEnabled(false);
        this.D.requestLayout();
        this.f10256e0 = true;
        this.D.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                MediaRouteControllerDialog.this.D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                MediaRouteControllerDialog.this.h(map, map2);
            }
        });
    }

    private void i(final View view, final int i2) {
        final int p2 = p(view);
        AnonymousClass7 r12 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f2, Transformation transformation) {
                int i2 = p2;
                MediaRouteControllerDialog.B(view, i2 - ((int) (((float) (i2 - i2)) * f2)));
            }
        };
        r12.setDuration((long) this.f10260g0);
        r12.setInterpolator(this.f10266j0);
        view.startAnimation(r12);
    }

    private boolean j() {
        return this.f10265j == null && !(this.U == null && this.T == null);
    }

    private void m() {
        AnonymousClass12 r02 = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                MediaRouteControllerDialog.this.n(true);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        int firstVisiblePosition = this.D.getFirstVisiblePosition();
        boolean z2 = false;
        for (int i2 = 0; i2 < this.D.getChildCount(); i2++) {
            View childAt = this.D.getChildAt(i2);
            VolumeGroupAdapter volumeGroupAdapter = this.E;
            if (this.G.contains((MediaRouter.RouteInfo) volumeGroupAdapter.getItem(firstVisiblePosition + i2))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration((long) this.f10262h0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z2) {
                    alphaAnimation.setAnimationListener(r02);
                    z2 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }

    private static int p(View view) {
        return view.getLayoutParams().height;
    }

    private int q(boolean z2) {
        if (!z2 && this.B.getVisibility() != 0) {
            return 0;
        }
        int paddingTop = 0 + this.f10287z.getPaddingTop() + this.f10287z.getPaddingBottom();
        if (z2) {
            paddingTop += this.A.getMeasuredHeight();
        }
        if (this.B.getVisibility() == 0) {
            paddingTop += this.B.getMeasuredHeight();
        }
        if (!z2 || this.B.getVisibility() != 0) {
            return paddingTop;
        }
        return paddingTop + this.C.getMeasuredHeight();
    }

    static boolean r(Bitmap bitmap) {
        return bitmap != null && bitmap.isRecycled();
    }

    private boolean s() {
        return this.f10255e.y() && this.f10255e.l().size() > 1;
    }

    private boolean t() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.U;
        Uri uri2 = null;
        if (mediaDescriptionCompat == null) {
            bitmap = null;
        } else {
            bitmap = mediaDescriptionCompat.getIconBitmap();
        }
        MediaDescriptionCompat mediaDescriptionCompat2 = this.U;
        if (mediaDescriptionCompat2 != null) {
            uri2 = mediaDescriptionCompat2.getIconUri();
        }
        FetchArtTask fetchArtTask = this.V;
        if (fetchArtTask == null) {
            bitmap2 = this.W;
        } else {
            bitmap2 = fetchArtTask.b();
        }
        FetchArtTask fetchArtTask2 = this.V;
        if (fetchArtTask2 == null) {
            uri = this.X;
        } else {
            uri = fetchArtTask2.c();
        }
        if (bitmap2 != bitmap) {
            return true;
        }
        if (bitmap2 != null || N(uri, uri2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void D() {
        k(true);
        this.D.requestLayout();
        this.D.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                MediaRouteControllerDialog.this.D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                MediaRouteControllerDialog.this.E();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void E() {
        Set<MediaRouter.RouteInfo> set = this.G;
        if (set == null || set.size() == 0) {
            n(true);
        } else {
            m();
        }
    }

    /* access modifiers changed from: package-private */
    public void F(boolean z2) {
        if (this.L != null) {
            this.f10250b0 = true;
            this.f10252c0 = z2 | this.f10252c0;
            return;
        }
        int i2 = 0;
        this.f10250b0 = false;
        this.f10252c0 = false;
        if (!this.f10255e.C() || this.f10255e.w()) {
            dismiss();
        } else if (this.f10259g) {
            this.f10284w.setText(this.f10255e.m());
            Button button = this.f10267k;
            if (!this.f10255e.a()) {
                i2 = 8;
            }
            button.setVisibility(i2);
            if (this.f10265j == null && this.Y) {
                if (r(this.Z)) {
                    Log.w("MediaRouteCtrlDialog", "Can't set artwork image with recycled bitmap: " + this.Z);
                } else {
                    this.f10281t.setImageBitmap(this.Z);
                    this.f10281t.setBackgroundColor(this.f10249a0);
                }
                l();
            }
            L();
            K();
            H(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        if (this.f10265j == null && t()) {
            if (!s() || this.f10286y) {
                FetchArtTask fetchArtTask = this.V;
                if (fetchArtTask != null) {
                    fetchArtTask.cancel(true);
                }
                FetchArtTask fetchArtTask2 = new FetchArtTask();
                this.V = fetchArtTask2;
                fetchArtTask2.execute(new Void[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void H(final boolean z2) {
        this.f10279r.requestLayout();
        this.f10279r.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                MediaRouteControllerDialog.this.f10279r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
                if (mediaRouteControllerDialog.f10256e0) {
                    mediaRouteControllerDialog.f10258f0 = true;
                } else {
                    mediaRouteControllerDialog.I(z2);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void I(boolean z2) {
        int i2;
        int i3;
        boolean z3;
        Bitmap bitmap;
        ImageView.ScaleType scaleType;
        int p2 = p(this.f10287z);
        B(this.f10287z, -1);
        J(j());
        View decorView = getWindow().getDecorView();
        boolean z4 = false;
        decorView.measure(View.MeasureSpec.makeMeasureSpec(getWindow().getAttributes().width, 1073741824), 0);
        B(this.f10287z, p2);
        if (this.f10265j != null || !(this.f10281t.getDrawable() instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) this.f10281t.getDrawable()).getBitmap()) == null) {
            i2 = 0;
        } else {
            i2 = o(bitmap.getWidth(), bitmap.getHeight());
            ImageView imageView = this.f10281t;
            if (bitmap.getWidth() >= bitmap.getHeight()) {
                scaleType = ImageView.ScaleType.FIT_XY;
            } else {
                scaleType = ImageView.ScaleType.FIT_CENTER;
            }
            imageView.setScaleType(scaleType);
        }
        int q2 = q(j());
        int size = this.F.size();
        if (s()) {
            i3 = this.N * this.f10255e.l().size();
        } else {
            i3 = 0;
        }
        if (size > 0) {
            i3 += this.P;
        }
        int min = Math.min(i3, this.O);
        if (!this.f10254d0) {
            min = 0;
        }
        int max = Math.max(i2, min) + q2;
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int height = rect.height() - (this.f10278q.getMeasuredHeight() - this.f10279r.getMeasuredHeight());
        if (this.f10265j != null || i2 <= 0 || max > height) {
            if (p(this.D) + this.f10287z.getMeasuredHeight() >= this.f10279r.getMeasuredHeight()) {
                this.f10281t.setVisibility(8);
            }
            max = min + q2;
            i2 = 0;
        } else {
            this.f10281t.setVisibility(0);
            B(this.f10281t, i2);
        }
        if (!j() || max > height) {
            this.A.setVisibility(8);
        } else {
            this.A.setVisibility(0);
        }
        if (this.A.getVisibility() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        J(z3);
        if (this.A.getVisibility() == 0) {
            z4 = true;
        }
        int q3 = q(z4);
        int max2 = Math.max(i2, min) + q3;
        if (max2 > height) {
            min -= max2 - height;
        } else {
            height = max2;
        }
        this.f10287z.clearAnimation();
        this.D.clearAnimation();
        this.f10279r.clearAnimation();
        if (z2) {
            i(this.f10287z, q3);
            i(this.D, min);
            i(this.f10279r, height);
        } else {
            B(this.f10287z, q3);
            B(this.D, min);
            B(this.f10279r, height);
        }
        B(this.f10277p, rect.height());
        A(z2);
    }

    /* access modifiers changed from: package-private */
    public void M(View view) {
        B((LinearLayout) view.findViewById(R$id.volume_item_container), this.N);
        View findViewById = view.findViewById(R$id.mr_volume_item_icon);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int i2 = this.M;
        layoutParams.width = i2;
        layoutParams.height = i2;
        findViewById.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void h(Map<MediaRouter.RouteInfo, Rect> map, Map<MediaRouter.RouteInfo, BitmapDrawable> map2) {
        OverlayListView.OverlayObject overlayObject;
        int i2;
        Map<MediaRouter.RouteInfo, Rect> map3 = map;
        Set<MediaRouter.RouteInfo> set = this.G;
        if (set != null && this.H != null) {
            int size = set.size() - this.H.size();
            AnonymousClass9 r3 = new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    MediaRouteControllerDialog.this.D.b();
                    MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
                    mediaRouteControllerDialog.D.postDelayed(mediaRouteControllerDialog.f10276o0, (long) mediaRouteControllerDialog.f10260g0);
                }
            };
            int firstVisiblePosition = this.D.getFirstVisiblePosition();
            boolean z2 = false;
            for (int i3 = 0; i3 < this.D.getChildCount(); i3++) {
                View childAt = this.D.getChildAt(i3);
                MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) this.E.getItem(firstVisiblePosition + i3);
                Rect rect = map3.get(routeInfo);
                int top = childAt.getTop();
                if (rect != null) {
                    i2 = rect.top;
                } else {
                    i2 = (this.N * size) + top;
                }
                AnimationSet animationSet = new AnimationSet(true);
                Set<MediaRouter.RouteInfo> set2 = this.G;
                if (set2 != null && set2.contains(routeInfo)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnimation.setDuration((long) this.f10262h0);
                    animationSet.addAnimation(alphaAnimation);
                    i2 = top;
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (i2 - top), 0.0f);
                translateAnimation.setDuration((long) this.f10260g0);
                animationSet.addAnimation(translateAnimation);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                animationSet.setInterpolator(this.f10266j0);
                if (!z2) {
                    animationSet.setAnimationListener(r3);
                    z2 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
                map3.remove(routeInfo);
                map2.remove(routeInfo);
            }
            Map<MediaRouter.RouteInfo, BitmapDrawable> map4 = map2;
            for (Map.Entry next : map2.entrySet()) {
                final MediaRouter.RouteInfo routeInfo2 = (MediaRouter.RouteInfo) next.getKey();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) next.getValue();
                Rect rect2 = map3.get(routeInfo2);
                if (this.H.contains(routeInfo2)) {
                    overlayObject = new OverlayListView.OverlayObject(bitmapDrawable, rect2).c(1.0f, 0.0f).e((long) this.f10264i0).f(this.f10266j0);
                } else {
                    overlayObject = new OverlayListView.OverlayObject(bitmapDrawable, rect2).g(this.N * size).e((long) this.f10260g0).f(this.f10266j0).d(new OverlayListView.OverlayObject.OnAnimationEndListener() {
                        public void onAnimationEnd() {
                            MediaRouteControllerDialog.this.I.remove(routeInfo2);
                            MediaRouteControllerDialog.this.E.notifyDataSetChanged();
                        }
                    });
                    this.I.add(routeInfo2);
                }
                this.D.a(overlayObject);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(boolean z2) {
        Set<MediaRouter.RouteInfo> set;
        int firstVisiblePosition = this.D.getFirstVisiblePosition();
        for (int i2 = 0; i2 < this.D.getChildCount(); i2++) {
            View childAt = this.D.getChildAt(i2);
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) this.E.getItem(firstVisiblePosition + i2);
            if (!z2 || (set = this.G) == null || !set.contains(routeInfo)) {
                ((LinearLayout) childAt.findViewById(R$id.volume_item_container)).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        this.D.c();
        if (!z2) {
            n(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.Y = false;
        this.Z = null;
        this.f10249a0 = 0;
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z2) {
        this.G = null;
        this.H = null;
        this.f10256e0 = false;
        if (this.f10258f0) {
            this.f10258f0 = false;
            H(z2);
        }
        this.D.setEnabled(true);
    }

    /* access modifiers changed from: package-private */
    public int o(int i2, int i3) {
        if (i2 >= i3) {
            return (int) (((((float) this.f10263i) * ((float) i3)) / ((float) i2)) + 0.5f);
        }
        return (int) (((((float) this.f10263i) * 9.0f) / 16.0f) + 0.5f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10261h = true;
        this.f10251c.b(MediaRouteSelector.f10544c, this.f10253d, 2);
        C(this.f10251c.k());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(17170445);
        setContentView(R$layout.mr_controller_material_dialog_b);
        findViewById(16908315).setVisibility(8);
        ClickListener clickListener = new ClickListener();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.mr_expandable_area);
        this.f10277p = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaRouteControllerDialog.this.dismiss();
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.mr_dialog_area);
        this.f10278q = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        int d2 = MediaRouterThemeHelper.d(this.f10257f);
        Button button = (Button) findViewById(16908314);
        this.f10267k = button;
        button.setText(R$string.mr_controller_disconnect);
        this.f10267k.setTextColor(d2);
        this.f10267k.setOnClickListener(clickListener);
        Button button2 = (Button) findViewById(16908313);
        this.f10269l = button2;
        button2.setText(R$string.mr_controller_stop_casting);
        this.f10269l.setTextColor(d2);
        this.f10269l.setOnClickListener(clickListener);
        this.f10284w = (TextView) findViewById(R$id.mr_name);
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_close);
        this.f10273n = imageButton;
        imageButton.setOnClickListener(clickListener);
        this.f10280s = (FrameLayout) findViewById(R$id.mr_custom_control);
        this.f10279r = (FrameLayout) findViewById(R$id.mr_default_control);
        AnonymousClass4 r2 = new View.OnClickListener() {
            public void onClick(View view) {
                PendingIntent sessionActivity;
                MediaControllerCompat mediaControllerCompat = MediaRouteControllerDialog.this.R;
                if (mediaControllerCompat != null && (sessionActivity = mediaControllerCompat.getSessionActivity()) != null) {
                    try {
                        sessionActivity.send();
                        MediaRouteControllerDialog.this.dismiss();
                    } catch (PendingIntent.CanceledException unused) {
                        Log.e("MediaRouteCtrlDialog", sessionActivity + " was not sent, it had been canceled.");
                    }
                }
            }
        };
        ImageView imageView = (ImageView) findViewById(R$id.mr_art);
        this.f10281t = imageView;
        imageView.setOnClickListener(r2);
        findViewById(R$id.mr_control_title_container).setOnClickListener(r2);
        this.f10287z = (LinearLayout) findViewById(R$id.mr_media_main_control);
        this.C = findViewById(R$id.mr_control_divider);
        this.A = (RelativeLayout) findViewById(R$id.mr_playback_control);
        this.f10282u = (TextView) findViewById(R$id.mr_control_title);
        this.f10283v = (TextView) findViewById(R$id.mr_control_subtitle);
        ImageButton imageButton2 = (ImageButton) findViewById(R$id.mr_control_playback_ctrl);
        this.f10271m = imageButton2;
        imageButton2.setOnClickListener(clickListener);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R$id.mr_volume_control);
        this.B = linearLayout2;
        linearLayout2.setVisibility(8);
        SeekBar seekBar = (SeekBar) findViewById(R$id.mr_volume_slider);
        this.J = seekBar;
        seekBar.setTag(this.f10255e);
        VolumeChangeListener volumeChangeListener = new VolumeChangeListener();
        this.K = volumeChangeListener;
        this.J.setOnSeekBarChangeListener(volumeChangeListener);
        this.D = (OverlayListView) findViewById(R$id.mr_volume_group_list);
        this.F = new ArrayList();
        VolumeGroupAdapter volumeGroupAdapter = new VolumeGroupAdapter(this.D.getContext(), this.F);
        this.E = volumeGroupAdapter;
        this.D.setAdapter(volumeGroupAdapter);
        this.I = new HashSet();
        MediaRouterThemeHelper.u(this.f10257f, this.f10287z, this.D, s());
        MediaRouterThemeHelper.w(this.f10257f, (MediaRouteVolumeSlider) this.J, this.f10287z);
        HashMap hashMap = new HashMap();
        this.Q = hashMap;
        hashMap.put(this.f10255e, this.J);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(R$id.mr_group_expand_collapse);
        this.f10275o = mediaRouteExpandCollapseButton;
        mediaRouteExpandCollapseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaRouteControllerDialog mediaRouteControllerDialog = MediaRouteControllerDialog.this;
                boolean z2 = !mediaRouteControllerDialog.f10254d0;
                mediaRouteControllerDialog.f10254d0 = z2;
                if (z2) {
                    mediaRouteControllerDialog.D.setVisibility(0);
                }
                MediaRouteControllerDialog.this.y();
                MediaRouteControllerDialog.this.H(true);
            }
        });
        y();
        this.f10260g0 = this.f10257f.getResources().getInteger(R$integer.mr_controller_volume_group_list_animation_duration_ms);
        this.f10262h0 = this.f10257f.getResources().getInteger(R$integer.mr_controller_volume_group_list_fade_in_duration_ms);
        this.f10264i0 = this.f10257f.getResources().getInteger(R$integer.mr_controller_volume_group_list_fade_out_duration_ms);
        View z2 = z(bundle);
        this.f10265j = z2;
        if (z2 != null) {
            this.f10280s.addView(z2);
            this.f10280s.setVisibility(0);
        }
        this.f10259g = true;
        updateLayout();
    }

    public void onDetachedFromWindow() {
        this.f10251c.s(this.f10253d);
        C((MediaSessionCompat.Token) null);
        this.f10261h = false;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        int i3;
        if (i2 != 25 && i2 != 24) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.f10286y || !this.f10254d0) {
            MediaRouter.RouteInfo routeInfo = this.f10255e;
            if (i2 == 25) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            routeInfo.H(i3);
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        return (this.T.getActions() & 514) != 0;
    }

    /* access modifiers changed from: package-private */
    public void updateLayout() {
        int b2 = MediaRouteDialogHelper.b(this.f10257f);
        getWindow().setLayout(b2, -2);
        View decorView = getWindow().getDecorView();
        this.f10263i = (b2 - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = this.f10257f.getResources();
        this.M = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_item_icon_size);
        this.N = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_item_height);
        this.O = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_max_height);
        this.W = null;
        this.X = null;
        G();
        F(false);
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return (this.T.getActions() & 516) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return (this.T.getActions() & 1) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean x(MediaRouter.RouteInfo routeInfo) {
        return this.f10285x && routeInfo.t() == 1;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        Interpolator interpolator;
        if (this.f10254d0) {
            interpolator = this.f10268k0;
        } else {
            interpolator = this.f10270l0;
        }
        this.f10266j0 = interpolator;
    }

    public View z(Bundle bundle) {
        return null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaRouteControllerDialog(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 1
            android.content.Context r2 = androidx.mediarouter.app.MediaRouterThemeHelper.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.MediaRouterThemeHelper.c(r2)
            r1.<init>(r2, r3)
            r1.f10285x = r0
            androidx.mediarouter.app.MediaRouteControllerDialog$1 r3 = new androidx.mediarouter.app.MediaRouteControllerDialog$1
            r3.<init>()
            r1.f10276o0 = r3
            android.content.Context r3 = r1.getContext()
            r1.f10257f = r3
            androidx.mediarouter.app.MediaRouteControllerDialog$MediaControllerCallback r3 = new androidx.mediarouter.app.MediaRouteControllerDialog$MediaControllerCallback
            r3.<init>()
            r1.S = r3
            android.content.Context r3 = r1.f10257f
            androidx.mediarouter.media.MediaRouter r3 = androidx.mediarouter.media.MediaRouter.j(r3)
            r1.f10251c = r3
            boolean r0 = androidx.mediarouter.media.MediaRouter.o()
            r1.f10286y = r0
            androidx.mediarouter.app.MediaRouteControllerDialog$MediaRouterCallback r0 = new androidx.mediarouter.app.MediaRouteControllerDialog$MediaRouterCallback
            r0.<init>()
            r1.f10253d = r0
            androidx.mediarouter.media.MediaRouter$RouteInfo r0 = r3.n()
            r1.f10255e = r0
            android.support.v4.media.session.MediaSessionCompat$Token r3 = r3.k()
            r1.C(r3)
            android.content.Context r3 = r1.f10257f
            android.content.res.Resources r3 = r3.getResources()
            int r0 = androidx.mediarouter.R$dimen.mr_controller_volume_group_list_padding_top
            int r3 = r3.getDimensionPixelSize(r0)
            r1.P = r3
            android.content.Context r3 = r1.f10257f
            java.lang.String r0 = "accessibility"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r3 = (android.view.accessibility.AccessibilityManager) r3
            r1.f10274n0 = r3
            int r3 = androidx.mediarouter.R$interpolator.mr_linear_out_slow_in
            android.view.animation.Interpolator r3 = android.view.animation.AnimationUtils.loadInterpolator(r2, r3)
            r1.f10268k0 = r3
            int r3 = androidx.mediarouter.R$interpolator.mr_fast_out_slow_in
            android.view.animation.Interpolator r2 = android.view.animation.AnimationUtils.loadInterpolator(r2, r3)
            r1.f10270l0 = r2
            android.view.animation.AccelerateDecelerateInterpolator r2 = new android.view.animation.AccelerateDecelerateInterpolator
            r2.<init>()
            r1.f10272m0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteControllerDialog.<init>(android.content.Context, int):void");
    }
}
