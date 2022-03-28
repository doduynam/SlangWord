package com.duynam;

import java.util.ArrayList;

public class SlangWord {
    private String _slag;
    private ArrayList<String> _mean;

    public SlangWord(String slag, ArrayList<String> mean) {
        _slag = slag;
        _mean = mean;
    }

    public String get_slag() {
        return _slag;
    }

    public ArrayList<String> get_mean() {
        return _mean;
    }

    public void set_mean(ArrayList<String> _mean) {
        this._mean = _mean;
    }

    public void set_slag(String _slag) {
        this._slag = _slag;
    }

    @Override
    public String toString() {
        String result = "";
        result = _slag + "`" + _mean;

        return result;
    }

    public String show() {
        String result = "";

        result = "Slang word: " + _slag + "\n";
        result += "Definition:\n";
        for (String s : _mean) {
            result += "\t\t" + s + "\n";
        }

        return result;
    }
}
