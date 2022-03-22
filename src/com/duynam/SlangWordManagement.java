package com.duynam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SlangWordManagement {
    List<SlangWord> slangWordList = new ArrayList<SlangWord>();

    public SlangWordManagement() {
        slangWordList = ReadWriteFile.readFile("slang.txt");
    }

    public ArrayList<String> findFollowSlag(String slag) {
        for (SlangWord sl : slangWordList) {
            if (sl.get_slag().equals(slag)) {
                return sl.get_mean();
            }
        }
        return null;
    }

    //TODO add more function to update quick
    public boolean addSlag(SlangWord slangWord) {
        if(slangWordList.add(slangWord)) {
            return true;
        }
        return false;
    }

    public boolean editSlag(String oldSlag, String newSlag) {
        for (SlangWord sl : slangWordList) {
            if (sl.get_slag().equals(oldSlag)) {
                sl.set_slag(newSlag);
                return true;
            }
        }
        return false;
    }

    public boolean editMean(String slag, ArrayList<String> mean) {
        for (SlangWord sl : slangWordList) {
            if (sl.get_slag().equals(slag)) {
                sl.set_mean(mean);
                return true;
            }
        }
        return false;
    }

    public boolean deleteSlag(SlangWord slag) {
        if(slangWordList.remove(slag)) {
            return true;
        }
        return false;
    }

    public SlangWord randomSlag() {
        Random rand = new Random();
        return slangWordList.get(rand.nextInt());
    }


}
