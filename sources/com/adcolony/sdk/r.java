package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.adcolony.sdk.e0;

class r {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public h0 f13345a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f13346b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f13347c;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (!a.h() || !(a.a() instanceof Activity)) {
                new e0.a().c("Missing Activity reference, can't build AlertDialog.").d(e0.f13114i);
            } else if (c0.t(h0Var.a(), "on_resume")) {
                h0 unused = r.this.f13345a = h0Var;
            } else {
                r.this.e(h0Var);
            }
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f13349b;

        b(h0 h0Var) {
            this.f13349b = h0Var;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            AlertDialog unused = r.this.f13346b = null;
            dialogInterface.dismiss();
            f1 q2 = c0.q();
            c0.w(q2, "positive", true);
            boolean unused2 = r.this.f13347c = false;
            this.f13349b.b(q2).e();
        }
    }

    class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f13351b;

        c(h0 h0Var) {
            this.f13351b = h0Var;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            AlertDialog unused = r.this.f13346b = null;
            dialogInterface.dismiss();
            f1 q2 = c0.q();
            c0.w(q2, "positive", false);
            boolean unused2 = r.this.f13347c = false;
            this.f13351b.b(q2).e();
        }
    }

    class d implements DialogInterface.OnCancelListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f13353b;

        d(h0 h0Var) {
            this.f13353b = h0Var;
        }

        public void onCancel(DialogInterface dialogInterface) {
            AlertDialog unused = r.this.f13346b = null;
            boolean unused2 = r.this.f13347c = false;
            f1 q2 = c0.q();
            c0.w(q2, "positive", false);
            this.f13353b.b(q2).e();
        }
    }

    class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AlertDialog.Builder f13355b;

        e(AlertDialog.Builder builder) {
            this.f13355b = builder;
        }

        public void run() {
            boolean unused = r.this.f13347c = true;
            AlertDialog unused2 = r.this.f13346b = this.f13355b.show();
        }
    }

    r() {
        a.e("Alert.show", new a());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"InlinedApi"})
    public void e(h0 h0Var) {
        Context a2 = a.a();
        if (a2 != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(a2, 16974374);
            f1 a3 = h0Var.a();
            String E = c0.E(a3, "message");
            String E2 = c0.E(a3, "title");
            String E3 = c0.E(a3, "positive");
            String E4 = c0.E(a3, "negative");
            builder.setMessage(E);
            builder.setTitle(E2);
            builder.setPositiveButton(E3, new b(h0Var));
            if (!E4.equals("")) {
                builder.setNegativeButton(E4, new c(h0Var));
            }
            builder.setOnCancelListener(new d(h0Var));
            z0.A(new e(builder));
        }
    }

    /* access modifiers changed from: package-private */
    public AlertDialog a() {
        return this.f13346b;
    }

    /* access modifiers changed from: package-private */
    public void d(AlertDialog alertDialog) {
        this.f13346b = alertDialog;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f13347c;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        h0 h0Var = this.f13345a;
        if (h0Var != null) {
            e(h0Var);
            this.f13345a = null;
        }
    }
}
