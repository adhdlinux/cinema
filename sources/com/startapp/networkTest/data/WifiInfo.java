package com.startapp.networkTest.data;

import com.startapp.networkTest.enums.HotspotStates;
import com.startapp.networkTest.enums.WifiStates;
import com.startapp.networkTest.enums.wifi.WifiAuthAlgorithms;
import com.startapp.networkTest.enums.wifi.WifiDetailedStates;
import com.startapp.networkTest.enums.wifi.WifiGroupCiphers;
import com.startapp.networkTest.enums.wifi.WifiKeyManagements;
import com.startapp.networkTest.enums.wifi.WifiPairwiseCiphers;
import com.startapp.networkTest.enums.wifi.WifiProtocols;
import com.startapp.networkTest.enums.wifi.WifiSupplicantStates;
import java.io.Serializable;

public class WifiInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = 8111287616823344527L;
    public HotspotStates HotspotState = HotspotStates.Unknown;
    public boolean MissingPermission = false;
    public WifiAuthAlgorithms WifiAuthAlgorithm = WifiAuthAlgorithms.Unknown;
    public String WifiBSSID = "";
    public transient String WifiBSSID_Full;
    public WifiDetailedStates WifiDetailedState = WifiDetailedStates.Unknown;
    public int WifiFrequency = 0;
    public WifiGroupCiphers WifiGroupCipher = WifiGroupCiphers.Unknown;
    public WifiKeyManagements WifiKeyManagement = WifiKeyManagements.Unknown;
    public int WifiLinkQuality = -1;
    public String WifiLinkSpeed = "";
    public transient long WifiLinkSpeedBps;
    public transient String WifiMacAddress = "";
    public WifiPairwiseCiphers WifiPairwiseCipher = WifiPairwiseCiphers.Unknown;
    public WifiProtocols WifiProtocol = WifiProtocols.Unknown;
    public int WifiRxLev;
    public String WifiSSID = "";
    public transient String WifiSSID_Full;
    public WifiStates WifiState = WifiStates.Unknown;
    public WifiSupplicantStates WifiSupplicantState = WifiSupplicantStates.Unknown;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WifiState: " + this.WifiState + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiDetailedState: " + this.WifiDetailedState + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiSupplicantState: " + this.WifiSupplicantState + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiProtocol: " + this.WifiProtocol + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiGroupCipher: " + this.WifiGroupCipher + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiAuthAlgorithm: " + this.WifiAuthAlgorithm + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiPairwiseCipher: " + this.WifiPairwiseCipher + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiFrequency: " + this.WifiFrequency + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiLinkQuality: " + this.WifiLinkQuality + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiLinkSpeed: " + this.WifiLinkSpeed + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiRxLev: " + this.WifiRxLev + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiBSSID: " + this.WifiBSSID + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiSSID: " + this.WifiSSID + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append("WifiMacAddress: " + this.WifiMacAddress + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return sb.toString();
    }
}
