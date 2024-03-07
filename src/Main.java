import java.util.*;
class Main{
    static int seats[][]=new int[6][6];
public static void main(String args[]){

    for (int i=0;i<6;i++){
        for(int j=0;j<6;j++){
            seats[i][j]=0;
        }
    }
    Scanner sc=new Scanner(System.in);
    System.out.println("Welcome to Theatretickets....\n These are the available tickets");


    while(true){
        leftSeats();
        int left=Available();
        System.out.println("Total available seats "+left);
        if (left==0){
            System.out.println("All sold out");
            System.exit(0);
        }
        System.out.println("specify tickets you want");
        System.out.println("Accepted input formats: A1,A3-A5");
        String req=sc.next();
        String temp[]=null;
        String row[]=req.split(",");
        for (String s:row) {
            if (s.length()==2){
                Booking(s.charAt(0),Integer.parseInt(String.valueOf(s.charAt(1)))-1);
            }
            if (s.contains("-")){
                temp=s.split("-");
                for (int i=Integer.parseInt(String.valueOf(temp[0].charAt(1)))-1;i<=Integer.parseInt(String.valueOf(temp[1].charAt(1)))-1;i++){
                Booking(temp[0].charAt(0),i);
                }

            }
        }
        System.out.println("Book again?(y/n)");
        String q=sc.next();
        if (q.equals("n")){

            System.exit(0);
        }



}

}
public static int leftSeats(){
    for (int i=0;i<6;i++){
        if (i==0){
            System.out.println("  1 2 3 4 5 6");
        }
        for(int j=0;j<6;j++){
            if (j==0){
                System.out.print((char)(i+65)+" ");
            }
            System.out.print(seats[i][j]+" ");
        }
        System.out.println();
    }
    return 0;
};
public static int Available(){
  int count=0;
    for (int i=0;i<6;i++){
        for(int j=0;j<6;j++){
            if (seats[i][j]==0){
                count++;
            }

        }
    }
    return count;

};
public static void Booking(Character s,int n){
    int i=(int)s-65;

    if ((n<0) || (n>5) || (i<0) || (i>5)){
        System.out.println("invalid input:"+String.valueOf(s)+String.valueOf(n+1));
    }
    else if (seats[i][n]==1){
        System.out.println("ticket already booked:"+String.valueOf(s)+String.valueOf(n+1));
    }
else{
        seats[i][n]=1;
    }

};

}