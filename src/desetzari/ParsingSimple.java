package desetzari;

import java.util.Arrays;

public class ParsingSimple {
    public static void main(String[] args) {
        String neco = "Tady je cislo:2";
        //zkus najit cislo
        String[] arr = neco.split(":");
        System.out.println(Arrays.toString(arr));
        int num = Integer.parseInt(arr[1]);
        System.out.println(num + 2);



//        for (int i = 0; i < neco.length(); i++) {
//            //Character a =/= char a
//            //char nema metody
//
//            if (Character.isDigit(neco.charAt(i))){
//                System.out.println(neco.charAt(i));
//                int num = Integer.parseInt(neco.charAt(i));
//
//            }
//        }
    }
}
