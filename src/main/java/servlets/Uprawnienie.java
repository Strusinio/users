package servlets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Uprawnienie {
	NORMALNY, PREMUIM, ADMIN;

	private static Set<Uprawnienie> dostepDoPremium = new HashSet<>(Arrays.asList(PREMUIM, ADMIN));

	public boolean dostepDoPremium() {
		return dostepDoPremium.contains(this);
	}

}
