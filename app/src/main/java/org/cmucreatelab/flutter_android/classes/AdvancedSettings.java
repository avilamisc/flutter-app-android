package org.cmucreatelab.flutter_android.classes;

/**
 * Created by Steve on 10/25/2016.
 */
public abstract class AdvancedSettings {


    private int inputMax;
    private int inputMin;
    private int zeroValue;

    public AdvancedSettings() {
        inputMax = 100;
        inputMin = 0;
        zeroValue = 0;
    }


    // getters
    public int getInputMax() {
        return inputMax;
    }
    public int getInputMin() {
        return inputMin;
    }
    public int getZeroValue() {
        return zeroValue;
    }


    // setters
    public void setInputMax(int max) {
        inputMax = max;
    }
    public void setInputMin(int min) {
        inputMin = min;
    }
    public void setZeroValue(int zero) {
        zeroValue = zero;
    }

}
