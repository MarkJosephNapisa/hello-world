package com.example.midtermlab;

import android.net.Uri;

public class Person {
	
	private Uri imageUri;
	private String name;
	
	
	public Person(Uri imageUri, String name) {
		super();
		this.imageUri = imageUri;
		this.name = name;
	}


	public Uri getImageUri() {
		return imageUri;
	}


	public void setImageUri(Uri imageUri) {
		this.imageUri = imageUri;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
