package com.applovin.impl.sdk.a;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.ScriptInjector;
import com.iab.omid.library.applovin.adsession.Partner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f15025a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f15026b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f15027c;

    public f(m mVar) {
        this.f15025a = mVar;
        this.f15026b = mVar.L();
    }

    public String a(String str) {
        try {
            return ScriptInjector.injectScriptContentIntoHtml(this.f15027c, str);
        } catch (Throwable th) {
            if (v.a()) {
                this.f15025a.A().b("OpenMeasurementService", "Failed to inject JavaScript SDK into HTML", th);
            }
            return str;
        }
    }

    public void a() {
        if (((Boolean) this.f15025a.a(b.aq)).booleanValue()) {
            if (v.a()) {
                v A = this.f15025a.A();
                A.b("OpenMeasurementService", "Initializing Open Measurement SDK v" + c() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    Omid.activate(f.this.f15026b);
                    if (v.a()) {
                        v A = f.this.f15025a.A();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Init ");
                        sb.append(f.this.b() ? "succeeded" : "failed");
                        sb.append(" and took ");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append("ms");
                        A.b("OpenMeasurementService", sb.toString());
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f.this.f15026b.getResources().openRawResource(R.raw.omsdk_v_1_0)));
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb2.append(readLine);
                                } else {
                                    String unused = f.this.f15027c = sb2.toString();
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e2) {
                                        Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e2);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e3);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (v.a()) {
                            f.this.f15025a.A().b("OpenMeasurementService", "Failed to retrieve resource omskd_v_1_0.js", th2);
                        }
                    }
                }
            });
        }
    }

    public boolean b() {
        return Omid.isActive();
    }

    public String c() {
        return Omid.getVersion();
    }

    public Partner d() {
        return Partner.createPartner((String) this.f15025a.a(b.ar), AppLovinSdk.VERSION);
    }

    public String e() {
        return this.f15027c;
    }
}
