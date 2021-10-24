package milestone.cst135n;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataService {

	public static List<BaseContact> contacts = new ArrayList<>();
	// public static List<Photo> photo = new ArrayList<>();

	// read items from text file
	public static List<BaseContact> read() {
		System.out.println("Reading from text file ...");
		// input of list
		PersonContact p1 = new PersonContact(null, "p1", "Jimmy Dean", "623-756-2323", "Phoenix, AZ", "12/23/1990",
				"Loves sandwiches");
		contacts.add(p1);
		PersonContact p2 = new PersonContact(null, "p2", "Matt Damon", "949-686-2323", "Beverly Hills, CA",
				"10/08/1970", "Hollywood Actor");
		contacts.add(p2);
		PersonContact p3 = new PersonContact(null, "p3", "Abbie Stentson", "787-124-7896", "Rolling Hills, MI",
				"04/01/1988", "Great artist");
		contacts.add(p3);
		BusinessContact b1 = new BusinessContact(null, "b1", "BestBuy", "480-878-1800", "Mesa, AZ", "0900 - 2100",
				"https://www.bestbuy.com");
		contacts.add(b1);
		BusinessContact b2 = new BusinessContact(null, "b2", "Target", "602-784-2454", "Gilbert, AZ", "1000 - 2200",
				"https://www.target.com");
		contacts.add(b2);
		BusinessContact b3 = new BusinessContact(null, "b3", "Living Spaces", "623-989-7841", "Anthem, AZ",
				"0800 - 2130", "https://www.livingspaces.com");
		contacts.add(b3);

		try {
			FileInputStream fis = new FileInputStream("file.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			contacts = (ArrayList<BaseContact>) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open text file!");
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contacts;
	}

	// write items to the text file
	public static void write(List<BaseContact> contacts) {
		System.out.println("Writing to text file ...");

		try {
			FileOutputStream fos = new FileOutputStream("contacts.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contacts);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
