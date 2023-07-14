class Solution {
    class Node {
        int val;
        int index;
        int count;
        Node(int val, int index) {
            this.val = val;
            this.index = index;
            count = 0;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Node[] arr = new Node[nums.length];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i], i);
            arr[i] = node;
            ans.add(0);
        }
        
        mergeSort(arr, 0, nums.length - 1);
        
        for (Node node : arr) {
            ans.set(node.index, node.count);
        }
        
        return ans;
    }
    
    private static void mergeSort(Node[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    
    private static void merge(Node[] arr, int l, int m, int r) {
        int size1 = m - l + 1;
        int size2 = r - m;
        
        Node[] arr1 = new Node[size1];
        Node[] arr2 = new Node[size2];
        
        for (int i = 0; i < size1; i++) {
            arr1[i] = arr[l + i];
        }
        
        for (int i = 0; i < size2; i++) {
            arr2[i] = arr[m + i + 1];
        }
        
        int i = 0;
        int j = 0;
        int k = l;
        
        while (i < size1 && j < size2) {
            if (arr1[i].val > arr2[j].val) {
                arr1[i].count += (size2 - j);
                arr[k++] = arr1[i++];
            }
            else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < size1) {
            arr[k++] = arr1[i++]; 
        }
        while (j < size2) {
            arr[k++] = arr2[j++];
        }
    }
}