package com.startapp;

import android.net.Uri;
import com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig;
import com.startapp.sdk.common.SDKException;

public class u9 {

    /* renamed from: a  reason: collision with root package name */
    public final r9 f36660a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36661b = lb.a();

    public u9(r9 r9Var) {
        this.f36660a = r9Var;
    }

    public void a(String str, String str2, SDKException sDKException) {
        int i2;
        String str3;
        Uri uri;
        long a2 = lb.a();
        r9 r9Var = this.f36660a;
        long j2 = a2 - this.f36661b;
        NetworkDiagnosticConfig a3 = r9Var.a();
        if (a3 != null) {
            if (sDKException == null) {
                str3 = "Success";
                i2 = 4;
            } else if (sDKException.getCause() != null) {
                str3 = "Failure: " + sDKException.getCause().getClass().getName();
                i2 = 2;
            } else {
                str3 = "Error: " + sDKException.a();
                i2 = 1;
            }
            if ((a3.d() & i2) != 0) {
                if (sDKException != null) {
                    uri = sDKException.b();
                } else {
                    uri = null;
                }
                if (uri == null) {
                    uri = Uri.parse(str2).buildUpon().query((String) null).build();
                }
                r9Var.f35774d.execute(new s9(r9Var, str + ' ' + uri, str3, j2));
            }
            if (i2 == 4) {
                r9Var.f35774d.execute(r9Var.f35776f);
            }
        }
    }
}
