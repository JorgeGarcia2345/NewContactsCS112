import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner keyboard = new Scanner(System.in);
		Contact[] myContacts = new Contact[100];
		int count = 0, choice;
		String firstName, lastName, mobile, birthday;
		boolean isFavorite;

		SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");

		File contactsBinaryFile = new File("Contacts.dat");
		
		System.out.println("Loading Contact Information from Database...");
		// TODO: Load contacts from binary file
		//String phoneNumberFormatted = String.valueOf(phoneNumber).replaceFirst
		//                ("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

		if (contactsBinaryFile.exists() && contactsBinaryFile.length() > 1L) {
			try {

				ObjectInputStream contactsFileReader = new ObjectInputStream(new FileInputStream(contactsBinaryFile));
				// Create a temp array to store contacts from a binary file
				Contact[] temp = (Contact []) contactsFileReader.readObject();
						//myContacts = (Contact []) contactsReader.readObject();
				//use a for loop all contacts from temp into my contacts
				for (int i = 0; i < temp.length; i++) {
					myContacts[i] = temp[i];
				}
				//update the count

				count = temp.length;
				//close the reader
				contactsFileReader.close();
							/*
							while (myContacts[count]!=null) {
								System.out.print(count+1 + ": ");
								System.out.println(myContacts[count++]);
							}

							 */

			}
			catch (IOException | ClassNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			}

		}
		else
			System.out.println("Done! " + count + " contacts loaded");
		
		do {
		System.out.print(
				  "\n********************************************************************\n"
				+ "**                                                                **\n"
				+ "**                       MIKE'S PHONE CONTACTS                    **\n"
				+ "**                                                                **\n"
				+ "********************************************************************\n"
				+ "1) Add New Contact...\n"
				+ "2) View Contact Names\n"
				+ "3) View Contact Details\n"
				+ "4) Exit\n"
				+ "********************************************************************\n"
				+ ">> ");
			choice = keyboard.nextInt();

			switch (choice)
			{
			case 1:  // Add New Contact...
				// Clear out \n from keyboard
				keyboard.nextLine();
				System.out.print("First Name: ");
				firstName = keyboard.nextLine();
				System.out.print("Last  Name: ");
				lastName = keyboard.nextLine();
				System.out.print("Mobile   #: ");
				String mobileInput = keyboard.nextLine();
				mobile = String.valueOf(mobileInput).replaceFirst
						("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
				System.out.print("Birthday  : ");
				birthday =keyboard.nextLine();
				System.out.print("Favorite (Y/N): ");
				isFavorite = keyboard.nextLine().equalsIgnoreCase("Y");

				myContacts[count++] = new Contact(firstName, lastName, mobile, birthday, isFavorite);

				break;

			case 2:  // View Contact Names
				System.out.println("\n********************************************************************");
				System.out.println("                        Contact Names");
				System.out.println("********************************************************************");
				// TODO: Print contact names (only)
				for (int i = 0; i < count; i++) {
					System.out.println(myContacts[i].getFullName());
				}
				break;

			case 3:  // View Contact Details
				System.out.println("\n********************************************************************");
				System.out.println("                        Contact Details");
				System.out.println("********************************************************************");
				// TODO: Print contact details
				for (int i = 0; i < count; i++) {
					System.out.println(myContacts[i]);
				}
				break;

			case 4:  // Exit
				System.out.println("Saving Contact Information to Database...");
				break;
			default:  // Error - Invalid input
				System.err.println("Invalid choice. Please select (1-4)");
				Thread.sleep(500); // To pause a bit of time (e.g. 0.5 second) before restarting loop

			}
		
		}
		while (choice != 4);
		
		// TODO: Save contacts to binary file

		try {

			ObjectOutputStream contactsFileWriter = new ObjectOutputStream(new FileOutputStream(contactsBinaryFile));

					//contactsFileWriter.writeObject(myContacts);

			//temp array to store data
			Contact [] temp = new Contact[count];
			// store in the temp to make sure only store actual data
			for (int i = 0; i < count; i++) {
				temp[i] = myContacts[i];
			}
			// storing
			contactsFileWriter.writeObject(temp);

			contactsFileWriter.close();
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Done! " + count + " contacts saved");
		
		keyboard.close();
	}

}
