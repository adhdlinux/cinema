package com.applovin.mediation.nativeAds.adPlacer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.applovin.impl.mediation.b.a.c;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.Collection;

public class MaxRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MaxAdPlacer.Listener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MaxAdPlacer f16031a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView.Adapter f16032b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16033c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f16034d;

    /* renamed from: e  reason: collision with root package name */
    private c f16035e;

    /* renamed from: f  reason: collision with root package name */
    private MaxAdPlacer.Listener f16036f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f16037g = 8;

    public static class MaxAdRecyclerViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f16039a;

        public MaxAdRecyclerViewHolder(View view) {
            super(view);
            this.f16039a = (ViewGroup) view.findViewById(R.id.native_ad_view_container);
        }

        public ViewGroup getContainerView() {
            return this.f16039a;
        }
    }

    private class a extends RecyclerView.AdapterDataObserver {
        private a() {
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public void onChanged() {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i2, int i3) {
            int adjustedPosition = MaxRecyclerAdapter.this.f16031a.getAdjustedPosition(i2);
            MaxRecyclerAdapter.this.notifyItemRangeChanged(adjustedPosition, (MaxRecyclerAdapter.this.f16031a.getAdjustedPosition((i2 + i3) - 1) - adjustedPosition) + 1);
        }

        public void onItemRangeInserted(int i2, int i3) {
            int adjustedPosition = MaxRecyclerAdapter.this.f16031a.getAdjustedPosition(i2);
            for (int i4 = 0; i4 < i3; i4++) {
                MaxRecyclerAdapter.this.f16031a.insertItem(adjustedPosition);
            }
            MaxRecyclerAdapter.this.notifyItemRangeInserted(adjustedPosition, i3);
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public void onItemRangeMoved(int i2, int i3, int i4) {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeRemoved(int i2, int i3) {
            int adjustedPosition = MaxRecyclerAdapter.this.f16031a.getAdjustedPosition(i2);
            int itemCount = MaxRecyclerAdapter.this.f16032b.getItemCount();
            int adjustedCount = MaxRecyclerAdapter.this.f16031a.getAdjustedCount(itemCount + i3);
            for (int i4 = 0; i4 < i3; i4++) {
                MaxRecyclerAdapter.this.f16031a.removeItem(adjustedPosition);
            }
            int adjustedCount2 = MaxRecyclerAdapter.this.f16031a.getAdjustedCount(itemCount);
            int i5 = adjustedCount - adjustedCount2;
            Collection<Integer> clearTrailingAds = MaxRecyclerAdapter.this.f16031a.clearTrailingAds(adjustedCount2 - 1);
            if (!clearTrailingAds.isEmpty()) {
                i5 += clearTrailingAds.size();
            }
            MaxRecyclerAdapter.this.notifyItemRangeRemoved(adjustedPosition - (i5 - i3), i5);
        }
    }

    public MaxRecyclerAdapter(MaxAdPlacerSettings maxAdPlacerSettings, RecyclerView.Adapter adapter, Activity activity) {
        a aVar = new a();
        this.f16033c = aVar;
        MaxAdPlacer maxAdPlacer = new MaxAdPlacer(maxAdPlacerSettings, activity);
        this.f16031a = maxAdPlacer;
        maxAdPlacer.setListener(this);
        super.setHasStableIds(adapter.hasStableIds());
        this.f16032b = adapter;
        adapter.registerAdapterDataObserver(aVar);
    }

    private int a(int i2) {
        int pxToDp = AppLovinSdkUtils.pxToDp(this.f16034d.getContext(), this.f16034d.getWidth());
        RecyclerView.LayoutManager layoutManager = this.f16034d.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            return layoutManager instanceof StaggeredGridLayoutManager ? pxToDp / ((StaggeredGridLayoutManager) layoutManager).A() : pxToDp;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        return (pxToDp / gridLayoutManager.k()) * gridLayoutManager.o().f(i2);
    }

    public void destroy() {
        try {
            this.f16032b.unregisterAdapterDataObserver(this.f16033c);
        } catch (Exception unused) {
        }
        this.f16031a.destroy();
        c cVar = this.f16035e;
        if (cVar != null) {
            cVar.a();
        }
    }

    public MaxAdPlacer getAdPlacer() {
        return this.f16031a;
    }

    public int getAdjustedPosition(int i2) {
        return this.f16031a.getAdjustedPosition(i2);
    }

    public int getItemCount() {
        return this.f16031a.getAdjustedCount(this.f16032b.getItemCount());
    }

    public long getItemId(int i2) {
        if (!this.f16032b.hasStableIds()) {
            return -1;
        }
        return this.f16031a.isFilledPosition(i2) ? this.f16031a.getAdItemId(i2) : this.f16032b.getItemId(this.f16031a.getOriginalPosition(i2));
    }

    public int getItemViewType(int i2) {
        if (this.f16031a.isAdPosition(i2)) {
            return -42;
        }
        return this.f16032b.getItemViewType(this.f16031a.getOriginalPosition(i2));
    }

    public int getOriginalPosition(int i2) {
        return this.f16031a.getOriginalPosition(i2);
    }

    public void loadAds() {
        this.f16031a.loadAds();
    }

    public void onAdClicked(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f16036f;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    public void onAdLoaded(int i2) {
        notifyItemChanged(i2);
        MaxAdPlacer.Listener listener = this.f16036f;
        if (listener != null) {
            listener.onAdLoaded(i2);
        }
    }

    public void onAdRemoved(int i2) {
        MaxAdPlacer.Listener listener = this.f16036f;
        if (listener != null) {
            listener.onAdRemoved(i2);
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f16036f;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f16034d = recyclerView;
        c cVar = new c(recyclerView);
        this.f16035e = cVar;
        cVar.a((c.a) new c.a() {
            public void a(int i2, int i3) {
                MaxRecyclerAdapter.this.f16031a.updateFillablePositions(i2, Math.min(i3 + MaxRecyclerAdapter.this.f16037g, MaxRecyclerAdapter.this.getItemCount() - 1));
            }
        });
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        this.f16035e.a(viewHolder.itemView, i2);
        if (this.f16031a.isAdPosition(i2)) {
            AppLovinSdkUtils.Size adSize = this.f16031a.getAdSize(i2, a(i2));
            ViewGroup containerView = ((MaxAdRecyclerViewHolder) viewHolder).getContainerView();
            ViewGroup.LayoutParams layoutParams = containerView.getLayoutParams();
            if (adSize != AppLovinSdkUtils.Size.ZERO) {
                layoutParams.width = adSize.getWidth() < 0 ? adSize.getWidth() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getWidth());
                layoutParams.height = adSize.getHeight() < 0 ? adSize.getHeight() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getHeight());
                containerView.setLayoutParams(layoutParams);
                this.f16031a.renderAd(i2, containerView);
                return;
            }
            layoutParams.width = -2;
            layoutParams.height = -2;
            containerView.setLayoutParams(layoutParams);
            return;
        }
        this.f16032b.onBindViewHolder(viewHolder, this.f16031a.getOriginalPosition(i2));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != -42) {
            return this.f16032b.onCreateViewHolder(viewGroup, i2);
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.max_native_ad_recycler_view_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        RecyclerView.LayoutManager layoutManager = this.f16034d.getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            layoutParams.width = -1;
            layoutParams.height = -2;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        inflate.setLayoutParams(layoutParams);
        return new MaxAdRecyclerViewHolder(inflate);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f16034d = null;
        c cVar = this.f16035e;
        if (cVar != null) {
            cVar.a();
            this.f16035e = null;
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return viewHolder instanceof MaxAdRecyclerViewHolder ? super.onFailedToRecycleView(viewHolder) : this.f16032b.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            super.onViewAttachedToWindow(viewHolder);
        } else {
            this.f16032b.onViewAttachedToWindow(viewHolder);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
        } else {
            this.f16032b.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        c cVar = this.f16035e;
        if (cVar != null) {
            cVar.a(viewHolder.itemView);
        }
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            if (this.f16031a.isFilledPosition(viewHolder.getBindingAdapterPosition())) {
                ((MaxAdRecyclerViewHolder) viewHolder).getContainerView().removeAllViews();
            }
            super.onViewRecycled(viewHolder);
            return;
        }
        this.f16032b.onViewRecycled(viewHolder);
    }

    public void setHasStableIds(boolean z2) {
        super.setHasStableIds(z2);
        this.f16032b.unregisterAdapterDataObserver(this.f16033c);
        this.f16032b.setHasStableIds(z2);
        this.f16032b.registerAdapterDataObserver(this.f16033c);
    }

    public void setListener(MaxAdPlacer.Listener listener) {
        this.f16036f = listener;
    }

    public void setLookAhead(int i2) {
        this.f16037g = i2;
    }
}
