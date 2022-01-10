import java.util.Scanner;
public class usAlma {
    static int us(int a,int b) {
        if (b==1){
            return b;
        }
        return a*us(a,b-1);
    }

    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int a=inp.nextInt();
        System.out.print("Üs sayıyı giriniz=");
        int b=inp.nextInt();
        System.out.println("sonuç:"+us(a,b+1));
    }



}
