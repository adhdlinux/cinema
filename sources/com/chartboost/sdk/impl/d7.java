package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public interface d7 {

    public static final class a {
        public static CBError.CBImpressionError a(d7 d7Var, String str) {
            Intrinsics.f(str, MRAIDPresenter.ERROR);
            return CBError.CBImpressionError.INTERNAL;
        }
    }

    String C();

    void D();

    void a(float f2);

    void a(float f2, float f3);

    void a(g9 g9Var);

    void a(oc ocVar);

    void a(x2 x2Var);

    void a(List list);

    void a(boolean z2, String str);

    void b();

    void b(float f2);

    void b(x2 x2Var);

    CBError.CBImpressionError c(String str);

    void c(x2 x2Var);

    void d(x2 x2Var);

    void d(String str);

    void e(String str);

    void f();

    void g();

    String i();

    void j();

    void k();

    String l();

    void m();

    String n();

    void o();

    void t();

    void u();

    String w();

    String x();

    void z();
}
