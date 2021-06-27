// 621 LeetCode TaskScheduler
class Solution {
    class Task{
        Task(char name,int count){
            this.name = name;
            this.count = count; 
        }
        char name;
        int count;
        int time; 
        public String toString(){
            return " "+this.name+" "+this.count+" "+this.time; 
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> pq = new PriorityQueue<Task>((a,b)->b.count-a.count);
        ArrayList<Task> waitingTask = new ArrayList<Task>();
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(char curr:tasks){
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        
        for(Character curr: map.keySet())
            pq.offer(new Task(curr,map.get(curr)));
        
        
        
        int timer=0;
        while(pq.size()>0 || waitingTask.size()>0){
            if(waitingTask.size()>0){
                for(int i=0;i<waitingTask.size();i++){
                    Task node = waitingTask.get(i);
                    node.time--;
                    if(node.time==-1){
                        waitingTask.remove(i);
                        pq.offer(node);
                        i--;
                    }
                }
            }
            if(pq.size()>0){
                Task node = pq.poll();
                node.count--;
                if(node.count!=0){
                    node.time = n;
                    waitingTask.add(node);
                }
            }
            
            // System.out.println(pq+"Next"+waitingTask);
            timer++;
        }
        return timer;
    }
}