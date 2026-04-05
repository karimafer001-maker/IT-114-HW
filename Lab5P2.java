public class Lab5P2 {
    
    public static int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result = result ^ num;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {2, 2, 1};
        int[] test2 = {4, 1, 2, 1, 2};
        int[] test3 = {1};
        
        System.out.print("Output: " + singleNumber(test1));  
        System.out.print("Output: " + singleNumber(test2));  
        System.out.print("Output: " + singleNumber(test3));  
    }
}