package validation;

public class Validator {
    public static boolean isBelongs(int begin, int end, int value) {
        return begin <= value && value < end;
    }
}