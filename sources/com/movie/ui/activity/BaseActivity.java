package com.movie.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ads.videoreward.AdsManager;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.original.tase.helper.http.HttpHelper;
import com.utils.Utils;
import com.yoku.marumovie.R;
import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {
    @BindView(2131362826)
    protected Toolbar mToolbar;
    protected boolean needToCancelHttpHelper = true;
    Unbinder unbinder;
    private ProgressDialog waitingDialog = null;

    private void setupToolbar() {
        Toolbar toolbar = this.mToolbar;
        if (toolbar == null) {
            Timber.g("Didn't find a toolbar", new Object[0]);
            return;
        }
        ViewCompat.z0(toolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(this.mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(false);
            supportActionBar.y(false);
        }
    }

    public final Toolbar getToolbar() {
        return this.mToolbar;
    }

    public void hideWaitingDialog() {
        ProgressDialog progressDialog = this.waitingDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        AdsManager.d().i(i2, i3, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupComponent(FreeMoviesApp.m(this).l());
        Utils.w0(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Unbinder unbinder2 = this.unbinder;
        if (unbinder2 != null) {
            unbinder2.unbind();
        }
        super.onDestroy();
        if (this.needToCancelHttpHelper) {
            HttpHelper.i().k();
        }
        AdsManager.d().j();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        AdsManager.d().k();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AdsManager.d().l();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        AdsManager.d().m();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        AdsManager.d().n();
    }

    public void setContentView(int i2) {
        super.setContentView(i2);
        this.unbinder = ButterKnife.bind((Activity) this);
        setupToolbar();
    }

    /* access modifiers changed from: protected */
    public abstract void setupComponent(AppComponent appComponent);

    public void shareMyApp() {
        String share_url = GlobalVariable.c().b().getShare_url();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "Cinema");
        intent.putExtra("android.intent.extra.TEXT", "Get the lastest movie/tvShow app at " + share_url);
        startActivity(Intent.createChooser(intent, share_url));
    }

    public AlertDialog showAlertDialog(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder message = new AlertDialog.Builder(this).setTitle(str).setMessage(str2);
        if (onClickListener != null) {
            message.setPositiveButton("OK", onClickListener);
        }
        if (onClickListener2 != null) {
            message.setNegativeButton("No", onClickListener2);
        }
        return message.show();
    }

    public void showWaitingDialog(String str) {
        if (this.waitingDialog == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
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
