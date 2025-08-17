package com.startapp.networkTest.data;

import java.io.Serializable;

public class IspInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = -884736715180732782L;
    public String AutonomousSystemNumber = "";
    public String AutonomousSystemOrganization = "";
    public String IpAddress = "";
    public String IspName = "";
    public String IspOrganizationalName = "";
    public boolean SuccessfulIspLookup = false;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
