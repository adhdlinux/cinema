package com.startapp;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;

public class y3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x3 f36942a;

    public y3(x3 x3Var) {
        this.f36942a = x3Var;
    }

    public void run() {
        long j2 = 1000;
        long uptimeMillis = (((long) this.f36942a.f36721s) * 1000) - SystemClock.uptimeMillis();
        x3 x3Var = this.f36942a;
        long j3 = uptimeMillis + x3Var.B;
        TextView textView = x3Var.P;
        if (textView != null) {
            long j4 = j3 / 1000;
            if (j4 > 0 && j3 % 1000 < 100) {
                j4--;
            }
            textView.setText(String.valueOf(j4));
        }
        if (j3 >= 1000) {
            Handler handler = this.f36942a.T;
            long j5 = j3 % 1000;
            if (j5 != 0) {
                j2 = j5;
            }
            handler.postDelayed(this, j2);
            return;
        }
        x3 x3Var2 = this.f36942a;
        if (x3Var2.P != null) {
            x3Var2.Q.setVisibility(8);
            this.f36942a.P.setVisibility(8);
        }
        this.f36942a.u();
    }
}
