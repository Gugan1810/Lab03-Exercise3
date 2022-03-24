package Exercise3;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class RainfallDataReader {
	
	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "Rainfalldata.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			double Rate = 0;
			double totalRate = 0;
			int noOfRecords = 0;
			String Days = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				Days = dis.readUTF();
				Rate = dis.readDouble();
				System.out.println( Days + "\t" + Rate);
				
				// Calculate total utilization
				totalRate += Rate;
				noOfRecords ++;
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate average utlization
			double averageRate = totalRate / noOfRecords;
			String formattedAverage = String.format("%.1f", averageRate);
			System.out.print("\nAverage Rate for " + noOfRecords 
					+ " states: " + formattedAverage + "");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}

}
