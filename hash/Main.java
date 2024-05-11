public class Main {

    public static void main(String[] args) {

        // Hash Table with Open Adressing
        int size = 3;
        HashTable table1 = new HashTableOA(size);
        
        System.out.println("* Inserting keys and values...");
        String ans;

        ans = table1.insert(0, "A");
        System.out.println(ans);

        ans = table1.insert(1, "B");
        System.out.println(ans);

        ans = table1.insert(2, "C");
        System.out.println(ans);

        // Trying to insert into a full hash table
        ans = table1.insert(3, "D");
        System.out.println(ans);

        System.out.println("\n* Searching for keys...");

        ans = table1.search(0);
        System.out.println(ans);    // A

        ans = table1.search(1);
        System.out.println(ans);    // B

        ans = table1.search(2);
        System.out.println(ans);    // C

        ans = table1.search(3);
        System.out.println(ans);    // Key not found.

        System.out.println("\n* Inserting a value into a key that already exists...");
        ans = table1.insert(0, "D");
        System.out.println(ans);

        System.out.println("\n* Removing an element...");

        // Removing an element that exists
        table1.remove(1);

        // Removing an element that doesn't exist
        table1.remove(5);

        // Hash Table with Chaining
        HashTable table2 = new HashTableChaining(3);

    }
}
