package com.movie.ui.adapter;

import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter;
import com.movie.data.model.TorrentObject;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.List;

public class MagnetInfoAdapter extends RecyclerView.Adapter<MagnetHolder> {

    /* renamed from: n  reason: collision with root package name */
    List<TorrentObject> f33072n;

    /* renamed from: o  reason: collision with root package name */
    MagnetInfoListener f33073o;

    public static class MagnetHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        TextView f33078j;

        /* renamed from: k  reason: collision with root package name */
        ImageView f33079k;

        /* renamed from: l  reason: collision with root package name */
        TextView f33080l;

        /* renamed from: m  reason: collision with root package name */
        TextView f33081m;

        /* renamed from: n  reason: collision with root package name */
        TextView f33082n;

        /* renamed from: o  reason: collision with root package name */
        ProgressBar f33083o;

        public MagnetHolder(View view) {
            super(view);
            this.f33078j = (TextView) view.findViewById(R.id.tvID);
            this.f33079k = (ImageView) view.findViewById(R.id.imgdelete);
            this.f33080l = (TextView) view.findViewById(R.id.tvFileSize);
            this.f33082n = (TextView) view.findViewById(R.id.tvStatus);
            this.f33081m = (TextView) view.findViewById(R.id.tvNumberFile);
            this.f33083o = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }

    public interface MagnetInfoListener {
        void B(TorrentObject torrentObject);

        void a(TorrentObject torrentObject, int i2);

        void b(TorrentObject torrentObject);
    }

    public MagnetInfoAdapter(List<TorrentObject> list) {
        this.f33072n = list;
    }

    public void c(TorrentObject torrentObject) {
        this.f33072n.add(torrentObject);
        notifyDataSetChanged();
    }

    public void d(TorrentObject torrentObject) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f33072n.size()) {
                break;
            } else if (this.f33072n.get(i2).getId().equals(torrentObject.getId())) {
                this.f33072n.remove(i2);
                break;
            } else {
                i2++;
            }
        }
        notifyDataSetChanged();
    }

    public List<TorrentObject> e() {
        return this.f33072n;
    }

    /* renamed from: f */
    public void onBindViewHolder(MagnetHolder magnetHolder, int i2) {
        final TorrentObject torrentObject = this.f33072n.get(i2);
        TextView textView = magnetHolder.f33078j;
        textView.setText("[" + TorrentTypeConverter.b(torrentObject.getType()) + "] " + torrentObject.getName());
        magnetHolder.f33080l.setText(Formatter.formatFileSize(Utils.v(), torrentObject.getSize()));
        magnetHolder.f33082n.setText(torrentObject.getStatusBean().getStatus());
        int i3 = 8;
        boolean z2 = true;
        if (torrentObject.getFiles().size() > 1) {
            TextView textView2 = magnetHolder.f33081m;
            textView2.setText(torrentObject.getFiles().size() + " files");
        } else {
            magnetHolder.f33081m.setVisibility(8);
        }
        ProgressBar progressBar = magnetHolder.f33083o;
        if (torrentObject.getStatusBean().getProgress() != 0 && torrentObject.isGotDetails()) {
            z2 = false;
        }
        progressBar.setIndeterminate(z2);
        magnetHolder.f33083o.setProgress(torrentObject.getStatusBean().getProgress());
        ProgressBar progressBar2 = magnetHolder.f33083o;
        if (torrentObject.getStatusBean().getProgress() < 100 || !torrentObject.isGotDetails()) {
            i3 = 0;
        }
        progressBar2.setVisibility(i3);
        if (this.f33073o != null) {
            magnetHolder.f33079k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MagnetInfoListener magnetInfoListener = MagnetInfoAdapter.this.f33073o;
                    if (magnetInfoListener != null) {
                        magnetInfoListener.b(torrentObject);
                    }
                }
            });
            magnetHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MagnetInfoListener magnetInfoListener = MagnetInfoAdapter.this.f33073o;
                    if (magnetInfoListener != null) {
                        magnetInfoListener.B(torrentObject);
                    }
                }
            });
            if (torrentObject.getStatusBean().getProgress() < 100) {
                this.f33073o.a(torrentObject, 5);
            } else if (!torrentObject.isGotDetails()) {
                this.f33073o.a(torrentObject, 0);
            }
        }
    }

    /* renamed from: g */
    public MagnetHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new MagnetHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.magnet_info_item, viewGroup, false));
    }

    public int getItemCount() {
        return this.f33072n.size();
    }

    public void h(MagnetInfoListener magnetInfoListener) {
        this.f33073o = magnetInfoListener;
    }

    public void i(TorrentObject torrentObject) {
        for (int i2 = 0; i2 < this.f33072n.size(); i2++) {
            if (this.f33072n.get(i2).getId().equals(torrentObject.getId())) {
                this.f33072n.set(i2, torrentObject);
                notifyItemChanged(i2);
                return;
            }
        }
    }
}
