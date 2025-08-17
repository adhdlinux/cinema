package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediaRouteDynamicChooserDialog extends AppCompatDialog {

    /* renamed from: b  reason: collision with root package name */
    final MediaRouter f10323b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaRouterCallback f10324c;

    /* renamed from: d  reason: collision with root package name */
    Context f10325d;

    /* renamed from: e  reason: collision with root package name */
    private MediaRouteSelector f10326e;

    /* renamed from: f  reason: collision with root package name */
    List<MediaRouter.RouteInfo> f10327f;

    /* renamed from: g  reason: collision with root package name */
    private ImageButton f10328g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerAdapter f10329h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f10330i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10331j;

    /* renamed from: k  reason: collision with root package name */
    MediaRouter.RouteInfo f10332k;

    /* renamed from: l  reason: collision with root package name */
    private long f10333l;

    /* renamed from: m  reason: collision with root package name */
    private long f10334m;

    /* renamed from: n  reason: collision with root package name */
    private final Handler f10335n;

    private final class MediaRouterCallback extends MediaRouter.Callback {
        MediaRouterCallback() {
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicChooserDialog.this.refreshRoutes();
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicChooserDialog.this.refreshRoutes();
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicChooserDialog.this.refreshRoutes();
        }

        public void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            MediaRouteDynamicChooserDialog.this.dismiss();
        }
    }

    private final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        private final ArrayList<Item> f10339n = new ArrayList<>();

        /* renamed from: o  reason: collision with root package name */
        private final LayoutInflater f10340o;

        /* renamed from: p  reason: collision with root package name */
        private final Drawable f10341p;

        /* renamed from: q  reason: collision with root package name */
        private final Drawable f10342q;

        /* renamed from: r  reason: collision with root package name */
        private final Drawable f10343r;

        /* renamed from: s  reason: collision with root package name */
        private final Drawable f10344s;

        private class HeaderViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: j  reason: collision with root package name */
            TextView f10346j;

            HeaderViewHolder(View view) {
                super(view);
                this.f10346j = (TextView) view.findViewById(R$id.mr_picker_header_name);
            }

            public void a(Item item) {
                this.f10346j.setText(item.a().toString());
            }
        }

        private class Item {

            /* renamed from: a  reason: collision with root package name */
            private final Object f10348a;

            /* renamed from: b  reason: collision with root package name */
            private final int f10349b;

            Item(Object obj) {
                this.f10348a = obj;
                if (obj instanceof String) {
                    this.f10349b = 1;
                } else if (obj instanceof MediaRouter.RouteInfo) {
                    this.f10349b = 2;
                } else {
                    this.f10349b = 0;
                    Log.w("RecyclerAdapter", "Wrong type of data passed to Item constructor");
                }
            }

            public Object a() {
                return this.f10348a;
            }

            public int b() {
                return this.f10349b;
            }
        }

        private class RouteViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: j  reason: collision with root package name */
            final View f10351j;

            /* renamed from: k  reason: collision with root package name */
            final ImageView f10352k;

            /* renamed from: l  reason: collision with root package name */
            final ProgressBar f10353l;

            /* renamed from: m  reason: collision with root package name */
            final TextView f10354m;

            RouteViewHolder(View view) {
                super(view);
                this.f10351j = view;
                this.f10352k = (ImageView) view.findViewById(R$id.mr_picker_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_picker_route_progress_bar);
                this.f10353l = progressBar;
                this.f10354m = (TextView) view.findViewById(R$id.mr_picker_route_name);
                MediaRouterThemeHelper.t(MediaRouteDynamicChooserDialog.this.f10325d, progressBar);
            }

            public void a(Item item) {
                final MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) item.a();
                this.f10351j.setVisibility(0);
                this.f10353l.setVisibility(4);
                this.f10351j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MediaRouteDynamicChooserDialog mediaRouteDynamicChooserDialog = MediaRouteDynamicChooserDialog.this;
                        MediaRouter.RouteInfo routeInfo = routeInfo;
                        mediaRouteDynamicChooserDialog.f10332k = routeInfo;
                        routeInfo.I();
                        RouteViewHolder.this.f10352k.setVisibility(4);
                        RouteViewHolder.this.f10353l.setVisibility(0);
                    }
                });
                this.f10354m.setText(routeInfo.m());
                this.f10352k.setImageDrawable(RecyclerAdapter.this.d(routeInfo));
            }
        }

        RecyclerAdapter() {
            this.f10340o = LayoutInflater.from(MediaRouteDynamicChooserDialog.this.f10325d);
            this.f10341p = MediaRouterThemeHelper.g(MediaRouteDynamicChooserDialog.this.f10325d);
            this.f10342q = MediaRouterThemeHelper.q(MediaRouteDynamicChooserDialog.this.f10325d);
            this.f10343r = MediaRouterThemeHelper.m(MediaRouteDynamicChooserDialog.this.f10325d);
            this.f10344s = MediaRouterThemeHelper.n(MediaRouteDynamicChooserDialog.this.f10325d);
            f();
        }

        private Drawable c(MediaRouter.RouteInfo routeInfo) {
            int f2 = routeInfo.f();
            if (f2 == 1) {
                return this.f10342q;
            }
            if (f2 == 2) {
                return this.f10343r;
            }
            if (routeInfo.y()) {
                return this.f10344s;
            }
            return this.f10341p;
        }

        /* access modifiers changed from: package-private */
        public Drawable d(MediaRouter.RouteInfo routeInfo) {
            Uri j2 = routeInfo.j();
            if (j2 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(MediaRouteDynamicChooserDialog.this.f10325d.getContentResolver().openInputStream(j2), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException e2) {
                    Log.w("RecyclerAdapter", "Failed to load " + j2, e2);
                }
            }
            return c(routeInfo);
        }

        public Item e(int i2) {
            return this.f10339n.get(i2);
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f10339n.clear();
            this.f10339n.add(new Item(MediaRouteDynamicChooserDialog.this.f10325d.getString(R$string.mr_chooser_title)));
            for (MediaRouter.RouteInfo item : MediaRouteDynamicChooserDialog.this.f10327f) {
                this.f10339n.add(new Item(item));
            }
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f10339n.size();
        }

        public int getItemViewType(int i2) {
            return this.f10339n.get(i2).b();
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            int itemViewType = getItemViewType(i2);
            Item e2 = e(i2);
            if (itemViewType == 1) {
                ((HeaderViewHolder) viewHolder).a(e2);
            } else if (itemViewType != 2) {
                Log.w("RecyclerAdapter", "Cannot bind item to ViewHolder because of wrong view type");
            } else {
                ((RouteViewHolder) viewHolder).a(e2);
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                return new HeaderViewHolder(this.f10340o.inflate(R$layout.mr_picker_header_item, viewGroup, false));
            }
            if (i2 == 2) {
                return new RouteViewHolder(this.f10340o.inflate(R$layout.mr_picker_route_item, viewGroup, false));
            }
            Log.w("RecyclerAdapter", "Cannot create ViewHolder because of wrong view type");
            return null;
        }
    }

    static final class RouteComparator implements Comparator<MediaRouter.RouteInfo> {

        /* renamed from: b  reason: collision with root package name */
        public static final RouteComparator f10358b = new RouteComparator();

        RouteComparator() {
        }

        /* renamed from: a */
        public int compare(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2) {
            return routeInfo.m().compareToIgnoreCase(routeInfo2.m());
        }
    }

    public MediaRouteDynamicChooserDialog(Context context) {
        this(context, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10331j = true;
        this.f10323b.b(this.f10326e, this.f10324c, 1);
        refreshRoutes();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_picker_dialog);
        MediaRouterThemeHelper.s(this.f10325d, this);
        this.f10327f = new ArrayList();
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_picker_close_button);
        this.f10328g = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaRouteDynamicChooserDialog.this.dismiss();
            }
        });
        this.f10329h = new RecyclerAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.mr_picker_list);
        this.f10330i = recyclerView;
        recyclerView.setAdapter(this.f10329h);
        this.f10330i.setLayoutManager(new LinearLayoutManager(this.f10325d));
        updateLayout();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10331j = false;
        this.f10323b.s(this.f10324c);
        this.f10335n.removeMessages(1);
    }

    public boolean onFilterRoute(MediaRouter.RouteInfo routeInfo) {
        if (routeInfo.w() || !routeInfo.x() || !routeInfo.E(this.f10326e)) {
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
        if (this.f10332k == null && this.f10331j) {
            ArrayList arrayList = new ArrayList(this.f10323b.m());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, RouteComparator.f10358b);
            if (SystemClock.uptimeMillis() - this.f10334m >= this.f10333l) {
                updateRoutes(arrayList);
                return;
            }
            this.f10335n.removeMessages(1);
            Handler handler = this.f10335n;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.f10334m + this.f10333l);
        }
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f10326e.equals(mediaRouteSelector)) {
            this.f10326e = mediaRouteSelector;
            if (this.f10331j) {
                this.f10323b.s(this.f10324c);
                this.f10323b.b(mediaRouteSelector, this.f10324c, 1);
            }
            refreshRoutes();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLayout() {
        getWindow().setLayout(MediaRouteDialogHelper.c(this.f10325d), MediaRouteDialogHelper.a(this.f10325d));
    }

    /* access modifiers changed from: package-private */
    public void updateRoutes(List<MediaRouter.RouteInfo> list) {
        this.f10334m = SystemClock.uptimeMillis();
        this.f10327f.clear();
        this.f10327f.addAll(list);
        this.f10329h.f();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaRouteDynamicChooserDialog(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.MediaRouterThemeHelper.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.MediaRouterThemeHelper.c(r2)
            r1.<init>(r2, r3)
            androidx.mediarouter.media.MediaRouteSelector r2 = androidx.mediarouter.media.MediaRouteSelector.f10544c
            r1.f10326e = r2
            androidx.mediarouter.app.MediaRouteDynamicChooserDialog$1 r2 = new androidx.mediarouter.app.MediaRouteDynamicChooserDialog$1
            r2.<init>()
            r1.f10335n = r2
            android.content.Context r2 = r1.getContext()
            androidx.mediarouter.media.MediaRouter r3 = androidx.mediarouter.media.MediaRouter.j(r2)
            r1.f10323b = r3
            androidx.mediarouter.app.MediaRouteDynamicChooserDialog$MediaRouterCallback r3 = new androidx.mediarouter.app.MediaRouteDynamicChooserDialog$MediaRouterCallback
            r3.<init>()
            r1.f10324c = r3
            r1.f10325d = r2
            android.content.res.Resources r2 = r2.getResources()
            int r3 = androidx.mediarouter.R$integer.mr_update_routes_delay_ms
            int r2 = r2.getInteger(r3)
            long r2 = (long) r2
            r1.f10333l = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteDynamicChooserDialog.<init>(android.content.Context, int):void");
    }
}
