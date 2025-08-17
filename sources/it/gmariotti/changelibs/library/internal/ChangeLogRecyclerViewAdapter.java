package it.gmariotti.changelibs.library.internal;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import it.gmariotti.changelibs.R$id;
import it.gmariotti.changelibs.library.Constants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChangeLogRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: n  reason: collision with root package name */
    private final Context f40197n;

    /* renamed from: o  reason: collision with root package name */
    private int f40198o = Constants.f40184b;

    /* renamed from: p  reason: collision with root package name */
    private int f40199p = Constants.f40185c;

    /* renamed from: q  reason: collision with root package name */
    private int f40200q = Constants.f40186d;

    /* renamed from: r  reason: collision with root package name */
    private List<ChangeLogRow> f40201r;

    public static class ViewHolderHeader extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        public TextView f40202j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f40203k;

        public ViewHolderHeader(View view) {
            super(view);
            this.f40202j = (TextView) view.findViewById(R$id.chg_headerVersion);
            this.f40203k = (TextView) view.findViewById(R$id.chg_headerDate);
        }
    }

    public static class ViewHolderRow extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        public TextView f40204j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f40205k;

        public ViewHolderRow(View view) {
            super(view);
            this.f40204j = (TextView) view.findViewById(R$id.chg_text);
            this.f40205k = (TextView) view.findViewById(R$id.chg_textbullet);
        }
    }

    public ChangeLogRecyclerViewAdapter(Context context, List<ChangeLogRow> list) {
        this.f40197n = context;
        this.f40201r = list == null ? new ArrayList<>() : list;
    }

    private ChangeLogRow d(int i2) {
        return this.f40201r.get(i2);
    }

    private boolean e(int i2) {
        return d(i2).d();
    }

    private void f(ViewHolderHeader viewHolderHeader, int i2) {
        ChangeLogRow d2 = d(i2);
        if (d2 != null) {
            if (viewHolderHeader.f40202j != null) {
                StringBuilder sb = new StringBuilder();
                String string = this.f40197n.getString(this.f40200q);
                if (string != null) {
                    sb.append(string);
                }
                sb.append(d2.f40207b);
                viewHolderHeader.f40202j.setText(sb.toString());
            }
            TextView textView = viewHolderHeader.f40203k;
            if (textView != null) {
                String str = d2.f40209d;
                if (str != null) {
                    textView.setText(str);
                    viewHolderHeader.f40203k.setVisibility(0);
                    return;
                }
                textView.setText("");
                viewHolderHeader.f40203k.setVisibility(8);
            }
        }
    }

    private void g(ViewHolderRow viewHolderRow, int i2) {
        ChangeLogRow d2 = d(i2);
        if (d2 != null) {
            TextView textView = viewHolderRow.f40204j;
            if (textView != null) {
                textView.setText(Html.fromHtml(d2.b(this.f40197n)));
                viewHolderRow.f40204j.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (viewHolderRow.f40205k == null) {
                return;
            }
            if (d2.c()) {
                viewHolderRow.f40205k.setVisibility(0);
            } else {
                viewHolderRow.f40205k.setVisibility(8);
            }
        }
    }

    public void c(LinkedList<ChangeLogRow> linkedList) {
        int size = this.f40201r.size();
        this.f40201r.addAll(linkedList);
        notifyItemRangeInserted(size, linkedList.size() + size);
    }

    public int getItemCount() {
        return this.f40201r.size();
    }

    public int getItemViewType(int i2) {
        return e(i2) ? 1 : 0;
    }

    public void h(int i2) {
        this.f40199p = i2;
    }

    public void i(int i2) {
        this.f40198o = i2;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (e(i2)) {
            f((ViewHolderHeader) viewHolder, i2);
        } else {
            g((ViewHolderRow) viewHolder, i2);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new ViewHolderHeader(LayoutInflater.from(viewGroup.getContext()).inflate(this.f40199p, viewGroup, false));
        }
        return new ViewHolderRow(LayoutInflater.from(viewGroup.getContext()).inflate(this.f40198o, viewGroup, false));
    }
}
