package org.cmucreatelab.flutter_android.ui.dialogs.robots_tab.outputs.speaker.tab_volume;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.cmucreatelab.flutter_android.R;
import org.cmucreatelab.flutter_android.classes.outputs.Speaker;
import org.cmucreatelab.flutter_android.classes.sensors.Sensor;
import org.cmucreatelab.flutter_android.classes.settings.AdvancedSettings;
import org.cmucreatelab.flutter_android.classes.settings.SettingsAmplitude;
import org.cmucreatelab.flutter_android.ui.dialogs.robots_tab.children.AdvancedSettingsDialog;
import org.cmucreatelab.flutter_android.ui.dialogs.robots_tab.children.MaxVolumeDialog;
import org.cmucreatelab.flutter_android.ui.dialogs.robots_tab.children.MinVolumeDialog;
import org.cmucreatelab.flutter_android.ui.dialogs.robots_tab.outputs.speaker.SpeakerDialog;

/**
 * Created by mike on 4/6/17.
 *
 * SpeakerVolumeStateHelper implementation with Amplitude relationship
 *
 */
public class SpeakerVolumeAmplitude extends SpeakerVolumeStateHelper {


    SpeakerVolumeAmplitude(Speaker speaker) {
        super(speaker);
    }


    public static SpeakerVolumeAmplitude newInstance(Speaker speaker) {
        return new SpeakerVolumeAmplitude(speaker);
    }


    @Override
    public void updateView(SpeakerDialog dialog) {
        ImageView advancedSettingsView = (ImageView) dialog.dialogView.findViewById(R.id.image_advanced_settings);
        LinearLayout linkedSensor = (LinearLayout) dialog.dialogView.findViewById(R.id.linear_set_linked_sensor);
        LinearLayout minVolumeLayout = (LinearLayout) dialog.dialogView.findViewById(R.id.linear_set_min_volume);

        SettingsAmplitude volumeSettings = (SettingsAmplitude) getSpeaker().getVolume().getSettings();

        // advanced settings
        advancedSettingsView.setVisibility(View.VISIBLE);

        // sensor
        linkedSensor.setVisibility(View.VISIBLE);
        ((ImageView)linkedSensor.getChildAt(0)).setImageResource(getSpeaker().getVolume().getSettings().getSensor().getGreenImageId());
        ViewGroup sensorViewGroup = ((ViewGroup)linkedSensor.getChildAt(2));
        ((TextView)sensorViewGroup.getChildAt(0)).setText(R.string.linked_sensor);
        ((TextView)sensorViewGroup.getChildAt(1)).setText(getSpeaker().getVolume().getSettings().getSensor().getSensorTypeId());

        // max Volume
        ImageView maxVolumeImg = (ImageView) dialog.dialogView.findViewById(R.id.image_max_volume);
        maxVolumeImg.setImageResource(R.drawable.link_icon_volume_high);
        TextView maxVolumeTxt = (TextView) dialog.dialogView.findViewById(R.id.text_max_volume);
        maxVolumeTxt.setText(dialog.getString(getSpeaker().getVolume().getSettings().getSensor().getHighTextId()) + " " + dialog.getString(R.string.volume));
        TextView maxVolumeValue = (TextView) dialog.dialogView.findViewById(R.id.text_max_volume_value);
        maxVolumeValue.setText(String.valueOf(volumeSettings.getOutputMax()));

        // min Volume
        minVolumeLayout.setVisibility(View.VISIBLE);
        ImageView minVolumeImg = (ImageView) dialog.dialogView.findViewById(R.id.image_min_volume);
        minVolumeImg.setImageResource(R.drawable.link_icon_volume_low);
        TextView minVolumeTxt = (TextView) dialog.dialogView.findViewById(R.id.text_min_volume);
        minVolumeTxt.setText(dialog.getString(getSpeaker().getVolume().getSettings().getSensor().getLowTextId()) + " " + dialog.getString(R.string.volume));
        TextView minVolumeValue = (TextView) dialog.dialogView.findViewById(R.id.text_min_volume_value);
        minVolumeValue.setText(String.valueOf(volumeSettings.getOutputMin()));
    }


    @Override
    public void clickAdvancedSettings(SpeakerDialog dialog) {
        DialogFragment fragment = AdvancedSettingsDialog.newInstance(dialog, getSpeaker().getVolume());
        fragment.show(dialog.getFragmentManager(), "tag");
    }


    @Override
    public void clickMin(SpeakerDialog dialog) {
        SettingsAmplitude volumeSettings = (SettingsAmplitude) getSpeaker().getVolume().getSettings();
        DialogFragment fragment = MinVolumeDialog.newInstance(volumeSettings.getOutputMin(),dialog);
        fragment.show(dialog.getFragmentManager(), "tag");
    }


    @Override
    public void clickMax(SpeakerDialog dialog) {
        SettingsAmplitude volumeSettings = (SettingsAmplitude) getSpeaker().getVolume().getSettings();
        DialogFragment fragment = MaxVolumeDialog.newInstance(volumeSettings.getOutputMax(),dialog);
        fragment.show(dialog.getFragmentManager(), "tag");
    }


    @Override
    public void setAdvancedSettings(AdvancedSettings advancedSettings) {
        SettingsAmplitude settingsVolume = (SettingsAmplitude) getSpeaker().getVolume().getSettings();
        settingsVolume.setAdvancedSettings(advancedSettings);
    }


    @Override
    public void setLinkedSensor(Sensor sensor) {
        SettingsAmplitude settingsAmplitude = (SettingsAmplitude) getSpeaker().getVolume().getSettings();
        settingsAmplitude.setSensorPortNumber(sensor.getPortNumber());
    }


    @Override
    public void setMinimum(int minimum) {
        SettingsAmplitude settingsAmplitude = (SettingsAmplitude) getSpeaker().getVolume().getSettings();
        settingsAmplitude.setOutputMin(minimum);
    }


    @Override
    public void setMaximum(int maximum) {
        SettingsAmplitude settingsAmplitude = (SettingsAmplitude) getSpeaker().getVolume().getSettings();
        settingsAmplitude.setOutputMax(maximum);
    }

}
