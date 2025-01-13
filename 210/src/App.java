import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = solution.findOrder(numCourses, prerequisites);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public class Course {
        final int id;
        // Nodes that are pointing to this node in the directed graph
        final List<Course> dependencies;
        // Nodes this node points to in the directed graph
        final List<Course> isDependencyFor;
        Course(int id) {
            this.id = id;
            this.dependencies = new ArrayList<>();
            this.isDependencyFor = new ArrayList<>();
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Init courses
        Course[] courses = new Course[numCourses];
        for(int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i); // Initialize each course
        }

        // Build dependency graph
        for(int[] relation: prerequisites) {
            int courseId = relation[0];
            int dependencyId = relation[1];

            courses[courseId].dependencies.add(courses[dependencyId]); // Add dependency
            courses[dependencyId].isDependencyFor.add(courses[courseId]); // Add course to dependency list
        }
    
        Queue<Course> toTake = new LinkedList<>();
        // Take courses with no dependencies because there is no reason not to
        for(int i = 0; i < courses.length; i++)
            if(courses[i].dependencies.isEmpty())
                toTake.offer(courses[i]); // Add courses with no dependencies to the queue

        List<Integer> courseOrder = new ArrayList<>(numCourses);
        Set<Course> taken = new HashSet<>(numCourses);
        
        while(!toTake.isEmpty()) {
            Course curr = toTake.poll(); // Get the next course to take
            
            // Take course if you haven't taken it already and you took all dependencies
            if(!taken.contains(curr) && taken.containsAll(curr.dependencies)) {
                courseOrder.add(curr.id); // Add course to the order
                taken.add(curr); // Mark course as taken
                
                for(Course next : curr.isDependencyFor)
                    toTake.offer(next); // Add dependent courses to the queue
            }
        }

        // If it's not possible to take all courses we take none
        return courseOrder.size() != courses.length ? new int[0]
         : courseOrder.stream().mapToInt(Integer::intValue).toArray(); // Return the course order
    }
}