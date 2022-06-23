import java.util.InputMismatchException;
import java.util.Scanner;
class checkid{
    public checkid(){
        boolean flag1=false;
        String str="011";
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter an ID to validate :");
        String id=sc1.nextLine();

        int v1=Integer.parseInt(id.substring(3,5));
        int v2=Integer.parseInt(id.substring(5,6));
        int v3=Integer.parseInt(id.substring(6,id.length()));
        if(id.length()==9) {
            if (id.substring(0,3).equals(str)) {
                if(v1>=3 && v1<=20){
                    if(v2>=1 && v2<=3) {
                        if (v3 >= 1 && v3 <= 999) {
                            flag1 = true;
                        }

                    }
                }
            }
        }

        if(flag1==false){
            System.out.println("Invalid\n");
        }
        if(flag1==true){
            System.out.println("Valid\n");
        }
    }
}

class checkmail {
    public checkmail() {
        boolean flag2 = false;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter Email to validate : ");
        String mail = sc2.nextLine();
        int len0 = mail.length();
        int len = mail.length() - 16;
        String str = mail.substring(len, len0);
        String end1 = "@bscse.uiu.ac.bd";
        String end2 = "@bseee.uiu.ac.bd";
        if (str.equals(end1) | str.equals(end2)) {
            if (Integer.parseInt(mail.substring(len - 3, len)) >= 1 && Integer.parseInt(mail.substring(len - 3, len)) <= 999) {
                if (Integer.parseInt(mail.substring(len - 4, len - 3)) >= 1 && Integer.parseInt(mail.substring(len - 4, len - 3)) <= 3) {
                    if (Integer.parseInt(mail.substring(len - 6, len - 4)) >= 3 && Integer.parseInt(mail.substring(len - 6, len - 4)) <= 20) {
                        flag2 = true;
                    }
                }
            }
        } else {
            flag2 = false;
        }

        if (flag2 == true) {
            System.out.println("Valid\n");
        } else {
            System.out.println("Invalid\n");
        }


    }
}
class checkpass{
    public checkpass(){
        boolean num=false,upc=false,lowc=false,specialc=false,lastp=false,underc=true;
        char ch;
        System.out.println("Enter Pass:");
        Scanner sc3=new Scanner(System.in);
        String pass=sc3.nextLine();
        if(pass.length()>7){
            for(int i=0;i<pass.length();i++){
                ch=pass.charAt(i);
                if(Character.isDigit(ch)){
                    num=true;
                }
                else if(Character.isUpperCase(ch)){
                    upc=true;
                }
                else if(Character.isLowerCase(ch)){
                    lowc=true;
                }
                else if(ch=='#' || ch=='@' || ch=='%' || ch=='&'){
                    specialc=true;
                }
                else if(ch=='_'){
                    underc=false;
                }
                if(pass.charAt(pass.length()-1)=='P'){
                    lastp=true;
                }
            }
            if(num && lowc && upc && lastp && specialc && underc){
                System.out.println("Valid\n");
            }
            else{
                System.out.println("Invalid\n");
            }
        }
        else {
            System.out.println("Invalid : Too Small\n");
        }
    }
}
class checknumber{
    public checknumber(){
        System.out.println("Enter Number :");
        Scanner sc4=new Scanner(System.in);
        String string =sc4.nextLine();
        boolean isNumeric = true;

        try {
            Double num = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        if(isNumeric)
            System.out.println("Valid\n");
        else
            System.out.println("Invalid\n");

    }

}
class checkname {
    public checkname(){
        boolean hasUIU=false,hasNum=false,isEqual=false,isLow=true,tryFlag=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Username :");
        String uname=sc.nextLine();
        String[] str=uname.split("UIU");
        int len=str[0].length();
        try {
            if (uname.substring(len, len + 3).equals("UIU")) {
                hasUIU = true;
            }


            try {
                if (Integer.parseInt(uname.substring(len + 3, len + 4)) >= 0 && Integer.parseInt(uname.substring(len + 3, len + 4)) <= 9) {
                    hasNum = true;
                }
            } catch (NumberFormatException e) {
                tryFlag = true;
            }
            try {
                if (uname.substring(len + 4, uname.length()).equals(str[0])) {
                    isEqual = true;
                }
            }catch (InputMismatchException e){
                tryFlag=true;
            }
        }catch (StringIndexOutOfBoundsException e){
            tryFlag=true;
        }
        for(char c : str[0].toCharArray()) {
            if(Character.isUpperCase(c)) {
                isLow=false;
            }


        }
        if(hasUIU && hasNum && isEqual && isLow){
            System.out.println("Valid\n");
        }
        else if(tryFlag){
            System.out.println("Invalid");
        }
        else {
            System.out.println("Invalid\n");
        }


    }
}

public class Try1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Assuming Established date of UIU is 2003\nMenu:");
        int flag=0;
        while (flag!=6){
            System.out.println("1)ID validation \n2)E-mail validation \n3)Password validation \n4)Number validaiotn \n" +
                    "5)Username validation \n6)Exit \nChoose an Option: ");
            flag=sc.nextInt();

            if(flag==1){
                checkid c=new checkid();
            }
            if(flag==2){
                checkmail c1=new checkmail();
            }
            if(flag==3){
                checkpass c2=new checkpass();
            }
            if(flag==4){
                checknumber c3=new checknumber();
            }
            if(flag==5){
                checkname c4=new checkname();
            }

        }
    }
}
