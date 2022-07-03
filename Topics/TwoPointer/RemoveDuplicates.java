package Topics.TwoPointer;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr){
        int nextNonDuplicate = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[nextNonDuplicate - 1] != arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        // int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
        int[] arr = new int[] {2, 2, 2, 9};
        System.out.println(removeDuplicates(arr));
    }        
}
