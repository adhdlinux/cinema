package com.movie.ui.fragment.premium.adapter;

import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.movie.data.model.TorrentObject;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.ArrayList;

public class FilesTorrentAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

    /* renamed from: n  reason: collision with root package name */
    TorrentObject f33530n;

    /* renamed from: o  reason: collision with root package name */
    TorrentObject f33531o;

    /* renamed from: p  reason: collision with root package name */
    boolean f33532p = true;

    /* renamed from: q  reason: collision with root package name */
    FileTorrentListener f33533q;

    public interface FileTorrentListener {
        void C(TorrentObject.FileBean fileBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        TextView f33537j;

        /* renamed from: k  reason: collision with root package name */
        TextView f33538k;

        public ViewHolder(View view) {
            super(view);
            this.f33537j = (TextView) view.findViewById(R.id.tvID);
            this.f33538k = (TextView) view.findViewById(R.id.tvFileSize);
        }
    }

    public FilesTorrentAdapter(TorrentObject torrentObject) {
        this.f33530n = torrentObject.sort();
        this.f33531o = torrentObject.sort();
    }

    /* renamed from: c */
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        final TorrentObject.FileBean fileBean = this.f33531o.getFiles().get(i2);
        viewHolder.f33537j.setText(fileBean.getName());
        viewHolder.f33538k.setText(Formatter.formatFileSize(Utils.v(), fileBean.getSize()));
        viewHolder.f33537j.setTextColor(-256);
        if (this.f33533q != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FilesTorrentAdapter.this.f33533q.C(fileBean);
                }
            });
        }
    }

    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.file_torrent_item, viewGroup, false));
    }

    public void e(FileTorrentListener fileTorrentListener) {
        this.f33533q = fileTorrentListener;
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                TorrentObject torrentObject = FilesTorrentAdapter.this.f33530n;
                if (charSequence2.isEmpty()) {
                    FilesTorrentAdapter.this.f33531o = torrentObject;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (TorrentObject.FileBean next : torrentObject.getFiles()) {
                        if (next.getName().toLowerCase().contains(charSequence2.toLowerCase())) {
                            arrayList.add(next);
                        }
                    }
                    FilesTorrentAdapter.this.f33531o.setFiles(arrayList);
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = FilesTorrentAdapter.this.f33531o;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                FilesTorrentAdapter filesTorrentAdapter = FilesTorrentAdapter.this;
                filesTorrentAdapter.f33531o = (TorrentObject) filterResults.values;
                filesTorrentAdapter.notifyDataSetChanged();
            }
        };
    }

    public int getItemCount() {
        if (this.f33531o.getFiles() != null) {
            return this.f33531o.getFiles().size();
        }
        return 0;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
