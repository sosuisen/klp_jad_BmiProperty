package com.example;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Bmi {
	public DoubleProperty cmHeight = new SimpleDoubleProperty();
	public DoubleProperty kgWeight = new SimpleDoubleProperty();
	public transient NumberBinding bmi = kgWeight.divide(cmHeight.multiply(cmHeight).divide(10000));
}
