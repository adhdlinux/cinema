package com.facebook.ads.internal.view.c.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.internal.adapters.a.g;
import com.facebook.ads.internal.d.b;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.component.a.d;
import java.util.List;

public class d extends RecyclerView.Adapter<g> {

    /* renamed from: a  reason: collision with root package name */
    private final c f20973a;

    /* renamed from: b  reason: collision with root package name */
    private final b f20974b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.r.a f20975c;

    /* renamed from: d  reason: collision with root package name */
    private final u f20976d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.ads.internal.adapters.a.d f20977e;

    /* renamed from: f  reason: collision with root package name */
    private a.C0037a f20978f;

    /* renamed from: g  reason: collision with root package name */
    private int f20979g;

    /* renamed from: h  reason: collision with root package name */
    private int f20980h;

    /* renamed from: i  reason: collision with root package name */
    private String f20981i;

    /* renamed from: j  reason: collision with root package name */
    private int f20982j;

    /* renamed from: k  reason: collision with root package name */
    private int f20983k;

    /* renamed from: l  reason: collision with root package name */
    private List<b> f20984l;

    /* renamed from: m  reason: collision with root package name */
    private final a f20985m;

    public interface a {
        void a(int i2);
    }

    d(List<b> list, c cVar, b bVar, com.facebook.ads.internal.r.a aVar, u uVar, a.C0037a aVar2, com.facebook.ads.internal.adapters.a.d dVar, String str, int i2, int i3, int i4, int i5, a aVar3) {
        this.f20973a = cVar;
        this.f20974b = bVar;
        this.f20975c = aVar;
        this.f20976d = uVar;
        this.f20978f = aVar2;
        this.f20984l = list;
        this.f20980h = i2;
        this.f20977e = dVar;
        this.f20982j = i5;
        this.f20981i = str;
        this.f20979g = i4;
        this.f20983k = i3;
        this.f20985m = aVar3;
    }

    /* renamed from: a */
    public g onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new g(com.facebook.ads.internal.view.component.a.a.c.a(new d.a(viewGroup.getContext(), this.f20973a, this.f20978f, (g) null, (View) null, this.f20975c, this.f20976d).a(), this.f20982j, this.f20977e, this.f20981i, this.f20985m), this.f20975c, this.f20980h, this.f20979g, this.f20983k, this.f20984l.size());
    }

    /* renamed from: a */
    public void onBindViewHolder(g gVar, int i2) {
        gVar.a(this.f20984l.get(i2), this.f20973a, this.f20974b, this.f20976d, this.f20981i, false);
    }

    public int getItemCount() {
        return this.f20984l.size();
    }
}
