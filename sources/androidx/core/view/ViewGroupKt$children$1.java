package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.sequences.Sequence;

public final class ViewGroupKt$children$1 implements Sequence<View> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f2789a;

    ViewGroupKt$children$1(ViewGroup viewGroup) {
        this.f2789a = viewGroup;
    }

    public Iterator<View> iterator() {
        return ViewGroupKt.c(this.f2789a);
    }
}
