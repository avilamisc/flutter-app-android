package org.cmucreatelab.flutter_android.classes.outputs;

import org.cmucreatelab.flutter_android.classes.Settings;
import org.cmucreatelab.flutter_android.classes.relationships.Proportional;
import org.cmucreatelab.flutter_android.classes.relationships.Relationship;
import org.cmucreatelab.flutter_android.classes.sensors.NoSensor;
import org.cmucreatelab.flutter_android.classes.sensors.Sensor;

/**
 * Created by Steve on 8/11/2016.
 *
 * A_Output
 *
 * An abstract class that implements the linking between outputs, sensors and their relationship.
 *
 */
public abstract class A_Output implements Output{

    private Settings settings;


    public A_Output() {}

    // getters
    @Override
    public Settings getSettings() {
        return settings;
    }

    // setters
    @Override
    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
