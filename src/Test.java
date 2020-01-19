import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Test {



    public static void main(String[] args) {
        int[] arr = new int[100];


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            arr[i] = i;
            map.put(i, 0);
        }

        shuffleArray(arr, map);

        int first = 0;
        for(int i = 0; i < 50; i++){
            first+= map.get(i);
        }
        int second = 0;
        for(int i = 50; i < 100; i++){
            second+= map.get(i);
        }

        System.out.println("0-49: " + first);
        System.out.println("50-99: " + second);


        System.out.println(map);


    }



    public static int[] shuffleArray(int[] arr, HashMap<Integer, Integer> map){
        Random rand = new Random();
        int randNum;
        for(int i = 0; i < arr.length; i++){
            randNum = (rand.nextInt(arr.length-i) + i);
            swap(arr, i, randNum);
            map.put(i, map.get(i) +1);
            map.put(randNum, map.get(randNum)+1);
        }

        return arr;
    }


    public static void swap(int[] arr, int b, int a){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
