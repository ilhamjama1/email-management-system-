package emailapp;

public class Emailapp {
    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");
        em1.setAlternateEmail("js@gmail.com");
        System.out.println(em1.showInfo());
    }
}
