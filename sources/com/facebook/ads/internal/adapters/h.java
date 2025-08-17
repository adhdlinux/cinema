package com.facebook.ads.internal.adapters;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.g;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.view.b.d;
import com.facebook.ads.internal.view.b.e;
import com.facebook.ads.internal.view.c;
import com.facebook.ads.internal.view.hscroll.b;
import com.facebook.ads.internal.view.l;
import com.facebook.ads.internal.view.s;
import java.util.List;

public class h extends RecyclerView.Adapter<c> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f19808a = Color.argb(51, 0, 0, 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a.C0035a f19809b = new a.C0035a() {
        public void a() {
            if (h.this.f19813f != null) {
                h.this.f19813f.a();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final List<f> f19810c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19811d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19812e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f19813f;

    public interface a {
        void a();
    }

    public h(b bVar, List<f> list) {
        float f2 = bVar.getContext().getResources().getDisplayMetrics().density;
        this.f19810c = list;
        this.f19811d = Math.round(f2 * 1.0f);
        this.f19812e = bVar.getChildSpacing();
    }

    /* renamed from: a */
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new c(new l(viewGroup.getContext()));
    }

    public void a(a aVar) {
        this.f19813f = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, final int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i3 = this.f19812e;
        if (i2 == 0) {
            i3 *= 2;
        }
        marginLayoutParams.setMargins(i3, 0, i2 >= this.f19810c.size() + -1 ? this.f19812e * 2 : this.f19812e, 0);
        l lVar = (l) cVar.f20944a;
        lVar.setLayoutParams(marginLayoutParams);
        int i4 = this.f19811d;
        lVar.setPadding(i4, i4, i4, i4);
        final s sVar = (s) lVar.getAdContentsView();
        x.a((View) sVar, 0);
        sVar.setImageDrawable((Drawable) null);
        final f fVar = this.f19810c.get(i2);
        fVar.a((View) lVar, (g) lVar);
        com.facebook.ads.internal.n.h k2 = fVar.k();
        if (k2 != null) {
            d a2 = new d((ImageView) sVar).a();
            a2.a((e) new e() {
                public void a(boolean z2) {
                    if (i2 == 0) {
                        fVar.a(h.this.f19809b);
                    }
                    fVar.a(z2, true);
                    x.a((View) sVar, h.f19808a);
                }
            });
            a2.a(k2.a());
        }
    }

    public int getItemCount() {
        return this.f19810c.size();
    }
}
