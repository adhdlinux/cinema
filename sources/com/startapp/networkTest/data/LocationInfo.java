package com.startapp.networkTest.data;

import com.startapp.networkTest.enums.LocationProviders;
import java.io.Serializable;

public class LocationInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = -937846764579533362L;
    public int IsMocked = -1;
    public double LocationAccuracyHorizontal;
    public double LocationAccuracyVertical;
    public long LocationAge = -1;
    public double LocationAltitude;
    public double LocationBearing;
    public double LocationLatitude;
    public double LocationLongitude;
    public LocationProviders LocationProvider = LocationProviders.Unknown;
    public double LocationSpeed;
    public String LocationTimestamp = "";
    public transient long locationTimestampMillis;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
