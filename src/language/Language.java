package language;

import unit.Unit;

import java.util.ArrayList;
import java.util.List;

public abstract class Language {

	List<Unit> units = new ArrayList<>();

	public Language(List<Unit> units) {
		this.units = units;
	}
}

