package com.movie.ui.activity.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.database.MvDatabase;
import com.database.entitys.CategoryEntity;
import com.movie.AppComponent;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class CategoryListFragment extends BaseFragment {

    /* renamed from: d  reason: collision with root package name */
    ListView f32508d;

    /* renamed from: e  reason: collision with root package name */
    ListViewAdapter f32509e;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    MvDatabase f32510f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    TMDBRepositoryImpl f32511g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    TraktRepositoryImpl f32512h;

    /* renamed from: i  reason: collision with root package name */
    CompositeDisposable f32513i;

    public static class ListViewAdapter extends ArrayAdapter<CategoryEntity> {

        /* renamed from: b  reason: collision with root package name */
        int f32514b;

        /* renamed from: c  reason: collision with root package name */
        Context f32515c;

        /* renamed from: d  reason: collision with root package name */
        MvDatabase f32516d;

        /* renamed from: e  reason: collision with root package name */
        CompositeDisposable f32517e;

        static class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            TextView f32521a;

            /* renamed from: b  reason: collision with root package name */
            CheckBox f32522b;

            /* renamed from: c  reason: collision with root package name */
            ImageView f32523c;

            ViewHolder() {
            }
        }

        public ListViewAdapter(Context context, int i2, List<CategoryEntity> list, MvDatabase mvDatabase, CompositeDisposable compositeDisposable) {
            super(context, i2, list);
            this.f32515c = context;
            this.f32514b = i2;
            this.f32516d = mvDatabase;
            this.f32517e = compositeDisposable;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            final CategoryEntity categoryEntity = (CategoryEntity) getItem(i2);
            if (view == null) {
                view = ((Activity) this.f32515c).getLayoutInflater().inflate(this.f32514b, viewGroup, false);
            }
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.f32521a = (TextView) view.findViewById(R.id.txtCategory);
            viewHolder.f32522b = (CheckBox) view.findViewById(R.id.cbRestrict);
            viewHolder.f32523c = (ImageView) view.findViewById(R.id.imgSource);
            viewHolder.f32522b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* access modifiers changed from: private */
                public static /* synthetic */ void c(Boolean bool) throws Exception {
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void d(Throwable th) throws Exception {
                }

                public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    categoryEntity.setRestricted(Boolean.valueOf(z2));
                    ListViewAdapter.this.f32517e.b(Observable.create(new ObservableOnSubscribe<Boolean>() {
                        public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                            ListViewAdapter.this.f32516d.w().b(categoryEntity);
                            observableEmitter.onNext(Boolean.TRUE);
                            observableEmitter.onComplete();
                        }
                    }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(), new f()));
                }
            });
            viewHolder.f32521a.setText(categoryEntity.getName());
            viewHolder.f32522b.setChecked(categoryEntity.getRestricted().booleanValue());
            if (categoryEntity.getSource() == CategoryEntity.Source.TMDB) {
                viewHolder.f32523c.setImageDrawable(this.f32515c.getResources().getDrawable(R.drawable.ic_tmdb_icon));
            } else {
                viewHolder.f32523c.setImageDrawable(this.f32515c.getResources().getDrawable(R.drawable.trakt_icon));
            }
            return view;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource L(CategoryEntity.Type type, List list) throws Exception {
        return this.f32511g.F(type);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List M(int i2, List list) throws Exception {
        return this.f32510f.w().d(i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(List list) throws Exception {
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), R.layout.category_retrict_item, list, this.f32510f, this.f32513i);
        this.f32509e = listViewAdapter;
        this.f32508d.setAdapter(listViewAdapter);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O(Throwable th) throws Exception {
    }

    public static CategoryListFragment P(CategoryEntity.Type type) {
        CategoryListFragment categoryListFragment = new CategoryListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type.getValue());
        categoryListFragment.setArguments(bundle);
        return categoryListFragment;
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().j(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.list_category, viewGroup, false);
        this.f32508d = (ListView) inflate.findViewById(R.id.listCategory);
        return inflate;
    }

    public void onDestroy() {
        this.f32513i.d();
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        int i2 = getArguments().getInt("type");
        CategoryEntity.Type type = CategoryEntity.Type.values()[i2];
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f32513i = compositeDisposable;
        compositeDisposable.b(this.f32512h.g(type).flatMap(new a(this, type)).map(new b(this, i2)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c(this), new d()));
    }
}
