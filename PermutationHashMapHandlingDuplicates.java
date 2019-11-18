//Permutations hashmap Handling duplicates
class Solution {
	List<List<Integer>> res;
    public void permuteUtil(HashMap<Integer,Integer> map,int [] nums,ArrayList<Integer> seq) {
    	if(seq.size()==nums.length) {
    		if(!res.contains(seq)) {
			//Doing Deep copy
			ArrayList<Integer> newList = new ArrayList<Integer>(seq);
			res.add(newList);}
    		return ;
    	}
    	for(int i=0;i<nums.length;i++) {
    		if(map.get(nums[i])>=1){
	    		seq.add(nums[i]);
	    		map.put(nums[i],map.get(nums[i])-1);
	    		permuteUtil(map,nums,seq);
	    		seq.remove(seq.size()-1);
	    		map.put(nums[i],map.get(nums[i])+1);
    		}
    	}
    }
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	res = new ArrayList<List<Integer>>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i, count;
        for(i =0;i<nums.length;i++){
        	count = map.containsKey(nums[i]) ? map.get(nums[i]):0;
        	map.put(nums[i],count+1);    
        }
        permuteUtil(map,nums,new ArrayList<Integer>());
        return res;
    }
}