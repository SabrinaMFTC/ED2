// public class HashTableChaining implements HashTable {
//     // Fields
//     private int size;
//     private int[] table;

//     // Constructors
//     public HashTableChaining(int size) {
//         this.size = size;
//         table = new int[size];
//     }

//     // Methods
//     public int hashFunction(int key) {
//         final double a = 0.61803;
//         double hash = size * ((key * a) % 1);
//         return (int) Math.floor(hash) ;
//     }


// }