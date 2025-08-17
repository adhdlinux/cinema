package com.startapp.sdk.adsbase.adinformation;

import com.startapp.j0;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import java.io.Serializable;

public class AdInformationOverrides implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean enable = true;
    private boolean enableOverride = false;
    @j0(type = AdInformationPositions.Position.class)
    private AdInformationPositions.Position position = AdInformationPositions.Position.getByName(AdInformationPositions.f36270a);
    private boolean positionOverride = false;

    public static AdInformationOverrides a() {
        return new AdInformationOverrides();
    }

    public AdInformationPositions.Position b() {
        return this.position;
    }

    public boolean c() {
        return this.enable;
    }

    public boolean d() {
        return this.enableOverride;
    }

    public boolean e() {
        return this.positionOverride;
    }

    public void a(boolean z2) {
        this.enable = z2;
        this.enableOverride = true;
    }

    public void a(AdInformationPositions.Position position2) {
        this.position = position2;
        if (position2 != null) {
            this.positionOverride = true;
        } else {
            this.positionOverride = false;
        }
    }
}
