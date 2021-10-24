package milestone.cst135n;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	// test
	private String name;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<BaseContact> contacts = new ArrayList<>();

	// Constructor
	AddressBook(String name) {
		this.name = name;
	}

	// Overload Constructor
	AddressBook() {
	}

	public void open() {
		System.out.println("SYSTEM MESSAGE: The address book is now open!");
		contacts = (ArrayList<BaseContact>) DataService.read();
		mainMenu();
	}

	private void mainMenu() {
		int option = 0;
		do {
			System.out.println("====================");
			System.out.println("+++ Address Book +++");
			System.out.println("====================");
			System.out.println("1. Create Person Contact");
			System.out.println("2. Create Business Contact");
			System.out.println("3. Show All Contacts");
			System.out.println("4. Show Details of One Contact");
			System.out.println("5. Update A Contact");
			System.out.println("6. Delete A Contact");
			System.out.println("7. Search for a Contact by Name");
			System.out.println("8. Sort All Contacts by Name");
			System.out.println("9. Exit");
			System.out.println("====================");
			System.out.print("Please select an option: ");
			option = sc.nextInt(); // Return
			sc.nextLine(); // Consume the return
			switch (option) {
			case 1:
				addPersonContact();
				break;
			case 2:
				addBusinessContact();
				break;
			case 3:
				viewAll();
				break;
			case 4:
				showDetails();
				break;
			case 5:
				updateContact();
				break;
			case 6:
				deleteContact();
				break;
			case 7:
				searchContact();
				break;
			case 8:
				sortContactName();
				break;
			case 9:
				DataService.write(contacts);
				System.out.println("*** This selection exits the address book! ***");
				break;
			default:
				System.out.println("Please pick a valid option: 1 through 9.");
			}
		} while (option != 9);
	}

	private void addPersonContact() {
		System.out.println("*** This selection adds a person contact! ***");
		System.out.println("Person contact added!");
		System.out.println("=================");
		System.out.println("What's the contact's ID?");
		String id = sc.nextLine();
		System.out.println("What do you want to name this contact?");
		String name = sc.nextLine();
		System.out.println("What's the contact's phone number?");
		String number = sc.nextLine();
		System.out.println("What's the contact's location?");
		String location = sc.nextLine();
		System.out.println("What's the contact's DOB?");
		String birthDay = sc.nextLine();
		System.out.println("Description of contact: ");
		String description = sc.nextLine();
		contacts.add(new PersonContact(null, id, name, number, location, birthDay, description));
	}

	private void addBusinessContact() {
		System.out.println("*** This selection adds a business contact! ***");
		System.out.println("Business contact added!");
		System.out.println("=================");
		System.out.println("What's the contact's ID?");
		String id = sc.nextLine();
		System.out.println("What do you want to name this contact?");
		String name = sc.nextLine();
		System.out.println("What's the contact's phone number?");
		String number = sc.nextLine();
		System.out.println("What's the contact's location?");
		String location = sc.nextLine();
		System.out.println("What's the contact's business hours?");
		String businessHours = sc.nextLine();
		System.out.println("What's the contact's URL? ");
		String webURL = sc.nextLine();
		contacts.add(new BusinessContact(null, id, name, number, location, businessHours, webURL));
	}

	private void viewAll() {
		System.out.println("*** This selection views all options! ***");
		System.out.println("Viewing all options!");
		System.out.println("=================");
		int counter = 0;
		for (BaseContact contactItem : contacts) {
			System.out.print(counter++ + ". ");
			System.out.println(contactItem);
		}
	}

	private void deleteContact() {
		System.out.println("*** This selection deletes the selected item! ***");
		System.out.println("Deleting item!");
		System.out.println("=================");
		viewAll();
		System.out.println("Which contact would you like to delete?");
		int item = sc.nextInt();
		sc.nextLine();
		contacts.remove(item);
	}

	private void showDetails() {
		System.out.println("*** This selection shows the details of the contact! ***");
		viewAll();
		System.out.println("Which contact would you like to view?");
		viewAll();
		System.out.println("Which contact would you like to view?");
		int item = sc.nextInt();
		sc.nextLine();
		if (contacts.get(item) instanceof PersonContact) {
			System.out.println("Viewing Person Contact");
			viewPerson(item);
		} else if (contacts.get(item) instanceof BusinessContact) {
			System.out.println("Viewing Business Contact");
			viewBusiness(item);
		} else {
			System.out.println("don't know what you mean");
		}
	}

	private void viewBusiness(int item) {
		System.out.println("Business photos: " + contacts.get(item).getListOfPhotos());
		System.out.println("Business ID: " + contacts.get(item).getContactID());
		System.out.println("Business name: " + contacts.get(item).getName());
		System.out.println("Business pnone: " + contacts.get(item).getPhone());
		System.out.println("Business name: " + contacts.get(item).getLocation());
		System.out.println("Business hours: " + ((BusinessContact) contacts.get(item)).getBusinessHours());
		System.out.println("Business URL: " + ((BusinessContact) contacts.get(item)).getWebsiteURL());

	}

	private void viewPerson(int item) {
		System.out.println("Person photos: " + contacts.get(item).getListOfPhotos());
		System.out.println("Person ID: " + contacts.get(item).getContactID());
		System.out.println("Person name: " + contacts.get(item).getName());
		System.out.println("Person pnone: " + contacts.get(item).getPhone());
		System.out.println("Person name: " + contacts.get(item).getLocation());
		System.out.println("Person DOB: " + ((PersonContact) contacts.get(item)).getBirthDate());
		System.out.println("Person description: " + ((PersonContact) contacts.get(item)).getDescription());
		System.out.println("Photos: ");
		for (Photo i : contacts.get(item).getListOfPhotos()) {
			System.out.println(i.getPhotoID());
		}
	}

	private void updateContact() {
		System.out.println("*** This selection updates the contact! ***");
		System.out.println("============================");
		viewAll();
		System.out.println("============================");
		System.out.println("Which item do you want to update?");
		int item = sc.nextInt();
		sc.nextLine();
		System.out.println("what do you want to update the contact too?");
		String name = sc.nextLine();
		contacts.get(item).setName(name);
		if (contacts.get(item) instanceof PersonContact) {
			System.out.println("editing Person Contact");
			editPersonContact(item);
		} else if (contacts.get(item) instanceof BusinessContact) {
			System.out.println("editing Business Contact");
			editBusinessContact(item);
		} else {
			System.out.println("don't know what you mean");
		}
	}

	private void editPersonContact(int item) {
		System.out.println(" What do you want to change the ID to? ");
		String id = sc.nextLine();
		contacts.get(item).setContactID(id);
		System.out.println(" What do you want to change the name to? ");
		String name = sc.nextLine();
		contacts.get(item).setName(name);
		System.out.println(" What do you want to change the phone to? ");
		String phone = sc.nextLine();
		contacts.get(item).setPhone(phone);
		System.out.println(" What do you want to change the location to? ");
		String location = sc.nextLine();
		contacts.get(item).setLocation(location);
		System.out.println(" What do you want to change the D.O.B to? ");
		String dob = sc.nextLine();
		((PersonContact) contacts.get(item)).setBirthDate(dob);
		System.out.println(" What do you want to change the Description to? ");
		String description = sc.nextLine();
		((PersonContact) contacts.get(item)).setDescription(description);

		System.out.println("Do you want to add a photo (Y or N)? ");
		char option = sc.nextLine().toUpperCase().charAt(0);
		ArrayList<Photo> photos = new ArrayList<>();
		while (option == 'Y') {
			System.out.println("What's the photo ID?");
			int photoID = sc.nextInt();
			// System.out.println("this is the photoID: " + photoID);
			sc.nextLine();
			System.out.println("What's the file name?");
			String fileName = sc.nextLine();
			// System.out.println( "this is the file name: " + fileName);
			System.out.println("What's the photo date?");
			String photoDate = sc.nextLine();
			// System.out.println( "this is the photo date: " + photoDate);
			System.out.println("What's the photo description?");
			String photoDescription = sc.nextLine();
			// System.out.println( "this is the photo description: " + photoDescription);
			Photo photo = new Photo(photoID, fileName, photoDate, photoDescription);
			// System.out.println( "this is the photo: " + photo);
			photos.add(photo);
			// System.out.println("this is photos: " + photos);
			System.out.println("Do you want to add another photo? (Y or N)  ");
			option = sc.nextLine().toUpperCase().charAt(0);
		}
		contacts.get(item).setListOfPhotos(photos);
		System.out.println("this is contacts: " + contacts);

		contacts.add(new PersonContact(photos, id, name, phone, location, dob, description));
	}

	private void editBusinessContact(int item) {
		System.out.println(" What do you want to change the ID to? ");
		String id = sc.nextLine();
		contacts.get(item).setContactID(id);
		System.out.println(" What do you want to change the name to? ");
		String name = sc.nextLine();
		contacts.get(item).setName(name);
		System.out.println(" What do you want to change the phone to? ");
		String phone = sc.nextLine();
		contacts.get(item).setPhone(phone);
		System.out.println(" What do you want to change the location to? ");
		String location = sc.nextLine();
		contacts.get(item).setLocation(location);
		System.out.println(" What do you want to change the Hours to? ");
		String hours = sc.nextLine();
		((BusinessContact) contacts.get(item)).setBusinessHours(hours);
		System.out.println(" What do you want to change the URL to? ");
		String url = sc.nextLine();
		((BusinessContact) contacts.get(item)).setWebsiteURL(url);

		System.out.println("Do you want to add a photo (Y or N)? ");
		char option = sc.nextLine().toUpperCase().charAt(0);
		ArrayList<Photo> photos = new ArrayList<>();
		while (option == 'Y') {
			System.out.println("What's the photo ID?");
			int photoID = sc.nextInt();
			sc.nextLine();
			System.out.println("What's the file name?");
			String fileName = sc.nextLine();
			System.out.println("What's the photo date?");
			String photoDate = sc.nextLine();
			System.out.println("What's the photo description?");
			String photoDescription = sc.nextLine();
			photos.add(new Photo(photoID, fileName, photoDate, photoDescription));
			System.out.println("Do you want to add another photo? (Y or N)  ");
			option = sc.nextLine().toUpperCase().charAt(0);
		}
		contacts.get(item).setListOfPhotos(photos);
		System.out.println("this is contacts: " + contacts);

		contacts.add(new BusinessContact(photos, id, name, phone, location, hours, url));

	}

	private void searchContact() {
		System.out.println("*** This selection searches for a contact! ***");
		System.out.println("what is the name of the contact");
		String name = sc.nextLine();
		for (int x = 0; x < contacts.size(); x++) {
			if (contacts.get(x).getName().toLowerCase().contains(name.toLowerCase())) {
				System.out.println(x + "." + contacts.get(x));
			}
		}
	}

	private void sortContactName() {
		System.out.println("*** This selection sorts each contact by name! ***");
		contacts.sort(new ComparatorName());
	}
}