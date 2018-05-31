/*
 * Copyright (C) 2011 Jason von Nieda <jason@vonnieda.org>
 * 
 * This file is part of OpenPnP.
 * 
 * OpenPnP is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * OpenPnP is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with OpenPnP. If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * For more information about OpenPnP visit http://openpnp.org
 */

package org.openpnp.machine.reference.camera.wizards;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.Converter;
import org.openpnp.capture.CaptureDevice;
import org.openpnp.capture.CaptureFormat;
import org.openpnp.gui.components.ComponentDecorators;
import org.openpnp.gui.support.IntegerConverter;
import org.openpnp.machine.reference.camera.OpenCvCamera.OpenCvCapturePropertyValue;
import org.openpnp.machine.reference.camera.OpenPnpCaptureCamera;
import org.openpnp.machine.reference.wizards.ReferenceCameraConfigurationWizard;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class OpenPnpCaptureCameraConfigurationWizard extends ReferenceCameraConfigurationWizard {
    private final OpenPnpCaptureCamera camera;

    private List<OpenCvCapturePropertyValue> properties = new ArrayList<>();
    private JPanel panel;
    private JComboBox deviceCb;
    private JLabel lblDevice;
    private JLabel lblFormat;
    private JComboBox formatCb;
    private JLabel exposure;
    private JLabel exposureMin;
    private JLabel lblMax;
    private JLabel lblMin_1;
    private JLabel exposureMax;
    private JLabel lblValue;
    private JLabel whiteBalance;
    private JLabel focus;
    private JLabel zoom;
    private JLabel gain;
    private JLabel whiteBalanceMin;
    private JLabel focusMin;
    private JLabel zoomMin;
    private JLabel gainMin;
    private JLabel whiteBalanceMax;
    private JLabel focusMax;
    private JLabel zoomMax;
    private JLabel gainMax;
    private JLabel lblAuto;
    private JCheckBox exposureAuto;
    private JCheckBox zoomAuto;
    private JCheckBox focusAuto;
    private JSlider focusSlider;
    private JSlider exposureSlider;
    private JSlider whiteBalanceSlider;
    private JSlider zoomSlider;
    private JCheckBox whiteBalanceAuto;
    private JCheckBox gainAuto;
    private JSlider gainSlider;
    private JLabel lblFps;
    private JTextField fps;
    private JTextField exposureValue;
    private JTextField whiteBalanceValue;
    private JTextField focusValue;
    private JTextField zoomValue;
    private JTextField gainValue;
    private JLabel brightness;
    private JCheckBox brightnessAuto;
    private JLabel brightnessMin;
    private JSlider brightnessSlider;
    private JTextField brightnessValue;
    private JLabel brightnessMax;
    private JLabel contrast;
    private JCheckBox contrastAuto;
    private JLabel contrastMin;
    private JSlider contrastSlider;
    private JTextField contrastValue;
    private JLabel contrastMax;
    private JLabel gamma;
    private JCheckBox gammaAuto;
    private JLabel gammaMin;
    private JSlider gammaSlider;
    private JTextField gammaValue;
    private JLabel gammaMax;
    private JLabel saturation;
    private JCheckBox saturationAuto;
    private JLabel saturationMin;
    private JSlider saturationSlider;
    private JTextField saturationValue;
    private JLabel saturationMax;
    private JLabel lblDefault;
    private JLabel brightnessDefault;
    private JLabel contrastDefault;
    private JLabel exposureDefault;
    private JLabel focusDefault;
    private JLabel gainDefault;
    private JLabel gammaDefault;
    private JLabel saturationDefault;
    private JLabel whiteBalanceDefault;
    private JLabel zoomDefault;
    private JLabel backLightCompensation;
    private JLabel backLightCompensationMin;
    private JSlider backLightCompensationSlider;
    private JTextField backLightCompensationValue;
    private JLabel backLightCompensationMax;
    private JLabel backLightCompensationDefault;
    private JCheckBox backLightCompensationAuto;
    private JLabel hue;
    private JCheckBox hueAuto;
    private JLabel hueMin;
    private JSlider hueSlider;
    private JTextField hueValue;
    private JLabel hueMax;
    private JLabel hueDefault;
    private JLabel powerLineFrequency;
    private JCheckBox powerLineFrequencyAuto;
    private JLabel powerLineFrequencyMin;
    private JSlider powerLineFrequencySlider;
    private JTextField powerLineFrequencyValue;
    private JLabel powerLineFrequencyMax;
    private JLabel powerLineFrequencyDefault;
    private JLabel sharpness;
    private JCheckBox sharpnessAuto;
    private JLabel sharpnessMin;
    private JSlider sharpnessSlider;
    private JTextField sharpnessValue;
    private JLabel sharpnessMax;
    private JLabel sharpnessDefault;

    public OpenPnpCaptureCameraConfigurationWizard(OpenPnpCaptureCamera camera) {
        super(camera);
        this.camera = camera;
        createUi();
    }

    private void createUi() {

        panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP,
                null, null));
        contentPanel.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("left:default"),
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("center:default"),
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,},
            new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,}));

        lblDevice = new JLabel("Device");
        panel.add(lblDevice, "2, 2, right, default");

        deviceCb = new JComboBox();
        panel.add(deviceCb, "4, 2, 15, 1");

        lblFormat = new JLabel("Format");
        panel.add(lblFormat, "2, 4, right, default");

        formatCb = new JComboBox();
        panel.add(formatCb, "4, 4, 15, 1, fill, default");

        lblFps = new JLabel("FPS");
        panel.add(lblFps, "2, 6, right, default");

        fps = new JTextField();
        panel.add(fps, "4, 6, 15, 1");
        fps.setColumns(10);

        lblAuto = new JLabel("Auto");
        panel.add(lblAuto, "4, 8, center, default");

        lblMin_1 = new JLabel("Min");
        panel.add(lblMin_1, "8, 8, center, default");

        lblValue = new JLabel("Value");
        panel.add(lblValue, "12, 8, 3, 1, center, default");

        lblMax = new JLabel("Max");
        panel.add(lblMax, "18, 8, center, default");

        lblDefault = new JLabel("Default");
        panel.add(lblDefault, "22, 8");

        brightness = new JLabel("Brightness");
        panel.add(brightness, "2, 10, right, default");

        brightnessAuto = new JCheckBox("");
        panel.add(brightnessAuto, "4, 10");

        brightnessMin = new JLabel("min");
        panel.add(brightnessMin, "8, 10");

        brightnessSlider = new JSlider();
        brightnessSlider.setPaintTicks(true);
        brightnessSlider.setPaintLabels(true);
        panel.add(brightnessSlider, "12, 10");

        brightnessValue = new JTextField();
        brightnessValue.setText("00000");
        brightnessValue.setColumns(5);
        panel.add(brightnessValue, "14, 10, center, default");

        brightnessMax = new JLabel("max");
        panel.add(brightnessMax, "18, 10");

        brightnessDefault = new JLabel("def");
        panel.add(brightnessDefault, "22, 10");
        
        backLightCompensation = new JLabel("Backlight Compensation");
        panel.add(backLightCompensation, "2, 12, right, default");
        
        backLightCompensationAuto = new JCheckBox("");
        panel.add(backLightCompensationAuto, "4, 12");
        
        backLightCompensationMin = new JLabel("min");
        panel.add(backLightCompensationMin, "8, 12");
        
        backLightCompensationSlider = new JSlider();
        backLightCompensationSlider.setPaintTicks(true);
        backLightCompensationSlider.setPaintLabels(true);
        panel.add(backLightCompensationSlider, "12, 12");
        
        backLightCompensationValue = new JTextField();
        backLightCompensationValue.setText("00000");
        backLightCompensationValue.setColumns(5);
        panel.add(backLightCompensationValue, "14, 12, center, default");
        
        backLightCompensationMax = new JLabel("max");
        panel.add(backLightCompensationMax, "18, 12");
        
        backLightCompensationDefault = new JLabel("def");
        panel.add(backLightCompensationDefault, "22, 12");

        contrast = new JLabel("Contrast");
        panel.add(contrast, "2, 14, right, default");

        contrastAuto = new JCheckBox("");
        panel.add(contrastAuto, "4, 14");

        contrastMin = new JLabel("min");
        panel.add(contrastMin, "8, 14");

        contrastSlider = new JSlider();
        contrastSlider.setPaintTicks(true);
        contrastSlider.setPaintLabels(true);
        panel.add(contrastSlider, "12, 14");

        contrastValue = new JTextField();
        contrastValue.setText("00000");
        contrastValue.setColumns(5);
        panel.add(contrastValue, "14, 14, center, default");

        contrastMax = new JLabel("max");
        panel.add(contrastMax, "18, 14");

        contrastDefault = new JLabel("def");
        panel.add(contrastDefault, "22, 14");

        exposure = new JLabel("Exposure");
        panel.add(exposure, "2, 16, right, default");

        exposureAuto = new JCheckBox("");
        panel.add(exposureAuto, "4, 16, center, default");

        exposureMin = new JLabel("min");
        panel.add(exposureMin, "8, 16, center, default");

        exposureSlider = new JSlider();
        exposureSlider.setPaintLabels(true);
        exposureSlider.setPaintTicks(true);
        panel.add(exposureSlider, "12, 16, center, default");

        exposureValue = new JTextField();
        exposureValue.setText("00000");
        panel.add(exposureValue, "14, 16, center, default");
        exposureValue.setColumns(5);

        exposureMax = new JLabel("max");
        panel.add(exposureMax, "18, 16, center, default");

        exposureDefault = new JLabel("def");
        panel.add(exposureDefault, "22, 16");

        focusDefault = new JLabel("def");
        panel.add(focusDefault, "22, 18");

        gainDefault = new JLabel("def");
        panel.add(gainDefault, "22, 20");

        gamma = new JLabel("Gamma");
        panel.add(gamma, "2, 22, right, default");

        gammaAuto = new JCheckBox("");
        panel.add(gammaAuto, "4, 22");

        gammaMin = new JLabel("min");
        panel.add(gammaMin, "8, 22");

        gammaSlider = new JSlider();
        gammaSlider.setPaintTicks(true);
        gammaSlider.setPaintLabels(true);
        panel.add(gammaSlider, "12, 22");

        gammaValue = new JTextField();
        gammaValue.setText("00000");
        gammaValue.setColumns(5);
        panel.add(gammaValue, "14, 22, center, default");

        gammaMax = new JLabel("max");
        panel.add(gammaMax, "18, 22");

        gammaDefault = new JLabel("def");
        panel.add(gammaDefault, "22, 22");
        
        hue = new JLabel("Hue");
        panel.add(hue, "2, 24, right, default");
        
        hueAuto = new JCheckBox("");
        panel.add(hueAuto, "4, 24");
        
        hueMin = new JLabel("min");
        panel.add(hueMin, "8, 24");
        
        hueSlider = new JSlider();
        hueSlider.setPaintTicks(true);
        hueSlider.setPaintLabels(true);
        panel.add(hueSlider, "12, 24");
        
        hueValue = new JTextField();
        hueValue.setText("00000");
        hueValue.setColumns(5);
        panel.add(hueValue, "14, 24, center, default");
        
        hueMax = new JLabel("max");
        panel.add(hueMax, "18, 24");
        
        hueDefault = new JLabel("def");
        panel.add(hueDefault, "22, 24");
        
        powerLineFrequency = new JLabel("Power Line Freq.");
        panel.add(powerLineFrequency, "2, 26, right, default");
        
        powerLineFrequencyAuto = new JCheckBox("");
        panel.add(powerLineFrequencyAuto, "4, 26");
        
        powerLineFrequencyMin = new JLabel("min");
        panel.add(powerLineFrequencyMin, "8, 26");
        
        powerLineFrequencySlider = new JSlider();
        powerLineFrequencySlider.setPaintTicks(true);
        powerLineFrequencySlider.setPaintLabels(true);
        panel.add(powerLineFrequencySlider, "12, 26");
        
        powerLineFrequencyValue = new JTextField();
        powerLineFrequencyValue.setText("00000");
        powerLineFrequencyValue.setColumns(5);
        panel.add(powerLineFrequencyValue, "14, 26, center, default");
        
        powerLineFrequencyMax = new JLabel("max");
        panel.add(powerLineFrequencyMax, "18, 26");
        
        powerLineFrequencyDefault = new JLabel("def");
        panel.add(powerLineFrequencyDefault, "22, 26");

        saturation = new JLabel("Saturation");
        panel.add(saturation, "2, 28, right, default");

        saturationAuto = new JCheckBox("");
        panel.add(saturationAuto, "4, 28");

        saturationMin = new JLabel("min");
        panel.add(saturationMin, "8, 28");

        saturationSlider = new JSlider();
        saturationSlider.setPaintTicks(true);
        saturationSlider.setPaintLabels(true);
        panel.add(saturationSlider, "12, 28");

        saturationValue = new JTextField();
        saturationValue.setText("00000");
        saturationValue.setColumns(5);
        panel.add(saturationValue, "14, 28, center, default");

        saturationMax = new JLabel("max");
        panel.add(saturationMax, "18, 28");

        saturationDefault = new JLabel("def");
        panel.add(saturationDefault, "22, 28");
        
        sharpness = new JLabel("Sharpness");
        panel.add(sharpness, "2, 30, right, default");
        
        sharpnessAuto = new JCheckBox("");
        panel.add(sharpnessAuto, "4, 30");
        
        sharpnessMin = new JLabel("min");
        panel.add(sharpnessMin, "8, 30");
        
        sharpnessSlider = new JSlider();
        sharpnessSlider.setPaintTicks(true);
        sharpnessSlider.setPaintLabels(true);
        panel.add(sharpnessSlider, "12, 30");
        
        sharpnessValue = new JTextField();
        sharpnessValue.setText("00000");
        sharpnessValue.setColumns(5);
        panel.add(sharpnessValue, "14, 30, center, default");
        
        sharpnessMax = new JLabel("max");
        panel.add(sharpnessMax, "18, 30");
        
        sharpnessDefault = new JLabel("def");
        panel.add(sharpnessDefault, "22, 30");

        whiteBalance = new JLabel("White Balance");
        panel.add(whiteBalance, "2, 32, right, default");

        whiteBalanceAuto = new JCheckBox("");
        panel.add(whiteBalanceAuto, "4, 32, center, default");

        whiteBalanceMin = new JLabel("min");
        panel.add(whiteBalanceMin, "8, 32, center, default");

        whiteBalanceSlider = new JSlider();
        whiteBalanceSlider.setPaintTicks(true);
        whiteBalanceSlider.setPaintLabels(true);
        panel.add(whiteBalanceSlider, "12, 32, center, default");

        whiteBalanceValue = new JTextField();
        whiteBalanceValue.setText("00000");
        whiteBalanceValue.setColumns(5);
        panel.add(whiteBalanceValue, "14, 32, center, default");

        whiteBalanceMax = new JLabel("max");
        panel.add(whiteBalanceMax, "18, 32, center, default");

        focus = new JLabel("Focus");
        panel.add(focus, "2, 18, right, default");

        focusAuto = new JCheckBox("");
        panel.add(focusAuto, "4, 18, center, default");

        focusMin = new JLabel("min");
        panel.add(focusMin, "8, 18, center, default");

        focusSlider = new JSlider();
        focusSlider.setPaintTicks(true);
        focusSlider.setPaintLabels(true);
        panel.add(focusSlider, "12, 18, center, default");

        focusValue = new JTextField();
        focusValue.setText("00000");
        focusValue.setColumns(5);
        panel.add(focusValue, "14, 18, center, default");

        focusMax = new JLabel("max");
        panel.add(focusMax, "18, 18, center, default");

        whiteBalanceDefault = new JLabel("def");
        panel.add(whiteBalanceDefault, "22, 32");

        zoom = new JLabel("Zoom");
        panel.add(zoom, "2, 34, right, default");

        zoomAuto = new JCheckBox("");
        panel.add(zoomAuto, "4, 34, center, default");

        zoomMin = new JLabel("min");
        panel.add(zoomMin, "8, 34, center, default");

        zoomSlider = new JSlider();
        zoomSlider.setPaintTicks(true);
        zoomSlider.setPaintLabels(true);
        panel.add(zoomSlider, "12, 34, center, default");

        zoomValue = new JTextField();
        zoomValue.setText("00000");
        zoomValue.setColumns(5);
        panel.add(zoomValue, "14, 34, center, default");

        zoomMax = new JLabel("max");
        panel.add(zoomMax, "18, 34, center, default");

        gain = new JLabel("Gain");
        panel.add(gain, "2, 20, right, default");

        gainAuto = new JCheckBox("");
        panel.add(gainAuto, "4, 20, center, default");

        gainMin = new JLabel("min");
        panel.add(gainMin, "8, 20, center, default");

        gainSlider = new JSlider();
        gainSlider.setPaintTicks(true);
        gainSlider.setPaintLabels(true);
        panel.add(gainSlider, "12, 20, center, default");

        gainValue = new JTextField();
        gainValue.setText("00000");
        gainValue.setColumns(5);
        panel.add(gainValue, "14, 20, center, default");

        gainMax = new JLabel("max");
        panel.add(gainMax, "18, 20, center, default");

        zoomDefault = new JLabel("def");
        panel.add(zoomDefault, "22, 34");

        deviceCb.addActionListener(l -> {
            formatCb.removeAllItems();
            CaptureDevice dev = (CaptureDevice) deviceCb.getSelectedItem();
            if (dev == null) {
                return;
            }
            for (CaptureFormat format : dev.getFormats()) {
                formatCb.addItem(format);
            }
        });

        for (CaptureDevice dev : camera.getCaptureDevices()) {
            deviceCb.addItem(dev);
        }
    }

    @Override
    public void createBindings() {
        super.createBindings();

        IntegerConverter intConverter = new IntegerConverter();

        addWrappedBinding(camera, "device", deviceCb, "selectedItem");
        addWrappedBinding(camera, "format", formatCb, "selectedItem");

        addWrappedBinding(camera, "fps", fps, "text", intConverter);

        bindProperty("backLightCompensation", backLightCompensationAuto, backLightCompensationMin, 
                backLightCompensationMax, backLightCompensationSlider,
                backLightCompensation, backLightCompensationValue, backLightCompensationDefault);
        bindProperty("brightness", brightnessAuto, brightnessMin, brightnessMax, brightnessSlider,
                brightness, brightnessValue, brightnessDefault);
        bindProperty("contrast", contrastAuto, contrastMin, contrastMax, contrastSlider, contrast,
                contrastValue, contrastDefault);
        bindProperty("exposure", exposureAuto, exposureMin, exposureMax, exposureSlider, exposure,
                exposureValue, exposureDefault);
        bindProperty("focus", focusAuto, focusMin, focusMax, focusSlider, focus, focusValue, focusDefault);
        bindProperty("gain", gainAuto, gainMin, gainMax, gainSlider, gain, gainValue, gainDefault);
        bindProperty("gamma", gammaAuto, gammaMin, gammaMax, gammaSlider, gamma, gammaValue, gammaDefault);
        bindProperty("hue", hueAuto, hueMin, hueMax, hueSlider, hue, hueValue, hueDefault);
        bindProperty("powerLineFrequency", powerLineFrequencyAuto, powerLineFrequencyMin, 
                powerLineFrequencyMax, powerLineFrequencySlider, powerLineFrequency, powerLineFrequencyValue, powerLineFrequencyDefault);
        bindProperty("saturation", saturationAuto, saturationMin, saturationMax, saturationSlider,
                saturation, saturationValue, saturationDefault);
        bindProperty("sharpness", sharpnessAuto, sharpnessMin, sharpnessMax, sharpnessSlider,
                sharpness, sharpnessValue, sharpnessDefault);
        bindProperty("whiteBalance", whiteBalanceAuto, whiteBalanceMin, whiteBalanceMax,
                whiteBalanceSlider, whiteBalance, whiteBalanceValue, whiteBalanceDefault);
        bindProperty("zoom", zoomAuto, zoomMin, zoomMax, zoomSlider, zoom, zoomValue, zoomDefault);

        ComponentDecorators.decorateWithAutoSelect(fps);
    }

    private void bindProperty(String property, JCheckBox auto, JLabel min, JLabel max,
            JSlider slider, JLabel label, JTextField value, JLabel def) {
        IntegerConverter intConverter = new IntegerConverter();

        bind(UpdateStrategy.READ_WRITE, camera, property + ".auto", auto, "selected");

        bind(UpdateStrategy.READ, camera, property + ".min", min, "text", intConverter);
        bind(UpdateStrategy.READ, camera, property + ".max", max, "text", intConverter);
        bind(UpdateStrategy.READ, camera, property + ".default", def, "text", intConverter);

        bind(UpdateStrategy.READ, camera, property + ".min", slider, "minimum");
        bind(UpdateStrategy.READ, camera, property + ".max", slider, "maximum");
        bind(UpdateStrategy.READ_WRITE, camera, property + ".value", slider, "value");
        bind(UpdateStrategy.READ_WRITE, camera, property + ".value", value, "text", intConverter);

        bind(UpdateStrategy.READ, camera, property + ".autoSupported", auto, "enabled");
        bind(UpdateStrategy.READ, camera, property + ".supported", slider, "enabled");
        bind(UpdateStrategy.READ, camera, property + ".supported", label, "enabled");
        bind(UpdateStrategy.READ, camera, property + ".supported", value, "enabled");
        
        ComponentDecorators.decorateWithAutoSelect(value);
    }

    @Override
    protected void saveToModel() {
        super.saveToModel();
        camera.open();
    }

    class BooleanInverter extends Converter<Boolean, Boolean> {
        @Override
        public Boolean convertForward(Boolean arg0) {
            return !arg0;
        }

        @Override
        public Boolean convertReverse(Boolean arg0) {
            return !arg0;
        }
    }
}
