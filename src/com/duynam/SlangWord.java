package com.duynam;

public class SlangWord {
    private String _slag;
    private String _mean;

    public SlangWord(String slag, String mean) {
        _slag = slag;
        _mean = mean;
    }

    public String get_slag() {
        return _slag;
    }

    public String get_mean() {
        return _mean;
    }

    public void set_mean(String _mean) {
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
}
