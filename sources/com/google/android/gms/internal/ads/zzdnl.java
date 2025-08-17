package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzas;
import java.util.ArrayList;

public final class zzdnl extends FrameLayout {
    private final zzas zza;

    public zzdnl(Context context, View view, zzas zzas) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zza = zzas;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.zzm(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzcez)) {
                arrayList.add((zzcez) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((zzcez) arrayList.get(i3)).destroy();
        }
    }
}
