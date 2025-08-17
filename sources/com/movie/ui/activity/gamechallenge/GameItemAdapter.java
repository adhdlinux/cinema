package com.movie.ui.activity.gamechallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.List;

public class GameItemAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: n  reason: collision with root package name */
    private List<PromotionAppModel> f32228n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public GameAdapterListener f32229o;

    /* renamed from: p  reason: collision with root package name */
    Context f32230p;

    interface GameAdapterListener {
        void d(PromotionAppModel promotionAppModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        ImageView f32233j;

        /* renamed from: k  reason: collision with root package name */
        ImageButton f32234k;

        /* renamed from: l  reason: collision with root package name */
        TextView f32235l;

        /* renamed from: m  reason: collision with root package name */
        TextView f32236m;

        public ViewHolder(View view) {
            super(view);
            this.f32233j = (ImageView) view.findViewById(R.id.imgIcon);
            this.f32234k = (ImageButton) view.findViewById(R.id.btnAction);
            this.f32235l = (TextView) view.findViewById(R.id.txtName);
            this.f32236m = (TextView) view.findViewById(R.id.txtDescription);
        }
    }

    public static GameItemAdapter d(List<PromotionAppModel> list, Context context) {
        GameItemAdapter gameItemAdapter = new GameItemAdapter();
        gameItemAdapter.f32228n = list;
        gameItemAdapter.f32230p = context;
        return gameItemAdapter;
    }

    /* renamed from: e */
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        final PromotionAppModel promotionAppModel = this.f32228n.get(i2);
        viewHolder.f32235l.setText(promotionAppModel.d());
        viewHolder.f32236m.setText(promotionAppModel.a());
        if (promotionAppModel.b() != null) {
            viewHolder.f32233j.setImageDrawable(promotionAppModel.b());
        } else if (!promotionAppModel.c().isEmpty()) {
            Glide.t(this.f32230p).h(promotionAppModel.c()).a(((RequestOptions) ((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).h(R.color.list_dropdown_foreground_selected)).c()).x0(new DrawableTransitionOptions().e()).q0(viewHolder.f32233j);
        }
        if (Utils.m0(promotionAppModel.e())) {
            viewHolder.f32234k.setImageDrawable(this.f32230p.getResources().getDrawable(R.drawable.ic_play_circle_filled_black_48dp));
        } else {
            viewHolder.f32234k.setImageDrawable(this.f32230p.getResources().getDrawable(R.drawable.ic_download));
        }
        if (this.f32229o != null) {
            viewHolder.f32234k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GameItemAdapter.this.f32229o.d(promotionAppModel);
                }
            });
        }
    }

    /* renamed from: f */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item, viewGroup, false));
    }

    public void g(GameAdapterListener gameAdapterListener) {
        this.f32229o = gameAdapterListener;
    }

    public int getItemCount() {
        return this.f32228n.size();
    }

    public void h(List<PromotionAppModel> list) {
        this.f32228n = list;
    }
}
