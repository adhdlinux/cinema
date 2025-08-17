package com.movie.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.movie.data.model.ItemHelpCaptcha;
import com.yoku.marumovie.R;
import java.util.List;

public class HelpRecaptchaViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: n  reason: collision with root package name */
    private List<ItemHelpCaptcha> f33066n;

    /* renamed from: o  reason: collision with root package name */
    private LayoutInflater f33067o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ItemClickListener f33068p;

    public interface ItemClickListener {
        void n(View view, ItemHelpCaptcha itemHelpCaptcha);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: j  reason: collision with root package name */
        TextView f33069j;

        /* renamed from: k  reason: collision with root package name */
        Button f33070k;

        ViewHolder(View view) {
            super(view);
            this.f33069j = (TextView) view.findViewById(R.id.help_provider_text);
            this.f33070k = (Button) view.findViewById(R.id.btn_help_verify);
            view.setOnClickListener(this);
            this.f33070k.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (HelpRecaptchaViewAdapter.this.f33068p != null) {
                HelpRecaptchaViewAdapter.this.f33068p.n(view, HelpRecaptchaViewAdapter.this.d(getAdapterPosition()));
            }
        }
    }

    public HelpRecaptchaViewAdapter(Context context, List<ItemHelpCaptcha> list, ItemClickListener itemClickListener) {
        this.f33067o = LayoutInflater.from(context);
        this.f33066n = list;
        this.f33068p = itemClickListener;
    }

    /* access modifiers changed from: package-private */
    public ItemHelpCaptcha d(int i2) {
        return this.f33066n.get(i2);
    }

    /* renamed from: e */
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        viewHolder.f33069j.setText(this.f33066n.get(i2).getProviderName());
    }

    /* renamed from: f */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(this.f33067o.inflate(R.layout.help_recaptcha_recycleview_row, viewGroup, false));
    }

    public int getItemCount() {
        return this.f33066n.size();
    }
}
