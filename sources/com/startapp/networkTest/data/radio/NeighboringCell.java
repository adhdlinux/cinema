package com.startapp.networkTest.data.radio;

import com.startapp.networkTest.enums.NetworkTypes;
import java.io.Serializable;

public class NeighboringCell implements Cloneable, Serializable {
    private static final long serialVersionUID = 341410194515647516L;
    public int ARFCN = -1;
    public int EcN0 = 0;
    public String GsmCellId = "";
    public String GsmLAC = "";
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public String PrimaryScramblingCode = "";
    public int RXLevel;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
