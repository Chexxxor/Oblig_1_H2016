package task3;

public class ListOperations<E extends Comparable<E>>{

	public static <E extends Comparable<E>> E min(E[] list){
		if(list == null)
			throw new IllegalArgumentException("Array is null");
		if(list.length == 0)
			throw new IllegalArgumentException("Zero length array");
		E ret = list[0];
		for(int i = 1; i < list.length; i++){
			if(ret == null || list[i] != null && ret.compareTo(list[i]) > 0)
				ret = list[i];
		}
		return ret;
	}

	public static <E extends Comparable<E>> E max(E[] list){
		if(list == null)
			throw new IllegalArgumentException("Array is null");
		if(list.length == 0)
			throw new IllegalArgumentException("Zero length array");
		E ret = list[0];
		for(int i = 1; i < list.length; i++){
			if(ret == null || list[i] != null && ret.compareTo(list[i]) > 0)
				ret = list[i];
		}
		return ret;
	}
}
