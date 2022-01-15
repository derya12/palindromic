import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;
public class MineSweeper {
    int row, colomn;
    String[][] board;
    int size;
    Scanner inp = new Scanner(System.in);
    Random rnd = new Random();

    MineSweeper(int row, int colomn) {
        this.row = row;
        this.colomn = colomn;
        this.board = new String[row][colomn];
        this.size = row * colomn;
    }

    String[][] mayin() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colomn; j++) {
                board[i][j] = "-";
            }
        }
        return board;
    }

    String[][] sweper() {
        int count = (this.size / 4), randrow, rancol;
        String arr[][] = mayin();
            while (count>0){
                randrow = rnd.nextInt(arr.length);
                rancol = rnd.nextInt(arr[randrow].length);
                if (arr[randrow][rancol].equals("-") ) {
                    arr[randrow][rancol]="*";
                    count--;
                }
            }
            return arr;
            }
    void printMineBoard(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    int check(int x,int y,String [][]arr){
        int s=0;
        for (int i=Math.max(0,x-1);i<=Math.min(x+1, arr.length-1);i++){
            for (int j=Math.max(0,y-1);j<=Math.min(y+1,arr[0].length-1);j++){
                if((i!=x)||(j!=y)){

                    if(arr[i][j].equals("*") ){
                        s++;
                    }
                }
            }
        }
        return s;
    }
    void run(){
        int right=(this.row*this.colomn)-((this.row*this.colomn)/4);
        String[][] gameboard = mayin();
        String game [][] =sweper();
        //printMineBoard(gameboard);
        printMineBoard(game);
        System.out.println("..........................................");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz...");
        System.out.println();
        //printMineBoard(mayin());
        while (right!=0){
            System.out.print("Satır Sayısı Giriniz:");
            int r= inp.nextInt();
            System.out.print("Sütun Sayısı Giriniz:");
            int c= inp.nextInt();
            if ((r<0 ||c<0) || (r>=game.length||c>=game.length)){
                System.out.println("Hatalı Değer Girildi.Lütfen Geçerli Bir Değer Giriniz!!!");
                continue;
            }

            if (game[r][c].equals("*")) {
                System.out.println("Mayına Bastınız");
                System.out.println("KAYBETTİNİZ!!!");
                break;
            }
            game[r][c]=Integer.toString(check(r,c,game));
            gameboard[r][c]=Integer.toString(check(r,c,game));
            printMineBoard(game);
            System.out.println("Mayın Sayısı:"+check(r,c,game));
            System.out.println("Kalan Canınız:"+right);
            right--;
            if (right==0){
                System.out.println("TEBRİKLEERRR,OYUNU KAZANDINIZ...");
            }
            }
}

}
