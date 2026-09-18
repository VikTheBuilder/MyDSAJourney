import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> generateRow(int row){
        int ans=1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col=1; col<row; col++){
            ans = ans*(row-col);
            ans = ans/col;
            ansRow.add(ans);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        for (int i = 1; i <= numRows; i++) {
            result.add(generateRow(i));
        }
        return result;
    }
}
