package utils;


import java.io.IOException;
import java.util.ArrayList;



public class TestData {
public String getCarloan() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data=d.getdata("car loan");
String carloan=(String) data.get(1);
return carloan;
}

public String getInterest() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("car interest");
String interest=(String) data1.get(1);
return interest;
}
public String getTenureYr() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("car tenure Yr");
String tenureYr=(String) data1.get(1);
return tenureYr;
}
public String getTenureMn() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("car tenure Mn");
String tenureMn=(String) data1.get(1);
return tenureMn;
}
public String getHV() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("HV");
String HV=(String) data1.get(1);
return HV;
}
public String getDP() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("DP");
String DP=(String) data1.get(1);
return DP;
}
public String getLI() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("LI");
String LI=(String) data1.get(1);
return LI;
}
public String getIR() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("IR");
String IR=(String) data1.get(1);
return IR;
}
public String getLT() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("LT");
String LT=(String) data1.get(1);
return LT;
}
public String getLFees() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("LFees");
String LFees=(String) data1.get(1);
return LFees;
}
public String getLoanAmount() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("Loan Amount");
String LoanAmnt=(String) data1.get(1);
return LoanAmnt;
}
public String getInterestRate() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("Interest Rate");
String IntrstRt=(String) data1.get(1);
return IntrstRt;
}
public String getLoanTenure() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("Loan Tenure");
String Loanterm=(String) data1.get(1);
return Loanterm;
}
public String getFees() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("Fees and charges");
String Fees=(String) data1.get(1);
return Fees;
}
public String getEMI() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("EMI");
String EMI=(String) data1.get(1);
return EMI;
}



}
