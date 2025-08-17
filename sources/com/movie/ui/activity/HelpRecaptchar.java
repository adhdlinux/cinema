package com.movie.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.movie.AppComponent;
import com.movie.data.model.ItemHelpCaptcha;
import com.movie.ui.adapter.HelpRecaptchaViewAdapter;
import com.original.tase.RxBus;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;

public class HelpRecaptchar extends BaseActivity implements HelpRecaptchaViewAdapter.ItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public HelpRecaptchaViewAdapter f32026b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f32027c = null;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ItemHelpCaptcha> f32028d;

    class C51191 implements Consumer<Object> {

        /* renamed from: b  reason: collision with root package name */
        final HelpRecaptchar f32030b;

        C51191(HelpRecaptchar helpRecaptchar) {
            this.f32030b = helpRecaptchar;
        }

        public void accept(Object obj) {
            if (obj instanceof ItemHelpCaptcha) {
                this.f32030b.E((ItemHelpCaptcha) obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void B(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        finish();
    }

    public void E(ItemHelpCaptcha itemHelpCaptcha) {
        Iterator<ItemHelpCaptcha> it2 = this.f32028d.iterator();
        int i2 = -1;
        while (it2.hasNext()) {
            ItemHelpCaptcha next = it2.next();
            if (next.getLink().equals(itemHelpCaptcha.getLink()) && next.getProviderName().equals(itemHelpCaptcha.getProviderName())) {
                i2 = this.f32028d.indexOf(next);
                this.f32026b.notifyItemRemoved(i2);
            }
        }
        if (i2 != -1) {
            this.f32028d.remove(i2);
        }
    }

    public void n(View view, ItemHelpCaptcha itemHelpCaptcha) {
        Intent intent = new Intent(Utils.v(), RecaptchaWebViewActivity.class);
        intent.putExtra(ImagesContract.URL, itemHelpCaptcha.getLink());
        intent.putExtra("providername", itemHelpCaptcha.getProviderName());
        startActivityForResult(intent, 5);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_help_recaptchar);
        RxBus.a().c().subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new C51191(this), new j());
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            ViewCompat.z0(toolbar, getResources().getDimension(R.dimen.toolbar_elevation));
            this.mToolbar.setNavigationOnClickListener(new k(this));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.r(true);
                supportActionBar.B("Verify Recaptcha");
                supportActionBar.u(true);
            }
        }
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.w(view, "Replace with your own action", 0).x("Action", (View.OnClickListener) null).s();
            }
        });
        ArrayList<ItemHelpCaptcha> arrayList = Utils.f37615h;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f32028d = Utils.e0();
        } else {
            this.f32028d = Utils.f37615h;
        }
        ArrayList<ItemHelpCaptcha> arrayList2 = this.f32028d;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
            this.f32027c = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            HelpRecaptchaViewAdapter helpRecaptchaViewAdapter = new HelpRecaptchaViewAdapter(this, this.f32028d, this);
            this.f32026b = helpRecaptchaViewAdapter;
            this.f32027c.setAdapter(helpRecaptchaViewAdapter);
        }
    }

    public void onDestroy() {
        Utils.t0();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}
