package league;

import user.User;

import java.util.List;

public class SilverLeague extends League{

	public SilverLeague(String name) {
		super(name);
	}

	@Override
	public List<User> getAdvancedUsers() {
		this.getUsers().sort((user1, user2) -> user2.getTotalPoints() - user1.getTotalPoints());
		return this.getUsers().subList(0, Math.min(this.getUsers().size(), 10));
	}

}
