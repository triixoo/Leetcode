package Mediumtasks;
import java.util.*;

class Course {
    String id;
    int duration;

    public Course(String id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return id;
    }
}

class ConflictGraph {
    private Map<Course, List<Course>> conflictMap;

    public ConflictGraph() {
        this.conflictMap = new HashMap<>();
    }


    public void addCourse(Course course) {
        conflictMap.putIfAbsent(course, new ArrayList<>());
    }


    public void addConflict(Course c1, Course c2) {
        conflictMap.get(c1).add(c2);
        conflictMap.get(c2).add(c1);
    }


    public Map<Course, Integer> assignTimeSlots() {
        Map<Course, Integer> timeSlotAssignment = new HashMap<>();
        Map<Course, Integer> degree = new HashMap<>();


        for (Course course : conflictMap.keySet()) {
            degree.put(course, conflictMap.get(course).size());
        }


        List<Course> courses = new ArrayList<>(conflictMap.keySet());
        courses.sort((c1, c2) -> degree.get(c2) - degree.get(c1));


        for (Course course : courses) {
            Set<Integer> unavailableSlots = new HashSet<>();


            for (Course neighbor : conflictMap.get(course)) {
                if (timeSlotAssignment.containsKey(neighbor)) {
                    unavailableSlots.add(timeSlotAssignment.get(neighbor));
                }
            }


            int timeSlot = 1;
            while (unavailableSlots.contains(timeSlot)) {
                timeSlot++;
            }
            timeSlotAssignment.put(course, timeSlot);
        }

        return timeSlotAssignment;
    }


    public void printConflictGraph() {
        for (Map.Entry<Course, List<Course>> entry : conflictMap.entrySet()) {
            System.out.println(entry.getKey() + " conflicts with " + entry.getValue());
        }
    }
}

public class SchedulingConflictGraph {
    public static void main(String[] args) {
        ConflictGraph graph = new ConflictGraph();
        Course c1 = new Course("C1", 90);
        Course c2 = new Course("C2", 45);
        Course c3 = new Course("C3", 60);
        Course c4 = new Course("C4", 120);


        graph.addCourse(c1);
        graph.addCourse(c2);
        graph.addCourse(c3);
        graph.addCourse(c4);


        graph.addConflict(c1, c2);
        graph.addConflict(c1, c3);
        graph.addConflict(c2, c4);
        graph.addConflict(c3, c4);


        System.out.println("Conflict Graph:");
        graph.printConflictGraph();


        Map<Course, Integer> timeSlotAssignment = graph.assignTimeSlots();


        System.out.println("\nTime Slot Assignments:");
        for (Map.Entry<Course, Integer> entry : timeSlotAssignment.entrySet()) {
            System.out.println(entry.getKey() + " -> Time Slot " + entry.getValue());
        }
    }
}