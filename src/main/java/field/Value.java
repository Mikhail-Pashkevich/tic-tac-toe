package field;

import lombok.Getter;

@Getter
public enum Value {
    VALUE_X("X"),
    VALUE_O("O"),
    VALUE_EMPTY(" ");

    private final String value;

    Value(String value) {
        this.value = value;
    }
}