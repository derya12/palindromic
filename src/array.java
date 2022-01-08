import java.util.Arrays;
import java.util.Scanner;
public class array {
    public static String arrr(int [] arr){
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.print("Dizi Boyutunu Giriniz:");
        int x= inp.nextInt();
        int[] scores = new int[x];
        System.out.println("Dizi Elemanlarını Giriniz:");
        for (int i=0;i<scores.length;i++){
           System.out.print((i+1)+"."+"Elemanı:");
           int a=inp.nextInt();
           scores[i]=a;
        }
        System.out.println("sıralama:"+arrr(scores));
    }
}
