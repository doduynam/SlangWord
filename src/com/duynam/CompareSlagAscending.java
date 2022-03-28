package com.duynam;

import java.util.Comparator;

public class CompareSlagAscending implements Comparator<SlangWord> {

    @Override
    public int compare(SlangWord o1, SlangWord o2) {
        if (o1.get_slag().compareTo(o2.get_slag()) == 0) {
            return 0;
        }
        else if (o1.get_slag().compareTo(o2.get_slag()) < 0) {
            return -1;
        }
        return 1;
    }
}
