package com.chartboost.sdk.impl;

import android.view.View;
import com.chartboost.sdk.impl.t8;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class v8 {

    /* renamed from: a  reason: collision with root package name */
    public final t8.a f18855a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f18856b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18857c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18858d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18859e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18860f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18861g;

    public v8(t8.a aVar, boolean z2) {
        Intrinsics.f(aVar, "sessionHolder");
        this.f18855a = aVar;
        this.f18856b = z2;
    }

    public final void a() {
        Unit unit;
        if (!this.f18856b) {
            String a2 = w8.f18898a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "OMSDK signal impression event OM is disabled by the cb config!");
            return;
        }
        try {
            k b2 = this.f18855a.b();
            if (b2 != null) {
                b2.a();
                String a3 = w8.f18898a;
                Intrinsics.e(a3, "TAG");
                w7.a(a3, "Signal om ad event impression occurred!");
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                String a4 = w8.f18898a;
                Intrinsics.e(a4, "TAG");
                w7.a(a4, "Omid signal impression event is null!");
            }
        } catch (Exception e2) {
            String a5 = w8.f18898a;
            Intrinsics.e(a5, "TAG");
            w7.b(a5, "Error: " + e2);
        }
    }

    public final void b() {
        Unit unit;
        if (!this.f18856b) {
            String a2 = w8.f18898a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "OMSDK signal load OM is disabled by the cb config!");
            return;
        }
        try {
            k b2 = this.f18855a.b();
            if (b2 != null) {
                b2.b();
                String a3 = w8.f18898a;
                Intrinsics.e(a3, "TAG");
                w7.a(a3, "Signal om ad event loaded!");
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                String a4 = w8.f18898a;
                Intrinsics.e(a4, "TAG");
                w7.a(a4, "Omid load event is null!");
            }
        } catch (Exception e2) {
            String a5 = w8.f18898a;
            Intrinsics.e(a5, "TAG");
            w7.b(a5, "Error: " + e2);
        }
    }

    public final void c() {
        try {
            x7 a2 = a("signalMediaBufferFinish");
            if (a2 != null) {
                a2.a();
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void d() {
        try {
            x7 a2 = a("signalMediaBufferStart");
            if (a2 != null) {
                a2.b();
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void e() {
        try {
            x7 a2 = a("signalMediaComplete");
            if (a2 != null) {
                a2.c();
            }
            this.f18860f = true;
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void f() {
        try {
            if (!this.f18857c) {
                String a2 = w8.f18898a;
                Intrinsics.e(a2, "TAG");
                w7.a(a2, "Signal media first quartile");
                x7 a3 = a("signalMediaFirstQuartile");
                if (a3 != null) {
                    a3.d();
                }
                this.f18857c = true;
            }
        } catch (Exception e2) {
            String a4 = w8.f18898a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "Error: " + e2);
        }
    }

    public final void g() {
        try {
            if (!this.f18858d) {
                String a2 = w8.f18898a;
                Intrinsics.e(a2, "TAG");
                w7.a(a2, "Signal media midpoint");
                x7 a3 = a("signalMediaMidpoint");
                if (a3 != null) {
                    a3.e();
                }
                this.f18858d = true;
            }
        } catch (Exception e2) {
            String a4 = w8.f18898a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "Error: " + e2);
        }
    }

    public final void h() {
        try {
            x7 a2 = a("signalMediaPause");
            if (a2 != null) {
                a2.f();
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void i() {
        try {
            x7 a2 = a("signalMediaResume");
            if (a2 != null) {
                a2.g();
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void j() {
        try {
            if (!this.f18861g && !this.f18860f) {
                String a2 = w8.f18898a;
                Intrinsics.e(a2, "TAG");
                w7.a(a2, "Signal media skipped");
                x7 a3 = a("signalMediaSkipped");
                if (a3 != null) {
                    a3.h();
                }
                this.f18861g = true;
            }
        } catch (Exception e2) {
            String a4 = w8.f18898a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "Error: " + e2);
        }
    }

    public final void k() {
        try {
            if (!this.f18859e) {
                String a2 = w8.f18898a;
                Intrinsics.e(a2, "TAG");
                w7.a(a2, "Signal media third quartile");
                x7 a3 = a("signalMediaThirdQuartile");
                if (a3 != null) {
                    a3.i();
                }
                this.f18859e = true;
            }
        } catch (Exception e2) {
            String a4 = w8.f18898a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "Error: " + e2);
        }
    }

    public final void l() {
        try {
            x7 a2 = a("signalUserInteractionClick");
            if (a2 != null) {
                a2.a(s7.CLICK);
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void m() {
        Unit unit;
        if (!this.f18856b) {
            String a2 = w8.f18898a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "OMSDK start session OM is disabled by the cb config!");
            return;
        }
        try {
            p c2 = this.f18855a.c();
            if (c2 != null) {
                c2.b();
                String a3 = w8.f18898a;
                Intrinsics.e(a3, "TAG");
                w7.a(a3, "Omid session started successfully! Version: " + l8.a());
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                String a4 = w8.f18898a;
                Intrinsics.e(a4, "TAG");
                w7.a(a4, "Omid start session is null!");
            }
        } catch (Exception e2) {
            String a5 = w8.f18898a;
            Intrinsics.e(a5, "TAG");
            w7.b(a5, "Error: " + e2);
        }
    }

    public final void n() {
        if (!this.f18856b) {
            String a2 = w8.f18898a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "OMSDK stop session OM is disabled by the cb config!");
            return;
        }
        try {
            p c2 = this.f18855a.c();
            if (c2 != null) {
                c2.a();
                c2.a((View) null);
            }
            l8.c();
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Omid session finished!");
        } catch (Exception e2) {
            String a4 = w8.f18898a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "OMSDK stop session exception: " + e2);
        } catch (Throwable th) {
            this.f18855a.a((p) null);
            this.f18855a.a((k) null);
            throw th;
        }
        this.f18855a.a((p) null);
        this.f18855a.a((k) null);
    }

    public final void a(View view) {
        Intrinsics.f(view, "obstructionView");
        p c2 = this.f18855a.c();
        if (c2 != null) {
            c2.a(view, x5.OTHER, "Industry Icon");
        }
    }

    public final void a(float f2, float f3) {
        this.f18857c = false;
        this.f18858d = false;
        this.f18859e = false;
        try {
            x7 a2 = a("signalMediaStart" + " duration: " + f2 + " and volume " + f3);
            if (a2 != null) {
                a2.a(f2, f3);
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void a(float f2) {
        try {
            x7 a2 = a("signalMediaVolumeChange" + " volume: " + f2);
            if (a2 != null) {
                a2.c(f2);
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final void a(f9 f9Var) {
        Intrinsics.f(f9Var, "playerState");
        try {
            x7 a2 = a("signalMediaStateChange" + " state: " + f9Var.name());
            if (a2 != null) {
                a2.a(f9Var);
            }
        } catch (Exception e2) {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Error: " + e2);
        }
    }

    public final x7 a(String str) {
        if (this.f18855a.a() == null) {
            String a2 = w8.f18898a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "MediaEvents are null when executing " + str);
        } else {
            String a3 = w8.f18898a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "MediaEvents valid when executing: " + str);
        }
        return this.f18855a.a();
    }
}
