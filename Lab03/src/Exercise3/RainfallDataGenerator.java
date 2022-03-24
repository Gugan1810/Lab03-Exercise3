package Exercise3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainfallDataGenerator {
	
	public static void main(String[] args) {
			
			
			// 1. Declare output file 
			String outFile = "Rainfalldata.txt";
			
			// Data declaration
			String Days[] = {"18/03/2022", "19/03/2022", "20/03/2022", "21/03/2022", "22/03/2022", 
					"23/03/2022"};
			double rate[] = {7.0,0.0,0.0,8.0,0.0,0.0};
			
			try {
				
				// 2. Create stream to read data
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
				
				// Process data
				for (int index = 0; index < Days.length; index++) {
					
					// 3. Write data into data stream
					dos.writeUTF(Days[index]);
					dos.writeDouble(rate[index]);
					
					// 4. Flush for each writing
					dos.flush();
				}
				
				// 5. Close stream
				dos.close();
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
			
			// Indicate end of program - Could be successful
			System.out.println("End of program. Check out " + outFile); 
		}

}
