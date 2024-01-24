class Solution {
    public int[] findErrorNums(int[] nums) {
        int n =nums.length;
        int arr[]= new int[2];
        int i=0;
        while(i<n){
            int check = nums[i]-1;
            if(nums[i] != nums[check]){
                int temp =nums[i];
                nums[i]=nums[check];
                nums[check]=temp;
            }
            else{
                i++;
            }
        }

        for(int index=0; index<n ; index++){
            if(nums[index]!=index+1){
                arr[0]=nums[index];
                arr[1]=index+1;
            }
        }
        return arr;   
    }
}