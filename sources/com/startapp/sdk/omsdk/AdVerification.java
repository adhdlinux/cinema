package com.startapp.sdk.omsdk;

import com.startapp.j0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class AdVerification implements Serializable {
    private static final long serialVersionUID = 1;
    @j0(name = "adVerifications", type = VerificationDetails.class)
    private VerificationDetails[] adVerification;

    public AdVerification() {
    }

    public List<VerificationDetails> a() {
        VerificationDetails[] verificationDetailsArr = this.adVerification;
        if (verificationDetailsArr == null) {
            return null;
        }
        return Arrays.asList(verificationDetailsArr);
    }

    public AdVerification(VerificationDetails[] verificationDetailsArr) {
        this.adVerification = verificationDetailsArr;
    }
}
