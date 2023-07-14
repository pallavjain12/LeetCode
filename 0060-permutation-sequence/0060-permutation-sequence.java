public class Solution {
    public String getPermutation(int n, int k) {        
        
        int[] factorial = new int[n+1];        
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            factorial[i] = i * factorial[i - 1];
        }
        
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();

        for(int i = n - 1; i >= 0; i--){
            int index = k/factorial[i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[i];
        }

        return sb.toString();
    }
}