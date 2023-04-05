package language;

import unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Language {

	private String languageName;

	List<Unit> units = new ArrayList<>();

	public Language(String languageName, List<Unit> units) {
		this.languageName = languageName;
		this.units = units;
	}
}

