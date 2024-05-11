public class HashTableData {

    // Fields
    protected int key;
    protected String value;
    protected HashTableData[] table;

    // Constructors
    public HashTableData() {};

    public HashTableData(int key, String value) {
        this.key = key;
        this.value = value;
    }

}