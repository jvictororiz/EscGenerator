package rest.entitie;

public class TypeValue {
    public static final String TIPO_TEXT = "TIPO_TEXT";
    public static final String TIPO_TABLE = "TIPO_TABLE";

    private String key;
    private String value;

    public TypeValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public TypeValue(String value) {
        this.key = TIPO_TABLE;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
