package com.company;

public class ReportCard
{
    private String studentName;
    private double englishGrade;
    private double mathGrade;
    private double physicsGrade;
    private double chemistryGrade;

    public ReportCard(String inputName)
    {
        studentName = inputName;
    }

    public double getEnglishGrade()
    {
        return englishGrade;
    }

    public void setEnglishGrade(double englishGrade)
    {
        this.englishGrade = englishGrade;
    }

    public double getMathGrade()
    {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade)
    {
        this.mathGrade = mathGrade;
    }

    public double getPhysicsGrade()
    {
        return physicsGrade;
    }

    public void setPhysicsGrade(double physicsGrade)
    {
        this.physicsGrade = physicsGrade;
    }

    public double getChemistryGrade()
    {
        return chemistryGrade;
    }

    public void setChemistryGrade(double chemistryGrade)
    {
        this.chemistryGrade = chemistryGrade;
    }


    public String toString()
    {
        return "Name: "+studentName +", English grade: "+ getEnglishGrade()+", Math grade: "+
                getMathGrade()+", Physics grade: "+getPhysicsGrade()+ ", Chemistry grade: "+
                getChemistryGrade()+".";
    }


}
