package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
	private static final int maxLengthOfName = 5;

	public static void validateCarNames(String[] carNames) {
		for (String name : carNames) {
			if (isNotValidName(name)) {
				throw new IllegalArgumentException("공백만 입력 할 수 없습니다.");
			}
			if (!isValidLengthOfName(name)) {
				throw new IllegalArgumentException("5글자 이하로만 입력가능합니다.");
			}
		}
		if (containDuplicatedName(carNames)){
			throw new IllegalArgumentException("중복된 이름입력이 불가합니다.");
		}
	}

	private static boolean isValidLengthOfName(String name) {
		return name.length() <= maxLengthOfName;
	}

	private static boolean containDuplicatedName(String[] names) {
		Set<String> nameSet = new HashSet<>(Arrays.asList(names));
		return nameSet.size() != names.length;
	}

	private static boolean isNotValidName(String name) {
		String trimedName = TrimName.removeAllBlankInName(name);
		return trimedName.equals("");
	}
}
