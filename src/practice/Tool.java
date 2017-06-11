package practice;

import java.io.*;

/**
 * Created by liusiwei on 2017/5/23.
 */
public class Tool {
    public static void main(String[] args) {
        String path = "C:\\Users\\liusiwei\\Desktop\\ifile\\test.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = "";
            while((line = br.readLine())!=null) {
                if(!line.startsWith("#"))
                    System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
