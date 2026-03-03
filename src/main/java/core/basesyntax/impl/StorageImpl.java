package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int arrayLength = 10;

    private Object [] keys = new Object[arrayLength];
    private Object [] values = new Object[arrayLength];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (java.util.Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int x = 0; x < count; x++) {
            if (java.util.Objects.equals(keys[x], key)) {
                return (V) values[x];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
