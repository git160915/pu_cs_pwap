public class HelloWorld {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        if (args.length > 0) {
            System.out.println("It's nice to meet you, " + args[0] + "!");
        }
    }
}