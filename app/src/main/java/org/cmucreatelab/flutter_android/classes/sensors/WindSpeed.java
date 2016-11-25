package org.cmucreatelab.flutter_android.classes.sensors;

import org.cmucreatelab.flutter_android.R;

import java.io.Serializable;

/**
 * Created by Steve on 8/11/2016.
 *
 * WindSpeed
 *
 * A class representing a wind speed sensor.
 *
 */
public class WindSpeed extends A_Sensor implements Sensor, Serializable {

    private static final Sensor.Type sensorType = Type.WIND_SPEED;
    private static final int sensorTypeId = R.string.wind_speed;
    private static final int highTextId = R.string.fast;
    private static final int lowTextId = R.string.slow;
    private static final int typeTextId = R.string.wind_speed;

    private static final int blueImageId = R.drawable.sensor_blue_wind_speed_l_g_68;
    private static final int greenImageId = R.drawable.sensor_green_wind_speed_l_g_68;
    private static final int orangeImageIdMd = R.drawable.sensor_orange_wind_speed_m_d_40;
    private static final int orangeImageIdSm = R.drawable.sensor_orange_wind_speed_s_m_22;
    private static final int greyImageIdSm = R.drawable.sensor_wind_speed_grey_s_m_20;


    public WindSpeed(int portNumber) {
        super(portNumber);
    }


    @Override
    public Type getSensorType() {
        return sensorType;
    }


    @Override
    public int getSensorTypeId() {
        return sensorTypeId;
    }


    @Override
    public int getHighTextId() {
        return highTextId;
    }


    @Override
    public int getLowTextId() {
        return lowTextId;
    }


    @Override
    public int getTypeTextId() {
        return typeTextId;
    }


    @Override
    public int getBlueImageId() {
        return blueImageId;
    }


    @Override
    public int getGreenImageId() {
        return greenImageId;
    }


    @Override
    public int getOrangeImageIdMd() {
        return orangeImageIdMd;
    }


    @Override
    public int getOrangeImageIdSm() {
        return orangeImageIdSm;
    }


    @Override
    public int getGreyImageIdSm() {
        return greyImageIdSm;
    }

}
