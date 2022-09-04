public class Ex08 {
    public static boolean doesntIncludes101(String toTest) {
        toTest = toTest.toLowerCase();
        int count = 0;
        int state = 0;

        while (count<toTest.length()) {

            switch (state) {
                case 0:
                    if (toTest.charAt(count) == '1') state = 1;
                    break;
                case 1:
                case 3:
                    if (toTest.charAt(count) == '0') state = 2;
                    break;
                case 2:
                    if (toTest.charAt(count) == '1') state = 3;
                    break;
            }

            count++;
        }

        return state <= 2;
    }
}
