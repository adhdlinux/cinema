package com.movie.ui.fragment.mylist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.database.MvDatabase;
import com.database.entitys.UserListEntity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.movie.FreeMoviesApp;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.mylist.UserListAdapter;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public class UserListSelectionDialog extends BottomSheetDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f33410b = new CompositeDisposable();

    /* renamed from: c  reason: collision with root package name */
    private EditText f33411c;

    /* renamed from: d  reason: collision with root package name */
    private Button f33412d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f33413e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f33414f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f33415g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    TraktRepositoryImpl f33416h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    MvDatabase f33417i;

    /* renamed from: j  reason: collision with root package name */
    private UserListAdapter.Listener f33418j;

    /* access modifiers changed from: private */
    public /* synthetic */ List J(List list) throws Exception {
        boolean z2;
        List<UserListEntity> h2 = this.f33417i.F().h();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            UserListEntity userListEntity = (UserListEntity) it2.next();
            Iterator<UserListEntity> it3 = h2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z2 = false;
                    break;
                }
                UserListEntity next = it3.next();
                if (next.f19321c.equals(userListEntity.f19321c) && next.f19322d.equals(userListEntity.f19322d)) {
                    z2 = true;
                    break;
                }
            }
            userListEntity.f19325g = Boolean.valueOf(z2);
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(UserListAdapter userListAdapter, List list) throws Exception {
        userListAdapter.e(list);
        Timber.b("List: %s", list);
        this.f33413e.setVisibility(8);
        if (list.isEmpty()) {
            this.f33414f.setText("No list available to display.");
            this.f33414f.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(Throwable th) throws Exception {
        this.f33413e.setVisibility(8);
        this.f33414f.setText(th.getMessage());
        this.f33414f.setVisibility(0);
        Timber.e(th, "Error", new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(UserListAdapter userListAdapter, View view) {
        Utils.g0(getContext(), view);
        String obj = this.f33411c.getText().toString();
        this.f33414f.setVisibility(8);
        if (!obj.isEmpty()) {
            this.f33413e.setVisibility(0);
            this.f33410b.b(this.f33416h.n(obj.trim()).map(new w(this)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new x(this, userListAdapter), new y(this)));
        }
    }

    public static UserListSelectionDialog N(UserListAdapter.Listener listener) {
        UserListSelectionDialog userListSelectionDialog = new UserListSelectionDialog();
        userListSelectionDialog.f33418j = listener;
        return userListSelectionDialog;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m(context).l()).b().i(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.user_list_selection, viewGroup, false);
        this.f33411c = (EditText) inflate.findViewById(R.id.edtUserName);
        this.f33412d = (Button) inflate.findViewById(R.id.btnSubmit);
        this.f33413e = (ProgressBar) inflate.findViewById(R.id.loading);
        this.f33415g = (RecyclerView) inflate.findViewById(R.id.rvList);
        this.f33414f = (TextView) inflate.findViewById(R.id.errorText);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                inflate.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BottomSheetBehavior I = BottomSheetBehavior.I((FrameLayout) ((BottomSheetDialog) UserListSelectionDialog.this.getDialog()).findViewById(R.id.design_bottom_sheet));
                I.S(3);
                I.Q(0);
            }
        });
        return inflate;
    }

    public void onDestroyView() {
        this.f33410b.dispose();
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f33413e.setVisibility(8);
        this.f33415g.setLayoutManager(new LinearLayoutManager(getContext()));
        UserListAdapter userListAdapter = new UserListAdapter();
        userListAdapter.i(this.f33418j);
        this.f33415g.setAdapter(userListAdapter);
        this.f33411c.requestFocus();
        this.f33412d.setOnClickListener(new v(this, userListAdapter));
    }
}
