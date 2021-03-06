package com.duynam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReadWriteFile {
    public static ArrayList<SlangWord> readFile(String filename) {
        ArrayList<SlangWord> result = new ArrayList<SlangWord>();

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(filename));
            String buf = inFile.readLine();
            while ((buf = inFile.readLine()) != null) {
                String[] row = buf.split("`");
                String slag = row[0];
                ArrayList<String> mean = new ArrayList<String>();
                if (row[1].indexOf("|") != -1) {
                    String[] rowMean = row[1].split("\\| ");
                    for(String s : rowMean) {
                        mean.add(s.toLowerCase());
                    }
                }
                else {
                    mean.add(row[1].toLowerCase());
                }

                result.add(new SlangWord(slag, mean));
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

    public static void writeFile(ArrayList<SlangWord> slangWordList, String filename) {
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


