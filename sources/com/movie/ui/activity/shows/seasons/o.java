package com.movie.ui.activity.shows.seasons;

import androidx.palette.graphics.Palette;
import com.movie.ui.activity.shows.seasons.SeasonRecyclerViewAdapter;
import com.movie.ui.widget.glidepalette.BitmapPalette;

public final /* synthetic */ class o implements BitmapPalette.CallBack {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SeasonRecyclerViewAdapter.ViewHolder f32842a;

    public /* synthetic */ o(SeasonRecyclerViewAdapter.ViewHolder viewHolder) {
        this.f32842a = viewHolder;
    }

    public final void a(Palette palette) {
        SeasonRecyclerViewAdapter.g(this.f32842a, palette);
    }
}
