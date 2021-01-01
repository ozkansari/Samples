package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckArrayFormationThroughConcatenation {
	
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        String targetFormation = Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining("_"))
            .concat("_");
        
        for(int [] p : pieces) {
            
            String pieceFormation = Arrays.stream(p)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("_"))
                .concat("_");
            if(!targetFormation.contains(pieceFormation)) {
                return false;
            }
            
        }
        
        return true;
    }

}
