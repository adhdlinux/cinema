package com.facebook.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.ads.internal.adapters.k;
import com.facebook.ads.internal.adapters.l;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.settings.a;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.c.a.f;
import com.facebook.ads.internal.view.e;
import com.facebook.ads.internal.view.f.b.z;
import com.facebook.ads.internal.view.g;
import com.facebook.ads.internal.view.h;
import com.facebook.ads.internal.view.n;
import com.facebook.ads.internal.view.o;
import com.facebook.ads.internal.view.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AudienceNetworkActivity extends Activity {
    @Deprecated
    public static final String AD_ICON_URL = "adIconUrl";
    @Deprecated
    public static final String AD_SUBTITLE = "adSubtitle";
    @Deprecated
    public static final String AD_TITLE = "adTitle";
    public static final String AUDIENCE_NETWORK_UNIQUE_ID_EXTRA = "uniqueId";
    public static final String AUTOPLAY = "autoplay";
    public static final String BROWSER_URL = "browserURL";
    public static final String CLIENT_TOKEN = "clientToken";
    @Deprecated
    public static final String CONTEXT_SWITCH_BEHAVIOR = "contextSwitchBehavior";
    @Deprecated
    public static final String END_CARD_ACTIVATION_COMMAND = "facebookRewardedVideoEndCardActivationCommand";
    @Deprecated
    public static final String END_CARD_MARKUP = "facebookRewardedVideoEndCardMarkup";
    public static final String HANDLER_TIME = "handlerTime";
    public static final String PLACEMENT_ID = "placementId";
    public static final String PREDEFINED_ORIENTATION_KEY = "predefinedOrientationKey";
    public static final String REQUEST_TIME = "requestTime";
    public static final String REWARD_SERVER_URL = "rewardServerURL";
    public static final String SKIP_DELAY_SECONDS_KEY = "skipAfterSeconds";
    public static final String USE_CACHE = "useCache";
    public static final String VIDEO_LOGGER = "videoLogger";
    public static final String VIDEO_MPD = "videoMPD";
    @Deprecated
    public static final String VIDEO_REPORT_URL = "videoReportURL";
    public static final String VIDEO_SEEK_TIME = "videoSeekTime";
    public static final String VIDEO_URL = "videoURL";
    public static final String VIEW_TYPE = "viewType";
    @Deprecated
    public static final String WEBVIEW_ENCODING = "utf-8";
    @Deprecated
    public static final String WEBVIEW_MIME_TYPE = "text/html";

    /* renamed from: a  reason: collision with root package name */
    private final List<BackButtonInterceptor> f19434a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f19435b;

    /* renamed from: c  reason: collision with root package name */
    private int f19436c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f19437d;

    /* renamed from: e  reason: collision with root package name */
    private a.C0036a f19438e;

    /* renamed from: f  reason: collision with root package name */
    private long f19439f;

    /* renamed from: g  reason: collision with root package name */
    private long f19440g;

    /* renamed from: h  reason: collision with root package name */
    private int f19441h;

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.ads.internal.view.a f19442i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public com.facebook.ads.internal.view.b.c f19443j;

    /* renamed from: com.facebook.ads.AudienceNetworkActivity$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19444a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.ads.internal.settings.a$a[] r0 = com.facebook.ads.internal.settings.a.C0036a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19444a = r0
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.FULL_SCREEN_VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19444a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19444a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.INTERSTITIAL_WEB_VIEW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19444a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.BROWSER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f19444a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.INTERSTITIAL_OLD_NATIVE_VIDEO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f19444a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.INTERSTITIAL_NATIVE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f19444a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.INTERSTITIAL_NATIVE_IMAGE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f19444a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.facebook.ads.internal.settings.a$a r1 = com.facebook.ads.internal.settings.a.C0036a.INTERSTITIAL_NATIVE_CAROUSEL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.AudienceNetworkActivity.AnonymousClass1.<clinit>():void");
        }
    }

    public interface BackButtonInterceptor {
        boolean interceptBackButton();
    }

    public enum Type {
        INTERSTITIAL_WEB_VIEW(a.C0036a.INTERSTITIAL_WEB_VIEW),
        INTERSTITIAL_OLD_NATIVE_VIDEO(a.C0036a.INTERSTITIAL_OLD_NATIVE_VIDEO),
        INTERSTITIAL_NATIVE_VIDEO(a.C0036a.INTERSTITIAL_NATIVE_VIDEO),
        INTERSTITIAL_NATIVE_IMAGE(a.C0036a.INTERSTITIAL_NATIVE_IMAGE),
        INTERSTITIAL_NATIVE_CAROUSEL(a.C0036a.INTERSTITIAL_NATIVE_CAROUSEL),
        FULL_SCREEN_VIDEO(a.C0036a.FULL_SCREEN_VIDEO),
        REWARDED_VIDEO(a.C0036a.REWARDED_VIDEO),
        BROWSER(a.C0036a.BROWSER);
        

        /* renamed from: a  reason: collision with root package name */
        a.C0036a f19446a;

        private Type(a.C0036a aVar) {
            this.f19446a = aVar;
        }
    }

    private static class a implements a.C0037a {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<AudienceNetworkActivity> f19447a;

        private a(AudienceNetworkActivity audienceNetworkActivity) {
            this.f19447a = new WeakReference<>(audienceNetworkActivity);
        }

        /* synthetic */ a(AudienceNetworkActivity audienceNetworkActivity, AnonymousClass1 r2) {
            this(audienceNetworkActivity);
        }

        public void a(View view) {
            if (this.f19447a.get() != null) {
                this.f19447a.get().f19435b.addView(view);
            }
        }

        public void a(String str) {
            if (this.f19447a.get() != null) {
                this.f19447a.get().a(str);
            }
        }

        public void a(String str, com.facebook.ads.internal.j.d dVar) {
            if (this.f19447a.get() != null) {
                this.f19447a.get().a(str, dVar);
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final AudienceNetworkActivity f19448a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f19449b;

        /* renamed from: c  reason: collision with root package name */
        private final com.facebook.ads.internal.m.c f19450c;

        private b(AudienceNetworkActivity audienceNetworkActivity, Intent intent, com.facebook.ads.internal.m.c cVar) {
            this.f19448a = audienceNetworkActivity;
            this.f19449b = intent;
            this.f19450c = cVar;
        }

        /* synthetic */ b(AudienceNetworkActivity audienceNetworkActivity, Intent intent, com.facebook.ads.internal.m.c cVar, AnonymousClass1 r4) {
            this(audienceNetworkActivity, intent, cVar);
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a a() {
            h hVar = new h(this.f19448a, this.f19450c, i(), h() ? new com.facebook.ads.internal.d.b(this.f19448a) : null);
            a((com.facebook.ads.internal.view.a) hVar);
            return hVar;
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a a(RelativeLayout relativeLayout) {
            AudienceNetworkActivity audienceNetworkActivity = this.f19448a;
            u uVar = new u(audienceNetworkActivity, this.f19450c, new a(audienceNetworkActivity, (AnonymousClass1) null));
            uVar.a((View) relativeLayout);
            uVar.a(this.f19449b.getIntExtra("video_time_polling_interval", 200));
            return uVar;
        }

        private void a(com.facebook.ads.internal.view.a aVar) {
            aVar.setListener(new a(this.f19448a, (AnonymousClass1) null));
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a b() {
            com.facebook.ads.internal.view.a a2 = k.a(this.f19449b.getStringExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA));
            if (a2 == null) {
                return null;
            }
            a(a2);
            return a2;
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a c() {
            AudienceNetworkActivity audienceNetworkActivity = this.f19448a;
            return new com.facebook.ads.internal.view.b(audienceNetworkActivity, this.f19450c, new a(audienceNetworkActivity, (AnonymousClass1) null));
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a d() {
            com.facebook.ads.internal.adapters.a.k kVar = (com.facebook.ads.internal.adapters.a.k) this.f19449b.getSerializableExtra("rewardedVideoAdDataBundle");
            if (kVar.e().j() == null) {
                return new o(this.f19448a, this.f19450c, new com.facebook.ads.internal.view.f.a(this.f19448a), new d(this.f19448a, (AnonymousClass1) null), kVar);
            }
            AudienceNetworkActivity audienceNetworkActivity = this.f19448a;
            return new n(audienceNetworkActivity, this.f19450c, new d(audienceNetworkActivity, (AnonymousClass1) null), kVar);
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a e() {
            AudienceNetworkActivity audienceNetworkActivity = this.f19448a;
            return new e(audienceNetworkActivity, this.f19450c, new a(audienceNetworkActivity, (AnonymousClass1) null));
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a f() {
            f fVar = new f(this.f19448a, this.f19450c, h() ? new com.facebook.ads.internal.d.b(this.f19448a) : null);
            a((com.facebook.ads.internal.view.a) fVar);
            return fVar;
        }

        /* access modifiers changed from: private */
        public com.facebook.ads.internal.view.a g() {
            g gVar = new g(this.f19448a, i(), this.f19450c);
            a((com.facebook.ads.internal.view.a) gVar);
            return gVar;
        }

        private boolean h() {
            return this.f19449b.getBooleanExtra(AudienceNetworkActivity.USE_CACHE, false);
        }

        private com.facebook.ads.internal.adapters.a.g i() {
            return (com.facebook.ads.internal.adapters.a.g) this.f19449b.getSerializableExtra("ad_data_bundle");
        }
    }

    private class c implements View.OnLongClickListener {
        private c() {
        }

        /* synthetic */ c(AudienceNetworkActivity audienceNetworkActivity, AnonymousClass1 r2) {
            this();
        }

        public boolean onLongClick(View view) {
            if (!(AudienceNetworkActivity.this.f19443j == null || AudienceNetworkActivity.this.f19435b == null)) {
                AudienceNetworkActivity.this.f19443j.setBounds(0, 0, AudienceNetworkActivity.this.f19435b.getWidth(), AudienceNetworkActivity.this.f19435b.getHeight());
                AudienceNetworkActivity.this.f19443j.a(!AudienceNetworkActivity.this.f19443j.a());
            }
            return true;
        }
    }

    private static class d extends a {
        private d(AudienceNetworkActivity audienceNetworkActivity) {
            super(audienceNetworkActivity, (AnonymousClass1) null);
        }

        /* synthetic */ d(AudienceNetworkActivity audienceNetworkActivity, AnonymousClass1 r2) {
            this(audienceNetworkActivity);
        }

        public void a(String str) {
            if (this.f19447a.get() != null) {
                this.f19447a.get().a(str);
                String a2 = z.REWARDED_VIDEO_END_ACTIVITY.a();
                String a3 = z.REWARDED_VIDEO_ERROR.a();
                if (str.equals(a2) || str.equals(a3)) {
                    this.f19447a.get().finish();
                }
            }
        }
    }

    private com.facebook.ads.internal.view.a a() {
        b bVar = new b(this, getIntent(), com.facebook.ads.internal.m.d.a((Context) this), (AnonymousClass1) null);
        a.C0036a aVar = this.f19438e;
        if (aVar == null) {
            return null;
        }
        switch (AnonymousClass1.f19444a[aVar.ordinal()]) {
            case 1:
                return bVar.a(this.f19435b);
            case 2:
                return bVar.d();
            case 3:
                return bVar.e();
            case 4:
                return bVar.c();
            case 5:
                return bVar.b();
            case 6:
                return bVar.a();
            case 7:
                return bVar.g();
            case 8:
                return bVar.f();
            default:
                return null;
        }
    }

    private void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.f19436c = bundle.getInt(PREDEFINED_ORIENTATION_KEY, -1);
            this.f19437d = bundle.getString(AUDIENCE_NETWORK_UNIQUE_ID_EXTRA);
            this.f19438e = (a.C0036a) bundle.getSerializable(VIEW_TYPE);
            return;
        }
        this.f19436c = intent.getIntExtra(PREDEFINED_ORIENTATION_KEY, -1);
        this.f19437d = intent.getStringExtra(AUDIENCE_NETWORK_UNIQUE_ID_EXTRA);
        this.f19438e = (a.C0036a) intent.getSerializableExtra(VIEW_TYPE);
        this.f19441h = intent.getIntExtra(SKIP_DELAY_SECONDS_KEY, 0) * 1000;
    }

    private void a(Intent intent, boolean z2) {
        if (com.facebook.ads.internal.l.a.b(this) && this.f19438e != a.C0036a.BROWSER) {
            this.f19443j = new com.facebook.ads.internal.view.b.c();
            this.f19443j.a(intent.getStringExtra(PLACEMENT_ID));
            this.f19443j.b(getPackageName());
            long longExtra = intent.getLongExtra(REQUEST_TIME, 0);
            if (longExtra != 0) {
                this.f19443j.a(longExtra);
            }
            TextView textView = new TextView(this);
            textView.setText("Debug");
            textView.setTextColor(-1);
            x.a((View) textView, Color.argb(160, 0, 0, 0));
            textView.setPadding(5, 5, 5, 5);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            textView.setLayoutParams(layoutParams);
            c cVar = new c(this, (AnonymousClass1) null);
            textView.setOnLongClickListener(cVar);
            if (z2) {
                this.f19435b.addView(textView);
            } else {
                this.f19435b.setOnLongClickListener(cVar);
            }
            this.f19435b.getOverlay().add(this.f19443j);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        LocalBroadcastManager.b(this).d(new Intent(str + ":" + this.f19437d));
    }

    /* access modifiers changed from: private */
    public void a(String str, com.facebook.ads.internal.j.d dVar) {
        Intent intent = new Intent(str + ":" + this.f19437d);
        intent.putExtra("event", dVar);
        LocalBroadcastManager.b(this).d(intent);
    }

    public void addBackButtonInterceptor(BackButtonInterceptor backButtonInterceptor) {
        this.f19434a.add(backButtonInterceptor);
    }

    public void finish() {
        if (!isFinishing()) {
            a(this.f19438e == a.C0036a.REWARDED_VIDEO ? z.REWARDED_VIDEO_CLOSED.a() : "com.facebook.ads.interstitial.dismissed");
            super.finish();
        }
    }

    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f19440g + (currentTimeMillis - this.f19439f);
        this.f19440g = j2;
        this.f19439f = currentTimeMillis;
        if (j2 > ((long) this.f19441h)) {
            boolean z2 = false;
            for (BackButtonInterceptor interceptBackButton : this.f19434a) {
                if (interceptBackButton.interceptBackButton()) {
                    z2 = true;
                }
            }
            if (!z2) {
                super.onBackPressed();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        com.facebook.ads.internal.view.a aVar = this.f19442i;
        if (aVar instanceof l) {
            ((l) aVar).a(configuration);
        } else if (aVar instanceof o) {
            ((o) aVar).onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.facebook.ads.internal.q.a.d.a();
        boolean z2 = true;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f19435b = relativeLayout;
        x.a((View) relativeLayout, -16777216);
        setContentView(this.f19435b, new RelativeLayout.LayoutParams(-1, -1));
        Intent intent = getIntent();
        a(intent, bundle);
        com.facebook.ads.internal.view.a a2 = a();
        this.f19442i = a2;
        if (a2 == null) {
            com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a((Throwable) null, "Unable to infer viewType from intent or savedInstanceState"));
            a("com.facebook.ads.interstitial.error");
            finish();
            return;
        }
        a2.a(intent, bundle, this);
        a("com.facebook.ads.interstitial.displayed");
        this.f19439f = System.currentTimeMillis();
        if (this.f19438e != a.C0036a.INTERSTITIAL_WEB_VIEW) {
            z2 = false;
        }
        a(intent, z2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        a(this.f19438e == a.C0036a.REWARDED_VIDEO ? z.REWARDED_VIDEO_ACTIVITY_DESTROYED.a() : "com.facebook.ads.interstitial.activity_destroyed");
        RelativeLayout relativeLayout = this.f19435b;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        com.facebook.ads.internal.view.a aVar = this.f19442i;
        if (aVar != null) {
            k.a(aVar);
            this.f19442i.onDestroy();
            this.f19442i = null;
        }
        if (this.f19443j != null && com.facebook.ads.internal.l.a.b(this)) {
            this.f19443j.b();
        }
        super.onDestroy();
    }

    public void onPause() {
        this.f19440g += System.currentTimeMillis() - this.f19439f;
        com.facebook.ads.internal.view.a aVar = this.f19442i;
        if (aVar != null) {
            aVar.i();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f19439f = System.currentTimeMillis();
        com.facebook.ads.internal.view.a aVar = this.f19442i;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.facebook.ads.internal.view.a aVar = this.f19442i;
        if (aVar != null) {
            aVar.a(bundle);
        }
        bundle.putInt(PREDEFINED_ORIENTATION_KEY, this.f19436c);
        bundle.putString(AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f19437d);
        bundle.putSerializable(VIEW_TYPE, this.f19438e);
    }

    public void onStart() {
        super.onStart();
        int i2 = this.f19436c;
        if (i2 != -1) {
            setRequestedOrientation(i2);
        }
    }

    public void removeBackButtonInterceptor(BackButtonInterceptor backButtonInterceptor) {
        this.f19434a.remove(backButtonInterceptor);
    }
}
