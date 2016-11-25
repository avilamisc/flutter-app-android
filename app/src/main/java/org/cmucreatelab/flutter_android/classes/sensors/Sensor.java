package org.cmucreatelab.flutter_android.classes.sensors;
/**
 * Created by Steve on 6/20/2016.
 *
 * Sensor
 *
 * Interface for the anything is a sensor. There are various types of sensors defined in the enum 'Type'
 *
 */
public interface Sensor {

    public static final String SENSOR_KEY = "sensor_key";
    public static final String SENSOR_PORT_KEY = "sensor_text_key";

    // I am unsure of the use of an Analog or Unknown Sensor.
    // Is this for error checking? Should the user always have a sensor that is defined?
    enum Type {
        LIGHT,
        SOIL_MOISTURE,
        DISTANCE,
        SOUND,
        WIND_SPEED,
        HUMIDITY,
        TEMPERATURE,
        BAROMETRIC_PRESSURE,
        ANALOG_OR_UNKNOWN,
        NO_SENSOR
    }

    Type getSensorType();
    int getSensorTypeId();
    int getHighTextId();
    int getLowTextId();
    int getTypeTextId();
    int getBlueImageId();
    int getGreenImageId();
    int getOrangeImageIdMd();
    int getOrangeImageIdSm();
    int getGreyImageIdSm();
    int getSensorReading();
    int getPortNumber();
    void setSensorReading(int value);

}
