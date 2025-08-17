package com.movie.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.original.tase.helper.http.HttpHelper;
import com.utils.Utils;

public abstract class BaseFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f33225b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f33226c = true;

    /* access modifiers changed from: protected */
    public abstract void F(AppComponent appComponent);

    /* access modifiers changed from: protected */
    public void G(String str) {
        Utils.i0(getActivity(), str);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            F(FreeMoviesApp.m((Activity) context).l());
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        Unbinder unbinder = this.f33225b;
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (this.f33226c) {
            HttpHelper.i().k();
        }
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f33225b = ButterKnife.bind((Object) this, view);
    }
}
