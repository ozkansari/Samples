package practice.graph.bfs.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS Algorithm
 * 
 * Modified from yan.braslavski code
 */
public class BfsAlgorithm {

    /**
     * Running multi purpose bfs algorithm
     * 
     * @param vert root node
     * @param interrupTraversalAction defines actions to take on each node traversal
     */
    public void run(Vertex vert, BfsActionForInterruptTraversal interrupTraversalAction) {
    	
    	vert.setVisited(true);
    	
    	List<Vertex> trackVisitedList = new ArrayList<>();
    	trackVisitedList.add(vert);
    	
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(vert);
       
        while (!q.isEmpty()) {
            Vertex n = (Vertex) q.poll();

            // Break if needed
            if (interrupTraversalAction.onVisitParent(n)) {
                break;
            }

            for (Vertex adj : n.getAdjVertices()) {
                if (!adj.isVisited()) {
                    adj.setVisited(true);
                    trackVisitedList.add(adj);
                    q.add(adj);

                    // Break if needed
                    if (interrupTraversalAction.onVisitChild(adj)) {
                        //we are emptying the queue to break from the loop
                        q = new LinkedList<Vertex>();
                        break;
                    }
                }
            }
        }

        // reset vertexes state
        for (Vertex v : trackVisitedList) {
            v.setVisited(false);
        }
    }

    /**
     * Shows if interrupt traversal is required on different conditions
     *  
     * This interface will help us to make BFS Algorithm usage generic for different purposes
     */
    public interface BfsActionForInterruptTraversal {
    	
        /**
         * @return true if want to interrupt traversal
         */
        boolean onVisitParent(Vertex vertex);

        /**
         * @return true if want to interrupt traversal
         */
        boolean onVisitChild(Vertex vertex);
    }
}