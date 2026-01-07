class Student {

    int rollNo;
    String name;


    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }


    public static void main(String[] args) {

        Student s1 = new Student();


        s1.rollNo = 50;
        s1.name = "Gautam";


        s1.display();
    }
}