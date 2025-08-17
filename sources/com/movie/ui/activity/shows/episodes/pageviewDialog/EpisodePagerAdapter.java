package com.movie.ui.activity.shows.episodes.pageviewDialog;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.activity.shows.episodes.pageviewDialog.EpisodeDetailsFragment;
import java.util.List;

class EpisodePagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: j  reason: collision with root package name */
    private final List<EpisodeItem> f32738j;

    /* renamed from: k  reason: collision with root package name */
    private final Context f32739k;

    /* renamed from: l  reason: collision with root package name */
    EpisodeDetailsFragment.EpisodeListener f32740l;

    /* renamed from: m  reason: collision with root package name */
    private int f32741m;

    EpisodePagerAdapter(Context context, FragmentManager fragmentManager, List<EpisodeItem> list, int i2) {
        super(fragmentManager);
        this.f32739k = context;
        this.f32738j = list;
        this.f32741m = i2;
    }

    public Fragment a(int i2) {
        EpisodeDetailsFragment I = EpisodeDetailsFragment.I(this.f32738j.get(i2));
        I.J(this.f32740l);
        return I;
    }

    public void b(EpisodeDetailsFragment.EpisodeListener episodeListener) {
        this.f32740l = episodeListener;
    }

    public int getCount() {
        return this.f32738j.size();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public CharSequence getPageTitle(int i2) {
        String str;
        EpisodeItem episodeItem = this.f32738j.get(i2);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f32741m);
        sb.append("x");
        sb.append(episodeItem.f32694b);
        if (episodeItem.f32695c.booleanValue()) {
            str = "(*)";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
