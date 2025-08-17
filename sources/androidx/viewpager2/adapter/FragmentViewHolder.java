package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(FrameLayout frameLayout) {
        super(frameLayout);
    }

    static FragmentViewHolder a(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(ViewCompat.m());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    /* access modifiers changed from: package-private */
    public FrameLayout b() {
        return (FrameLayout) this.itemView;
    }
}
