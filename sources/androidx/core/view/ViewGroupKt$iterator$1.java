package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private int f2797b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewGroup f2798c;

    ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.f2798c = viewGroup;
    }

    /* renamed from: a */
    public View next() {
        ViewGroup viewGroup = this.f2798c;
        int i2 = this.f2797b;
        this.f2797b = i2 + 1;
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean hasNext() {
        return this.f2797b < this.f2798c.getChildCount();
    }

    public void remove() {
        ViewGroup viewGroup = this.f2798c;
        int i2 = this.f2797b - 1;
        this.f2797b = i2;
        viewGroup.removeViewAt(i2);
    }
}
