package com.example;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Model {
	public DoubleProperty cmHeight = new SimpleDoubleProperty();
	public DoubleProperty kgWeight = new SimpleDoubleProperty();
	public DoubleProperty bmi = new SimpleDoubleProperty();
	
	public void calc() {
		double height = cmHeight.getValue() / 100;
		double weight = kgWeight.getValue();
		bmi.set(weight / (height * height));
	}
}
