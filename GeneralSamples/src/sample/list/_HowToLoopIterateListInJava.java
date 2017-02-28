package sample.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _HowToLoopIterateListInJava {

	public static void main(String[] argv) {

		String sArray[] = new String[] { "Array 1", "Array 2", "Array 3" };

		// convert array to list
		List<String> lList = Arrays.asList(sArray);

		// iterator loop
		System.out.println("#1 iterator");
		Iterator<String> iterator = lList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// for loop
		System.out.println("#2 for");
		for (int i = 0; i < lList.size(); i++) {
			System.out.println(lList.get(i));
		}

		// for loop advance
		System.out.println("#3 for advance");
		for (String temp : lList) {
			System.out.println(temp);
		}

		// while loop
		System.out.println("#4 while");
		int j = 0;
		while (j < lList.size()) {
			System.out.println(lList.get(j));
			j++;
		}
	}
}