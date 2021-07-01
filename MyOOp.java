class Print {
    static String delimiter = "";
    static void A() {
        System.out.println(delimiter);
        System.out.println("A");
        System.out.println("A");
    }

    static void B() {
        System.out.println(delimiter);
        System.out.println("B");
        System.out.println("B");
    }
}

class MyOOP {

    public static void main(String[] args) {
        Print.delimiter = "-----";
        Print.A();
        Print.A();
        Print.B();
        Print.B();

        Print.delimiter = "*****";
        Print.A();
        Print.A();
        Print.B();
        Print.B();
    }
}