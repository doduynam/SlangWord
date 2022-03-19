package com.duynam;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<SlangWord> slangWordList = ReadWriteFile.readFile("slang.txt");
        for(SlangWord sl : slangWordList) {
            System.out.println(sl);
        }

        ReadWriteFile.writeFile(slangWordList, "slang1.txt");
    }
}
