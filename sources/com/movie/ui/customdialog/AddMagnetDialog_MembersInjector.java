package com.movie.ui.customdialog;

import com.database.MvDatabase;
import com.movie.data.api.realdebrid.RealDebridApi;
import dagger.MembersInjector;

public final class AddMagnetDialog_MembersInjector implements MembersInjector<AddMagnetDialog> {
    public static void a(AddMagnetDialog addMagnetDialog, MvDatabase mvDatabase) {
        addMagnetDialog.f33156e = mvDatabase;
    }

    public static void b(AddMagnetDialog addMagnetDialog, RealDebridApi realDebridApi) {
        addMagnetDialog.f33153b = realDebridApi;
    }
}
