import java.util.ArrayList;
import java.util.List;

public class Lab10 {

    static class Course {
        private String code;
        private String title;
        private int credits;
        private int capacity;
        private int enrolled;

        public Course(String code, String title, int credits, int capacity) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.capacity = capacity;
            this.enrolled = 0;
        }

        public String getCode() { return code; }
        public String getTitle() { return title; }
        public int getCredits() { return credits; }
        public int getCapacity() { return capacity; }
        public int getEnrolled() { return enrolled; }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public boolean isAvailable() {
            return enrolled < capacity;
        }

        public void incrementEnrolled() {
            if (enrolled < capacity) enrolled++;
        }

        public void decrementEnrolled() {
            if (enrolled > 0) enrolled--;
        }

        @Override
        public String toString() {
            return code + " - " + title + " (" + credits + " cr) [" 
                   + enrolled + "/" + capacity + " enrolled]";
        }
    }

    static class Student {
        private String name;
        private String studentId;
        private double gpa;
        private List<Course> courses;

        public Student(String name, String studentId, double gpa) {
            this.name = name;
            this.studentId = studentId;
            this.gpa = gpa;
            this.courses = new ArrayList<>();
        }

        public void enroll(Course course) {
            if (courses.contains(course)) {
                throw new IllegalStateException(name + " is already enrolled in " + course.getCode());
            }
            if (!course.isAvailable()) {
                throw new IllegalArgumentException(course.getCode() + " is full.");
            }

            courses.add(course);
            course.incrementEnrolled();
            System.out.print(name + " successfully enrolled in " + course.getCode());
        }

        public void drop(String courseCode) {
            for (Course c : courses) {
                if (c.getCode().equals(courseCode)) {
                    c.decrementEnrolled();
                    courses.remove(c);
                    System.out.print(name + " dropped " + courseCode);
                    return;
                }
            }
            throw new IllegalArgumentException(name + " is not enrolled in " + courseCode);
        }

        public int getTotalCredits() {
            int total = 0;
            for (Course c : courses) {
                total += c.getCredits();
            }
            return total;
        }

        @Override
        public String toString() {
            return name + " (" + studentId + ") - GPA: " + gpa 
                   + " | Credits: " + getTotalCredits();
        }
    }

    public static void main(String[] args) {
        Course cs101 = new Course("CS101", "Intro to Programming", 4, 30);
        Course math202 = new Course("MATH202", "Calculus II", 4, 25);
        Course bio150 = new Course("BIO150", "Biology Basics", 3, 20);

        Student alice = new Student("Alice Chen", "S1001", 3.85);
        Student bob = new Student("Bob Rodriguez", "S1002", 3.4);
        Student charlie = new Student("Charlie Kim", "S1003", 3.9);

        System.out.print("=== University Course Registration System ===\n");

        alice.enroll(cs101);
        alice.enroll(math202);
        bob.enroll(cs101);
        charlie.enroll(bio150);

        alice.drop("MATH202");

        try {
            bob.enroll(math202);   
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }

        System.out.print("\n=== Final Status ===");
        System.out.print(alice);
        System.out.print(bob);
        System.out.print(charlie);

        System.out.print("\nCourse Summary:");
        System.out.print(cs101);
        System.out.print(math202);
        System.out.print(bio150);
    }
}
