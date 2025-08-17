package com.facebook.ads.internal.view.c.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.view.component.a.a.b;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.Map;

class g extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final b f21014a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21015b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21016c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21017d;

    /* renamed from: e  reason: collision with root package name */
    private final int f21018e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f21019f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f21020g;

    /* renamed from: h  reason: collision with root package name */
    private a.C0035a f21021h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f21022i;

    g(b bVar, a aVar, int i2, int i3, int i4, int i5) {
        super(bVar);
        this.f21014a = bVar;
        this.f21022i = aVar;
        this.f21015b = i2;
        this.f21016c = i3;
        this.f21017d = i4;
        this.f21018e = i5;
    }

    private String a(com.facebook.ads.internal.d.b bVar, String str) {
        String b2 = (bVar == null || str == null) ? "" : bVar.b(str);
        return !TextUtils.isEmpty(b2) ? b2 : str;
    }

    private void a(c cVar, u uVar, String str, final b bVar) {
        if (!this.f21019f) {
            a aVar = this.f21020g;
            if (aVar != null) {
                aVar.c();
                this.f21020g = null;
            }
            final Map<String, String> a2 = bVar.a();
            final String str2 = str;
            final u uVar2 = uVar;
            final c cVar2 = cVar;
            this.f21021h = new a.C0035a() {
                public void a() {
                    if (!g.this.f21022i.b() && !TextUtils.isEmpty(str2)) {
                        if (g.this.f21020g != null) {
                            g.this.f21020g.a((Map<String, String>) a2);
                        }
                        a2.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(uVar2.e()));
                        cVar2.a(str2, a2);
                    }
                    boolean unused = g.this.f21019f = true;
                }
            };
            a aVar2 = new a(this.f21014a, 10, this.f21021h);
            this.f21020g = aVar2;
            aVar2.a(100);
            this.f21020g.b(100);
            this.f21014a.setOnAssetsLoadedListener(new b.a() {
                public void a() {
                    if (bVar.b() == 0) {
                        g.this.f21022i.a();
                    }
                    g.this.f21020g.a();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, c cVar, com.facebook.ads.internal.d.b bVar2, u uVar, String str, boolean z2) {
        int b2 = bVar.b();
        this.f21014a.setTag(-1593835536, Integer.valueOf(b2));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.f21015b, -2);
        marginLayoutParams.setMargins(b2 == 0 ? this.f21016c : this.f21017d, 0, b2 >= this.f21018e + -1 ? this.f21016c : this.f21017d, 0);
        String g2 = bVar.c().c().g();
        String a2 = bVar.c().c().a();
        this.f21014a.setIsVideo(!TextUtils.isEmpty(a2));
        if (this.f21014a.f()) {
            this.f21014a.setVideoPlaceholderUrl(g2);
            this.f21014a.setVideoUrl(a(bVar2, a2));
            if (z2) {
                this.f21014a.h();
            }
        } else {
            this.f21014a.setImageUrl(g2);
        }
        this.f21014a.setLayoutParams(marginLayoutParams);
        this.f21014a.a(bVar.c().a().a(), bVar.c().a().c());
        this.f21014a.a(bVar.c().b().b(), bVar.c().b().a(), bVar.a());
        this.f21014a.a(bVar.a());
        a(cVar, uVar, str, bVar);
    }
}
