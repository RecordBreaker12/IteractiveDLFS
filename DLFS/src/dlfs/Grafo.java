package dlfs;

import java.util.ArrayList;
import java.util.Stack;

public class Grafo{
    
    public boolean execute(Node start, Node goal, int limit){
        Stack<Node> nodeStack = new Stack<>();
        ArrayList<Node> visitedNodes = new ArrayList<>();
        nodeStack.add(start);

        int depth = 0;

        while(!nodeStack.isEmpty()){
            if(depth <= limit) {
                Node current = nodeStack.pop();
                if (current.equals(goal)) {
                    System.out.println("Goal node found");
                    return true;
                } 
                else {
                    visitedNodes.add(current);
                    for(Node check : current.adj){
                        if(!visitedNodes.contains(check)){
                            nodeStack.add(check);
                        }
                    }
                    depth++;

                }
            } 
            else {
                return false;
            }
        }
        System.out.println("Goal Node not found within depth limit");
        return false;
    }
    
    public boolean executeInteractive(Node start, Node goal, int max){
        for(int i = 0; i<=max;i++){
            if(execute(start, goal, i)){
                System.out.println("Depth: " + i);
                return true;
            }
        }
        return false;
    }
}