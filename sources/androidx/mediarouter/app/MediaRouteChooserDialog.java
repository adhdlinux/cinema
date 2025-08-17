package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediaRouteChooserDialog extends AppCompatDialog {
    static final int MSG_UPDATE_ROUTES = 1;
    static final String TAG = "MediaRouteChooserDialog";
    private static final long UPDATE_ROUTES_DELAY_MS = 300;
    private RouteAdapter mAdapter;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private final Handler mHandler;
    private long mLastUpdateTime;
    private ListView mListView;
    private final MediaRouter mRouter;
    private ArrayList<MediaRouter.RouteInfo> mRoutes;
    private MediaRouteSelector mSelector;
    private TextView mTitleView;

    private final class MediaRouterCallback extends MediaRouter.Callback {
        MediaRouterCallback() {
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteChooserDialog.this.dismiss();
        }
    }

    private static final class RouteAdapter extends ArrayAdapter<MediaRouter.RouteInfo> implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final LayoutInflater f10241b;

        /* renamed from: c  reason: collision with root package name */
        private final Drawable f10242c;

        /* renamed from: d  reason: collision with root package name */
        private final Drawable f10243d;

        /* renamed from: e  reason: collision with root package name */
        private final Drawable f10244e;

        /* renamed from: f  reason: collision with root package name */
        private final Drawable f10245f;

        public RouteAdapter(Context context, List<MediaRouter.RouteInfo> list) {
            super(context, 0, list);
            this.f10241b = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R$attr.mediaRouteDefaultIconDrawable, R$attr.mediaRouteTvIconDrawable, R$attr.mediaRouteSpeakerIconDrawable, R$attr.mediaRouteSpeakerGroupIconDrawable});
            this.f10242c = AppCompatResources.b(context, obtainStyledAttributes.getResourceId(0, 0));
            this.f10243d = AppCompatResources.b(context, obtainStyledAttributes.getResourceId(1, 0));
            this.f10244e = AppCompatResources.b(context, obtainStyledAttributes.getResourceId(2, 0));
            this.f10245f = AppCompatResources.b(context, obtainStyledAttributes.getResourceId(3, 0));
            obtainStyledAttributes.recycle();
        }

        private Drawable a(MediaRouter.RouteInfo routeInfo) {
            int f2 = routeInfo.f();
            if (f2 == 1) {
                return this.f10243d;
            }
            if (f2 == 2) {
                return this.f10244e;
            }
            if (routeInfo.y()) {
                return this.f10245f;
            }
            return this.f10242c;
        }

        private Drawable b(MediaRouter.RouteInfo routeInfo) {
            Uri j2 = routeInfo.j();
            if (j2 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(getContext().getContentResolver().openInputStream(j2), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException e2) {
                    Log.w(MediaRouteChooserDialog.TAG, "Failed to load " + j2, e2);
                }
            }
            return a(routeInfo);
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f10241b.inflate(R$layout.mr_chooser_list_item, viewGroup, false);
            }
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) getItem(i2);
            TextView textView = (TextView) view.findViewById(R$id.mr_chooser_route_name);
            TextView textView2 = (TextView) view.findViewById(R$id.mr_chooser_route_desc);
            textView.setText(routeInfo.m());
            String d2 = routeInfo.d();
            boolean z2 = true;
            if (!(routeInfo.c() == 2 || routeInfo.c() == 1)) {
                z2 = false;
            }
            if (!z2 || TextUtils.isEmpty(d2)) {
                textView.setGravity(16);
                textView2.setVisibility(8);
                textView2.setText("");
            } else {
                textView.setGravity(80);
                textView2.setVisibility(0);
                textView2.setText(d2);
            }
            view.setEnabled(routeInfo.x());
            ImageView imageView = (ImageView) view.findViewById(R$id.mr_chooser_route_icon);
            if (imageView != null) {
                imageView.setImageDrawable(b(routeInfo));
            }
            return view;
        }

        public boolean isEnabled(int i2) {
            return ((MediaRouter.RouteInfo) getItem(i2)).x();
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) getItem(i2);
            if (routeInfo.x()) {
                ImageView imageView = (ImageView) view.findViewById(R$id.mr_chooser_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_chooser_route_progress_bar);
                if (!(imageView == null || progressBar == null)) {
                    imageView.setVisibility(8);
                    progressBar.setVisibility(0);
                }
                routeInfo.I();
            }
        }
    }

    static final class RouteComparator implements Comparator<MediaRouter.RouteInfo> {

        /* renamed from: b  reason: collision with root package name */
        public static final RouteComparator f10246b = new RouteComparator();

        RouteComparator() {
        }

        /* renamed from: a */
        public int compare(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2) {
            return routeInfo.m().compareToIgnoreCase(routeInfo2.m());
        }
    }

    public MediaRouteChooserDialog(Context context) {
        this(context, 0);
    }

    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.b(this.mSelector, this.mCallback, 1);
        refreshRoutes();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_chooser_dialog);
        this.mRoutes = new ArrayList<>();
        this.mAdapter = new RouteAdapter(getContext(), this.mRoutes);
        ListView listView = (ListView) findViewById(R$id.mr_chooser_list);
        this.mListView = listView;
        listView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this.mAdapter);
        this.mListView.setEmptyView(findViewById(16908292));
        this.mTitleView = (TextView) findViewById(R$id.mr_chooser_title);
        updateLayout();
    }

    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mRouter.s(this.mCallback);
        this.mHandler.removeMessages(1);
        super.onDetachedFromWindow();
    }

    public boolean onFilterRoute(MediaRouter.RouteInfo routeInfo) {
        if (routeInfo.w() || !routeInfo.x() || !routeInfo.E(this.mSelector)) {
            return false;
        }
        return true;
    }

    public void onFilterRoutes(List<MediaRouter.RouteInfo> list) {
        int size = list.size();
        while (true) {
            int i2 = size - 1;
            if (size > 0) {
                if (!onFilterRoute(list.get(i2))) {
                    list.remove(i2);
                }
                size = i2;
            } else {
                return;
            }
        }
    }

    public void refreshRoutes() {
        if (this.mAttachedToWindow) {
            ArrayList arrayList = new ArrayList(this.mRouter.m());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, RouteComparator.f10246b);
            if (SystemClock.uptimeMillis() - this.mLastUpdateTime >= UPDATE_ROUTES_DELAY_MS) {
                updateRoutes(arrayList);
                return;
            }
            this.mHandler.removeMessages(1);
            Handler handler = this.mHandler;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.mLastUpdateTime + UPDATE_ROUTES_DELAY_MS);
        }
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.mSelector.equals(mediaRouteSelector)) {
            this.mSelector = mediaRouteSelector;
            if (this.mAttachedToWindow) {
                this.mRouter.s(this.mCallback);
                this.mRouter.b(mediaRouteSelector, this.mCallback, 1);
            }
            refreshRoutes();
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleView.setText(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void updateLayout() {
        getWindow().setLayout(MediaRouteDialogHelper.b(getContext()), -2);
    }

    /* access modifiers changed from: package-private */
    public void updateRoutes(List<MediaRouter.RouteInfo> list) {
        this.mLastUpdateTime = SystemClock.uptimeMillis();
        this.mRoutes.clear();
        this.mRoutes.addAll(list);
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaRouteChooserDialog(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.MediaRouterThemeHelper.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.MediaRouterThemeHelper.c(r2)
            r1.<init>(r2, r3)
            androidx.mediarouter.media.MediaRouteSelector r2 = androidx.mediarouter.media.MediaRouteSelector.f10544c
            r1.mSelector = r2
            androidx.mediarouter.app.MediaRouteChooserDialog$1 r2 = new androidx.mediarouter.app.MediaRouteChooserDialog$1
            r2.<init>()
            r1.mHandler = r2
            android.content.Context r2 = r1.getContext()
            androidx.mediarouter.media.MediaRouter r2 = androidx.mediarouter.media.MediaRouter.j(r2)
            r1.mRouter = r2
            androidx.mediarouter.app.MediaRouteChooserDialog$MediaRouterCallback r2 = new androidx.mediarouter.app.MediaRouteChooserDialog$MediaRouterCallback
            r2.<init>()
            r1.mCallback = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteChooserDialog.<init>(android.content.Context, int):void");
    }

    public void setTitle(int i2) {
        this.mTitleView.setText(i2);
    }
}
