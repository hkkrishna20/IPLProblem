import java.util.Arrays;
import java.util.Comparator;

public class MultiThreadExample {
	public static void main(String[] args) {
		/*
		 * for (int i = 0; i < 8; i++) { MutiThread mc = new MutiThread(); mc.start(); }
		 * ArrayList<Integer> al = new ArrayList<Integer>(); al.add(205); al.add(102);
		 * al.add(98); al.add(275); al.add(203);
		 * System.out.println("Elements of the ArrayList " + "before sorting : " + al);
		 * 
		 * // using lambda expression in place of comparator object Collections.sort(al,
		 * (o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
		 * 
		 * System.out.println("Elements of the ArrayList after" + " sorting : " + al);
		 * 
		 * TreeSet<Integer> h = new TreeSet<Integer>((o1, o2) -> (o1 > o2) ? -1 : (o1 <
		 * o2) ? 1 : 0); h.add(850); h.add(235); h.add(1080); h.add(15); h.add(5);
		 * System.out.println("Elements of the TreeSet after" + " sorting are: " + h);
		 * 
		 * TreeMap<Integer, String> m = new TreeMap<Integer, String>((o1, o2) -> (o1 >
		 * o2) ? -1 : (o1 < o2) ? 1 : 0); m.put(1, "Apple"); m.put(4, "Mango"); m.put(5,
		 * "Orange"); m.put(2, "Banana"); m.put(3, "Grapes");
		 * System.out.println("Elements of the TreeMap " + "after sorting are : " + m);
		 */

		Integer[] arr = { 1, 4, 5, 2, 7, 8, 343, 13, 22, 12, 122, 14, 15, 17 };
		int oddCount = 0;
		int index = 0;
		System.out.println("Initital array");
		System.out.println(Arrays.asList(arr).toString());
		for (int i : arr) {
			if (i % 2 != 0 && oddCount != index) {
				int t = arr[oddCount + 1];
				arr[oddCount + 1] = i;
				arr[index] = t;
				oddCount++;
			}
			index++;
		}

		System.out.println("After Odd Shuffling");
		System.out.println(Arrays.asList(arr).toString());
		/*
		 * index = 0; evenCount = oddCount + 1; for (int i : arr) { if (i % 2 == 0 &&
		 * evenCount != index) { int t = arr[evenCount + 1]; arr[evenCount + 1] = i;
		 * arr[index] = t; evenCount++; } index++; }
		 */
		for (int i = 0; i <= oddCount; i++) {
			for (int j = i; j <= oddCount; j++) {
				if (arr[i] > arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}

			}
		}
		for (int i = oddCount + 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}

			}
		}
		System.out.println("After Even and odd sort");
		System.out.println(Arrays.asList(arr).toString());

		Integer[] arr1 = { 1, 4, 5, 2, 7, 8, 343, 13, 22, 12, 122, 14, 15, 17 };
		Arrays.sort(arr1, new NameComparator2());
		System.out.println(Arrays.asList(arr1).toString());
		Arrays.sort(arr1, new NameComparator());
		System.out.println(Arrays.asList(arr1).toString());
		
	}

	public static boolean isStringOnlyAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.chars().allMatch(Character::isLetter)));
	}
}
