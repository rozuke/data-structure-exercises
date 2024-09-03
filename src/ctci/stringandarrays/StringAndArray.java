package ctci.stringandarrays;

public class StringAndArray {


    public String URLify(String input) {

        StringBuilder st = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                if (i != 0 && input.charAt(i - 1) != ' ') {
                    st.append("&20");
                }
            } else {
                st.append(input.charAt(i));
            }
        }
        return st.substring(0, st.length() - 2);
    }

    public static void main(String[] args) {

        StringAndArray test = new StringAndArray();

        String  st = "Mr John COmo vas estal              20 ";
        System.out.println(test.URLify(st));


    }

}
