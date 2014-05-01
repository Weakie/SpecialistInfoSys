package com.weakie.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ReadOnlyMap<K, V> implements Map<K, V> {

	private Map<K,V> map;
	
	public ReadOnlyMap(Map<K,V> instance){
		this.map = instance;
	}
	
	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return this.map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return this.map.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return this.map.get(key);
	}

	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException("com.weakie.util.ReadOnlyMap ��֧��put����");
	}

	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException("com.weakie.util.ReadOnlyMap ��֧��remove����");
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException("com.weakie.util.ReadOnlyMap ��֧��putAll����");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("com.weakie.util.ReadOnlyMap ��֧��clear����");
	}

	@Override
	public Set<K> keySet() {
		return this.map.keySet();
	}

	@Override
	public Collection<V> values() {
		return this.map.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return this.map.entrySet();
	}

}
