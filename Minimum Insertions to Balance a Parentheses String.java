class Solution {
    public int minInsertions(String s) {
        int o = 0, c = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') o++;
            else{
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') i++;
                else c++;
                if (o > 0) o--;
                else c++;
            }
        }
        return c + o * 2;
    }
}
