import java.util.Iterator;

public abstract class AbstractMap<K,V> implements Map<K,V> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;

        public MapEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public void setK(K key) {
            k = key;
        }

        public V setV(V value) {
            V old = v;
            v = value;
            return old;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V> {
        @Override
        public Iterator<V> iterator() {
            return new ValueIterator( );
        }
    }
    public Iterable<V> values( ) { return new ValueIterable( ); }
}
