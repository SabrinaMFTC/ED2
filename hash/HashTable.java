public interface HashTable {
    // Methods

    // Search: A busca deve ser feita pela chave e deve retornar o valor associado à chave, se existir
    String search(int key);

    // Insert: A inserção deve retornar um de três resultados, sendo que os resultados indicam "chave-valor inserido", "valor da chave atualizado" ou "erro ao inserir chave-valor"
    void insert(int key, String value);

    // Remove: A remoção deve ser feita pela chave e deve retornar true se foi possível remover a chave-valor ou false caso contrário.
    void remove(int key);

}