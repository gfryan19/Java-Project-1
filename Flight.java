// Create a directory called project 1 within projects directory
// make a collaboration.txt file in that directory
// Coordinates for Holy Cross = 42.238145 N  71.810862 W
// PLace program code in a file named Flight.java

// Have the Math.PI function checked
// Check the arctan equation
// Check the error reguarding Char variables in the error message if statements

/*------------------------------------------------
* Author: Greg Ryan
* Email: gfryan19@g.holycross.edu
* Written: 9/22/2015
*
* Calculates the distance between home and a destination 
* using longitude and latitude coordinates
*
* Coordinates for Holy Cross = 42.238145 N  71.810862 W
*
* Latitude coordinates must be between 0 and 90
* Longitude coordinates must be between 0 and 180
*
* Example: java Flight 42.238145 N 71.810862 W 37.362517 N 122.03476 W
*------------------------------------------------*/ 

public class Flight {
	public static void main(String[] args){

	final double radius = 3963.1676; // Radius of the Earth
	double homeLat, homeLong, destLat, destLong; // Longitude and Latituude variables
	double radHomeLat, radHomeLong, radDestLat, radDestLong; // Radian variables
	double firstLat, firstLong, latSin, longSin, cosFinal, v, distance; // equation variables
	char homeLatH, homeLongH, destLatH, destLongH; // Hemisphere variables
	String answer;

	homeLat = Double.parseDouble(args[0]);  // Home latitude
	homeLatH = args[1].charAt(0); 				// Home latitude  hemisphere N/S
	homeLong = Double.parseDouble(args[2]); // Home longitude
	homeLongH = args[3].charAt(0); 				// Home longitude hemisphere E/W
	destLat = Double.parseDouble(args[4]);  // Destination latitude
	destLatH = args[5].charAt(0); 				// Destination latitude hemisphere N/S
	destLong = Double.parseDouble(args[6]); // Destination longitude
	destLongH = args[7].charAt(0); 				// Destination longitude hemisphereE/W

	if (homeLat < 0 || homeLat > 90){ // Validates the home latitude coordinates
		System.out.print("Error, the home coordinates you entered are not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	} // The following if statement validates the home latitude hemisphere
	if (homeLatH != 'N' && homeLatH != 'n' && homeLatH != 'S' && homeLatH != 's'){
		System.out.print("Error, the home N/S hemisphere you entered is not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	}
	if (homeLong < 0 || homeLong > 180){ // Validates the home longitude coordinates
		System.out.print("Error, the home coordinates you entered are not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	} // The following if statement validates the home longitude hemisphere
	if (homeLongH != 'E' && homeLongH != 'e' && homeLongH != 'W' && homeLongH != 'w'){
		System.out.print("Error, the home E/W hemisphere you entered is not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	}
	if (destLat < 0 || destLat > 90){ // Validates the destination latitude coordinates
		System.out.print("Error, the destination coordinates you entered are not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	}// The following if statement validates the destination latitude hemisphere
	if (destLatH != 'N' && destLatH != 'n' && destLatH != 'S' && destLatH != 's'){
		System.out.print("Error, the destination N/S hemisphere you entered is not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	}
	if (destLong < 0 || destLong > 180){ // Validates the destination longitude coordinates
		System.out.print("Error, the destination coordinates you entered are not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	} // The following if statement validates the destination longitude himisphere
	if (destLongH != 'E' && destLongH != 'e' && destLongH != 'W' && destLongH != 'w'){
		System.out.print("Error, the destination E/W hemisphere you entered is not valid,");
		System.out.println("the program will now terminate.");
		System.exit(1);
	}

	// Prints the coordinates
	System.out.println("Home Latitude is: " + homeLat + " " + homeLatH);
	System.out.println("Home Longitude is: " + homeLong + " " + homeLongH);
	System.out.println("Destination Latitude is: " + destLat + " " + destLatH);
	System.out.println("Destination Longitude is: " + destLong + " " + destLongH);

	// The following four if statements convert all
	// the coordinates to signed decimal degrees format
	if (homeLatH == 'S' || homeLatH == 's'){ 
		homeLat = homeLat * -1;        
	}
	if (homeLongH == 'W' || homeLongH == 'w'){ 
		homeLong = homeLong * -1;
	}
	if (destLatH == 'S' || destLatH == 's'){
		destLat = destLat * -1;
	}
	if (destLongH == 'W' || destLongH == 'w'){
		destLong = destLong * -1;
	}

	radHomeLat = homeLat * (Math.PI / 180); // get help on this one.. Math.PI function not working
	System.out.println(radHomeLat);
	radHomeLong = homeLong * (Math.PI / 180); // get help on this one.. Math.PI function not working
	System.out.println(radHomeLong);
	radDestLat = destLat * (Math.PI / 180); // get help on this one.. Math.PI function not working
	System.out.println(radDestLat);
	radDestLong = destLong * (Math.PI / 180); // get help on this one.. Math.PI function not working
	System.out.println(radDestLong);

	// The following statements are a broken up version of the distance formula
	firstLat = (radDestLat - radHomeLat) / 2;
	firstLong = (radDestLong - radHomeLong) / 2;

	latSin = Math.pow(Math.sin(firstLat), 2);
	longSin = Math.pow(Math.sin(firstLong), 2);

	cosFinal = (Math.cos(radHomeLat)) * (Math.cos(radDestLat));
	v = (latSin + longSin) * cosFinal;
	System.out.println("v = " + v);
	// ************ CHECK THIS FORMULA *************
	distance = 2 * radius * (Math.atan2(Math.sqrt(v), Math.sqrt(1 - v)));

	// Prints the distance between home and the destination
	System.out.println("The distance from home to destination is: " + distance + " miles.\n");

	// Asks the user if they would like a map
	System.out.println("Would you like a map?");
	answer = StdIn.readString();

	if (answer.equalsIgnoreCase("Yes")){
		String url = ("http://maps.googleapis.com/maps/api/staticmap?size=600x300&maptype=roadmap&markers=color:blue%7Clabel:A%7C" + homeLat + "," + homeLong + "&markers=color:red%7Clabel:B%7C" + destLat + "," + destLong + "&path=color:0x0000ff%7Cweight:5%7Cgeodesic:true%7C" + homeLat + "," + homeLong + "%7C" + destLat + "," + destLong);
		System.out.println(url); // Prints the url to the console
		StdDraw.picture(0.5, 0.5, url); // This displays the image in a drawing window
	}
	else if (answer.equalsIgnoreCase("No")){
		System.out.println("Good Bye.");
		System.exit(1);
	}
	else{
		System.out.println("Error, invalid input, the program will now terminate.");
		System.exit(1);
	}
	}
}