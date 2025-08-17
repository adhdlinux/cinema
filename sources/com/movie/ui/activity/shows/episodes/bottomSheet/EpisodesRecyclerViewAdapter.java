package com.movie.ui.activity.shows.episodes.bottomSheet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.database.entitys.SeasonEntity;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.activity.shows.episodes.bottomSheet.EpisodeBottomSheetFragment;
import com.yoku.marumovie.R;
import java.util.List;

public class EpisodesRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: n  reason: collision with root package name */
    private final List<EpisodeItem> f32718n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final EpisodeBottomSheetFragment.OnListFragmentInteractionListener f32719o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public SeasonEntity f32720p;

    /* renamed from: q  reason: collision with root package name */
    private Context f32721q;

    /* renamed from: r  reason: collision with root package name */
    private Fragment f32722r;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        /* renamed from: j  reason: collision with root package name */
        public final View f32725j;

        /* renamed from: k  reason: collision with root package name */
        public CheckBox f32726k;

        /* renamed from: l  reason: collision with root package name */
        public EpisodeItem f32727l;

        public ViewHolder(View view) {
            super(view);
            this.f32725j = view;
            view.setOnCreateContextMenuListener(this);
            this.f32726k = (CheckBox) view.findViewById(R.id.watched);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            MenuItem add = contextMenu.add(1, 123, 2, "Add to watched list");
            MenuItem add2 = contextMenu.add(1, 124, 3, "Remove from Favourite");
            add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    EpisodeBottomSheetFragment.OnListFragmentInteractionListener c2 = EpisodesRecyclerViewAdapter.this.f32719o;
                    ViewHolder viewHolder = ViewHolder.this;
                    c2.a(viewHolder.f32725j, EpisodesRecyclerViewAdapter.this.f32720p.j(), ViewHolder.this.f32727l.f32694b.intValue());
                    ViewHolder.this.f32726k.setChecked(true);
                    return true;
                }
            });
            add2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    EpisodeBottomSheetFragment.OnListFragmentInteractionListener c2 = EpisodesRecyclerViewAdapter.this.f32719o;
                    ViewHolder viewHolder = ViewHolder.this;
                    c2.b(viewHolder.f32725j, EpisodesRecyclerViewAdapter.this.f32720p.j(), ViewHolder.this.f32727l.f32694b.intValue());
                    ViewHolder.this.f32726k.setChecked(false);
                    return true;
                }
            });
        }

        public String toString() {
            return super.toString() + " '" + this.f32727l.f32696d + "'";
        }
    }

    public EpisodesRecyclerViewAdapter(Fragment fragment, List<EpisodeItem> list, EpisodeBottomSheetFragment.OnListFragmentInteractionListener onListFragmentInteractionListener, SeasonEntity seasonEntity) {
        this.f32718n = list;
        this.f32719o = onListFragmentInteractionListener;
        this.f32720p = seasonEntity;
        this.f32722r = fragment;
    }

    /* renamed from: e */
    public void onBindViewHolder(final ViewHolder viewHolder, int i2) {
        EpisodeItem episodeItem = this.f32718n.get(i2);
        TextView textView = (TextView) viewHolder.f32725j.findViewById(R.id.tvTabTitle);
        if (episodeItem.f32696d != null) {
            textView.setText(String.format("%02d. ", new Object[]{episodeItem.f32694b}) + episodeItem.f32696d);
        } else {
            textView.setText(String.format("Episode %02d", new Object[]{episodeItem.f32694b}));
        }
        TextView textView2 = (TextView) viewHolder.f32725j.findViewById(R.id.tvOverviewExpand);
        String str = episodeItem.f32700h;
        if (str != null) {
            textView2.setText(str);
        } else {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) viewHolder.f32725j.findViewById(R.id.tvAiredDate);
        String str2 = episodeItem.f32701i;
        if (str2 != null) {
            textView3.setText(str2);
        } else {
            textView3.setVisibility(8);
        }
        ImageView imageView = (ImageView) viewHolder.f32725j.findViewById(R.id.epi_cover);
        imageView.setImageDrawable((Drawable) null);
        Glide.u(this.f32722r).h(episodeItem.f32699g).a(((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).c()).x0(new DrawableTransitionOptions().e()).q0(imageView);
        ((CheckBox) viewHolder.f32725j.findViewById(R.id.watched)).setChecked(episodeItem.f32695c.booleanValue());
        if (!episodeItem.f32702j) {
            textView.setTextColor(-7829368);
            textView2.setTextColor(-7829368);
        }
        viewHolder.f32727l = episodeItem;
        viewHolder.f32725j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (EpisodesRecyclerViewAdapter.this.f32719o != null) {
                    EpisodesRecyclerViewAdapter.this.f32719o.u(viewHolder.f32727l, EpisodesRecyclerViewAdapter.this.f32720p);
                }
            }
        });
    }

    /* renamed from: f */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.episode_item, viewGroup, false);
        this.f32721q = viewGroup.getContext();
        return new ViewHolder(inflate);
    }

    public int getItemCount() {
        return this.f32718n.size();
    }
}
