package eamilapp;
import java.util.*;
import java.io.*;
import java.security.cert.Extension;
public class Email {
    public Scanner s = new Scanner(System.in);
    //settting variables as private  
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity=500;
    private String alter_email; 

    // Constructor tom receive first name last name;
    public  Email(String fname, String lname){
        this.fname=fname;
        this.lname=lname;
        System.out.println( "New Emaloyee: "+this.fname+" "+ lname);
        //calling method
        this.dept=this.setDept();
        this.password=this.generate_password(8);
        this.email=this.generate_method();
    }
    // generate eamil method

    private String generate_method(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".compnay.com";
    }
    // asking for dept;
    private String setDept(){
        System.out.println("Department codes \n1 for salea \n2 Devlopment \n3 for Accounting \n0 for None");
        boolean flag=false;
        do{
            System.out.println("Enter department code:");
            int choice=s.nextInt();
            switch(choice){
                case 1: 
                return "Sales";
                case 2: return "Development";
                case 3: return "Accounting";
                case 0: return "None";
                default :
                System.out.println("Invalid choice Please choose it again"); 
            }
        }while(!flag);
        return  null;
    }
    
    //Generate Random Password method
    private String generate_password(int lenngth){
        Random r = new Random();
        String captial_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String  samll_char="abcdefghijklmnopqrstuvwxyz";
        String numebr ="0123456789";
        String specilChar="!@#$%&?*";
        String value = samll_char+captial_chars+numebr+specilChar;
        String password="";
        for(int i=0;i<lenngth;i++){
            password = password+value.charAt(r.nextInt(value.length()));
        }
        return password;      
    }
    //change password
    public void set_password(){
        boolean flag= false;
        do{
            System.out.println("Do you want to change password! (y/n)");
            char choice= s.next().charAt(0);
            if(choice=='y'||choice=='Y'){
                flag =true;
                System.out.println("Enter the current Password");
                String temp=s.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new passsword:");
                    this.password=s.next();
                    System.out.println("password changes  succesfully");
                }        
                else{
                    System.out.println("Inccorect password: ");
                }
            }            
            else if(choice =='n'||choice=='N'){
                flag = true;
                System.out.println("Password changed opetion cancelled! ");
            }
            else{
                System.out.println("Enter Valid choice");
            }
        }while(!flag);
    }
    //set mail capacity
    public void set_mailcap(){
        System.out.println("curretn capacity="+this.mailCapacity+"mb");
        System.out.println("enter new mailbox capacity:");
        this.mailCapacity=s.nextInt();
        System.out.println("mailbox capacity is successfully changed ");
    }
    //set aleternate mail
    public void alter_email(){
        System.out.println("enter new alternate mail"); 
        this.alter_email=s.next();
        System.out.println("alternate email is set");
    }
    //Display user information method
    public void getInf(){
        System.out.println("New: "+this.fname+" "+ this.lname);
        System.out.println("Depatment: "+this.dept);
        System.out.println("Email: "+this.email);
        System.out.println("Password: "+this.password);
        System.out.println("Mail capacity: "+this.mailCapacity);
        System.out.println("Alternate mail: "+this.alter_email );
    }

    // Store  in file
    public void storeFile(){
        try {
            FileWriter in=new FileWriter("D:\\maheshProg\\java\\email_adiminstration\\Info.txt");
            in.write("\nfirst name: "+this.fname);
            in.append("\nlast name:"+ lname);
            in.append("\nEmail: "+email);
            in.append("\nPassword "+this.password);
            in.append("\nCapacity "+this.mailCapacity+"mb");
            in.append("\nAlternate Email: "+alter_email);
            in.close();
            System.out.println("Data Stroed...");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    //Reading file
    public void readFile(){
        try {
            FileReader f1= new FileReader("D:\\maheshProg\\java\\email_adiminstration\\Info.txt");
            int i;
            while((i=f1.read())!=-1){
                System.out.print((char)i);  
            }
            System.out.println();
            f1.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
}
}