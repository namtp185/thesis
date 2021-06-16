package frsl.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import frsl.metamodel.NavigableStep;
import frsl.metamodel.UseCaseV2;

public class ExtractorUtil {
	public static List<NavigableStep> gatherStep(UseCaseV2 usecase, String start, String end) {
		List<NavigableStep> steps = new ArrayList<>();

		if (isGreaterThan(start, end)) {
			// swap start and end
			String swap = start;
			start = end;
			end = swap;
		}

		int startIdx = Integer.parseInt(start);

		if (end == null)
			return steps;

		int endIdx = Integer.parseInt(end);

		for (int i = startIdx; i < endIdx; i++) {
			steps.add(usecase.getStep(String.valueOf(i)));
		}

		return steps;
	}

	// assume end is greater than start when end is null
	private static boolean isGreaterThan(String string1, String string2) {
		if (StringUtils.isNumeric(string1) && StringUtils.isNumeric(string2)) {
			int index1 = Integer.parseInt(string1);
			int index2 = Integer.parseInt(string2);
			return index1 > index2;
		} else {
			return false;
		}
	}
}
