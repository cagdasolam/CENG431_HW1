package league;

import user.User;

import java.util.List;
import java.util.stream.Collectors;

public class SapphireLeague extends League{

	public SapphireLeague(String name) {
		super(name);
	}



	@Override
	public List<User> getAdvancedUsers() {
		return this.getUsers().stream()
				.filter(user -> (user.getStreak() >= 30 && user.getTotalPoints() > 5000)
						|| user.getCurrentUnit().getUnitNumber() >= 10)
				.collect(Collectors.toList());
	}

}
