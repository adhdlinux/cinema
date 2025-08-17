package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;

public final class zzcey extends WebChromeClient {
    private final zzcez zza;

    public zzcey(zzcez zzcez) {
        this.zza = zzcez;
    }

    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcez)) {
            return webView.getContext();
        }
        zzcez zzcez = (zzcez) webView;
        Activity zzi = zzcez.zzi();
        if (zzi != null) {
            return zzi;
        }
        return zzcez.getContext();
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcez)) {
            zzbzr.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzl zzL = ((zzcez) webView).zzL();
        if (zzL == null) {
            zzbzr.zzj("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzL.zzb();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i2 = zzcex.zza[consoleMessage.messageLevel().ordinal()];
        if (i2 == 1) {
            zzbzr.zzg(str);
        } else if (i2 == 2) {
            zzbzr.zzj(str);
        } else if (i2 == 3 || i2 == 4) {
            zzbzr.zzi(str);
        } else if (i2 != 5) {
            zzbzr.zzi(str);
        } else {
            zzbzr.zze(str);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z2, boolean z3, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzH() != null) {
            webView2.setWebViewClient(this.zza.zzH());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        long j5 = 5242880 - j4;
        if (j5 <= 0) {
            quotaUpdater.updateQuota(j2);
            return;
        }
        if (j2 == 0) {
            if (j3 > j5 || j3 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                j3 = 0;
            }
        } else if (j3 == 0) {
            j3 = Math.min(j2 + Math.min(131072, j5), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } else {
            if (j3 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j2, j5)) {
                j2 += j3;
            }
            j3 = j2;
        }
        quotaUpdater.updateQuota(j3);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z2;
        if (callback != null) {
            zzt.zzp();
            if (!zzs.zzw(this.zza.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzt.zzp();
                if (!zzs.zzw(this.zza.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z2 = false;
                    callback.invoke(str, z2, true);
                }
            }
            z2 = true;
            callback.invoke(str, z2, true);
        }
    }

    public final void onHideCustomView() {
        zzl zzL = this.zza.zzL();
        if (zzL == null) {
            zzbzr.zzj("Could not get ad overlay when hiding custom view.");
        } else {
            zzL.zzg();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        zzl zzL = this.zza.zzL();
        if (zzL == null) {
            zzbzr.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzL.zzC(view, customViewCallback);
        zzL.zzA(i2);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z2) {
        zzb zzd;
        try {
            zzcez zzcez = this.zza;
            if (zzcez == null || zzcez.zzN() == null || this.zza.zzN().zzd() == null || (zzd = this.zza.zzN().zzd()) == null || zzd.zzc()) {
                zzt.zzp();
                AlertDialog.Builder zzG = zzs.zzG(context);
                zzG.setTitle(str2);
                if (z2) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    zzG.setView(linearLayout).setPositiveButton(17039370, new zzcew(jsPromptResult, editText)).setNegativeButton(17039360, new zzcev(jsPromptResult)).setOnCancelListener(new zzceu(jsPromptResult)).create().show();
                } else {
                    zzG.setMessage(str3).setPositiveButton(17039370, new zzcet(jsResult)).setNegativeButton(17039360, new zzces(jsResult)).setOnCancelListener(new zzcer(jsResult)).create().show();
                }
                return true;
            }
            zzd.zzb("window." + str + "('" + str3 + "')");
            return false;
        } catch (WindowManager.BadTokenException e2) {
            zzbzr.zzk("Fail to display Dialog.", e2);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
