public class Main {

    public static void main(String[] args) {

        // Hash Table with Open Adressing
        HashTableOA table1 = new HashTableOA(3);
        
        System.out.println("* Inserting keys and values...");
        table1.insert(0, "A");
        table1.insert(1, "B");
        table1.insert(2, "C");

        System.out.println("\n* Searching for keys...");
        String ans;

        ans = table1.search(0);
        System.out.println(ans);    // A

        ans = table1.search(1);
        System.out.println(ans);    // B

        ans = table1.search(2);
        System.out.println(ans);    // C

        ans = table1.search(3);
        System.out.println(ans);    // Key not found.

        System.out.println("\n* Inserting a value into a key that already exists...");
        table1.insert(0, "D");

        System.out.println("\n* Removing an element...");
        table1.remove(1);
        System.out.println(table1.search(1));

    }
}
