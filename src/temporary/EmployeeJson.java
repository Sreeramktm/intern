package temporary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class EmployeeJson {
    public static void main(String[] args) throws IOException, ParseException {
        JSONObject jo=(JSONObject) new JSONParser().parse(new FileReader("C:\\Users\\sreeram-pt3552\\Desktop\\employee.json"));
        String fn =(String) jo.get("firstName");
        int age=(int)(long)jo.get("age");
        System.out.println(fn+"  "+age);
    }
}
