package milestone.cst135n;

import java.util.Comparator;

public class ComparatorName implements Comparator<BaseContact> {

	@Override
	public int compare(BaseContact o1, BaseContact o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
