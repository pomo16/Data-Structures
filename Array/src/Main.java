public class Main {

    public static void main(String[] args) {
	    Array<String> arr = new Array<>();
	    for(int i = 0 ; i < 5 ; i ++) {
	        arr.addLast("h");
        }
		for(int i = 0 ; i < 5 ; i ++) {
			arr.addLast("hhh");
		}

		System.out.println(arr.toString());

		// System.out.println(arr.findAll("h"));
    }
}
