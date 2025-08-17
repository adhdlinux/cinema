package com.movie.ui.activity.payment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.payment.bitcoin.ProductResponse;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class ChooseProductFragment extends BaseFragment {
    @BindView(2131361950)
    Button btnNext;
    @BindView(2131362020)
    CheckBox cbSplitKey;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MoviesApi f32257d;

    /* renamed from: e  reason: collision with root package name */
    CompositeDisposable f32258e;
    @BindView(2131362850)
    EditText edtEmail;

    /* renamed from: f  reason: collision with root package name */
    private List<ProductResponse.ResultsBean> f32259f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ProductResponse.ResultsBean f32260g;

    /* renamed from: h  reason: collision with root package name */
    private String f32261h;

    /* renamed from: i  reason: collision with root package name */
    private ChooseProductListListener f32262i;
    @BindView(2131362276)
    ImageButton imgbtnDetails;
    @BindView(2131362604)
    ProgressBar progressBarloading;
    @BindView(2131362611)
    RadioGroup radioGroupProducts;
    @BindView(2131362870)
    TextView tvValidate;

    public interface ChooseProductListListener {
        void e(ProductResponse.ResultsBean resultsBean, String str, Boolean bool);
    }

    public static final boolean M(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(ProductResponse productResponse) throws Exception {
        R(productResponse.getResults());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P() throws Exception {
        S();
        this.progressBarloading.setVisibility(8);
    }

    public static ChooseProductFragment Q(ChooseProductListListener chooseProductListListener) {
        ChooseProductFragment chooseProductFragment = new ChooseProductFragment();
        chooseProductFragment.setArguments(new Bundle());
        chooseProductFragment.f32262i = chooseProductListListener;
        return chooseProductFragment;
    }

    private void R(List<ProductResponse.ResultsBean> list) {
        this.f32259f = list;
        for (ProductResponse.ResultsBean next : list) {
            final RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setText(next.getPrice() + " USD / " + next.getDescription());
            radioButton.setTag(next);
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    if (z2) {
                        ProductResponse.ResultsBean unused = ChooseProductFragment.this.f32260g = (ProductResponse.ResultsBean) radioButton.getTag();
                    }
                    boolean unused2 = ChooseProductFragment.this.S();
                }
            });
            this.radioGroupProducts.addView(radioButton, 0, new RadioGroup.LayoutParams(-2, -2));
        }
    }

    /* access modifiers changed from: private */
    public boolean S() {
        String str = "";
        this.tvValidate.setText(str);
        String obj = this.edtEmail.getText().toString();
        this.f32261h = obj;
        if (obj.isEmpty()) {
            str = str + "\n- Missing email";
        } else if (!M(this.f32261h)) {
            str = str + "\n- Invalid email format";
        }
        List<ProductResponse.ResultsBean> list = this.f32259f;
        if (list == null || list.size() == 0) {
            str = str + "\n- Can't load product list";
        } else if (this.f32260g == null) {
            str = str + "\n- You must select a product";
        }
        this.tvValidate.setText(str);
        if (!str.isEmpty()) {
            this.tvValidate.setVisibility(0);
        } else {
            this.tvValidate.setVisibility(8);
        }
        if (str.isEmpty()) {
            this.btnNext.setBackgroundColor(getResources().getColor(R.color.material_green300));
        } else {
            this.btnNext.setBackgroundColor(-7829368);
        }
        return str.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().u(this);
    }

    @OnClick({2131361950})
    public void onBtnNextClick() {
        if (S() && this.f32262i != null) {
            FreeMoviesApp.p().edit().putString("pref_payment_bit_mail", this.f32261h).apply();
            FreeMoviesApp.p().edit().putString("pref_payment_bit_product_id", new Gson().u(this.f32260g)).apply();
            this.f32262i.e(this.f32260g, this.f32261h, Boolean.valueOf(this.cbSplitKey.isChecked()));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_bitcoin_choose_products, viewGroup, false);
    }

    public void onDestroy() {
        this.f32258e.dispose();
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String string = FreeMoviesApp.p().getString("pref_payment_bit_mail", "");
        if (!string.isEmpty()) {
            this.edtEmail.setText(string);
        }
        this.progressBarloading.setVisibility(0);
        view.getContext();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f32258e = compositeDisposable;
        compositeDisposable.b(this.f32257d.productList().subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new b(this), new c(), new d(this)));
    }
}
