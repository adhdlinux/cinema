package com.nononsenseapps.filepicker;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;
import com.nononsenseapps.filepicker.AbstractFilePickerFragment;

public class FileItemAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: n  reason: collision with root package name */
    protected final LogicHandler<T> f33725n;

    /* renamed from: o  reason: collision with root package name */
    protected SortedList<T> f33726o = null;

    public FileItemAdapter(LogicHandler<T> logicHandler) {
        this.f33725n = logicHandler;
    }

    public void c(SortedList<T> sortedList) {
        this.f33726o = sortedList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        SortedList<T> sortedList = this.f33726o;
        if (sortedList == null) {
            return 0;
        }
        return sortedList.i() + 1;
    }

    public int getItemViewType(int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = i2 - 1;
        return this.f33725n.c(i3, this.f33726o.g(i3));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (i2 == 0) {
            this.f33725n.u((AbstractFilePickerFragment.HeaderViewHolder) viewHolder);
            return;
        }
        int i3 = i2 - 1;
        this.f33725n.g((AbstractFilePickerFragment.DirViewHolder) viewHolder, i3, this.f33726o.g(i3));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return this.f33725n.k(viewGroup, i2);
    }
}
