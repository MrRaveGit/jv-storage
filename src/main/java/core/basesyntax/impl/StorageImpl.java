package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private Object [] keys;
    private Object [] values;
    private int count;

    public StorageImpl() {
        this.keys = new Object[MAX_CAPACITY];
        this.values = new Object[MAX_CAPACITY];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int indexPut = 0; indexPut < count; indexPut++) {
            if (java.util.Objects.equals(keys[indexPut], key)) {
                values[indexPut] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int indexGet = 0; indexGet < count; indexGet++) {
            if (key == null && keys[indexGet] == null
                    || (key != null && key.equals(keys[indexGet]))) {
                return (V) values[indexGet];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
