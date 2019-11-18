//Permutation without using Hashmap Cannot handle duplicates
class Solution {
	List<List<Integer>> res;
    public void permuteUtil(int [] nums,ArrayList<Integer> seq) {
    	if(seq.size()==nums.length) {
    		ArrayList<Integer> newList = new ArrayList<Integer>(seq);
			res.add(newList);
			return;
    	}
    	for(int i=0;i<nums.length;i++) {
    		if(!seq.contains(nums[i])){
	    		seq.add(nums[i]);
	    		permuteUtil(nums,seq);
	    		seq.remove(seq.size()-1);
    		}
    	}
    }
    public List<List<Integer>> permute(int[] nums) {
    	res = new ArrayList<List<Integer>>();
        permuteUtil(nums,new ArrayList<Integer>());
        return res;
    }
}