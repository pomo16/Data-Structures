public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i++){
            ll.addR(i);
            System.out.println(i);
            System.out.println(ll.toString());
        }
    }
}
