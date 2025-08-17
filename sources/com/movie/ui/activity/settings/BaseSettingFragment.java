package com.movie.ui.activity.settings;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.yoku.marumovie.R;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseSettingFragment extends PreferenceFragmentCompat {
    protected CompositeDisposable compositeDisposable;
    private ProgressDialog waitingDialog = null;

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    /* access modifiers changed from: protected */
    public SharedPreferences getSharedPreference() {
        return getPreferenceManager().j();
    }

    public void hideWaitingDialog() {
        ProgressDialog progressDialog = this.waitingDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        this.compositeDisposable = new CompositeDisposable();
        super.onCreate(bundle);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.r("hdmovies");
        preferenceManager.q(0);
    }

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView onCreateRecyclerView = super.onCreateRecyclerView(layoutInflater, viewGroup, bundle);
        onCreateRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        return onCreateRecyclerView;
    }

    public void onDestroy() {
        this.compositeDisposable.dispose();
        super.onDestroy();
    }

    public void showWaitingDialog(int i2) {
        showWaitingDialog(getActivity().getString(i2));
    }

    public void showWaitingDialog(String str) {
        if (this.waitingDialog == null) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.waitingDialog = progressDialog;
            try {
                progressDialog.show();
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        this.waitingDialog.setCancelable(true);
        this.waitingDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.waitingDialog.setContentView(R.layout.progressbar);
        TextView textView = (TextView) this.waitingDialog.findViewById(R.id.tv_title);
        if (!str.isEmpty()) {
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        this.waitingDialog.show();
    }
}
