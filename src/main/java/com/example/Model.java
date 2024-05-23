package com.example;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Model {
	public DoubleProperty cmHeight = new SimpleDoubleProperty();
	public DoubleProperty kgWeight = new SimpleDoubleProperty();
	public NumberBinding bmi = kgWeight.divide(cmHeight.multiply(cmHeight).divide(10000));
	// 必要であればcmHeightとkgWeightをセーブ・ロードする
}
