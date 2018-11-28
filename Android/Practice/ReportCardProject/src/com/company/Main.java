package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ReportCard john = new ReportCard("John Jackson");
        john.setChemistryGrade(149);
        john.setEnglishGrade(125);
        john.setMathGrade(144);
        john.setPhysicsGrade(122);

        System.out.println(john.toString());
    }
}
