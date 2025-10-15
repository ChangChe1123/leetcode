package leetcode100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Code {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("abc");
		for(String str : set) {
			continue;
		}
		// iterator
		set.forEach(System.out::println);
	}
	
	public void test_deque() {
		Deque<String> deque = new ArrayDeque<>();
		deque.offerLast("abc");
		deque.peekLast();
		deque.pollLast();
		for(String str : deque) {
			continue;
		}
		// iterator
		deque.forEach(str -> System.out.println(str));
	}
	
	public void test_map() {
		// 创建Map
		Map<String, Integer> map = new HashMap<>();
		// CRUD
		map.put("abc", 123);
		map.putIfAbsent("a", 1);
		System.out.println(map.get("abc"));
		System.out.println(map.getOrDefault("c", 1123));
		// 遍历
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			continue;
		}
		map.forEach((key, value) -> System.out.println(key + value));
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			continue;
		}
	}
	
	public void test_list() {
		// 创建List
		List<String> list1 = Arrays.asList("a", "b", "c");
		List<String> list2 = new ArrayList<>(Arrays.asList("c", "d", "e"));
		List<String> list3 = List.of("cc", "bb");
		// CRUD
		list2.add(0, "0");
		list2.add("1");
		list2.addAll(list3);
		System.out.println(list2);
		list2.remove(0);
		list2.remove("1");
		System.out.println(list2);
		list2.set(1, "b");
		System.out.println(list2.get(1));
		// 遍历
		for (int i = 0; i < list1.size(); i++) {
			continue;
		}
		for (String str : list1) {
			continue;
		}
		Iterator<String> iterator = list1.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			continue;
		}
		list1.forEach(System.out::println);
		// APIs
		List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 3));
		Collections.sort(list);
		Collections.reverse(list);
		list.forEach(System.out::println);

		List<String> str_list = Arrays.asList("ac", "ace", "ace");
		List<String> filtered = str_list.stream().filter(str -> str.length() > 2).map(String::toUpperCase)
				.collect(Collectors.toList());
		filtered.forEach(System.out::print);

		Set<String> set = new HashSet<>(filtered);
		set.forEach(System.out::print);
	}
	
	
}
