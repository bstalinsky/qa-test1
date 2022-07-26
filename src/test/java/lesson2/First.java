package lesson2;

import org.junit.Test;

public class First {
    @Test
    public void first() {
        int a = 3;
        int b = 5;
        int c = sum(a,b);
        System.out.println(c);


        c = sum(22,15);
        System.out.println(c);

    }

    private int sum(int a , int b) {
        System.out.println("First digit is: " + a + " and Second is : " + b);
        int c = a + b;
        return c;

    }
    @Test
    public void usingObjects() {
        Student jack = new Student();
        jack.setFirstName("Mikhail");
        jack.setLastName("jas");
        jack.setAge(18);
        jack.setPersonalCode("123231q");


        Student mike = new Student();
        mike.setFirstName("Gang");
        mike.setLastName("Bang");
        mike.setAge(23);
        mike.setPersonalCode("123231q-1231");


        System.out.println(jack.getFirstName() + " " +jack.getLastName());


    }

}
