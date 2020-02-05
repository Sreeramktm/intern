package temporary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class SaveImage {

    public static void main(String[] args) throws IOException{
            InputStream in=null;
        OutputStream out=null;
            try{
        URL myurl=new URL("https://www.google.com/images/srpr/logo3w.png");
        String fileName = myurl.getFile();
        String destname= "C:\\Users\\sreeram-pt3552\\Desktop"+fileName.substring(fileName.lastIndexOf("/"));
      //  System.out.println(fileName+" "+destname);
        in=myurl.openStream();
        out=new FileOutputStream(destname);
        byte b[]=new byte[2048];
        int len;
        while ((len=in.read(b))!=-1){
            out.write(b,0,len);
        }}
            finally {



        in.close();
        out.close();}

    }
}
