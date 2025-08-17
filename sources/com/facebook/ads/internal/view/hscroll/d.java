package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class d extends RecyclerView implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    protected final int f21606a = a();

    /* renamed from: b  reason: collision with root package name */
    protected int f21607b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f21608c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21609d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21610e = false;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayoutManager f21611f;

    /* renamed from: g  reason: collision with root package name */
    private a f21612g;

    public interface a {
        int a(int i2);
    }

    public d(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnTouchListener(this);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOnTouchListener(this);
    }

    private int a() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    private int a(int i2) {
        int i3 = this.f21608c - i2;
        int a2 = this.f21612g.a(i3);
        int i4 = this.f21606a;
        return i3 > i4 ? a(this.f21607b, a2) : i3 < (-i4) ? b(this.f21607b, a2) : this.f21607b;
    }

    private int a(int i2, int i3) {
        return Math.min(i2 + i3, getItemCount() - 1);
    }

    private int b(int i2, int i3) {
        return Math.max(i2 - i3, 0);
    }

    private int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getItemCount();
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z2) {
        if (getAdapter() != null) {
            this.f21607b = i2;
            if (z2) {
                smoothScrollToPosition(i2);
            } else {
                scrollToPosition(i2);
            }
        }
    }

    public int getCurrentPosition() {
        return this.f21607b;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.f21610e) {
                a(a(rawX), true);
            }
            this.f21609d = true;
            this.f21610e = false;
            return true;
        }
        if (actionMasked == 0 || actionMasked == 5 || (this.f21609d && actionMasked == 2)) {
            this.f21608c = rawX;
            if (this.f21609d) {
                this.f21609d = false;
            }
            this.f21610e = true;
        }
        return false;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            super.setLayoutManager(layoutManager);
            this.f21611f = (LinearLayoutManager) layoutManager;
            return;
        }
        throw new IllegalArgumentException("SnapRecyclerView only supports LinearLayoutManager");
    }

    public void setSnapDelegate(a aVar) {
        this.f21612g = aVar;
    }
}
