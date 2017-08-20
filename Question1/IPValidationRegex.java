import java.util.*;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;

public class IPValidationRegex {

    private static final String filename = "ipFile.txt";
    
    public static void main(String []args)
    {
        File testfile = new File(filename);

        if (testfile.exists())
        {
            IPValidationRegex thisObj = new IPValidationRegex();
            
            List<String> ipArrList = thisObj.ReadTextFile(filename);
            List<String> invalidIPList = new ArrayList<String>();
            
            // Loop through ipArrList to get ip record  
            for(String ipRec : ipArrList)
            {
                String [] split = ipRec.split("\\.");
                for (String otect : split)
                {
                    Boolean rtnStatus = thisObj.validateIPValue(otect);
                    
                    // If return false, put into list and show invalid IP address
                    if (!rtnStatus)
                    {
                        invalidIPList.add(ipRec);
                        break;
                    }
                }
            }
            
            // Print out each invalid IP element
            if (invalidIPList.size() > 0)
            {
                System.out.print("List of invalid IP addresses: \n");
                for (String ip : invalidIPList) 
                {
                    System.out.print(ip + "\n");
                }
            }
        }
    }
    
    public List<String> ReadTextFile(String filename)
    {
        List<String> ipRecInList = new ArrayList<String>();
        try
        {
            String line;
            // FileReader reads text files and wrap in BufferedReader.
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            
            while ((line = bReader.readLine()) != null)
            {
                ipRecInList.add(line);
            }
            
            bReader.close();
            return ipRecInList;
        }
        catch (Exception e)
        {
            System.err.format("Exception for reading file - ", filename);
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean validateIPValue(String inOctet)
    {
        Boolean isValid = false;
        
        try
        {
            int octet = Integer.parseInt(inOctet);
            // Check each octet is not more than three digit
            int validateDigit = String.valueOf(octet).length();
            
            if (validateDigit > 0 && validateDigit <= 3)
            {
               // Get Range of validation (0 - 255) for each octet
               if (octet >= 0 && octet <= 255) {
                   isValid = true;
               }
               else
               {
                   isValid = false;
               }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return isValid;
    }
}
