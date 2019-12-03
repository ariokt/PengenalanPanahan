package com.example.ariowaskito.pengenalanpanahan;

public class ItemDetails {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getalamat() {
		return alamat;
	}
	public void setalamat(String alamat) {
		this.alamat= alamat;
	}
	public int getGambar() {
		return image;
	}
	public void setGambar(int image) {
		this.image = image;
	}

	private String name ;
	private String itemDescription;
	private String alamat;
	private int image;

	
}
