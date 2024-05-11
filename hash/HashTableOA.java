public class HashTableOA extends HashTableData implements HashTable {

    // Fields
    private int size;

    // Constructors
    public HashTableOA(int size) {
        table = new HashTableData[size];
        this.size = size;
    }

    // Methods
    public int hashFunction(int key) {
        return key % size;
    }

    @Override
    public String search(int key) {
        int hashKey = hashFunction(key);
        int originalHashKey = hashKey;

        while (table[hashKey] != null) {
            // If we found the key we are looking for, return its value
            if (table[hashKey].key == key) {
                return "Key " + key + " found. Value = " + table[hashKey].value;
            }

            // Otherwise, keep searching for the key using linear probing
            hashKey = (hashKey + 1) % size;

            // If we have already traversed the entire array of the hash table and did not find the key, break
            if (hashKey == originalHashKey) break;
        }

        return "Key " + key + " not found.";
    }

    @Override
    public void insert(int key, String value) {
        int hashKey = hashFunction(key);
        int originalHashKey = hashKey;

        while (table[hashKey] != null) {
            // If we found the key we are trying to insert, update its value and return
            if (table[hashKey].key == key) {
                String oldValue = table[hashKey].value;
                table[hashKey].value = value;
                System.out.println("Key " + key + " found and its value updated from " + oldValue + " to " + value + ".");
                return;
            }

            // Otherwise, keep searching for a free slot using linear probing
            hashKey = (hashKey + 1) % size;

            // If we have already traversed the entire array of the hash table and did not find a free slot, return
            if (hashKey == originalHashKey) {
                System.out.println("Element {" + key + ": " + value + "} could not be inserted.");
                return;
            }
        }

        // If we fond a free slot in the hash table, insert the element
        table[hashKey] = new HashTableData(key, value);
        System.out.println("Element {" + key + ": " + value + "} successfully inserted.");
        return;
    }

    @Override
    public void remove(int key) {
        int hashKey = hashFunction(key);
        int originalHashKey = hashKey;

        while (table[hashKey] != null) {
            // If we found the key we are trying to remove, remove it and return
            if (table[hashKey].key == key) {
                table[hashKey] = null;
                System.out.println("Key " + key + " successfully removed.");
                return;
            }

            // Otherwise, keep searching for the key using linear probing
            hashKey = (hashKey + 1) % size;

            // If we have already traversed the entire array of the hash table and did not find the key to be removed, return
            if (hashKey == originalHashKey) {
                System.out.println("Key " + key + " not found.");
                return;
            }
        }
    }

}
