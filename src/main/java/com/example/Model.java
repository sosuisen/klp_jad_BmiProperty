package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import org.hildan.fxgson.FxGsonBuilder;

import com.google.gson.Gson;

public class Model {
	public Bmi bmi;
	private Gson fxGson = new FxGsonBuilder().builder()
				.setPrettyPrinting()
				.create();
	private String filePath = "bmi.json";
	
	private void load() {
		try {
			var json = Files.readString(Path.of(filePath));
			bmi = fxGson.fromJson(json, Bmi.class);
		} catch (NoSuchFileException e) {
			System.out.println("File not found: " + filePath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if (bmi == null) {
			bmi = new Bmi();
		}
	}
	
	public void save() {
		try {
			var json = fxGson.toJson(bmi);
            Files.writeString(Path.of(filePath), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public Model() {
		load();
		bmi.bmi.addListener((obs, oldValue, newValue) -> save());
	}	
}
