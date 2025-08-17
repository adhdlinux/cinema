package com.movie.ui.listener;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    /* renamed from: o  reason: collision with root package name */
    private int f33637o;

    /* renamed from: p  reason: collision with root package name */
    private int f33638p;

    /* renamed from: q  reason: collision with root package name */
    private int f33639q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f33640r;

    /* renamed from: s  reason: collision with root package name */
    private int f33641s;

    /* renamed from: t  reason: collision with root package name */
    private OnLoadMoreCallback f33642t;

    public interface OnLoadMoreCallback {
        void z(int i2, int i3);
    }

    public EndlessScrollListener() {
        this.f33637o = 5;
        this.f33638p = 0;
        this.f33639q = 0;
        this.f33640r = true;
        this.f33641s = 0;
    }

    public static EndlessScrollListener a(final LinearLayoutManager linearLayoutManager, int i2, int i3) {
        return new EndlessScrollListener(i2, i3) {
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                if (i3 >= 0) {
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    e(findFirstVisibleItemPosition, linearLayoutManager.findLastVisibleItemPosition() - findFirstVisibleItemPosition, linearLayoutManager.getItemCount());
                }
            }
        };
    }

    public void d(int i2, int i3) {
        OnLoadMoreCallback onLoadMoreCallback = this.f33642t;
        if (onLoadMoreCallback != null) {
            onLoadMoreCallback.z(i2, i3);
        }
    }

    public void e(int i2, int i3, int i4) {
        if (i4 < this.f33639q) {
            this.f33638p = this.f33641s;
            this.f33639q = i4;
            if (i4 == 0) {
                this.f33640r = true;
            }
        }
        if (this.f33640r && i4 > this.f33639q) {
            this.f33640r = false;
            this.f33639q = i4;
            this.f33638p++;
        }
        if ((!this.f33640r && i4 - i3 <= i2 + this.f33637o) || i3 <= 0) {
            d(this.f33638p + 1, i4);
            this.f33640r = true;
        }
    }

    public EndlessScrollListener f(OnLoadMoreCallback onLoadMoreCallback) {
        this.f33642t = onLoadMoreCallback;
        return this;
    }

    public EndlessScrollListener(int i2, int i3) {
        this.f33639q = 0;
        this.f33640r = true;
        this.f33637o = i2;
        this.f33641s = i3;
        this.f33638p = i3;
    }
}
