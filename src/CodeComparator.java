package src;

import java.util.Arrays;
import java.util.Comparator;

public class CodeComparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

    }

    /**
     * 如果按照升序排序. o1 小于 o2 返回负数. o1 等于 o2 返回0. o1 大于 o2 返回正数
     * JAVA中默认升序
     */
    public static class IdAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    /**
     * 如果按照降序排序. o1 小于 o2 返回正数. o1 等于 o2 返回0. o1 大于 o2 返回负数
     */
    public static class IdDescendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void printStudent(Student[] students) {
        for (Student student : students) {
            System.out.println("序号:" + student.id + "\t姓名:" + student.name + "\t年龄:" + student.age);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alina", 3, 22);
        Student student2 = new Student("Alinayxl", 1, 22);
        Student student3 = new Student("Alina丢丢", 2, 22);

        Student[] students = new Student[]{student1, student2, student3};
        printStudent(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudent(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudent(students);
    }

}

