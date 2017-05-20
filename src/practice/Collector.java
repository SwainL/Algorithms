package practice;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by liusiwei on 2017/5/4.
 */
public class Collector {
    File rootDir = new File("C:\\Users\\liusiwei\\Desktop\\OpenFOAM-dev");
    File destDir = new File("C:\\Users\\liusiwei\\Desktop\\include");

    public void copyTo() {
        Set<String> set = new HashSet<>();
        Queue<File> queue = new ArrayDeque<>();
        queue.add(rootDir);
        while(!queue.isEmpty()) {
            File cur = queue.remove();
            for(File file : cur.listFiles()) {
                if(file.isDirectory()) {
                    queue.add(file);
                }
                else if(file.getPath().endsWith(".H")) {
//                    set.add(cur.getName());
                    //System.out.println(file.getAbsoluteFile());
                    copy(file, destDir);
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
//        for(String str : set) {
//            System.out.print(str + ";");
//        }

    }

    public boolean copy(File srcFile, File destDir) {
        File destFile = new File(destDir + "\\" + srcFile.getName());
        // 复制文件
        int byteread = 0; // 读取的字节数
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];

            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Collector collector = new Collector();
        collector.copyTo();
    }


}
