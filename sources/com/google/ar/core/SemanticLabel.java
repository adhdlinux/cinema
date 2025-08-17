package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum SemanticLabel {
    UNLABELED(0),
    SKY(1),
    BUILDING(2),
    TREE(3),
    ROAD(4),
    SIDEWALK(5),
    TERRAIN(6),
    STRUCTURE(7),
    OBJECT(8),
    VEHICLE(9),
    PERSON(10),
    WATER(11);
    
    final int nativeCode;

    private SemanticLabel(int i2) {
        this.nativeCode = i2;
    }

    static SemanticLabel forNumber(int i2) {
        for (SemanticLabel semanticLabel : values()) {
            if (semanticLabel.nativeCode == i2) {
                return semanticLabel;
            }
        }
        throw new FatalException(p.b((byte) 49, i2, "Unexpected value for native SemanticLabel, value="));
    }
}
