package topcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liusiwei on 2017/4/26.
 */
public class IPConverter {
    ArrayList<String> list = new ArrayList<>();

    //method1 : Iteration
    public String[] possibleAddresses(String ambiguousIP) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 3 && i + 1 <= ambiguousIP.length(); i++) {
            String[] address = new String[4];
            address[0] = ambiguousIP.substring(0, i + 1);
            if(isValid(address[0])) {
                for(int j = 0; j < 3 && i + j + 2 <= ambiguousIP.length(); j++) {
                    address[1] = ambiguousIP.substring(i + 1, i + j + 2);
                    if(isValid(address[1])) {
                        for(int k = 0; k < 3 && i + j + k + 3 <= ambiguousIP.length(); k++) {
                            address[2] = ambiguousIP.substring(i + j + 2, i + j + k + 3);
                            if(isValid(address[2]) && i + j + k + 3 <= ambiguousIP.length()) {
                                address[3] = ambiguousIP.substring(i + j + k + 3, ambiguousIP.length());
                                if(address[3].length() > 0 && isValid(address[3])){
                                    //System.out.println(Arrays.deepToString(address));
                                    list.add(linker(address));
                                }

                            }
                        }
                    }

                }
            }

        }
        return list.toArray(new String[list.size()]);
    }

    public boolean isValid(String str) {
        if(str.length() >= 1 && str.length() <= 3 && Integer.valueOf(str) < 256 && str.charAt(0) != '0') {
            return true;
        }
        else if(str.equals("0")) {
            return true;
        }
        else {
            return false;
        }
    }

    public String linker(String[] arr) {
        String result = "";
        for(String a : arr) {
            result += a + ".";
        }
        return result.substring(0, result.length() - 1);
    }

    //method2 : Recursion


    public static void main(String[] args) {
        IPConverter ipc = new IPConverter();
        System.out.println(Arrays.deepToString(ipc.possibleAddresses("1902426")));
    }
}