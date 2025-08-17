package com.movie.ui.activity.gamechallenge;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
import com.movie.ui.activity.BaseActivity_ViewBinding;
import com.yoku.marumovie.R;

public class GameChallenge_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private GameChallenge f32227b;

    public GameChallenge_ViewBinding(GameChallenge gameChallenge, View view) {
        super(gameChallenge, view);
        this.f32227b = gameChallenge;
        gameChallenge.rvApllication = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rvApllication, "field 'rvApllication'", RecyclerView.class);
    }

    public void unbind() {
        GameChallenge gameChallenge = this.f32227b;
        if (gameChallenge != null) {
            this.f32227b = null;
            gameChallenge.rvApllication = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
