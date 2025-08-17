package com.movie.ui.activity.settings.subfragment;

import com.original.tase.helper.PlayerHelper;
import dagger.MembersInjector;
import javax.inject.Named;

public final class GeneralFragment_MembersInjector implements MembersInjector<GeneralFragment> {
    @Named("MainActivity")
    public static void a(GeneralFragment generalFragment, PlayerHelper playerHelper) {
        generalFragment.playerHelper = playerHelper;
    }
}
