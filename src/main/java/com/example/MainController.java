package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class MainController {
    @FXML
    private Label bmiLabel;

    @FXML
    private Button calcButton;

    @FXML
    private TextField heightField;
    
    @FXML
    private TextField weightField;
    
    @FXML
    private Slider heightSlider;

    @FXML
    private Slider weightSlider;

    @FXML
    private Label bmiCategory;
    
    private Model model;
    
    private String getBmiLabel(float bmi) {
		var text = "肥満";
		if(bmi < 18.5) text = "痩せ型";
		else if(bmi < 25) text = "普通";
        return text;
    }
    
    private void adjustBmiLabel() {   	
		if (bmiLabel.getText().equals("NaN") || bmiLabel.getText().equals("Infinity")) {
			bmiLabel.setText("");
		}
    }
    
    public void initModel(Model model) {
		if (this.model != null)
			throw new IllegalStateException("Model can only be initialized once");
		
    	this.model = model;
    	
    	// Bind Model to View
		bmiLabel.textProperty().bind(model.bmi.asString("%.1f"));
    	// NanやInfinityの場合は空文字にするには次のようにカスタムのバインディングを使う
    	/*
		bmiLabel.textProperty().bind(Bindings.createStringBinding(() -> {
            double value = model.bmi.doubleValue();
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                return "";
            } else {
                return String.valueOf(value);
            }
        }, model.bmi));
        */		
		heightField.textProperty().bindBidirectional(model.cmHeight, new NumberStringConverter());
		weightField.textProperty().bindBidirectional(model.kgWeight, new NumberStringConverter());
		
		heightSlider.valueProperty().bindBidirectional(model.cmHeight);
		weightSlider.valueProperty().bindBidirectional(model.kgWeight);	
		
		model.bmi.addListener((obs, oldVal, newVal) -> {
			bmiCategory.setText(getBmiLabel(newVal.floatValue()));
		});
    }
    
	public void initialize() {
		// Write your initialization code here
	}
}