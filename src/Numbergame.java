import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Numbergame {
    public static void main(String[] args) {
        double number=(int)(Math.random()*100);
        System.out.println(number);
        Scanner inp=new Scanner(System.in);
        int right=0;
        int selected;
        boolean isWin=false;
        boolean isWrong=false;
        int [] wrong=new int[5];
        while (right<5){
            System.out.print("Lütfen Tahminizi Giriniz:");
            selected=inp.nextInt();
            if (selected<0 || selected>99){
                System.out.println("Lütfen 0-100 Aralıgında Bir Değer Giriniz");
                if (isWrong){
                    right++;
                    System.out.println("Çok FAZLA hatalı Giriş Yaptınız. Kalan Hakkınız:"+(5-(right)));
                }
                else {
                    isWrong=true;
                    System.out.println("Bir Daha Hata Yaparsanız Hakkınızdan Düşülecektir!!!");

                }
                continue;
            }
            if (selected==number){
                System.out.println("Tebrikler DOĞRU tahmin...");
                isWin=true;
                break;
            }
            else {
                System.out.println("Hatalı Bir Sayı Girdiniz!!!");
                if (selected>number){
                    System.out.println(selected+" Sayısı gizli sayıdan Büyüktür.");
                }
                else {
                    System.out.println(selected+" Sayısı gizli sayıdan Küçüktür.");
                }
                wrong[right++]=selected;
                System.out.println("Kalan Hakkınız:"+(5-right));
            }
        }
        if (!isWin){
            System.out.println("KAYBETTİNİZ!!!");
            if (!isWrong){
                System.out.println("Tahminleriniz:"+ Arrays.toString(wrong));
            }
        }
    }
}
