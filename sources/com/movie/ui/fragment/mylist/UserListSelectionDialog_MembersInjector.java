package com.movie.ui.fragment.mylist;

import com.database.MvDatabase;
import com.movie.data.repository.trakt.TraktRepositoryImpl;
import dagger.MembersInjector;

public final class UserListSelectionDialog_MembersInjector implements MembersInjector<UserListSelectionDialog> {
    public static void a(UserListSelectionDialog userListSelectionDialog, MvDatabase mvDatabase) {
        userListSelectionDialog.f33417i = mvDatabase;
    }

    public static void b(UserListSelectionDialog userListSelectionDialog, TraktRepositoryImpl traktRepositoryImpl) {
        userListSelectionDialog.f33416h = traktRepositoryImpl;
    }
}
