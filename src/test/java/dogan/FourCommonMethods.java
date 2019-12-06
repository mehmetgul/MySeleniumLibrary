package dogan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FourCommonMethods {

	public List<String> DataList() {
		List<String> names = new ArrayList<>();
		names.add("A");
		names.add("H");
		names.add("B");
		names.add("C");
		names.add("D");
		names.add("E");
		names.add("F");
		names.add("G");
		return names;
		//System.out.println(names);
	}

	@Test
	public void ClassicForLoop() {
		System.out.println(DataList());

	}

	@Test
	public void ForEachMethod(){

		List<String> data = new ArrayList<>(DataList());
		data.forEach(item-> System.out.println(item));

		}
	@Test
	public void iteratorMethod(){
		Iterator<String> iterator = DataList().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	@Test
	public void forEach(){
		List<String> data = new ArrayList<>(DataList());
		for(String foreachItem : data){
			System.out.println(foreachItem);
		}
	}


}
