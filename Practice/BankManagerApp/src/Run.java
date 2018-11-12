import static java.lang.System.out;

public class Run
{
    public static void main(String[] args){
//        out.println("Hey");
        CheckingAccount myCA = new CheckingAccount();
        SavingsAccount mySA = new SavingsAccount();
        CertificateOfDeposit myCOD = new CertificateOfDeposit();
        out.println(myCA.account);
    }

}
