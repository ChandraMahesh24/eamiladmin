package eamilapp;
import java.util.*;
public class EmailApp{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //user info
        System.out.println("Enter frist name:");
        String f_name=s.next();
        System.out.println("Enter last name");
        String l_name=s.next();

        //creating object for Email class
        Email em1=new Email(f_name, l_name);
        int choic=-1;
        System.out.printf("\n ...........................................\n\n");

        do{
            System.out.println("\n****************************\nEnter your choice\n1.Show Info\n2. Change password\n3. CHange mailbox capacity\n4. Set Alternate mail\n5. Store Data in file\n6. Dsiplay data from file\n7.Exit  ");
            System.out.printf("\n...........................................\n\n");
            choic=s.nextInt();
            switch(choic){
                case 1: em1.getInf();
                break;
                case 2: em1.set_password();
                break;
                case 3: em1.set_mailcap();
                break;
                case 4: em1.alter_email();
                case 5: em1.storeFile();;
                break;
                case 6: em1.readFile();
                break;
                case 7: System.out.println("Than you for you using this application!....");  
                break;
                default:
                System.out.println("Invalid choce! \nEnter proper choice again:");
            }
        }while(choic!=7);
}
}