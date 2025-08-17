package com.movie.ui.fragment.premium.adapter;

import android.content.Context;
import android.text.format.Formatter;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.movie.data.model.TorrentObject;
import com.movie.ui.adapter.EndlessAdapter;
import com.movie.ui.fragment.premium.TorrentAdapterListFragment;
import com.movie.ui.fragment.premium.viewholder.BaseViewHolder;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TorrentAdapter extends EndlessAdapter<TorrentObject, BaseViewHolder> {

    /* renamed from: t  reason: collision with root package name */
    TorrentAdapterListener f33540t;

    public class RDTorrentViewHolder extends BaseViewHolder implements View.OnCreateContextMenuListener {

        /* renamed from: k  reason: collision with root package name */
        public ProgressBar f33545k;

        /* renamed from: l  reason: collision with root package name */
        public TextView f33546l;

        /* renamed from: m  reason: collision with root package name */
        public TextView f33547m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f33548n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f33549o;

        /* renamed from: p  reason: collision with root package name */
        public ImageButton f33550p;

        /* renamed from: q  reason: collision with root package name */
        public ImageView f33551q;

        public RDTorrentViewHolder(View view) {
            super(view);
            this.f33545k = (ProgressBar) view.findViewById(R.id.pb_percent);
            this.f33546l = (TextView) view.findViewById(R.id.tvStatus);
            this.f33547m = (TextView) view.findViewById(R.id.tvNumPacks);
            this.f33549o = (TextView) view.findViewById(R.id.tvAddedByApp);
            this.f33548n = (TextView) view.findViewById(R.id.tvID);
            this.f33550p = (ImageButton) view.findViewById(R.id.btnPlay);
            this.f33551q = (ImageView) view.findViewById(R.id.imgdelete);
            view.setOnCreateContextMenuListener(this);
        }

        /* access modifiers changed from: protected */
        public void b() {
        }

        public void c(int i2) {
            boolean z2;
            int i3;
            String str;
            String str2;
            int i4;
            super.c(i2);
            final TorrentObject torrentObject = (TorrentObject) TorrentAdapter.this.f33060o.get(i2);
            ProgressBar progressBar = this.f33545k;
            if (torrentObject.getStatusBean().getProgress() == 0 || !torrentObject.isGotDetails()) {
                z2 = true;
            } else {
                z2 = false;
            }
            progressBar.setIndeterminate(z2);
            this.f33545k.setProgress(torrentObject.getStatusBean().getProgress());
            ProgressBar progressBar2 = this.f33545k;
            if (torrentObject.getStatusBean().getProgress() < 100 || !torrentObject.isGotDetails()) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            progressBar2.setVisibility(i3);
            String str3 = "";
            if (torrentObject.getStatusBean().getSeeders() > 0) {
                str = "/ " + torrentObject.getStatusBean().getSeeders() + " seeders";
            } else {
                str = str3;
            }
            if (torrentObject.getStatusBean().getSpeed() > 0) {
                str2 = " / speed : " + Formatter.formatFileSize(Utils.v(), torrentObject.getStatusBean().getSpeed()) + "/s";
            } else {
                str2 = str3;
            }
            TextView textView = this.f33546l;
            StringBuilder sb = new StringBuilder();
            sb.append(torrentObject.getStatusBean().getStatus());
            if (torrentObject.getStatusBean().getProgress() < 100) {
                str3 = str + str2;
            }
            sb.append(str3);
            textView.setText(sb.toString());
            this.f33548n.setText(torrentObject.getName() + " [" + Formatter.formatFileSize(Utils.v(), torrentObject.getSize()) + "]");
            TextView textView2 = this.f33549o;
            if (torrentObject.getTorrentEntity() != null) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            textView2.setVisibility(i4);
            if (torrentObject.getType() == TorrentObject.Type.PM) {
                this.f33547m.setVisibility(0);
                this.f33547m.setText(String.format("%d files", new Object[]{Integer.valueOf(torrentObject.getFiles().size())}));
            } else if (torrentObject.getFiles() == null || torrentObject.getFiles().size() <= 1) {
                this.f33547m.setVisibility(8);
            } else {
                this.f33547m.setVisibility(0);
                this.f33547m.setText(String.format("%d links/%d files", new Object[]{Integer.valueOf(torrentObject.getListLink().size()), Integer.valueOf(torrentObject.getFiles().size())}));
            }
            if (TorrentAdapter.this.f33540t != null) {
                this.f33551q.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TorrentAdapter.this.f33540t.i(torrentObject);
                    }
                });
                if (torrentObject.getStatusBean().getProgress() < 100) {
                    TorrentAdapter.this.f33540t.a(torrentObject, 5);
                } else if (!torrentObject.isGotDetails()) {
                    TorrentAdapter.this.f33540t.a(torrentObject, 0);
                }
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.add(TorrentAdapterListFragment.d0(((TorrentObject) TorrentAdapter.this.f33060o.get(getAdapterPosition())).getType()), 1, getAdapterPosition(), "Delete");
        }
    }

    public interface TorrentAdapterListener {
        void a(TorrentObject torrentObject, int i2);

        void h(TorrentObject torrentObject);

        void i(TorrentObject torrentObject);
    }

    public TorrentAdapter(Context context, List<TorrentObject> list) {
        super(context, list);
    }

    public long getItemId(int i2) {
        if (i(i2)) {
            return -1;
        }
        return (long) ((TorrentObject) f(i2)).getId().hashCode();
    }

    /* access modifiers changed from: protected */
    public RecyclerView.ViewHolder j(ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.ViewHolder k(ViewGroup viewGroup) {
        return new RDTorrentViewHolder(this.f33059n.inflate(R.layout.user_magnet_item, viewGroup, false));
    }

    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i2) {
        if (getItemViewType(i2) == 2) {
            ((RDTorrentViewHolder) viewHolder).c(i2);
        }
        if (this.f33540t != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TorrentAdapter torrentAdapter = TorrentAdapter.this;
                    torrentAdapter.f33540t.h((TorrentObject) torrentAdapter.f(viewHolder.getAdapterPosition()));
                }
            });
        }
    }

    public void p(List<TorrentObject> list) {
        if (!list.isEmpty()) {
            int size = this.f33060o.size();
            int size2 = list.size();
            this.f33060o.addAll(list);
            s(false);
            notifyItemRangeInserted(size, size2);
        }
    }

    public void q(TorrentObject torrentObject) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f33060o.size()) {
                break;
            } else if (((TorrentObject) this.f33060o.get(i2)).getId().equals(torrentObject.getId())) {
                this.f33060o.remove(i2);
                break;
            } else {
                i2++;
            }
        }
        notifyDataSetChanged();
    }

    public void r(TorrentAdapterListener torrentAdapterListener) {
        this.f33540t = torrentAdapterListener;
    }

    public void s(final boolean z2) {
        Collections.sort(this.f33060o, new Comparator<TorrentObject>() {
            /* renamed from: a */
            public int compare(TorrentObject torrentObject, TorrentObject torrentObject2) {
                if (z2) {
                    return torrentObject.getAddedTime().compareToIgnoreCase(torrentObject2.getAddedTime());
                }
                return torrentObject2.getAddedTime().compareToIgnoreCase(torrentObject.getAddedTime());
            }
        });
        notifyDataSetChanged();
    }

    public void t(TorrentObject torrentObject) {
        for (int i2 = 0; i2 < this.f33060o.size(); i2++) {
            if (((TorrentObject) this.f33060o.get(i2)).getId().equals(torrentObject.getId())) {
                this.f33060o.set(i2, torrentObject);
                notifyItemChanged(i2);
                return;
            }
        }
    }
}
