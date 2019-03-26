public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i++){
            ll.addLastR(i);
        }
        System.out.println(ll.toString());
        System.out.println(ll.containsR(33));
    }
}
