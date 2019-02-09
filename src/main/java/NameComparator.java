import java.util.Comparator;

class NameComparator implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		
		if( o1%2 == 0 && o2%2 ==0) {
			
			if((Integer)o1>(Integer)o2)
				return 1;
			
		}
		return 0;
	}
}