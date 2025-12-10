
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // use - adjacency matrix of independent(b) and dependent(a) - map
        // and indegree array for each vetex/course
        // and use queue to track completing courses with no or prerequisites finished

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++)
        {
            int inde = prerequisites[i][0];
            int dep = prerequisites[i][1];
            if(!map.containsKey(inde))
            {
                map.put(inde, new ArrayList<>());
            }
            map.get(inde).add(dep);
            indegree[dep]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++)
        {
            if(0 == indegree[i])
            {
                queue.add(i);
                count++;
            }
        }
        if(0 == count) return false;
        if(numCourses == count) return true;

        while(!queue.isEmpty())
        {
            int courseDone = queue.poll();
            List<Integer> dependencies = map.get(courseDone);
            if(null != dependencies)
            {
                for(int course : dependencies)
                {
                    indegree[course]--;
                    if(0 == indegree[course])
                    {
                        queue.add(course);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;
    }
}