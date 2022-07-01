import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        QueueReconstructionByHeight obj = new QueueReconstructionByHeight();
        int[][] people = {{8, 2},{4, 2},{4,5},{2, 0},{7, 2},{1,4},{9, 1}, {3, 1}, {9, 0}, {1, 0}};
        System.out.println(Arrays.deepToString(obj.exec(people)));
    }
}