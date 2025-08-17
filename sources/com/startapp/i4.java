package com.startapp;

import android.view.View;
import android.widget.AdapterView;
import com.startapp.sdk.ads.list3d.List3DView;

public class i4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List3DView f34686a;

    public i4(List3DView list3DView) {
        this.f34686a = list3DView;
    }

    public void run() {
        int b2;
        List3DView list3DView = this.f34686a;
        if (list3DView.f35973b == 1 && (b2 = list3DView.b(list3DView.f35974c, list3DView.f35975d)) != -1) {
            List3DView list3DView2 = this.f34686a;
            View childAt = list3DView2.getChildAt(b2);
            int i2 = list3DView2.f35980i + b2;
            long itemId = list3DView2.f35972a.getItemId(i2);
            AdapterView.OnItemLongClickListener onItemLongClickListener = list3DView2.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onItemLongClick(list3DView2, childAt, i2, itemId);
            }
        }
    }
}
