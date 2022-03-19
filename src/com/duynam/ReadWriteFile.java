package com.duynam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static List<SlangWord> readFile(String filename) {
        List<SlangWord> result = new ArrayList<SlangWord>();

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(filename));
            String buf = inFile.readLine();
            while ((buf = inFile.readLine()) != null) {
                String[] row = buf.split("`");
                if (row.length ==  1) {
                    System.out.println(buf);
                }
                result.add(new SlangWord(row[0], row[1]));
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void writeFile(List<SlangWord> slangWordList, String filename) {
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(filename));
            outFile.write("Slag`Meaning\n");
            for(SlangWord sl : slangWordList) {
                outFile.write(String.valueOf(sl) + "\n");
            }

            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


