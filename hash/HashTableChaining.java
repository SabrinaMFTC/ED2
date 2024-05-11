public class HashTableChaining extends HashTableData implements HashTable {

    // Fields
    private int size;

    // Constructors
    public HashTableChaining(int size) {
        table = new HashTableData[size];
        this.size = size;
    }

    // Methods
    public int hashFunction(int key) {
        final double a = 0.61803;
        double hash = size * ((key * a) % 1);
        return (int) Math.floor(hash);
    }

    @Override
    public String search(int key) {

    }

    @Override
    public String insert(int key, String value) {

    }

    @Override
    public Boolean remove(int key) {

    }

}
