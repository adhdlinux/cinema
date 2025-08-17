package com.facebook.ads.internal.view.f;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.b.m;
import com.facebook.ads.internal.view.f.b.n;
import com.facebook.ads.internal.view.f.b.p;
import com.facebook.ads.internal.view.f.b.r;
import com.facebook.ads.internal.view.f.b.s;
import com.facebook.ads.internal.view.f.b.v;
import com.facebook.ads.internal.view.f.b.w;
import com.facebook.ads.internal.view.f.b.x;
import com.facebook.ads.internal.view.f.b.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public int f21262a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final w f21263b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final f<r> f21264c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final f<h> f21265d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final f<j> f21266e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final f<n> f21267f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final f<com.facebook.ads.internal.view.f.b.b> f21268g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final f<p> f21269h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final f<x> f21270i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final f<y> f21271j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final f<s> f21272k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final m f21273l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final a f21274m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f21275n;

    public b(Context context, c cVar, a aVar, String str) {
        this(context, cVar, aVar, (List<com.facebook.ads.internal.b.b>) new ArrayList(), str);
    }

    public b(Context context, c cVar, a aVar, String str, Bundle bundle) {
        this(context, cVar, aVar, new ArrayList(), str, bundle, (Map<String, String>) null);
    }

    public b(Context context, c cVar, a aVar, String str, Map<String, String> map) {
        this(context, cVar, aVar, new ArrayList(), str, (Bundle) null, map);
    }

    public b(Context context, c cVar, a aVar, List<com.facebook.ads.internal.b.b> list, String str) {
        super(context, cVar, aVar, list, str);
        AnonymousClass1 r10 = new w() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21276a = true;

            public void a(v vVar) {
                if (f21276a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        bVar.e();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
        };
        this.f21263b = r10;
        AnonymousClass5 r11 = new f<r>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21284a = true;

            public Class<r> a() {
                return r.class;
            }

            public void a(r rVar) {
                if (f21284a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        bVar.f();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
        };
        this.f21264c = r11;
        AnonymousClass6 r13 = new f<h>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21286a = true;

            public Class<h> a() {
                return h.class;
            }

            public void a(h hVar) {
                if (f21286a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        bVar.h();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
        };
        this.f21265d = r13;
        AnonymousClass7 r14 = new f<j>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21288a = true;

            public Class<j> a() {
                return j.class;
            }

            public void a(j jVar) {
                if (f21288a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        if (!bVar.f21275n) {
                            boolean unused = b.this.f21275n = true;
                        } else {
                            b.this.i();
                        }
                    }
                } else {
                    throw new AssertionError();
                }
            }
        };
        this.f21266e = r14;
        AnonymousClass8 r02 = new f<n>() {
            public Class<n> a() {
                return n.class;
            }

            public void a(n nVar) {
                int a2 = nVar.a();
                b bVar = b.this;
                if (bVar.f21262a <= 0 || a2 != bVar.f21274m.getDuration() || b.this.f21274m.getDuration() <= b.this.f21262a) {
                    b.this.a(a2);
                }
            }
        };
        this.f21267f = r02;
        AnonymousClass9 r12 = new f<com.facebook.ads.internal.view.f.b.b>() {
            public Class<com.facebook.ads.internal.view.f.b.b> a() {
                return com.facebook.ads.internal.view.f.b.b.class;
            }

            public void a(com.facebook.ads.internal.view.f.b.b bVar) {
                int a2 = bVar.a();
                int b2 = bVar.b();
                b bVar2 = b.this;
                int i2 = bVar2.f21262a;
                if (i2 > 0 && a2 == b2 && b2 > i2) {
                    return;
                }
                if (b2 >= a2 + 500) {
                    bVar2.b(a2);
                } else if (b2 == 0) {
                    bVar2.b(i2);
                } else {
                    bVar2.b(b2);
                }
            }
        };
        this.f21268g = r12;
        AnonymousClass10 r2 = new f<p>() {
            public Class<p> a() {
                return p.class;
            }

            public void a(p pVar) {
                b.this.a(pVar.a(), pVar.b());
            }
        };
        this.f21269h = r2;
        AnonymousClass11 r3 = new f<x>() {
            public Class<x> a() {
                return x.class;
            }

            public void a(x xVar) {
                b.this.b();
            }
        };
        this.f21270i = r3;
        AnonymousClass12 r4 = new f<y>() {
            public Class<y> a() {
                return y.class;
            }

            public void a(y yVar) {
                b.this.c();
            }
        };
        this.f21271j = r4;
        AnonymousClass2 r5 = new f<s>() {
            public Class<s> a() {
                return s.class;
            }

            public void a(s sVar) {
                b bVar = b.this;
                bVar.a(bVar.j(), b.this.j());
            }
        };
        this.f21272k = r5;
        AnonymousClass3 r6 = new m() {
            public void a(l lVar) {
                b bVar = b.this;
                bVar.f21262a = bVar.f21274m.getDuration();
            }
        };
        this.f21273l = r6;
        this.f21275n = false;
        this.f21274m = aVar;
        aVar.getEventBus().a((T[]) new f[]{r10, r02, r11, r14, r13, r12, r2, r3, r4, r6, r5});
    }

    public b(Context context, c cVar, a aVar, List<com.facebook.ads.internal.b.b> list, String str, Bundle bundle, Map<String, String> map) {
        super(context, cVar, aVar, list, str, bundle, map);
        AnonymousClass1 r7 = new w() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21276a = true;

            public void a(v vVar) {
                if (f21276a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        bVar.e();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
        };
        this.f21263b = r7;
        AnonymousClass5 r8 = new f<r>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21284a = true;

            public Class<r> a() {
                return r.class;
            }

            public void a(r rVar) {
                if (f21284a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        bVar.f();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
        };
        this.f21264c = r8;
        AnonymousClass6 r10 = new f<h>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21286a = true;

            public Class<h> a() {
                return h.class;
            }

            public void a(h hVar) {
                if (f21286a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        bVar.h();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
        };
        this.f21265d = r10;
        AnonymousClass7 r11 = new f<j>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f21288a = true;

            public Class<j> a() {
                return j.class;
            }

            public void a(j jVar) {
                if (f21288a || b.this != null) {
                    b bVar = b.this;
                    if (bVar != null) {
                        if (!bVar.f21275n) {
                            boolean unused = b.this.f21275n = true;
                        } else {
                            b.this.i();
                        }
                    }
                } else {
                    throw new AssertionError();
                }
            }
        };
        this.f21266e = r11;
        AnonymousClass8 r12 = new f<n>() {
            public Class<n> a() {
                return n.class;
            }

            public void a(n nVar) {
                int a2 = nVar.a();
                b bVar = b.this;
                if (bVar.f21262a <= 0 || a2 != bVar.f21274m.getDuration() || b.this.f21274m.getDuration() <= b.this.f21262a) {
                    b.this.a(a2);
                }
            }
        };
        this.f21267f = r12;
        AnonymousClass9 r13 = new f<com.facebook.ads.internal.view.f.b.b>() {
            public Class<com.facebook.ads.internal.view.f.b.b> a() {
                return com.facebook.ads.internal.view.f.b.b.class;
            }

            public void a(com.facebook.ads.internal.view.f.b.b bVar) {
                int a2 = bVar.a();
                int b2 = bVar.b();
                b bVar2 = b.this;
                int i2 = bVar2.f21262a;
                if (i2 > 0 && a2 == b2 && b2 > i2) {
                    return;
                }
                if (b2 >= a2 + 500) {
                    bVar2.b(a2);
                } else if (b2 == 0) {
                    bVar2.b(i2);
                } else {
                    bVar2.b(b2);
                }
            }
        };
        this.f21268g = r13;
        AnonymousClass10 r02 = new f<p>() {
            public Class<p> a() {
                return p.class;
            }

            public void a(p pVar) {
                b.this.a(pVar.a(), pVar.b());
            }
        };
        this.f21269h = r02;
        AnonymousClass11 r14 = new f<x>() {
            public Class<x> a() {
                return x.class;
            }

            public void a(x xVar) {
                b.this.b();
            }
        };
        this.f21270i = r14;
        AnonymousClass12 r2 = new f<y>() {
            public Class<y> a() {
                return y.class;
            }

            public void a(y yVar) {
                b.this.c();
            }
        };
        this.f21271j = r2;
        AnonymousClass2 r3 = new f<s>() {
            public Class<s> a() {
                return s.class;
            }

            public void a(s sVar) {
                b bVar = b.this;
                bVar.a(bVar.j(), b.this.j());
            }
        };
        this.f21272k = r3;
        this.f21273l = new m() {
            public void a(l lVar) {
                b bVar = b.this;
                bVar.f21262a = bVar.f21274m.getDuration();
            }
        };
        this.f21275n = false;
        this.f21274m = aVar;
        aVar.getEventBus().a((T[]) new f[]{r7, r12, r8, r11, r10, r13, r02, r14, r2, r3});
    }

    public void a() {
        this.f21274m.getStateHandler().post(new Runnable() {
            public void run() {
                b.this.f21274m.getEventBus().b((T[]) new f[]{b.this.f21263b, b.this.f21267f, b.this.f21264c, b.this.f21266e, b.this.f21265d, b.this.f21268g, b.this.f21269h, b.this.f21270i, b.this.f21271j, b.this.f21273l, b.this.f21272k});
            }
        });
    }
}
