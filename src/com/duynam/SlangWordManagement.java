package com.duynam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SlangWordManagement {
    List<SlangWord> slangWordList = new ArrayList<SlangWord>();

    public SlangWordManagement() {
        slangWordList = ReadWriteFile.readFile("slang.txt");
    }

    public SlangWord findFollowSlag(String slag) {
        for (SlangWord sl : slangWordList) {
            if (sl.get_slag().equals(slag)) {
                sl.show();
                return sl;
            }
        }
        return null;
    }

    public ArrayList<SlangWord> findFollowDefinition(String keyword) {
        ArrayList<SlangWord> result = new ArrayList<SlangWord>();
        for (SlangWord sl : slangWordList) {
            for (String s : sl.get_mean()) {
                if (s.indexOf(keyword) != -1) {
                    result.add(sl);
                    break;
                }
            }
        }

        return result;
    }

    public boolean addSlag(SlangWord slangWord) {
        if(!canFind(slangWord.get_slag())) {
            if (slangWordList.add(slangWord)) {
                Collections.sort(slangWordList, new CompareSlagAscending());
                return true;
            }
            else {
                for(SlangWord sl : slangWordList) {
                    if (sl.get_slag().equals(slangWord.get_slag())) {
                        ArrayList<String> means = sl.get_mean();
                        for (String s : slangWord.get_mean()) {
                            means.add(s);
                        }
                        sl.set_mean(means);
                        return true;
                    }
                }
            }
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

    public boolean deleteSlag(String slag) {
        for (SlangWord sl : slangWordList) {
            if (sl.get_slag().equals(slag)) {
                if (slangWordList.remove(sl)) {
                    return true;
                }
            }
        }
        return false;
    }

    public SlangWord randomSlag() {
        Random rand = new Random();
        return slangWordList.get(rand.nextInt());
    }

    public boolean canFind(String slag) {
        for (SlangWord sl : slangWordList) {
            if (sl.get_slag().equals(slag)) {
                return true;
            }
        }
        return false;
    }

}
