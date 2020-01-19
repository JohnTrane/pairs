import java.util.Scanner;

public class Comparator {

    FieldBuilder fb = new FieldBuilder(4);

    public Comparator(){
        // why not
    }


    public void run(){

    }


    Scanner sc = new Scanner(System.in);

    private void match(char[][] field, int row, int col, int row2, int col2){
        if(field[row][col] == field[col2][row2]){
            field[row][col] = '○';
            field[row2][col2] = '○';
        }
    }

}
