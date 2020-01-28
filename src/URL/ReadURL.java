package URL;

import java.io.*;
import java.net.*;

public class ReadURL {
    public static void main(String args[]) throws Exception{
        URL viewurl=new URL("https://pentagonbuilders.in");
        BufferedReader out=new BufferedReader(new InputStreamReader(viewurl.openStream()));
        String output;
        while((output=out.readLine())!=null){
            System.out.println(output);
        }
        out.close();
    }
}
