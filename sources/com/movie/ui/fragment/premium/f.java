package com.movie.ui.fragment.premium;

import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilesBottomSheetFragment f33560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f33561c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f33562d;

    public /* synthetic */ f(FilesBottomSheetFragment filesBottomSheetFragment, MovieEntity movieEntity, MovieInfo movieInfo) {
        this.f33560b = filesBottomSheetFragment;
        this.f33561c = movieEntity;
        this.f33562d = movieInfo;
    }

    public final void accept(Object obj) {
        this.f33560b.Z(this.f33561c, this.f33562d, (ArrayList) obj);
    }
}
