import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ArrayList
		ArrayList<Bike> bikeList = new ArrayList<Bike>();

		// Sample Data
		bikeList.add(new Bike("B001", "Trek Sport Bike", 199.00));
		bikeList.add(new Bike("B002", "Connondale Mountain Bike", 299.50));
		bikeList.add(new Bike("B003", "Kona Road Bike", 399.50));
		bikeList.add(new Bike("B004", "Colnago Sports Bike", 409.50));
		bikeList.add(new Bike("B005", "Bianch BMX", 500.50));

		// Main Menu
		System.out.println("========================================");
		System.out.println("Main Menu");
		System.out.println("========================================");
		System.out.println("1. Manage bike listings and features");

		int MainMenuOption = Helper.readInt("Enter option > ");

		// 1. Manage bike listings and features
		if (MainMenuOption == 1) {
			System.out.println("========================================");
			System.out.println("Manage bike listings and features");
			System.out.println("========================================");
			System.out.println("1. View bike listings");
			System.out.println("2. Create new bike listings");
			System.out.println("3. Update bike listings");
			System.out.println("4. Delete bike listings");

			int ManageBikeListingsOption = Helper.readInt("Enter option > ");

			// "1. View bike listings"
			if (ManageBikeListingsOption == 1) {

				System.out.println("========================================");
				System.out.println("BIKE LISTINGS");
				System.out.println("========================================");
				String output = String.format("%-5s %-25s %-10s %s\n", "ID", "NAME", "PRICE", "AVAILABLE");

				for (int i = 0; i < bikeList.size(); i++) {

					output += String.format("%-5s %-25s %-10s %s\n", bikeList.get(i).getId(), bikeList.get(i).getName(),
							bikeList.get(i).getName(), bikeList.get(i).getIsAvailable());

				}
				System.out.println(output);
			}

			// 2. Create new bike listings
			else if (ManageBikeListingsOption == 2) {

				String id = Helper.readString("Enter id > ");
				String name = Helper.readString("Enter name > ");
				double price = Helper.readDouble("Enter price > ");

				Bike newBike = new Bike(id, name, price);

				System.out.println("1. Save and create bike listing");
				System.out.println("2. Cancel bike listing");

				int CreateBikeListingOption = Helper.readInt("Enter Option > ");

				if (CreateBikeListingOption == 1) {

					bikeList.add(newBike);
					System.out.println("New bike listing successfully created!");

				} else if (CreateBikeListingOption == 2) {

					System.out.println("Bike listing cancelled");
				}

			}
			// 3. Update bike listings
			else if (ManageBikeListingsOption == 3) {

				String id = Helper.readString("Enter bike id > ");

				boolean Result = false;
				for (int i = 0; i < bikeList.size(); i++) {
					if (bikeList.get(i).getId().equals(id)) {
						Result = true;
					}
				}

				if (Result == true) {
					String name = Helper.readString("Enter name to update > ");
					double price = Helper.readDouble("Enter price to update > ");
					String availability = Helper.readString("Enter availability > (yes/no) ");

					for (int i = 0; i < bikeList.size(); i++) {
						if (bikeList.get(i).getId().equals(id)) {
							bikeList.get(i).setName(name);
							bikeList.get(i).setPrice(price);
							if (availability == "yes") {
								bikeList.get(i).IsAvailable(true);
							} else {
								if (availability == "no") {
									bikeList.get(i).IsAvailable(false);
								}
							}
							System.out.println("Bike List has been updated!");
						} else {
							System.out.println("Entered ID is not in listings");
						}
					}

				}

				// 4. Delete bike listings
				else if (ManageBikeListingsOption == 4) {

					String id1 = Helper.readString("Enter bike id > ");

					boolean Result1 = false;
					for (int i = 0; i < bikeList.size(); i++) {
						if (bikeList.get(i).getId().equals(id)) {
							Result1 = true;
						}
					}
					if (Result == true) {
						for (int i = 0; i < bikeList.size(); i++) {
							if (bikeList.get(i).getId().equals(id)) {
								String confirm = Helper
										.readString("Confirm deletion of bike listing " + id + "? (yes/no) > ");
								if (confirm == "yes") {
									bikeList.remove(i);
									System.out.println("Bike listing " + id + " successfully deleted.");
								} else {

									System.out.println("Unsuccessful deletion of bike.");
								}
							}
						}
					} else {
						System.out.println("Entered ID is not in listings.");
					}
				}

			}
		}

	}

}
