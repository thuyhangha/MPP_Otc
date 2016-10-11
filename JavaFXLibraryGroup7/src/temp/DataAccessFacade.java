package temp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataAccessFacade<K, V> implements DataAccess<K, V> {
	private Map<K, V> dataMap = new HashMap<K, V>();

	@Override
	public V add(K key, V value) {
		return dataMap.put(key, value);
	}

	@Override
	public V update(K key, V value) {
		return dataMap.put(key, value);
	}

	@Override
	public V get(K key) {
		return dataMap.get(key);
	}

	@Override
	public V delete(K key) {
		return dataMap.remove(key);	
	}

	@Override
	public Map<K, V> getDataMap(){
		return dataMap;
	}

	@Override
	public Collection<V> getList() {
		return dataMap.values();
	}
}
