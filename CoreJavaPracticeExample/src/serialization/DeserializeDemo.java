package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {

	public static void main(String[] args) {

		/*try {
			FileInputStream fis = new FileInputStream(new File("product.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);

			Product product = (Product) ois.readObject();
			System.out.println(product.getName() + ", " + product.getPrice());
			System.out.println(product.getTest() + ", " + product.getTest1());
			System.out.println(product.getFinal1() + ", " + product.getFinal2() + ", " + product.final3);

			fis.close();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/

		 try {
		 FileInputStream fis = new FileInputStream(new File("book.txt"));
		 ObjectInputStream ois = new ObjectInputStream(fis);
		
		 Book book = (Book) ois.readObject();
		 System.out.println(book.getName() + ", " + book.getPrice() + ", " +
		 book.getAuthor());
		
		 fis.close();
		 ois.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 }
	}

}