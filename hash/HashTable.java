public interface HashTable {
    // Methods signatures

    // The search must be done by the key and should return the associated value of the key, if it exists.
    String search(int key);

    // The insertion should return one of three results, which indicate "key-value inserted", "value of the key updated", or "error inserting key-value".
    String insert(int key, String value);

    // The removal must be done by the key and should return true if it was possible to remove the key-value pair or false otherwise.
    Boolean remove(int key);

}
