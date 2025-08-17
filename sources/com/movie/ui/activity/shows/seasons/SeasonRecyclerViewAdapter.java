package com.movie.ui.activity.shows.seasons;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.database.entitys.SeasonEntity;
import com.database.entitys.TvWatchedEpisode;
import com.movie.FreeMoviesApp;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.activity.shows.seasons.SeasonFragment;
import com.movie.ui.widget.glidepalette.GlidePalette;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SeasonRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: n  reason: collision with root package name */
    private List<SeasonEntity> f32802n;

    /* renamed from: o  reason: collision with root package name */
    private List<TvWatchedEpisode> f32803o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<EpisodeItem> f32804p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final SeasonFragment.OnListFragmentInteractionListener f32805q;

    /* renamed from: r  reason: collision with root package name */
    private Context f32806r;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        /* renamed from: j  reason: collision with root package name */
        public final View f32809j;

        /* renamed from: k  reason: collision with root package name */
        public SeasonEntity f32810k;

        /* renamed from: l  reason: collision with root package name */
        public ImageView f32811l;

        /* renamed from: m  reason: collision with root package name */
        public TextView f32812m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f32813n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f32814o;

        /* renamed from: p  reason: collision with root package name */
        public TextView f32815p;

        /* renamed from: q  reason: collision with root package name */
        public ProgressBar f32816q;

        /* renamed from: r  reason: collision with root package name */
        public TextView f32817r;

        /* renamed from: s  reason: collision with root package name */
        public FrameLayout f32818s;

        public ViewHolder(View view) {
            super(view);
            this.f32809j = view;
            this.f32811l = (ImageView) view.findViewById(R.id.movie_poster);
            this.f32812m = (TextView) view.findViewById(R.id.movie_title);
            this.f32813n = (TextView) view.findViewById(R.id.tvOverview);
            this.f32814o = (TextView) view.findViewById(R.id.tvOverviewExpand);
            this.f32815p = (TextView) view.findViewById(R.id.movie_release_date);
            this.f32816q = (ProgressBar) view.findViewById(R.id.progressBar2);
            this.f32817r = (TextView) view.findViewById(R.id.textView7);
            this.f32818s = (FrameLayout) view.findViewById(R.id.background);
            view.setOnCreateContextMenuListener(this);
        }

        public void a(String str) {
            this.f32813n.setText(str);
            int height = this.f32813n.getHeight();
            int scrollY = this.f32813n.getScrollY();
            Layout layout = this.f32813n.getLayout();
            if (layout != null) {
                layout.getLineForVertical(scrollY);
                int i2 = scrollY + height;
                int lineForVertical = layout.getLineForVertical(i2);
                if (layout.getLineBottom(lineForVertical) > i2) {
                    lineForVertical--;
                }
                String charSequence = this.f32813n.getText().toString();
                int lineEnd = this.f32813n.getLayout().getLineEnd(Math.min(lineForVertical - 1, layout.getLineCount() - 1));
                if (lineEnd >= charSequence.length() - 1 || layout.getLineBottom(layout.getLineCount() - 1) <= height) {
                    this.f32813n.setGravity(51);
                    this.f32814o.setVisibility(8);
                    return;
                }
                String substring = charSequence.substring(0, lineEnd);
                if (substring.endsWith(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
                    substring = substring.substring(0, substring.length() - 1);
                }
                this.f32813n.setText(substring);
                this.f32813n.setGravity(83);
                this.f32814o.setVisibility(0);
                this.f32814o.setText(charSequence.substring(lineEnd, charSequence.length() - 1));
                return;
            }
            this.f32813n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ViewHolder.this.f32813n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ViewHolder.this.f32813n.post(new Runnable() {
                        public void run() {
                            int height = ViewHolder.this.f32813n.getHeight();
                            int scrollY = ViewHolder.this.f32813n.getScrollY();
                            Layout layout = ViewHolder.this.f32813n.getLayout();
                            int absoluteAdapterPosition = ViewHolder.this.getAbsoluteAdapterPosition();
                            if (layout != null && absoluteAdapterPosition > 0 && layout.getLineCount() > absoluteAdapterPosition) {
                                layout.getLineForVertical(scrollY);
                                int i2 = scrollY + height;
                                int lineForVertical = layout.getLineForVertical(i2);
                                if (layout.getLineBottom(lineForVertical) > i2) {
                                    lineForVertical--;
                                }
                                String charSequence = ViewHolder.this.f32813n.getText().toString();
                                int lineEnd = ViewHolder.this.f32813n.getLayout().getLineEnd(Math.min(lineForVertical - 1, layout.getLineCount() - 1));
                                if (lineEnd >= charSequence.length() - 1 || layout.getLineBottom(layout.getLineCount() - 1) <= height) {
                                    ViewHolder.this.f32813n.setGravity(51);
                                    ViewHolder.this.f32814o.setVisibility(8);
                                    return;
                                }
                                String substring = charSequence.substring(0, lineEnd);
                                if (substring.endsWith(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
                                    substring = substring.substring(0, substring.length() - 1);
                                }
                                ViewHolder.this.f32813n.setText(substring);
                                ViewHolder.this.f32813n.setGravity(83);
                                ViewHolder.this.f32814o.setVisibility(0);
                                ViewHolder.this.f32814o.setText(charSequence.substring(lineEnd, charSequence.length() - 1));
                            }
                        }
                    });
                }
            });
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            boolean z2 = false;
            contextMenu.add(getAdapterPosition(), 121, 0, "Add all to watched list");
            contextMenu.add(getAdapterPosition(), 122, 1, "Remove all from watched list");
            MenuItem add = contextMenu.add(getAdapterPosition(), 124, 2, "Load season packs");
            if (RealDebridCredentialsHelper.d().isValid() || AllDebridCredentialsHelper.b().isValid() || PremiumizeCredentialsHelper.b().isValid()) {
                z2 = true;
            }
            add.setVisible(z2);
        }

        public String toString() {
            return super.toString() + " '" + this.f32810k.g() + "'";
        }
    }

    public SeasonRecyclerViewAdapter(List<SeasonEntity> list, List<TvWatchedEpisode> list2, SeasonFragment.OnListFragmentInteractionListener onListFragmentInteractionListener) {
        this.f32802n = list;
        this.f32803o = list2;
        this.f32805q = onListFragmentInteractionListener;
    }

    private List<TvWatchedEpisode> f(List<TvWatchedEpisode> list, int i2) {
        ArrayList arrayList = new ArrayList();
        for (TvWatchedEpisode next : list) {
            if (next.f() == i2) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(ViewHolder viewHolder, Palette palette) {
        if (palette != null && palette.f() != null) {
            viewHolder.f32818s.setBackgroundColor(palette.f().e());
        }
    }

    public int getItemCount() {
        return this.f32802n.size();
    }

    /* renamed from: h */
    public void onBindViewHolder(final ViewHolder viewHolder, int i2) {
        viewHolder.f32810k = this.f32802n.get(i2);
        viewHolder.f32809j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SeasonRecyclerViewAdapter.this.f32805q == null) {
                    return;
                }
                if (SeasonRecyclerViewAdapter.this.f32804p != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = SeasonRecyclerViewAdapter.this.f32804p.iterator();
                    while (it2.hasNext()) {
                        EpisodeItem episodeItem = (EpisodeItem) it2.next();
                        if (episodeItem.f32704l.intValue() == viewHolder.f32810k.j()) {
                            arrayList.add(episodeItem);
                        }
                    }
                    SeasonRecyclerViewAdapter.this.f32805q.c(viewHolder.f32810k, arrayList);
                    return;
                }
                SeasonRecyclerViewAdapter.this.f32805q.c(viewHolder.f32810k, (ArrayList<EpisodeItem>) null);
            }
        });
        RequestBuilder<Drawable> x02 = Glide.t(this.f32806r).h(viewHolder.f32810k.i()).a(((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).c()).x0(new DrawableTransitionOptions().e());
        boolean z2 = FreeMoviesApp.p().getBoolean("pref_change_bg_color", true);
        if (!FreeMoviesApp.s() && z2) {
            x02 = x02.s0(GlidePalette.h(viewHolder.f32810k.i()).g(new o(viewHolder)));
        }
        x02.q0(viewHolder.f32811l);
        viewHolder.f32812m.setText(viewHolder.f32810k.g());
        viewHolder.a(viewHolder.f32810k.h());
        viewHolder.f32815p.setText(Utils.F(viewHolder.f32810k.c()));
        List<TvWatchedEpisode> f2 = f(this.f32803o, viewHolder.f32810k.j());
        viewHolder.f32816q.setProgress(Double.valueOf(((((double) f2.size()) * 1.0d) / ((double) viewHolder.f32810k.d())) * 100.0d).intValue());
        TextView textView = viewHolder.f32817r;
        textView.setText(f2.size() + "/" + viewHolder.f32810k.d() + " watched");
    }

    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.session_item, viewGroup, false);
        this.f32806r = viewGroup.getContext();
        return new ViewHolder(inflate);
    }

    public void j(ArrayList<EpisodeItem> arrayList) {
        this.f32804p = arrayList;
    }

    public void k(List<SeasonEntity> list) {
        this.f32802n = list;
    }

    public void l(List<TvWatchedEpisode> list) {
        this.f32803o = list;
    }

    public SeasonRecyclerViewAdapter(List<SeasonEntity> list, List<TvWatchedEpisode> list2, ArrayList<EpisodeItem> arrayList, SeasonFragment.OnListFragmentInteractionListener onListFragmentInteractionListener) {
        this.f32802n = list;
        this.f32803o = list2;
        this.f32804p = arrayList;
        this.f32805q = onListFragmentInteractionListener;
    }
}
