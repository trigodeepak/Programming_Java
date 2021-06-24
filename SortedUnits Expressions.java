import java.util.*;

//Edge class to perform edge operations 
class Edge{
	Edge(int val,String node){
		this.val = val;
		this.node = node;
	}
	int val;
	String node;
	String start;
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public String toString() {
		return start+"-"+Integer.valueOf(val)+"->"+node;
	}
}

class Solution{
	HashSet<String> visited;
	HashMap<String,Edge> map;
	//Function to perform DFS
	public Edge dfsUtil(String unit) {
		if(visited.contains(unit))
			return map.get(unit);
		visited.add(unit);
		Edge trvEdge = dfsUtil(map.get(unit).node);
		if(trvEdge==null)
			return null;
		map.put(unit, new Edge(trvEdge.val*map.get(unit).val,trvEdge.node));
		return map.get(unit);
	}
	
	public String returnExpressions(String unitString,String[] values) {
        String[] units = unitString.split(",");
        //Creating graph for units associated
        map = new HashMap<String,Edge>();
        for(String unit : units) {
        	map.put(unit,new Edge(1,unit));
        }
        //Parsing it into nodes
        for(String value : values) {
        	String[] calc = value.split("=");
        	if(calc.length!=2)
        		continue;
        	calc[1] = calc[1].strip();
        	String []edge = calc[1].split(" ");
        	Edge newEdge = new Edge(Integer.valueOf(edge[0]),edge[1]);
        	map.put(calc[0].strip(),newEdge);
        }
        visited = new HashSet<String>();
        
        //Calling DFS to put the appropriate values to nodes
        for(String unit:units) {
        	dfsUtil(unit);
        }
        List<Edge> list = new ArrayList<>();
        for(String key: map.keySet()) {
        	map.get(key).start = key;
        	list.add(map.get(key));
        }
        Collections.sort(list,(a,b)->b.val-a.val);
        int maxValue = list.get(0).val;
        
        StringBuffer res = new StringBuffer();
        int len = list.size();
        Edge edge;
        for(int i=0;i<len-1;i++) {
        	edge = list.get(i);
        	res.append(Integer.valueOf(maxValue/edge.val)+edge.start+" = ");
        }
        edge = list.get(len-1);
        res.append(Integer.valueOf(maxValue/edge.val)+edge.start);
        System.out.println(res);
        return res.toString();
	}

}

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String unitString = s.nextLine();                 
        String []units = unitString.split(",");
        int len = units.length;
//        String valueString = "hc = 6000 t:s = 600 t:b = 50 t";
//        String [] values = valueString.split(":");
        String [] values = new String[len-1];
        for(int i=0;i<len-1;i++) {
        	values[i] = s.nextLine().strip();
        }
    	Solution sol = new Solution();
    	sol.returnExpressions(unitString,values);
    }
}
//Sample Input Out for this program
//housingcomplex,sector,block,tower,apartment
//housingcomplex = 8 sector
//sector = 10 block
//block = 3 tower
//tower = 300 apartment
//1housingcomplex = 8sector = 80block = 240tower = 72000apartment
