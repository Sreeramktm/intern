package temporary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args){
        long start=System.nanoTime();
        String[] input={"a","q","e","r","b"};
        HashSet<String> out=new HashSet<>(Arrays.asList(input));
        System.out.println(out);
        System.out.println(System.nanoTime()-start);
    }
    public void fileChanger(int choice){
        Scanner scanner=new Scanner(System.in);

        switch (choice){
            case 1:
        }
    }
}
