package com.example.bachoquiz;

public class OnlineTest {
    private  int id;
    private int OptionNo;
    private int Test_Id;
    private String CorrectAns;
    private String GivenAns;
    private String Result;


    public OnlineTest(int id,int Test_id ,int optionNo, String correctAns, String givenAns, String result) {
        this.id = id;
        Test_Id = Test_id;
        OptionNo = optionNo;
        CorrectAns = correctAns;
        GivenAns = givenAns;
        Result = result;
    }

    public OnlineTest() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTest_Id() {
        return Test_Id;
    }

    public void setTest_Id(int test_Id) {
        Test_Id = test_Id;
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
