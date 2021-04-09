package com.codegym.task.task18.task1825;

import java.io.*;
import java.util.*;

/**
Building a file

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        String pathAndFileName = "";
        String backUpFileName = "";
        ArrayList<String> files = new ArrayList<>();

        while(true){
            String fileName = reader.readLine();
            if(fileName.equals("end")){
                break;
            }
            backUpFileName = fileName;  
            pathAndFileName = fileName;
            files.add(pathAndFileName);
        }
        reader.close();
        files.sort((a, b) -> {
            Integer p1 = Integer.parseInt(a.substring(a.indexOf("part") + 4));
            Integer p2 = Integer.parseInt(b.substring(b.indexOf("part") + 4));
            return p1.compareTo(p2);
        });


        String[] everyWordOfFileName = backUpFileName.split("\\.");
        everyWordOfFileName = Arrays.copyOfRange(everyWordOfFileName, 0, everyWordOfFileName.length-1);
        String finalFileName = String.join(".", everyWordOfFileName);

        FileOutputStream fos = new FileOutputStream(finalFileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for(String s : files){

            FileInputStream fis = new FileInputStream(s);
            BufferedInputStream bis = new BufferedInputStream(fis);
            while(bis.available() > 0){
                int count = bis.read();
                bos.write(count);
            }

            fis.close();
            bis.close();
        }
        fos.close();
        bos.close();
    }
}
