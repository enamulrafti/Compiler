import java.util.Scanner;

public class Try2 {
    public static void main(String[] args) {
        String dataTable[][]=new String[100][3];
        String breakSpace[];
        String breakComa[];
        String breakEq[];
        String originalStat;
        int row=0;
        boolean isNotcontain=true;
        Scanner sc = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.println("_____Symbol Table_______");
        int flag=0;

        while(flag!=5){
            System.out.println("1)Insert Data \n2)Remove Data \n3)Update Data \n4)Display Data \n" +
                    "5)Exit\n ");
            System.out.println("Choose an option:");
            flag = sc.nextInt();
            isNotcontain=true;
            if(flag==1){
                System.out.println("Enter a statement:\n(Try to avoid unnecessary space in statement)");
                Scanner sc1=new Scanner(System.in);
                String stat=sc1.nextLine();
                if(stat.charAt(stat.length()-1)==';'){
                    originalStat=stat.substring(0,stat.length()-1);
                    breakSpace=originalStat.split(" ");

                    if(breakSpace[1].contains(",")){
                        breakComa=breakSpace[1].split(",");
                        for(int i=0;i<breakComa.length;i++){
                            if(breakComa[i].contains("=")){
                                breakEq=breakComa[i].split("=");
                                for(int j=0;j<row;j++){
                                    if(dataTable[j][1].equals(breakEq[0])){
                                        isNotcontain=false;
                                    }
                                }
                                if(isNotcontain){
                                    dataTable[row][0]=breakEq[0];
                                    dataTable[row][1]=breakSpace[0];
                                    dataTable[row][2]=breakEq[1];
                                    row++;

                                }
                                else {
                                    System.out.println("Already Exist\n");
                                }
                            }
                            else {
                                for (int j=0;j<row;j++){
                                    if(dataTable[j][1].equals(breakComa[i])) {
                                    isNotcontain=false;
                                    }
                                }
                                if(isNotcontain){
                                    dataTable[row][0]=breakComa[i];
                                    dataTable[row][1]=breakSpace[0];
                                    dataTable[row][2]="NULL";
                                    row++;

                                }
                                else {
                                    System.out.println("Already Exist");
                                }
                            }

                            }
                        }else {
                        if(breakSpace[1].contains("=")){
                            breakEq=breakSpace[1].split("=");
                            for(int i=0;i<row;i++){
                                if(breakEq[0].equals(dataTable[i][0])){
                                    isNotcontain=false;
                                }
                            }
                            if(isNotcontain){
                                dataTable[row][0]=breakEq[0];
                                dataTable[row][1]=breakSpace[0];
                                dataTable[row][2]=breakEq[1];
                                row++;
                            }
                            else {
                                System.out.println(" Already Exist");
                            }
                        }
                        else {
                            for(int i=0;i<row;i++){
                                if(dataTable[i][0].equals(breakSpace[1])){
                                    isNotcontain=false;
                                }
                            }
                            if(isNotcontain){
                            dataTable[row][0]=breakSpace[1];
                            dataTable[row][1]=breakSpace[0];
                            dataTable[row][2]="NULL";
                            row++;

                            }
                            else {
                                System.out.println("Already Exist");
                            }
                        }


                    }

                    System.out.println("Data Inserted.");

                }
                else {
                    System.out.println("Your statement missed semicolon (;)");
                }
            }
            if(flag==2){
                Scanner sc2=new Scanner(System.in);
                System.out.println("Enter DataName to Remove: ");
                String search=sc2.nextLine();
                System.out.println("Confirm removing : 1)OK 2)Cancel");
                int confirmation=sc2.nextInt();
                boolean test=false;
                if(confirmation==1){
                    for(int i=0;i<row;i++){
                        if(search.equals(dataTable[i][0])){
                            dataTable[i][0]="_";
                            dataTable[i][1]="_";
                            dataTable[i][2]="_";
                            test=true;
                            System.out.println("Data Removed!");
                        }
                    }
                }else {
                    System.out.println("Removing Cancelled");
                }
                if(!test){
                    System.out.println("Don't Exist!");
                }
            }
            if(flag==3){
                System.out.println("Enter DataName to Update:");
                String dataname=sc3.next();
                System.out.println("1)Update Data Type\n2)Update Value\nChoose to update:");
                int a=sc3.nextInt();
                boolean x=false;
                if(a==1) {
                    System.out.println("Enter New data type:");
                    String datatype=sc.next();
                    for(int i=0;i<row;i++){
                        if(dataname.equals(dataTable[i][0])){
                            dataTable[i][1]=datatype;
                            x=true;
                            System.out.println("Data Type Updated!");
                        }
                    }
                }
                else {
                    System.out.println("Enter New Value :");
                    String value=sc.next();
                    for(int i=0;i<row;i++){
                        if(dataname.equals(dataTable[i][0])){
                            dataTable[i][2]=value;
                            x=true;
                            System.out.println("Value Updated!");
                        }
                    }
                }
                if(!x){
                    System.out.println("Not Found!");
                }
            }
            if(flag==4){
                System.out.println("SL\tName\tDataType\tValue");
                for(int i=0;i<row;i++){
                    System.out.println(i+1+"\t"+dataTable[i][0]+"\t\t"+dataTable[i][1]+"\t\t\t"+dataTable[i][2]);
                }
            }
            if(flag==5){
                break;
            }


        }
    }
}
