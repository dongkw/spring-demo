package xyz.jecy.util.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/25 9:47 上午
 */
public class Lru {

  int capacity;
  Map<Integer, Integer> map;


  public Lru(int capacity) {

    this.capacity = capacity;
    map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return map.size() > capacity;
      }
    };
  }

  public int get(int key) {
    int i = map.getOrDefault(key, -1);
    System.out.println(i);
    return i;
  }

  public void put(int key, int value) {
    map.put(key, value);
    System.out.println("map:");
    map.entrySet().forEach(t -> {
      System.out.println(t.getKey() + ":" + t.getValue());
    });
  }

  public static void main(String[] args) {
    Lru cache = new Lru(2 /* 缓存容量 */);

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4

  }

}
