package league;

import user.User;

import java.util.List;
import java.util.stream.Collectors;

public class GoldLeague extends League{

	public GoldLeague(String name) {
		super(name);
	}

	@Override
	public List<User> getAdvancedUsers() {
		this.getUsers().sort((user1, user2) -> user2.getTotalPoints() - user1.getTotalPoints());
		return this.getUsers().subList(0, Math.min(this.getUsers().size(), 5))
				.stream().filter(user -> user.getStreak() >= 7).toList();
	}

}
