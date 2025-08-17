package com.facebook.ads.internal.view.c.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.internal.view.c.a.d;
import com.facebook.ads.internal.view.component.a.a.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f20952a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20953b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.SmoothScroller f20954c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Integer> f20955d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private List<b> f20956e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final com.facebook.ads.internal.r.a f20957f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20958g = true;

    /* renamed from: h  reason: collision with root package name */
    private d.a f20959h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20960i = true;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f20961j = true;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f20962k;

    /* renamed from: l  reason: collision with root package name */
    private final b.e f20963l = new b.e() {

        /* renamed from: b  reason: collision with root package name */
        private float f20967b = 0.0f;

        public float a() {
            return this.f20967b;
        }

        public void a(float f2) {
            this.f20967b = f2;
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private final b.c f20964m = new b.c() {
        public void a(int i2) {
            a.this.a(i2, true);
            if (a.this.f()) {
                a.this.d();
            } else {
                a.this.a(i2);
            }
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private final b.d f20965n = new b.d() {
        public void a(View view) {
            b bVar = (b) view;
            bVar.j();
            if (a.this.f20962k) {
                boolean unused = a.this.f20961j = true;
            }
            if (a.this.f20957f.b() && ((Integer) bVar.getTag(-1593835536)).intValue() == 0) {
                a.this.f20957f.a();
            }
        }

        public void b(View view) {
            if (a.this.f20962k) {
                boolean unused = a.this.f20961j = false;
            }
        }
    };

    a(c cVar, int i2, List<b> list, com.facebook.ads.internal.r.a aVar) {
        this.f20952a = cVar.getLayoutManager();
        this.f20953b = i2;
        this.f20956e = list;
        this.f20957f = aVar;
        this.f20954c = new LinearSmoothScroller(cVar.getContext());
        cVar.addOnScrollListener(this);
    }

    private b a(int i2, int i3) {
        return a(i2, i3, true);
    }

    private b a(int i2, int i3, boolean z2) {
        b bVar = null;
        while (i2 <= i3) {
            b bVar2 = (b) this.f20952a.findViewByPosition(i2);
            if (bVar2.g()) {
                return null;
            }
            boolean a2 = a((View) bVar2);
            if (bVar == null && bVar2.f() && a2 && !this.f20955d.contains(Integer.valueOf(i2)) && (!z2 || b(bVar2))) {
                bVar = bVar2;
            }
            if (bVar2.f() && !a2) {
                a(i2, false);
            }
            i2++;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        b a2 = a(i2 + 1, this.f20952a.findLastVisibleItemPosition(), false);
        if (a2 != null) {
            a2.h();
            b(((Integer) a2.getTag(-1593835536)).intValue());
        }
    }

    private void a(int i2, int i3, int i4) {
        if (f() && this.f20959h != null) {
            int findFirstCompletelyVisibleItemPosition = this.f20952a.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition != -1) {
                i2 = findFirstCompletelyVisibleItemPosition;
            } else if (i4 >= 0) {
                i2 = i3;
            }
            this.f20959h.a(i2);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        if (z2) {
            this.f20955d.add(Integer.valueOf(i2));
        } else {
            this.f20955d.remove(Integer.valueOf(i2));
        }
    }

    private static void a(View view, boolean z2) {
        view.setAlpha(z2 ? 1.0f : 0.5f);
    }

    private void a(b bVar, boolean z2) {
        if (f()) {
            a((View) bVar, z2);
        }
        if (!z2 && bVar.g()) {
            bVar.i();
        }
    }

    private static boolean a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }

    private boolean a(b bVar) {
        if (!this.f20958g || !bVar.f()) {
            return false;
        }
        this.f20958g = false;
        return true;
    }

    private void b(int i2) {
        this.f20954c.setTargetPosition(i2);
        this.f20952a.startSmoothScroll(this.f20954c);
    }

    private void b(int i2, int i3) {
        while (i2 <= i3) {
            c(i2);
            i2++;
        }
    }

    private static boolean b(b bVar) {
        return ((int) (bVar.getX() + ((float) bVar.getWidth()))) <= ((int) (((float) bVar.getWidth()) * 1.3f));
    }

    private void c(int i2) {
        b bVar = (b) this.f20952a.findViewByPosition(i2);
        if (a((View) bVar)) {
            a(bVar, true);
        }
        if (a(bVar)) {
            this.f20963l.a(this.f20956e.get(((Integer) bVar.getTag(-1593835536)).intValue()).c().c().f() ? 1.0f : 0.0f);
        }
    }

    private void c(int i2, int i3) {
        d(i2);
        d(i3);
    }

    /* access modifiers changed from: private */
    public void d() {
        int findFirstCompletelyVisibleItemPosition = this.f20952a.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition != -1 && findFirstCompletelyVisibleItemPosition < this.f20956e.size() - 1) {
            b(findFirstCompletelyVisibleItemPosition + 1);
        }
    }

    private void d(int i2) {
        b bVar = (b) this.f20952a.findViewByPosition(i2);
        if (!a((View) bVar)) {
            a(bVar, false);
        }
    }

    private void e() {
        b a2;
        if (this.f20961j && (a2 = a(this.f20952a.findFirstVisibleItemPosition(), this.f20952a.findLastVisibleItemPosition())) != null) {
            a2.h();
        }
    }

    /* access modifiers changed from: private */
    public boolean f() {
        return this.f20953b == 1;
    }

    public b.e a() {
        return this.f20963l;
    }

    /* access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.f20959h = aVar;
    }

    public b.c b() {
        return this.f20964m;
    }

    public b.d c() {
        return this.f20965n;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
        if (i2 == 0) {
            this.f20962k = true;
            e();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        this.f20962k = false;
        if (this.f20960i) {
            this.f20962k = true;
            e();
            this.f20960i = false;
        }
        int findFirstVisibleItemPosition = this.f20952a.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f20952a.findLastVisibleItemPosition();
        c(findFirstVisibleItemPosition, findLastVisibleItemPosition);
        b(findFirstVisibleItemPosition, findLastVisibleItemPosition);
        a(findFirstVisibleItemPosition, findLastVisibleItemPosition, i2);
    }
}
