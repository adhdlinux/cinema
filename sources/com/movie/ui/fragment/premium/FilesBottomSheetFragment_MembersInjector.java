package com.movie.ui.fragment.premium;

import com.database.MvDatabase;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import dagger.MembersInjector;
import javax.inject.Named;

public final class FilesBottomSheetFragment_MembersInjector implements MembersInjector<FilesBottomSheetFragment> {
    public static void a(FilesBottomSheetFragment filesBottomSheetFragment, MoviesHelper moviesHelper) {
        filesBottomSheetFragment.f33456b = moviesHelper;
    }

    public static void b(FilesBottomSheetFragment filesBottomSheetFragment, MvDatabase mvDatabase) {
        filesBottomSheetFragment.f33458d = mvDatabase;
    }

    public static void c(FilesBottomSheetFragment filesBottomSheetFragment, OpenSubtitleV1Api openSubtitleV1Api) {
        filesBottomSheetFragment.f33460f = openSubtitleV1Api;
    }

    @Named("MainActivity")
    public static void d(FilesBottomSheetFragment filesBottomSheetFragment, PlayerHelper playerHelper) {
        filesBottomSheetFragment.f33459e = playerHelper;
    }

    public static void e(FilesBottomSheetFragment filesBottomSheetFragment, RealDebridApi realDebridApi) {
        filesBottomSheetFragment.f33457c = realDebridApi;
    }
}
