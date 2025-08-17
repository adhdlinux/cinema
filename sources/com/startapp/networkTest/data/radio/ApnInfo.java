package com.startapp.networkTest.data.radio;

import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.wifi.WifiDetailedStates;
import java.io.Serializable;

public class ApnInfo implements Cloneable, Serializable {
    public String Apn = "";
    public String ApnTypes = "";
    public String Capabilities = "";
    public WifiDetailedStates MobileDataConnectionState = WifiDetailedStates.Unknown;
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public String PcscfAddresses = "";
    public String Reason = "";
    public long RxBytes = -1;
    public String SamsungImsServices = "";
    public int SamsungSipError = -1;
    public int SubscriptionId = -1;
    public long TxBytes = -1;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
