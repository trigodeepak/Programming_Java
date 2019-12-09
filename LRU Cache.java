import java.util.*;

class LRUCache {
    HashMap<Integer,ArrayList<Integer>> map;
    ArrayList<Integer> list;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer,ArrayList<Integer>>();
        this.list = new ArrayList<Integer>(capacity);
    }
    public int get(int key) {
        System.out.println("In get "+key+" "+map+" "+list);
        if(map.containsKey(key)){
            //set the priority according most recently used here
            ArrayList<Integer> p = map.get(key);
            if(((int)p.get(0))>-1){
                // System.out.println("Out"+p+list);
                
                //If I am directly passing it is trying to remove the object instead of removing fromm the index
                list.remove(((int)p.get(1)));
                // System.out.println("Out"+p+list);
                map.put(key,new ArrayList<Integer>(2));
                map.get(key).add(p.get(0));
                map.get(key).add(list.size());
                list.add(key);
                }
             System.out.println("Out"+map+" "+list);
            return (int)p.get(0);
        }
         System.out.println("Out"+map+" "+list);
        return -1;
        
    }
    
    public void put(int key, int value) {
        System.out.println("In Put "+key+" "+map+" "+list);
        if(list.size()<capacity) {
            map.put(key,new ArrayList<Integer>(Arrays.asList(value,list.size())));
            list.add(key);
        }else{
        	if(map.containsKey(key)) {
        	ArrayList<Integer> p = map.get(key);
            if(((int)p.get(0))>-1){
                // System.out.println("Out"+p+list);
                
                //If I am directly passing it is trying to remove the object instead of removing fromm the index
                list.remove(((int)p.get(1)));
                // System.out.println("Out"+p+list);
                map.put(key,new ArrayList<Integer>(2));
                map.get(key).add(value);
                map.get(key).add(list.size());
                list.add(key);
                return;
                }
            }	
            int keyRemove = list.get(0);
            map.put(keyRemove,new ArrayList<Integer>(Arrays.asList(-1,0)));
            list.remove(0);//if you are removing zero index change all the indexes in map
            for(Integer k: map.keySet()) {
            	map.get(k).set(1,map.get(k).get(1)-1);
            }
            map.put(key,new ArrayList<Integer>(Arrays.asList(value,list.size())));
            list.add(key);
            }
         System.out.println("Out"+map+" "+list);
    }
}
public class Hello {	
	public static void main(String[] args) {
//		Solution s = new Solution();
//		char [][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//		System.out.println(s.split("hi,we,are here", ','));
		
//		make a driver function that will call the thing
//		["LRUCache","put","put","get","put","get","put","get","get","get"]
//		[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		
		String[] inp = new String[] {"put","put","put","put","get","get","get","get","put","get","get","get","get","get"};
		int [][] inpList = new int[][]{new int[]{1,1},new int[]{2,2},new int[]{3,3},new int[]{4,4},new int[]{4},new int[]{3},new int[]{2},new int[]{1},new int[]{5,5},new int[]{1},new int[]{2},new int[]{3},new int[]{4},new int[]{5}}
;

//[null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5]

		
		LRUCache cache;
		cache = new LRUCache(3);//The capacity of the cache
		for(int i = 0 ; i<inp.length ;i++ ) {
			if(inp[i].charAt(0)=='p') {
				cache.put(inpList[i][0],inpList[i][1]);
			}else {
				System.out.println(cache.get(inpList[i][0]));
			}
		}
		
		
//		for(char[] itr : board) {
//			for(char it :  itr) {
//				System.out.print(it+" ");
//			}
//		System.out.println("");
//		}
	}
}


//["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
//[null,-1,null,-1,null,null,2,6]


//ladderLength("hit","cog",new ArrayList<String>(Arrays.asList("hit","cog"))

//["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
//[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]

//[null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]

//[null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,-1,-1,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,11,null,null,null,null,null,-1,null,null,-1,null,4,29,30,null,12,11,null,null,null,null,29,null,null,null,null,17,22,-1,null,null,null,-1,null,null,null,20,null,null,null,29,-1,-1,null,null,null,null,-1,null,null,null,null,null,null,null]
