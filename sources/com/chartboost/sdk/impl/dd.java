package com.chartboost.sdk.impl;

import android.content.Context;

public interface dd {

    public static final class a {
        public static /* synthetic */ void a(dd ddVar, String str, int i2, boolean z2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                if ((i3 & 2) != 0) {
                    i2 = 0;
                }
                if ((i3 & 4) != 0) {
                    z2 = false;
                }
                ddVar.a(str, i2, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDownloadIfPossible");
        }
    }

    int a(rc rcVar);

    void a(Context context);

    void a(String str, int i2, boolean z2);

    void a(String str, String str2, boolean z2, n0 n0Var);

    boolean a(String str);

    rc b(String str);
}
