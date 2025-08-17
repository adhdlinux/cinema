package com.chartboost.sdk.internal.clickthrough;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.a5;
import com.chartboost.sdk.impl.ib;
import com.chartboost.sdk.impl.kb;
import com.chartboost.sdk.impl.ob;
import com.chartboost.sdk.impl.qb;
import com.chartboost.sdk.impl.t4;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.impl.x4;
import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class EmbeddedBrowserActivity extends Activity implements a5 {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a5 f19155a = kb.a();

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f19156b = LazyKt__LazyJVMKt.b(new d(this));

    /* renamed from: c  reason: collision with root package name */
    public final Lazy f19157c = LazyKt__LazyJVMKt.b(new c(this));

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f19158d = LazyKt__LazyJVMKt.b(new e(this));

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }

        public final Intent a(Context context, String str) {
            Intrinsics.f(context, "context");
            Intrinsics.f(str, ImagesContract.URL);
            Intent putExtra = new Intent(context, EmbeddedBrowserActivity.class).putExtra("KEY_INTENT_URL", str);
            Intrinsics.e(putExtra, "Intent(context, Embedded…xtra(KEY_INTENT_URL, url)");
            return putExtra;
        }

        public final String a(Intent intent) {
            if (intent != null) {
                return intent.getStringExtra("KEY_INTENT_URL");
            }
            return null;
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmbeddedBrowserActivity f19161b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(EmbeddedBrowserActivity embeddedBrowserActivity) {
            super(0);
            this.f19161b = embeddedBrowserActivity;
        }

        /* renamed from: a */
        public final FrameLayout invoke() {
            FrameLayout frameLayout = new FrameLayout(this.f19161b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmbeddedBrowserActivity f19162b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(EmbeddedBrowserActivity embeddedBrowserActivity) {
            super(0);
            this.f19162b = embeddedBrowserActivity;
        }

        /* renamed from: a */
        public final FrameLayout invoke() {
            FrameLayout access$getFrameLayout = this.f19162b.a();
            access$getFrameLayout.addView(this.f19162b.c());
            return access$getFrameLayout;
        }
    }

    public static final class e extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmbeddedBrowserActivity f19163b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(EmbeddedBrowserActivity embeddedBrowserActivity) {
            super(0);
            this.f19163b = embeddedBrowserActivity;
        }

        /* renamed from: a */
        public final WebView invoke() {
            WebView webView = new WebView(this.f19163b);
            EmbeddedBrowserActivity embeddedBrowserActivity = this.f19163b;
            webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            webView.setWebViewClient(new b());
            return webView;
        }
    }

    public final FrameLayout a() {
        return (FrameLayout) this.f19157c.getValue();
    }

    public final View b() {
        return (View) this.f19156b.getValue();
    }

    public final WebView c() {
        return (WebView) this.f19158d.getValue();
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f19155a.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19155a.clearFromStorage(qbVar);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        Unit unit;
        try {
            Result.Companion companion = Result.f40263c;
            super.onCreate(bundle);
            setContentView(b());
            String a2 = Companion.a(getIntent());
            if (a2 != null) {
                c().loadUrl(a2);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                a(this, (Throwable) null, 1, (Object) null);
            }
            obj = Result.b(Unit.f40298a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            a(e2);
        }
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19155a.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f19155a.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f19155a.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19155a.track(qbVar);
    }

    public static /* synthetic */ void a(EmbeddedBrowserActivity embeddedBrowserActivity, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        embeddedBrowserActivity.a(th);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m96clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19155a.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m97persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19155a.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m98refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f19155a.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m99store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f19155a.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m100track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19155a.track(qbVar);
    }

    public final void a(Throwable th) {
        Log.e(t4.f18629a, "Error loading URL into embedded browser", th);
        finish();
    }

    public final class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final List f19159a = CollectionsKt__CollectionsKt.i(-1, -2, -3, -6, -9, -10, -11, -12);

        public b() {
        }

        public final String a(WebResourceError webResourceError) {
            JSONObject jSONObject = new JSONObject();
            Intent intent = EmbeddedBrowserActivity.this.getIntent();
            CharSequence charSequence = null;
            jSONObject.put(ImagesContract.URL, intent != null ? EmbeddedBrowserActivity.Companion.a(intent) : null);
            if (webResourceError != null) {
                charSequence = webResourceError.getDescription();
            }
            if (charSequence == null) {
                charSequence = "";
            } else {
                Intrinsics.e(charSequence, "this@asErrorMessage?.description ?: \"\"");
            }
            jSONObject.put(MRAIDPresenter.ERROR, charSequence);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.e(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
            return jSONObject2;
        }

        public final boolean b(WebResourceError webResourceError) {
            List<Number> list = this.f19159a;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (Number intValue : list) {
                    int intValue2 = intValue.intValue();
                    if (webResourceError != null && intValue2 == webResourceError.getErrorCode()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void c(WebResourceError webResourceError) {
            if (b(webResourceError)) {
                EmbeddedBrowserActivity.this.track((qb) new x4(tb.f.FAILURE, a(webResourceError), (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            String a2 = t4.f18629a;
            Log.e(a2, "onReceivedError: " + webResourceError);
            c(webResourceError);
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            String a2 = t4.f18629a;
            Log.e(a2, "onReceivedHttpError: " + webResourceResponse);
            b(webResourceResponse);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str;
            Context context;
            EmbeddedBrowserActivity embeddedBrowserActivity = EmbeddedBrowserActivity.this;
            tb.b bVar = tb.b.FAILURE;
            if (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) {
                str = "Webview killed, likely due to low memory";
            } else {
                str = "Webview crashed " + renderProcessGoneDetail;
            }
            embeddedBrowserActivity.track((qb) new x4(bVar, str, (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
            Activity activity = null;
            if (webView != null) {
                context = webView.getContext();
            } else {
                context = null;
            }
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            if (activity != null) {
                activity.finish();
            }
            return true;
        }

        public final String a(WebResourceResponse webResourceResponse) {
            JSONObject jSONObject = new JSONObject();
            Intent intent = EmbeddedBrowserActivity.this.getIntent();
            Integer num = null;
            jSONObject.put(ImagesContract.URL, intent != null ? EmbeddedBrowserActivity.Companion.a(intent) : null);
            StringBuilder sb = new StringBuilder();
            sb.append("HTTP status code: ");
            if (webResourceResponse != null) {
                num = Integer.valueOf(webResourceResponse.getStatusCode());
            }
            sb.append(num);
            jSONObject.put(MRAIDPresenter.ERROR, sb.toString());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.e(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
            return jSONObject2;
        }

        public final void b(WebResourceResponse webResourceResponse) {
            EmbeddedBrowserActivity.this.track((qb) new x4(tb.f.FAILURE, a(webResourceResponse), (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
        }
    }
}
