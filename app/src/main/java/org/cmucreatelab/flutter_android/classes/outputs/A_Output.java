package org.cmucreatelab.flutter_android.classes.outputs;

import org.cmucreatelab.flutter_android.classes.settings.Settings;

/**
 * Created by Steve on 8/11/2016.
 *
 * A_Output
 *
 * An abstract class that holds a Settings object to represent the link between input and output
 *
 */
public abstract class A_Output implements Output{

    private boolean isLinked;
    private Settings settings;
    private int portNumber;


    public A_Output(String type, int max, int min, int portNumber) {
        this.portNumber = portNumber;
        isLinked = false;
        settings = new Settings(type, max, min);
    }

    // getters
    @Override
    public Settings getSettings() {
        return settings;
    }


    @Override
    public int getPortNumber() {
        return portNumber;
    }


    @Override
    public boolean isLinked() {
        return isLinked;
    }


    // setters
    @Override
    public void setSettings(Settings settings) {
        this.settings = settings;
    }


    @Override
    public void setIsLinked(boolean bool, Output output) {
        isLinked = bool;
        if (!isLinked) {
            String type = settings.getType();
            int max = output.getMax();
            int min = output.getMin();
            settings = new Settings(type, max, min);
        }
    }
}
