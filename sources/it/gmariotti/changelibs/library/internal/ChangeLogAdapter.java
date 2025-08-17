package it.gmariotti.changelibs.library.internal;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import it.gmariotti.changelibs.library.Constants;
import java.util.List;

public class ChangeLogAdapter extends ArrayAdapter<ChangeLogRow> {

    /* renamed from: b  reason: collision with root package name */
    private int f40189b = Constants.f40184b;

    /* renamed from: c  reason: collision with root package name */
    private int f40190c = Constants.f40185c;

    /* renamed from: d  reason: collision with root package name */
    private int f40191d = Constants.f40186d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f40192e;

    static class ViewHolderHeader {

        /* renamed from: a  reason: collision with root package name */
        TextView f40193a;

        /* renamed from: b  reason: collision with root package name */
        TextView f40194b;

        public ViewHolderHeader(TextView textView, TextView textView2) {
            this.f40193a = textView;
            this.f40194b = textView2;
        }
    }

    static class ViewHolderRow {

        /* renamed from: a  reason: collision with root package name */
        TextView f40195a;

        /* renamed from: b  reason: collision with root package name */
        TextView f40196b;

        public ViewHolderRow(TextView textView, TextView textView2) {
            this.f40195a = textView;
            this.f40196b = textView2;
        }
    }

    public ChangeLogAdapter(Context context, List<ChangeLogRow> list) {
        super(context, 0, list);
        this.f40192e = context;
    }

    public void a(int i2) {
        this.f40190c = i2;
    }

    public void b(int i2) {
        this.f40189b = i2;
    }

    public int getItemViewType(int i2) {
        return ((ChangeLogRow) getItem(i2)).d() ? 1 : 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader} */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r7 = r1.inflate(r6.f40190c, r9, false);
        r4 = new it.gmariotti.changelibs.library.internal.ChangeLogAdapter.ViewHolderHeader((android.widget.TextView) r7.findViewById(it.gmariotti.changelibs.R$id.chg_headerVersion), (android.widget.TextView) r7.findViewById(it.gmariotti.changelibs.R$id.chg_headerDate));
        r7.setTag(r4);
        r8 = r7;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004f, code lost:
        if (r0 == null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r4.f40193a == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        r7 = new java.lang.StringBuilder();
        r9 = getContext().getString(r6.f40191d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        if (r9 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        r7.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        r7.append(r0.f40207b);
        r4.f40193a.setText(r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        r7 = r4.f40194b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        if (r7 == null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        r9 = r0.f40209d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        if (r9 == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        r7.setText(r9);
        r4.f40194b.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        r7.setText("");
        r4.f40194b.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        if (r4 == null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
        r7 = r1.inflate(r6.f40189b, r9, false);
        r4 = new it.gmariotti.changelibs.library.internal.ChangeLogAdapter.ViewHolderRow((android.widget.TextView) r7.findViewById(it.gmariotti.changelibs.R$id.chg_text), (android.widget.TextView) r7.findViewById(it.gmariotti.changelibs.R$id.chg_textbullet));
        r7.setTag(r4);
        r8 = r7;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c3, code lost:
        if (r0 == null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        r7 = r4.f40195a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        if (r7 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c9, code lost:
        r7.setText(android.text.Html.fromHtml(r0.b(r6.f40192e)));
        r4.f40195a.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e1, code lost:
        if (r4.f40196b == null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e7, code lost:
        if (r0.c() == false) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e9, code lost:
        r4.f40196b.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ef, code lost:
        r4.f40196b.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r4 == null) goto L_0x0030;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.getItem(r7)
            it.gmariotti.changelibs.library.internal.ChangeLogRow r0 = (it.gmariotti.changelibs.library.internal.ChangeLogRow) r0
            int r7 = r6.getItemViewType(r7)
            android.content.Context r1 = r6.f40192e
            java.lang.String r2 = "layout_inflater"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.LayoutInflater r1 = (android.view.LayoutInflater) r1
            r2 = 8
            r3 = 0
            r4 = 0
            if (r7 == 0) goto L_0x0093
            r5 = 1
            if (r7 == r5) goto L_0x001f
            goto L_0x00f4
        L_0x001f:
            if (r8 == 0) goto L_0x002c
            java.lang.Object r7 = r8.getTag()
            boolean r5 = r7 instanceof it.gmariotti.changelibs.library.internal.ChangeLogAdapter.ViewHolderHeader
            if (r5 == 0) goto L_0x002c
            r4 = r7
            it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader r4 = (it.gmariotti.changelibs.library.internal.ChangeLogAdapter.ViewHolderHeader) r4
        L_0x002c:
            if (r8 == 0) goto L_0x0030
            if (r4 != 0) goto L_0x004f
        L_0x0030:
            int r7 = r6.f40190c
            android.view.View r7 = r1.inflate(r7, r9, r3)
            int r8 = it.gmariotti.changelibs.R$id.chg_headerVersion
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = it.gmariotti.changelibs.R$id.chg_headerDate
            android.view.View r9 = r7.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader r4 = new it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderHeader
            r4.<init>(r8, r9)
            r7.setTag(r4)
            r8 = r7
        L_0x004f:
            if (r0 == 0) goto L_0x00f4
            android.widget.TextView r7 = r4.f40193a
            if (r7 == 0) goto L_0x0077
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.Context r9 = r6.getContext()
            int r1 = r6.f40191d
            java.lang.String r9 = r9.getString(r1)
            if (r9 == 0) goto L_0x0069
            r7.append(r9)
        L_0x0069:
            java.lang.String r9 = r0.f40207b
            r7.append(r9)
            android.widget.TextView r9 = r4.f40193a
            java.lang.String r7 = r7.toString()
            r9.setText(r7)
        L_0x0077:
            android.widget.TextView r7 = r4.f40194b
            if (r7 == 0) goto L_0x00f4
            java.lang.String r9 = r0.f40209d
            if (r9 == 0) goto L_0x0088
            r7.setText(r9)
            android.widget.TextView r7 = r4.f40194b
            r7.setVisibility(r3)
            goto L_0x00f4
        L_0x0088:
            java.lang.String r9 = ""
            r7.setText(r9)
            android.widget.TextView r7 = r4.f40194b
            r7.setVisibility(r2)
            goto L_0x00f4
        L_0x0093:
            if (r8 == 0) goto L_0x00a0
            java.lang.Object r7 = r8.getTag()
            boolean r5 = r7 instanceof it.gmariotti.changelibs.library.internal.ChangeLogAdapter.ViewHolderRow
            if (r5 == 0) goto L_0x00a0
            r4 = r7
            it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow r4 = (it.gmariotti.changelibs.library.internal.ChangeLogAdapter.ViewHolderRow) r4
        L_0x00a0:
            if (r8 == 0) goto L_0x00a4
            if (r4 != 0) goto L_0x00c3
        L_0x00a4:
            int r7 = r6.f40189b
            android.view.View r7 = r1.inflate(r7, r9, r3)
            int r8 = it.gmariotti.changelibs.R$id.chg_text
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = it.gmariotti.changelibs.R$id.chg_textbullet
            android.view.View r9 = r7.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow r4 = new it.gmariotti.changelibs.library.internal.ChangeLogAdapter$ViewHolderRow
            r4.<init>(r8, r9)
            r7.setTag(r4)
            r8 = r7
        L_0x00c3:
            if (r0 == 0) goto L_0x00f4
            android.widget.TextView r7 = r4.f40195a
            if (r7 == 0) goto L_0x00df
            android.content.Context r9 = r6.f40192e
            java.lang.String r9 = r0.b(r9)
            android.text.Spanned r9 = android.text.Html.fromHtml(r9)
            r7.setText(r9)
            android.widget.TextView r7 = r4.f40195a
            android.text.method.MovementMethod r9 = android.text.method.LinkMovementMethod.getInstance()
            r7.setMovementMethod(r9)
        L_0x00df:
            android.widget.TextView r7 = r4.f40196b
            if (r7 == 0) goto L_0x00f4
            boolean r7 = r0.c()
            if (r7 == 0) goto L_0x00ef
            android.widget.TextView r7 = r4.f40196b
            r7.setVisibility(r3)
            goto L_0x00f4
        L_0x00ef:
            android.widget.TextView r7 = r4.f40196b
            r7.setVisibility(r2)
        L_0x00f4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: it.gmariotti.changelibs.library.internal.ChangeLogAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isEnabled(int i2) {
        return false;
    }
}
