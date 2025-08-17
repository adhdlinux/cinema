package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPager2 f11998a;

    /* renamed from: b  reason: collision with root package name */
    private final ScrollEventAdapter f11999b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f12000c;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f11998a = viewPager2;
        this.f11999b = scrollEventAdapter;
        this.f12000c = recyclerView;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f11999b.j();
    }
}
