import java.util.*;
//import javafx.
import java.util.concurrent.ThreadLocalRandom;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class TreeNode{
	int val;
	TreeNode left = null, right = null;
	TreeNode(int val){
		this.val = val;
	}
}
class Solution {
    public int findPivot(int []nums){
        int i ,j, l = nums.length,mid = 0;
        i = 0;
        j = l-1;
        while(i<=j){
            mid = (i+j)/2;
            //2 conditions if pivot is mid
//            System.out.println(i+" "+j+" "+mid+" "+nums[i]+" "+nums[j] +" "+nums[mid]);
            if(nums[mid]>nums[j] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid]<nums[i] && nums[mid] < nums[mid-1]){
                return mid-1;
            }else if (nums[mid]<nums[j]){ //Conditions to jump to right of left subarray
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int target, int i, int j) {
    	int mid = 0;
        while(i<=j){
            mid = (i+j)/2;
//            System.out.println(i+" "+j+" "+mid);
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
//        System.out.println(pivot);
        int l = nums.length;
        if(pivot!=-1) {
        	if(nums[pivot]==target)
        		return pivot;
        	else if (target < nums[pivot] && target >= nums[0]) {
        		return binarySearch(nums,target,0,pivot-1);
        	}else {
        		return binarySearch(nums,target,pivot+1,l-1);
        	}
        }
        return binarySearch(nums,target,0,l-1);
        
    }
}


public class Hello {	
	public static void main(String[] args) {
		int x = ThreadLocalRandom.current().nextInt(2,10);
		Solution s = new Solution();
//		char [][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		int [][] grid = new int[][]{new int[]{1,1,1,0,0},
				new int[]{1,1,1,0,0},
				new int[]{0,1,1,1,1},
				new int[]{0,0,0,1,1}};
//		ListNode head = new ListNode(3);
//		head.next = new ListNode(5);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		head = s.reverseBetween(head, 1,2);
//		while(head!=null) {
//			System.out.print(head.val+" ");
//			head = head.next;
//		}
		
//		TreeNode root = new TreeNode(-2);
//		root.right = new TreeNode(-3);
		
		System.out.println("Result "+s.findPivot(new int[] {3,4,5}));

	}
}


