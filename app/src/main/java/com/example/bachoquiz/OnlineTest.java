package com.example.bachoquiz;

public class OnlineTest {
    private  int id;
    private int OptionNo;
    private String CorrectAns;
    private String GivenAns;
    private String Result;

    public OnlineTest(int id, int optionNo, String correctAns, String givenAns, String result) {
        this.id = id;
        OptionNo = optionNo;
        CorrectAns = correctAns;
        GivenAns = givenAns;
        Result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOptionNo() {
        return OptionNo;
    }

    public void setOptionNo(int optionNo) {
        OptionNo = optionNo;
    }

    public String getCorrectAns() {
        return CorrectAns;
    }

    public void setCorrectAns(String correctAns) {
        CorrectAns = correctAns;
    }

    public String getGivenAns() {
        return GivenAns;
    }

    public void setGivenAns(String givenAns) {
        GivenAns = givenAns;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}
