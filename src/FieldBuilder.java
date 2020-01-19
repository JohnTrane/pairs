
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FieldBuilder {
    private char[][] field;
    private char[][] hiddenField;
    private int size;


    private int row;
    private int row2;
    private int col;
    private int col2;

    public FieldBuilder(int size) {
        this.field = new char[size][size];
        this.hiddenField = new char[size][size];
        this.size = size;
        fill(this.field);
        fillHiddenField(this.hiddenField);
    }

    private void getInput(){
        Scanner sc = new Scanner(System.in);
        this.row = sc.nextInt();
        this.col = sc.nextInt();
        if(alreadySelected(hiddenField, row, col)){
            System.out.println("position is already revealed. select another");
            getInput();
        }
    }
    private void getInput2(){
        Scanner sc = new Scanner(System.in);
        this.row2 = sc.nextInt();
        this.col2 = sc.nextInt();
        if(alreadySelected(hiddenField, row2, col2)){
            System.out.println("position is already revealed. select another");
            getInput2();
        }
    }

    public void run() throws InterruptedException {
        while (true) {
            hugePaddind();
            draw(hiddenField);
            getInput();
            showSelected(row, col);
            hugePaddind();
            draw(hiddenField);
            getInput2();
            showSelected(row2, col2);

            if (field[row][col] != field[row2][col2]) {
                Thread.sleep(3000);
                hiddenField[row][col] = '☺';
                hiddenField[row2][col2] = '☺';
            }

            if(solved()){
                System.out.println("CONGRATS! PUZZLE SOLVED!");
                break;
            }
        }
    }



    public boolean alreadySelected (char[][] hiddenField, int row, int col){
        return hiddenField[row][col] != '☺';
    }

    public boolean solved(){
        for(char[] c : getHiddenField()){
            for(char ch : c){
                if (ch == '☺')
                    return false;
            }
        }
        return true;
    }

//    public void run(){
//        int row;
//        int col;
//        while(true){
//            hugePaddind();
//            draw(hiddenField);
//            row = sc.nextInt();
//            col = sc.nextInt();
//            showSelected(hiddenField, row, col);
//        }
//    }


    private void fillHiddenField(char[][] hiddenField) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                hiddenField[i][j] = '☺';
            }
        }
    }

    private char[] shuffleArray() {
        char[] pairs = concatPairs();
        Random rand = new Random();


        for (int i = 0; i < pairs.length; i++) {
            swap(pairs, i, rand.nextInt(pairs.length - i) + i);
        }

        return pairs;
    }


    private void swap(char[] arr, int b, int a) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    private void fill(char[][] field) {
        char[] pairs = shuffleArray();
        int counter = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                field[i][j] = pairs[counter];
                counter++;
            }
        }
    }


    private char[] concatPairs() {
        String s = new String(generatePairs(this.size));
        s += s;
        return s.toCharArray();

    }


    private char[] generatePairs(int size) {
        int amountOfPairs = (size * size) / 2;
        char[] pairs = new char[amountOfPairs];

        for (char c = 65; c < 65 + amountOfPairs; c++) {
            pairs[c - 65] = c;
        }
        return pairs;
    }


    public void draw(char[][] field) {
        for (char c[] : field) {
            System.out.println(Arrays.toString(c));
        }
    }


    public char[][] getField() {
        return this.field;
    }

    public char[][] getHiddenField() {
        return hiddenField;
    }


    public void showSelected(int row, int col) {
        this.hiddenField[row][col] = this.field[row][col];
        draw(this.hiddenField);
    }

    public void hugePaddind() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }


}
