package serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {

		/*Product product = new Product("Kids Toys", 20.00);

		try {
			FileOutputStream fos = new FileOutputStream(new File("product.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(product);

			fos.close();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		 Product book = new Book("India After Gandhi", 20.00, "APJ");
		
		 try {
		 FileOutputStream fos = new FileOutputStream(new File("book.txt"));
		 ObjectOutputStream oos = new ObjectOutputStream(fos);
		 oos.writeObject(book);
		
		 fos.close();
		 oos.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
	}

}