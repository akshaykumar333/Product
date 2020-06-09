package com.Amazon.app;

import java.io.File;
import java.io.FileNotFoundException;

public class UserInterface {

	public static void main(String[] args) throws FileNotFoundException {
		Product product = new Product();

		product.setName("iphone x");
		product.setPrice(64000);
		product.setDescription("The iPhone X was Apple's flagship 10th anniversary iPhone featuring a 5.8-inch OLED display, facial recognition and 3D camera functionality, a glass body, and an A11 Bionic processor");
		product.setRating(4.2);
		File image = new File("C:\\Users\\Akshay Kumar\\Pictures\\iphone.jpeg");
		product.setImage(image);
		
		
		InsertData insert=new InsertData();
		
		insert.addData(product);
		
	}

}
