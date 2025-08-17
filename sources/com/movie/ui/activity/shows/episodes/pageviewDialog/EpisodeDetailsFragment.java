package com.movie.ui.activity.shows.episodes.pageviewDialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.movie.AppComponent;
import com.movie.ui.activity.shows.episodes.EpisodeItem;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.yoku.marumovie.R;

public class EpisodeDetailsFragment extends BaseFragment {
    @BindView(2131362021)
    CheckBox checkBox;
    @BindView(2131362053)
    ConstraintLayout content;

    /* renamed from: d  reason: collision with root package name */
    EpisodeItem f32733d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EpisodeListener f32734e;
    @BindView(2131362348)
    ProgressBar loading;
    @BindView(2131362391)
    ImageView mCoverImage;
    @BindView(2131362263)
    ImageButton playbtn;
    @BindView(2131362794)
    TextView textViewEpisodeOverview;
    @BindView(2131362795)
    TextView textViewReleaseTime;
    @BindView(2131362797)
    TextView textViewSource;
    @BindView(2131362796)
    TextView textViewTitle;

    public interface EpisodeListener {
        void l(EpisodeItem episodeItem, boolean z2);

        void r(EpisodeItem episodeItem);
    }

    public static EpisodeDetailsFragment I(EpisodeItem episodeItem) {
        EpisodeDetailsFragment episodeDetailsFragment = new EpisodeDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("episode_tvdbid", episodeItem);
        episodeDetailsFragment.setArguments(bundle);
        return episodeDetailsFragment;
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().v(this);
    }

    public void J(EpisodeListener episodeListener) {
        this.f32734e = episodeListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f32733d = (EpisodeItem) arguments.getParcelable("episode_tvdbid");
            return;
        }
        throw new IllegalArgumentException("Missing arguments");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_episode, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        EpisodeItem episodeItem = (EpisodeItem) getArguments().getParcelable("episode_tvdbid");
        this.f32733d = episodeItem;
        this.textViewTitle.setText(episodeItem.f32696d);
        TextView textView = this.textViewReleaseTime;
        StringBuilder sb = new StringBuilder();
        if (this.f32733d.f32702j) {
            str = "Aired Date : ";
        } else {
            str = "Air Date :";
        }
        sb.append(str);
        sb.append(this.f32733d.f32701i);
        textView.setText(sb.toString());
        TextView textView2 = this.textViewEpisodeOverview;
        textView2.setText("Summary : " + this.f32733d.f32700h);
        TextView textView3 = this.textViewSource;
        textView3.setText("Source : " + this.f32733d.f32703k);
        if (!this.f32733d.f32702j) {
            view.setBackgroundColor(-7829368);
        }
        Glide.u(this).h(this.f32733d.f32699g).a(((RequestOptions) ((RequestOptions) new RequestOptions().R(R.color.movie_cover_placeholder)).h(R.color.list_dropdown_foreground_selected)).c()).x0(new DrawableTransitionOptions().e()).q0(this.mCoverImage);
        this.playbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (EpisodeDetailsFragment.this.f32734e != null) {
                    EpisodeDetailsFragment.this.f32734e.r(EpisodeDetailsFragment.this.f32733d);
                }
            }
        });
        this.checkBox.setChecked(this.f32733d.f32695c.booleanValue());
        this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (EpisodeDetailsFragment.this.f32734e != null) {
                    EpisodeDetailsFragment.this.f32734e.l(EpisodeDetailsFragment.this.f32733d, z2);
                }
            }
        });
        this.content.setVisibility(0);
        this.loading.setVisibility(4);
    }
}
