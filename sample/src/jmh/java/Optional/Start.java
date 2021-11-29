package Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    private String name;
    private int age;
    private boolean man;

    public Student(String name, int age, boolean man) {
        this.name = name;
        this.age = age;
        this.man = man;
    }


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isMan() {
        return this.man;
    }
}

public class Start {
    public static void main(String[] args) {
        List<Student> students=List.of(
                 new Student("송치윤",25,true),
                 new Student("박채현",22,false),
                 new Student("정우성",32,true),
                 new Student("김태희",38,false),
                 new Student("한지민",40,false)
        );

        List<String> stu=students.stream().map(Student::getName).collect(Collectors.toList());
        boolean girl=students.stream().allMatch(Student::isMan);
        System.out.println(girl);



    }
}
