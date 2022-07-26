import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Looops {
    @Test
    public void loopsLesson(){

        List<String> studentNames = new ArrayList<>();
        System.out.println(studentNames.isEmpty());

        studentNames.add("Nick");
        studentNames.add("Anna");
        studentNames.add("Mike");
        studentNames.add("Jack");
        studentNames.add("Jackie");
        studentNames.add("Anton");
        studentNames.add("John");
        studentNames.add("Jonna");

//        System.out.println(studentNames.get(1));
//        System.out.println(studentNames.size());
//        System.out.println(studentNames.isEmpty());
//
//        //------------------FOR--------------------
//        for (int i = 0; i < studentNames.size(); i = i + 1) {   // i = i + 1 -> i++
//            System.out.println(studentNames.get(i));
//        }
//
//        //-----------------FOREACH-----------------
//        for (String name : studentNames){
//            System.out.println(name);
//
//        }
        //------------------IF-ELSE------------------
        for (String name : studentNames){
            if (name.startsWith("J")){
                System.out.println(name + " This name start with J® ");
            } else {
                System.out.println(name + " This name doesn't start with J");
            }
        }




    }
}
