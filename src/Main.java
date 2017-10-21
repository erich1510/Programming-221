//Eric Huang
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //test cases
        int one[] = {3, 2, 5};
        int two[] = {1, 4, 6};
        int three[] = {1, 2, 3};
        int four[] = {2, 6, 8, 3, 1};
        int five[] = {5, 4};
        int six[] = {-2, -1, 0};
        int blank[] = {};
        int n[] = null;

        int DJTrueA[] = {1, 2, 3, 4};
        int DJTrueB[] = {5, 6, 7};
        int DJTrueC[] = {9, 10};

        int DJFalseA[] = {1, 2, 3, 4};
        int DJFalseB[] = {4, 6, 7};
        int DJFalseC[] = {1, 2, 3, 4, 5, 6, 7};

        int repeatA[] = {1, 2, 2, 4};
        int repeatB[] = {3, 3, 3, 3, 3};
        int repeatC[] = {5, 2, 3, 5};

        String notAnagramA = "anagram";
        String notAnagramB = "anaGaram";

        String repeatingCharsATrue = "racecar";
        String repeatingCharsBTrue = "racecar";
        String repeatingCharsAFalse = "racecars";
        String repeatingCharsBFalse = "racecar";

        String duplicateA = "hellohello";
        String duplicateB = "olollehleh";
        String duplicateC = "llolleheho1";

        String capsA = "Hello";
        String capsB = "Olleh";
        String capsC = "heLLo";

        String specialA = "Hello!?!?!?";
        String specialB = "HELLO?!?!?!";
        String specialC = "Olleh!?!?!?!";



        System.out.println("DisJoint Testing");
        System.out.println(DisJoint(one, two));
        System.out.println(DisJoint(one, three));
        System.out.println(DisJoint(one, two));
        System.out.println(DisJoint(six, four));
        System.out.println(DisJoint(four, five));
        System.out.println(DisJoint(blank, two));
        System.out.println(DisJoint(blank, blank));
        System.out.println("Testing Basic Cases that should be False");
        System.out.println(DisJoint(DJFalseA, DJFalseB));
        System.out.println(DisJoint(DJFalseA, DJFalseC));
        System.out.println(DisJoint(DJFalseB, DJFalseC));
        System.out.println("Testing Basic Cases that should be True");
        System.out.println(DisJoint(DJTrueA, DJTrueB));
        System.out.println(DisJoint(DJTrueA, DJTrueC));
        System.out.println(DisJoint(DJTrueB, DJTrueC));
        System.out.println("Testing Cases of Repeat Numbers");
        System.out.println(DisJoint(DJTrueA, DJTrueB));
        System.out.println(DisJoint(DJTrueA, DJTrueC));
        System.out.println(DisJoint(DJTrueB, DJTrueC));
        //System.out.println(DisJoint(null, DJTrueA));

        System.out.println(" \n\nAnagram Testing");
        System.out.println("Testing for cases where there are repeating characters in anagram");
        System.out.println(anagram(repeatingCharsATrue, repeatingCharsBTrue));
        System.out.println(!anagram(repeatingCharsAFalse, repeatingCharsBFalse));

        System.out.println("Testing basic false cases");
        System.out.println(anagram(notAnagramA, notAnagramB));

        System.out.println("Testing duplciate cases");
        System.out.println(anagram(duplicateA, duplicateB));
        System.out.println(!anagram(duplicateB, duplicateC));
        System.out.println(!anagram(duplicateA, duplicateC));

        System.out.println("Testing for cases where there are different capitalizations");
        System.out.println(anagram(capsA, capsB));
        System.out.println(anagram(capsB, capsC));
        System.out.println(anagram(capsA, capsC));

        System.out.println("Testing cases of special characters and numbers");
        System.out.println(anagram(specialA, specialB));
        System.out.println(!anagram(specialB, specialC));
        System.out.println(!anagram(specialA, specialC));
        System.out.println(!anagram(specialA, "1235"));
        System.out.println("Special cases");
        System.out.println(anagram(null, specialB));
        System.out.println(anagram(null, null));
    }


    public static boolean DisJoint(int[] a, int[] b) {
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < b.length ; j++) {
                if (a[i] == b[j])
                    return false;
            }
        }
        return true;
    }

    public static boolean anagram(String s, String a) {
        s = s.toLowerCase(); //convert to arrays, lowercase
        char[] sArray = s.toCharArray();
        a = a.toLowerCase();
        char[] aArray = a.toCharArray();

        Arrays.sort(sArray); //sort and match
        Arrays.sort(aArray);

        if (sArray.length != aArray.length)
        return false;
        else
            for (int i = 0; i < sArray.length; i++)  //loop through each character
                    if (sArray[i] != aArray[i])
                        return false; //if element doesn't match

        return true; //if all array elements match
}
}

