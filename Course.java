public class Course {

    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        students = new String[10];
        numberOfStudents = 0;
    }

    // Get course name
    public String getCourseName() {
        return courseName;
    }

    // Add a student
    public void addStudent(String student) {

        // If array is full, create a larger array
        if (numberOfStudents >= students.length) {

            String[] newStudents = new String[students.length * 2];

            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }

            students = newStudents;
        }

        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    // Drop a student
    public void dropStudent(String student) {

        for (int i = 0; i < numberOfStudents; i++) {

            if (students[i].equals(student)) {

                // Move the remaining students one position left
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[numberOfStudents - 1] = null;
                numberOfStudents--;

                break;
            }
        }
    }

    // Get students
    public String[] getStudents() {
        return students;
    }

    // Get number of students
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    // Main Test
    public static void main(String[] args) {

        Course course = new Course("Java Programming");

        // Add students
        course.addStudent("Sabrina");
        course.addStudent("Ahmed");
        course.addStudent("Mohamed");
        course.addStudent("Amina");

        System.out.println("Course Name: " + course.getCourseName());

        System.out.println("Number of Students: "
                + course.getNumberOfStudents());

        System.out.println("\nStudents:");

        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println(course.getStudents()[i]);
        }

        // Drop a student
        course.dropStudent("Ahmed");

        System.out.println("\nAfter dropping Ahmed:");

        System.out.println("Number of Students: "
                + course.getNumberOfStudents());

        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println(course.getStudents()[i]);
        }
    }
}