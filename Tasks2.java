import java.util.Arrays;

public class Tasks2 {
    public static void main(String[] args) {
//        System.out.println(duplicateChars("Barack", "Obama"));

//        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));

//        System.out.println(getInitials("simonov sergei evgenievich"));
//        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));

//        System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1,5, 9.0, 5.5})));
//        System.out.println(Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0})));

//        System.out.println(Arrays.toString(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5})));

//        System.out.println(camelToSnake("helloWorld"));

//        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));

//        System.out.println(localReverse("baobab", 'b'));
//        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));

//        System.out.println(equal(8, 1, 8));
//        System.out.println(equal(5, 5, 5));
//        System.out.println(equal(4, 9, 6));

//        System.out.println(isAnagram("LISTEN", "silent"));
//        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
//        System.out.println(isAnagram("hello", "world"));
    }

    // 1
    public static String duplicateChars(String a, String b) {
        StringBuilder sb = new StringBuilder();
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i = 0; i < a.length(); ++i) {
            char ch = a.charAt(i);
            if (b.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // 2
    public static int dividedByThree(int[] arr) {
        int c = 0;
        for (int i : arr) {
            if (i % 3 == 0) {
                c++;
            }
        }
        return c;
    }

    // 3
    public static String getInitials(String name) {
        String[] strs = name.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(strs[1].toUpperCase().charAt(0)).append('.');
        sb.append(strs[2].toUpperCase().charAt(0)).append('.');
        sb.append(strs[0].toUpperCase().charAt(0)).append(strs[0].substring(1));
        return sb.toString();
    }

    // 4
    public static double[] normalizator(double[] arr) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (double i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        double[] ans = new double[arr.length];
        for (int i = 0; i < ans.length; ++i) {
            if (max != min) {
                ans[i] = (arr[i] - min) / (max - min);
            } else {
                ans[i] = 0.0D;
            }
        }
        return ans;
    }

    // 5
    public static int[] compressedNums(double[] arr) {
        int c = 0;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                c++;
            }
            ans[i] = (int) arr[i];
        }
        Arrays.sort(ans);
        ans = Arrays.copyOfRange(ans, c, ans.length);
        return ans;
    }

    // 6
    public static String camelToSnake(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            if (isBigChar(str.charAt(i))) {
                sb.append("_").append(str.toLowerCase().charAt(i));
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isBigChar(char ch) {
        return (ch > 'A' && ch < 'Z');
    }

    // 7
    public static int secondBiggest(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > max1) {
                max2 = max1;
                max1 = i;
            }
        }
        return max2;
    }

    // 8
    public static String localReverse(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        int lp = 0;
        while (lp != str.length()) {
            if (str.charAt(lp) != ch) {
                sb.append(str.charAt(lp));
            } else {
                int rp = str.indexOf(ch, lp + 1);
                if (rp != -1) {
                    sb.append(new StringBuilder(str.substring(lp, rp + 1)).reverse());
                    lp = rp;
                } else {
                    sb.append(str.charAt(lp));
                }
            }
            lp++;
        }

        return sb.toString();

    }

    // 9
    public static int equal(int a, int b, int c) {
        if (a == b && b == c) return 3;
        if (a == b || b == c || a == c) return 2;
        return 0;
    }

    // 10
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] A = a.toLowerCase().toCharArray();
        char[] B = b.toLowerCase().toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);
        return Arrays.equals(A, B);
    }
}
