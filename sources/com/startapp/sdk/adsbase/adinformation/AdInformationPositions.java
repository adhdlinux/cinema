package com.startapp.sdk.adsbase.adinformation;

import android.widget.RelativeLayout;

public class AdInformationPositions {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36270a = Position.BOTTOM_LEFT.name();

    public enum Position {
        TOP_LEFT(1, new int[]{10, 9}, -1),
        TOP_RIGHT(2, new int[]{10, 11}, 1),
        BOTTOM_LEFT(3, new int[]{12, 9}, -1),
        BOTTOM_RIGHT(4, new int[]{12, 11}, 1);
        
        private int animationMultiplier;
        private int index;
        private int[] rules;

        private Position(int i2, int[] iArr, int i3) {
            this.rules = iArr;
            this.animationMultiplier = i3;
            this.index = i2;
        }

        public static Position getByIndex(long j2) {
            Position position = BOTTOM_LEFT;
            Position[] values = values();
            for (int i2 = 0; i2 < 4; i2++) {
                if (((long) values[i2].getIndex()) == j2) {
                    position = values[i2];
                }
            }
            return position;
        }

        public static Position getByName(String str) {
            Position position = BOTTOM_LEFT;
            Position[] values = values();
            for (int i2 = 0; i2 < 4; i2++) {
                if (values[i2].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    position = values[i2];
                }
            }
            return position;
        }

        public void addRules(RelativeLayout.LayoutParams layoutParams) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.rules;
                if (i2 < iArr.length) {
                    layoutParams.addRule(iArr[i2]);
                    i2++;
                } else {
                    return;
                }
            }
        }

        public int getAnimationStartMultiplier() {
            return this.animationMultiplier;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
