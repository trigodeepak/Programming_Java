//Permutations hashmap approach with not handling the repeatation of numbers but can be done 
class Solution {
	List<List<Integer>> res;
    public void permuteUtil(HashMap<Integer,Boolean> map,int [] nums,int i,ArrayList<Integer> seq) {
    	if(seq.size()==nums.length) {
    		if(!res.contains(seq)) {
    			//Doing Deep copy
    			ArrayList<Integer> newList = new ArrayList<Integer>();
    			for(Integer p : seq) {
    			    newList.add(p);
    			}
    			res.add(newList);
    		}
    		return ;
    	}
    	for(i=0;i<nums.length;i++) {
    		if(map.get(nums[i])){
	    		seq.add(nums[i]);
	    		map.put(nums[i],false);
	    		permuteUtil(map,nums,i,seq);
	    		seq.remove(seq.size()-1);
	    		map.put(nums[i],true);
    		}
    	}
    }
	
    public List<List<Integer>> permute(int[] nums) {
    	res = new ArrayList<List<Integer>>();
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],true);
        }
        permuteUtil(map,nums,0,new ArrayList<Integer>());
//        for(List<Integer> p: res) {
//        	for(Integer k: p) {
//        		System.out.print(k+" ");
//        	}System.out.println(" ");
//        }
        return res;
    }
}