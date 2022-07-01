import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class QueueReconstructionByHeight{
    public int[][] exec(int[][] people){
        //System.out.println(Arrays.deepToString(people));
        sort2dArray(people);
        //System.out.println(Arrays.deepToString(people));
        HashMap<Integer, Integer> positions = new HashMap<>();
        for(int i = 0; i < people.length; i++){
            int placeIn = 0;
            int index = people[i][1];
            for(int k = 0;k <= people.length; k++){
                if(index == 0){
                    placeIn = k;
                }
                if(positions.containsKey(k)){
                    if(people[i][0] <= people[positions.get(k)][0]) index--;
                }else{
                    index--;
                }
            }
            if(!positions.containsKey(placeIn)){
                positions.put(placeIn, i);
                //System.out.println(placeIn);
            }else{
                int nextPlace = placeIn;
                while(positions.containsKey(nextPlace)) nextPlace++;
                positions.put(nextPlace, i);
                //System.out.println(nextPlace);
            }
        }
        int[][] result = new int[people.length][people[0].length];
        for(int i = 0; i< people.length; i++){
            result[i] = people[positions.get(i)];
        }
        return result;
    }

    public static void sort2dArray(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[0] > second[0]) return 1;
                else if(first[0] == second[0]){
                    return Integer.compare(first[1], second[1]);
                }
                else return -1;
            }
        });
    }
}
