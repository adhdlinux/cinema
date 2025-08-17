package com.nononsenseapps.filepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;
import com.nononsenseapps.filepicker.NewItemFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFilePickerFragment<T> extends Fragment implements LoaderManager.LoaderCallbacks<SortedList<T>>, NewItemFragment.OnNewFolderListener, LogicHandler<T> {

    /* renamed from: b  reason: collision with root package name */
    protected final HashSet<T> f33691b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    protected final HashSet<AbstractFilePickerFragment<T>.CheckableViewHolder> f33692c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    protected int f33693d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected T f33694e = null;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f33695f = false;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f33696g = false;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f33697h = true;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f33698i = false;

    /* renamed from: j  reason: collision with root package name */
    protected OnFilePickedListener f33699j;

    /* renamed from: k  reason: collision with root package name */
    protected FileItemAdapter<T> f33700k = null;

    /* renamed from: l  reason: collision with root package name */
    protected TextView f33701l;

    /* renamed from: m  reason: collision with root package name */
    protected EditText f33702m;

    /* renamed from: n  reason: collision with root package name */
    protected RecyclerView f33703n;

    /* renamed from: o  reason: collision with root package name */
    protected LinearLayoutManager f33704o;

    /* renamed from: p  reason: collision with root package name */
    protected SortedList<T> f33705p = null;

    /* renamed from: q  reason: collision with root package name */
    protected Toast f33706q = null;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f33707r = false;

    /* renamed from: s  reason: collision with root package name */
    protected View f33708s = null;

    /* renamed from: t  reason: collision with root package name */
    protected View f33709t = null;

    public class CheckableViewHolder extends AbstractFilePickerFragment<T>.DirViewHolder {

        /* renamed from: n  reason: collision with root package name */
        public CheckBox f33714n;

        public CheckableViewHolder(View view) {
            super(view);
            boolean z2;
            int i2 = 0;
            if (AbstractFilePickerFragment.this.f33693d == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            CheckBox checkBox = (CheckBox) view.findViewById(R$id.f33742a);
            this.f33714n = checkBox;
            checkBox.setVisibility((z2 || AbstractFilePickerFragment.this.f33698i) ? 8 : i2);
            this.f33714n.setOnClickListener(new View.OnClickListener(AbstractFilePickerFragment.this) {
                public void onClick(View view) {
                    CheckableViewHolder checkableViewHolder = CheckableViewHolder.this;
                    AbstractFilePickerFragment.this.S(checkableViewHolder);
                }
            });
        }

        public void onClick(View view) {
            AbstractFilePickerFragment.this.T(view, this);
        }

        public boolean onLongClick(View view) {
            return AbstractFilePickerFragment.this.Y(view, this);
        }
    }

    public class DirViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        /* renamed from: j  reason: collision with root package name */
        public View f33718j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f33719k;

        /* renamed from: l  reason: collision with root package name */
        public T f33720l;

        public DirViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.f33718j = view.findViewById(R$id.item_icon);
            this.f33719k = (TextView) view.findViewById(16908308);
        }

        public void onClick(View view) {
            AbstractFilePickerFragment.this.U(view, this);
        }

        public boolean onLongClick(View view) {
            return AbstractFilePickerFragment.this.Z(view, this);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: j  reason: collision with root package name */
        final TextView f33722j;

        public HeaderViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.f33722j = (TextView) view.findViewById(16908308);
        }

        public void onClick(View view) {
            AbstractFilePickerFragment.this.V(view, this);
        }
    }

    public interface OnFilePickedListener {
        void g(List<Uri> list);

        void k();

        void v(Uri uri);
    }

    public AbstractFilePickerFragment() {
        setRetainInstance(true);
    }

    public void F() {
        Iterator<AbstractFilePickerFragment<T>.CheckableViewHolder> it2 = this.f33692c.iterator();
        while (it2.hasNext()) {
            it2.next().f33714n.setChecked(false);
        }
        this.f33692c.clear();
        this.f33691b.clear();
    }

    /* access modifiers changed from: protected */
    public void G(LayoutInflater layoutInflater, RecyclerView recyclerView) {
        TypedArray obtainStyledAttributes = getActivity().obtainStyledAttributes(new int[]{R$attr.nnf_list_item_divider});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        if (drawable != null) {
            recyclerView.addItemDecoration(new DividerItemDecoration(drawable));
        }
    }

    /* access modifiers changed from: protected */
    public FileItemAdapter<T> H() {
        return new FileItemAdapter<>(this);
    }

    public T I() {
        Iterator<T> it2 = this.f33691b.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String J() {
        return this.f33702m.getText().toString();
    }

    public void K(T t2) {
        if (!this.f33707r) {
            this.f33691b.clear();
            this.f33692c.clear();
            a0(t2);
        }
    }

    public void L() {
        K(w(this.f33694e));
    }

    /* access modifiers changed from: protected */
    public void M(T t2) {
    }

    /* access modifiers changed from: protected */
    public boolean N(T t2) {
        return true;
    }

    /* access modifiers changed from: protected */
    public View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R$layout.nnf_fragment_filepicker, viewGroup, false);
    }

    public boolean P(T t2) {
        if (t(t2)) {
            int i2 = this.f33693d;
            if ((i2 != 1 || !this.f33696g) && (i2 != 2 || !this.f33696g)) {
                return false;
            }
        } else {
            int i3 = this.f33693d;
            if (i3 == 0 || i3 == 2 || this.f33697h) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = r1.f33693d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Q(T r2) {
        /*
            r1 = this;
            boolean r2 = r1.t(r2)
            if (r2 != 0) goto L_0x0017
            int r2 = r1.f33693d
            if (r2 == 0) goto L_0x0017
            r0 = 2
            if (r2 == r0) goto L_0x0017
            r0 = 3
            if (r2 != r0) goto L_0x0015
            boolean r2 = r1.f33697h
            if (r2 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r2 = 0
            goto L_0x0018
        L_0x0017:
            r2 = 1
        L_0x0018:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nononsenseapps.filepicker.AbstractFilePickerFragment.Q(java.lang.Object):boolean");
    }

    public void R(View view) {
        OnFilePickedListener onFilePickedListener = this.f33699j;
        if (onFilePickedListener != null) {
            onFilePickedListener.k();
        }
    }

    public void S(AbstractFilePickerFragment<T>.CheckableViewHolder checkableViewHolder) {
        if (this.f33691b.contains(checkableViewHolder.f33720l)) {
            checkableViewHolder.f33714n.setChecked(false);
            this.f33691b.remove(checkableViewHolder.f33720l);
            this.f33692c.remove(checkableViewHolder);
            return;
        }
        if (!this.f33696g) {
            F();
        }
        checkableViewHolder.f33714n.setChecked(true);
        this.f33691b.add(checkableViewHolder.f33720l);
        this.f33692c.add(checkableViewHolder);
    }

    public void T(View view, AbstractFilePickerFragment<T>.CheckableViewHolder checkableViewHolder) {
        if (t(checkableViewHolder.f33720l)) {
            K(checkableViewHolder.f33720l);
            return;
        }
        Y(view, checkableViewHolder);
        if (this.f33698i) {
            W(view);
        }
    }

    public void U(View view, AbstractFilePickerFragment<T>.DirViewHolder dirViewHolder) {
        if (t(dirViewHolder.f33720l)) {
            K(dirViewHolder.f33720l);
        }
    }

    public void V(View view, AbstractFilePickerFragment<T>.HeaderViewHolder headerViewHolder) {
        L();
    }

    public void W(View view) {
        Uri uri;
        if (this.f33699j != null) {
            if ((this.f33696g || this.f33693d == 0) && (this.f33691b.isEmpty() || I() == null)) {
                if (this.f33706q == null) {
                    this.f33706q = Toast.makeText(getActivity(), R$string.nnf_select_something_first, 0);
                }
                this.f33706q.show();
                return;
            }
            int i2 = this.f33693d;
            if (i2 == 3) {
                String J = J();
                if (J.startsWith("/")) {
                    uri = d(v(J));
                } else {
                    uri = d(v(Utils.a(f(this.f33694e), J)));
                }
                this.f33699j.v(uri);
            } else if (this.f33696g) {
                this.f33699j.g(e0(this.f33691b));
            } else if (i2 == 0) {
                this.f33699j.v(d(I()));
            } else if (i2 == 1) {
                this.f33699j.v(d(this.f33694e));
            } else if (this.f33691b.isEmpty()) {
                this.f33699j.v(d(this.f33694e));
            } else {
                this.f33699j.v(d(I()));
            }
        }
    }

    /* renamed from: X */
    public void onLoadFinished(Loader<SortedList<T>> loader, SortedList<T> sortedList) {
        this.f33707r = false;
        this.f33691b.clear();
        this.f33692c.clear();
        this.f33705p = sortedList;
        this.f33700k.c(sortedList);
        TextView textView = this.f33701l;
        if (textView != null) {
            textView.setText(f(this.f33694e));
        }
        getLoaderManager().a(0);
    }

    public boolean Y(View view, AbstractFilePickerFragment<T>.CheckableViewHolder checkableViewHolder) {
        if (3 == this.f33693d) {
            this.f33702m.setText(e(checkableViewHolder.f33720l));
        }
        S(checkableViewHolder);
        return true;
    }

    public boolean Z(View view, AbstractFilePickerFragment<T>.DirViewHolder dirViewHolder) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void a0(T t2) {
        if (N(t2)) {
            this.f33694e = t2;
            this.f33707r = true;
            getLoaderManager().f(0, (Bundle) null, this);
            return;
        }
        M(t2);
    }

    public void b0(String str, int i2, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (i2 == 3 && z2) {
            throw new IllegalArgumentException("MODE_NEW_FILE does not support 'allowMultiple'");
        } else if (!z5 || !z2) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            if (str != null) {
                arguments.putString("KEY_START_PATH", str);
            }
            arguments.putBoolean("KEY_ALLOW_DIR_CREATE", z3);
            arguments.putBoolean("KEY_ALLOW_MULTIPLE", z2);
            arguments.putBoolean("KEY_ALLOW_EXISTING_FILE", z4);
            arguments.putBoolean("KEY_SINGLE_CLICK", z5);
            arguments.putInt("KEY_MODE", i2);
            setArguments(arguments);
        } else {
            throw new IllegalArgumentException("'singleClick' can not be used with 'allowMultiple'");
        }
    }

    public int c(int i2, T t2) {
        return P(t2) ? 2 : 1;
    }

    /* access modifiers changed from: protected */
    public void c0() {
        boolean z2;
        int i2;
        int i3 = 0;
        if (this.f33693d == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        View view = this.f33708s;
        if (z2) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view.setVisibility(i2);
        View view2 = this.f33709t;
        if (z2) {
            i3 = 8;
        }
        view2.setVisibility(i3);
        if (!z2 && this.f33698i) {
            getActivity().findViewById(R$id.nnf_button_ok).setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void d0(Toolbar toolbar) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    /* access modifiers changed from: protected */
    public List<Uri> e0(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T d2 : iterable) {
            arrayList.add(d(d2));
        }
        return arrayList;
    }

    public void g(AbstractFilePickerFragment<T>.DirViewHolder dirViewHolder, int i2, T t2) {
        int i3;
        dirViewHolder.f33720l = t2;
        View view = dirViewHolder.f33718j;
        if (t(t2)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        dirViewHolder.f33719k.setText(e(t2));
        if (!P(t2)) {
            return;
        }
        if (this.f33691b.contains(t2)) {
            CheckableViewHolder checkableViewHolder = (CheckableViewHolder) dirViewHolder;
            this.f33692c.add(checkableViewHolder);
            checkableViewHolder.f33714n.setChecked(true);
            return;
        }
        this.f33692c.remove(dirViewHolder);
        ((CheckableViewHolder) dirViewHolder).f33714n.setChecked(false);
    }

    public RecyclerView.ViewHolder k(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new HeaderViewHolder(LayoutInflater.from(getActivity()).inflate(R$layout.nnf_filepicker_listitem_dir, viewGroup, false));
        }
        if (i2 != 2) {
            return new DirViewHolder(LayoutInflater.from(getActivity()).inflate(R$layout.nnf_filepicker_listitem_dir, viewGroup, false));
        }
        return new CheckableViewHolder(LayoutInflater.from(getActivity()).inflate(R$layout.nnf_filepicker_listitem_checkable, viewGroup, false));
    }

    public void onActivityCreated(Bundle bundle) {
        String string;
        super.onActivityCreated(bundle);
        if (this.f33694e == null) {
            if (bundle != null) {
                this.f33693d = bundle.getInt("KEY_MODE", this.f33693d);
                this.f33695f = bundle.getBoolean("KEY_ALLOW_DIR_CREATE", this.f33695f);
                this.f33696g = bundle.getBoolean("KEY_ALLOW_MULTIPLE", this.f33696g);
                this.f33697h = bundle.getBoolean("KEY_ALLOW_EXISTING_FILE", this.f33697h);
                this.f33698i = bundle.getBoolean("KEY_SINGLE_CLICK", this.f33698i);
                String string2 = bundle.getString("KEY_CURRENT_PATH");
                if (string2 != null) {
                    this.f33694e = v(string2.trim());
                }
            } else if (getArguments() != null) {
                this.f33693d = getArguments().getInt("KEY_MODE", this.f33693d);
                this.f33695f = getArguments().getBoolean("KEY_ALLOW_DIR_CREATE", this.f33695f);
                this.f33696g = getArguments().getBoolean("KEY_ALLOW_MULTIPLE", this.f33696g);
                this.f33697h = getArguments().getBoolean("KEY_ALLOW_EXISTING_FILE", this.f33697h);
                this.f33698i = getArguments().getBoolean("KEY_SINGLE_CLICK", this.f33698i);
                if (getArguments().containsKey("KEY_START_PATH") && (string = getArguments().getString("KEY_START_PATH")) != null) {
                    T v2 = v(string.trim());
                    if (t(v2)) {
                        this.f33694e = v2;
                    } else {
                        this.f33694e = w(v2);
                        this.f33702m.setText(e(v2));
                    }
                }
            }
        }
        c0();
        if (this.f33694e == null) {
            this.f33694e = getRoot();
        }
        a0(this.f33694e);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f33699j = (OnFilePickedListener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnFilePickedListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public Loader<SortedList<T>> onCreateLoader(int i2, Bundle bundle) {
        return j();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R$menu.picker_actions, menu);
        menu.findItem(R$id.nnf_action_createdir).setVisible(this.f33695f);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View O = O(layoutInflater, viewGroup);
        Toolbar toolbar = (Toolbar) O.findViewById(R$id.nnf_picker_toolbar);
        if (toolbar != null) {
            d0(toolbar);
        }
        RecyclerView recyclerView = (RecyclerView) O.findViewById(16908298);
        this.f33703n = recyclerView;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.f33704o = linearLayoutManager;
        this.f33703n.setLayoutManager(linearLayoutManager);
        G(layoutInflater, this.f33703n);
        FileItemAdapter<T> fileItemAdapter = new FileItemAdapter<>(this);
        this.f33700k = fileItemAdapter;
        this.f33703n.setAdapter(fileItemAdapter);
        O.findViewById(R$id.nnf_button_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AbstractFilePickerFragment.this.R(view);
            }
        });
        O.findViewById(R$id.nnf_button_ok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AbstractFilePickerFragment.this.W(view);
            }
        });
        O.findViewById(R$id.nnf_button_ok_newfile).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AbstractFilePickerFragment.this.W(view);
            }
        });
        this.f33708s = O.findViewById(R$id.nnf_newfile_button_container);
        this.f33709t = O.findViewById(R$id.nnf_button_container);
        EditText editText = (EditText) O.findViewById(R$id.nnf_text_filename);
        this.f33702m = editText;
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                AbstractFilePickerFragment.this.F();
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        TextView textView = (TextView) O.findViewById(R$id.nnf_current_dir);
        this.f33701l = textView;
        T t2 = this.f33694e;
        if (!(t2 == null || textView == null)) {
            textView.setText(f(t2));
        }
        return O;
    }

    public void onDetach() {
        super.onDetach();
        this.f33699j = null;
    }

    public void onLoaderReset(Loader<SortedList<T>> loader) {
        this.f33707r = false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R$id.nnf_action_createdir != menuItem.getItemId()) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AppCompatActivity)) {
            return true;
        }
        NewFolderFragment.I(((AppCompatActivity) activity).getSupportFragmentManager(), this);
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("KEY_CURRENT_PATH", this.f33694e.toString());
        bundle.putBoolean("KEY_ALLOW_MULTIPLE", this.f33696g);
        bundle.putBoolean("KEY_ALLOW_EXISTING_FILE", this.f33697h);
        bundle.putBoolean("KEY_ALLOW_DIR_CREATE", this.f33695f);
        bundle.putBoolean("KEY_SINGLE_CLICK", this.f33698i);
        bundle.putInt("KEY_MODE", this.f33693d);
        super.onSaveInstanceState(bundle);
    }

    public void u(AbstractFilePickerFragment<T>.HeaderViewHolder headerViewHolder) {
        headerViewHolder.f33722j.setText("..");
    }
}
