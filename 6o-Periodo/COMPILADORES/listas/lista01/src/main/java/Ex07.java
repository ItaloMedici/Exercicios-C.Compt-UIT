public class Ex07 {
    public static boolean evenBautomaton(String toTest) {
        int state = 0;

        int count = 0;
        while (count<toTest.length()) {
            switch (state) {
                case 0:
                    if (toTest.toLowerCase().charAt(count) == 'b') {
                        state = 1;
                    }
                    break;
                case 1:
                    if (toTest.toLowerCase().charAt(count) == 'b') {
                        state = 0;
                    }
                    break;
            }
            count++;
        }

        return state == 0;
    }
}