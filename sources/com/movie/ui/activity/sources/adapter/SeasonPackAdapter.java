package com.movie.ui.activity.sources.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.movie.data.model.TorrentObject;
import com.original.tase.model.media.MediaSource;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SeasonPackAdapter extends RecyclerView.Adapter<PackViewHolder> implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public List<SeasonPackData> f32893n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public List<SeasonPackData> f32894o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public SeasonPackListener f32895p;

    /* renamed from: q  reason: collision with root package name */
    private int f32896q;

    class PackViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        TextView f32900j;

        /* renamed from: k  reason: collision with root package name */
        TextView f32901k;

        /* renamed from: l  reason: collision with root package name */
        TextView f32902l;

        /* renamed from: m  reason: collision with root package name */
        ImageButton f32903m;

        /* renamed from: n  reason: collision with root package name */
        ImageView f32904n;

        /* renamed from: o  reason: collision with root package name */
        ProgressBar f32905o;

        public PackViewHolder(View view) {
            super(view);
            this.f32900j = (TextView) view.findViewById(R.id.txt_pack_title);
            this.f32901k = (TextView) view.findViewById(R.id.txt_provider);
            this.f32902l = (TextView) view.findViewById(R.id.txtSoprce);
            this.f32904n = (ImageView) view.findViewById(R.id.streamableImg);
            this.f32905o = (ProgressBar) view.findViewById(R.id.downloadingbar);
            this.f32903m = (ImageButton) view.findViewById(R.id.btn_add_maget);
        }

        /* access modifiers changed from: package-private */
        public void a(SeasonPackData seasonPackData) {
            this.f32900j.setText(seasonPackData.b());
            this.f32901k.setText(seasonPackData.c());
            this.f32902l.setText(seasonPackData.e());
            TorrentObject torrentObject = seasonPackData.f32908b;
            if (torrentObject == null) {
                return;
            }
            if (!torrentObject.getListLink().isEmpty() || seasonPackData.a().getMagnetObjects().get(0).isPremiumCached()) {
                this.f32904n.setVisibility(0);
                this.f32905o.setVisibility(4);
                this.f32903m.setVisibility(4);
            } else if (seasonPackData.f32908b.getStatusBean() == null) {
                this.f32904n.setVisibility(4);
                this.f32905o.setVisibility(4);
                this.f32903m.setVisibility(0);
            } else {
                this.f32904n.setVisibility(4);
                this.f32905o.setVisibility(0);
                this.f32903m.setVisibility(4);
            }
        }
    }

    public static class SeasonPackData {

        /* renamed from: a  reason: collision with root package name */
        MediaSource f32907a;

        /* renamed from: b  reason: collision with root package name */
        TorrentObject f32908b;

        public MediaSource a() {
            return this.f32907a;
        }

        public String b() {
            if (this.f32908b.getName() == null || this.f32908b.getName().isEmpty()) {
                return this.f32907a.toString2();
            }
            return this.f32908b.getName();
        }

        public String c() {
            return this.f32907a.getProviderName();
        }

        public TorrentObject d() {
            return this.f32908b;
        }

        public String e() {
            TorrentObject torrentObject = this.f32908b;
            if (torrentObject == null) {
                return "Free";
            }
            return torrentObject.getType().name();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SeasonPackData seasonPackData = (SeasonPackData) obj;
            if (!Objects.equals(this.f32907a, seasonPackData.f32907a) || !Objects.equals(this.f32908b, seasonPackData.f32908b)) {
                return false;
            }
            return true;
        }

        public void f(MediaSource mediaSource) {
            this.f32907a = mediaSource;
        }

        public void g(TorrentObject torrentObject) {
            this.f32908b = torrentObject;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f32907a, this.f32908b});
        }
    }

    public interface SeasonPackListener {
        void l(SeasonPackData seasonPackData);
    }

    public SeasonPackAdapter(List<SeasonPackData> list, SeasonPackListener seasonPackListener, int i2) {
        this.f32893n = list;
        this.f32894o = list;
        this.f32895p = seasonPackListener;
        this.f32896q = i2;
    }

    public void f(SeasonPackData seasonPackData) {
        boolean z2;
        Iterator<SeasonPackData> it2 = this.f32893n.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().equals(seasonPackData)) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2) {
            this.f32893n.add(seasonPackData);
            notifyDataSetChanged();
        }
        getFilter().filter("full episode only");
    }

    /* renamed from: g */
    public void onBindViewHolder(PackViewHolder packViewHolder, int i2) {
        final SeasonPackData seasonPackData = this.f32894o.get(i2);
        packViewHolder.a(seasonPackData);
        packViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SeasonPackAdapter.this.f32895p != null) {
                    SeasonPackAdapter.this.f32895p.l(seasonPackData);
                }
            }
        });
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (charSequence == null || charSequence.length() == 0) {
                    arrayList.addAll(SeasonPackAdapter.this.f32893n);
                } else {
                    charSequence.toString().toLowerCase().trim();
                    for (SeasonPackData add : SeasonPackAdapter.this.f32893n) {
                        arrayList.add(add);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = SeasonPackAdapter.this.f32894o = (List) filterResults.values;
                SeasonPackAdapter.this.notifyDataSetChanged();
            }
        };
    }

    public int getItemCount() {
        List<SeasonPackData> list = this.f32894o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: h */
    public PackViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new PackViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pack_item, viewGroup, false));
    }
}
