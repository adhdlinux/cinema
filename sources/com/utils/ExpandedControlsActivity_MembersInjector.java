package com.utils;

import com.original.tase.helper.PlayerHelper;
import dagger.MembersInjector;
import javax.inject.Named;

public final class ExpandedControlsActivity_MembersInjector implements MembersInjector<ExpandedControlsActivity> {
    @Named("ExpandedControlsActivity")
    public static void a(ExpandedControlsActivity expandedControlsActivity, PlayerHelper playerHelper) {
        expandedControlsActivity.f37233b = playerHelper;
    }
}
