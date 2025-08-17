package com.movie.data;

import com.movie.AppComponent;
import dagger.Component;

@Component(dependencies = {AppComponent.class})
public interface GlideSetupComponent {
    void a(GlideSetup glideSetup);
}
