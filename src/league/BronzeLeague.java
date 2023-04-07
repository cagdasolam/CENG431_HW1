package league;

import user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BronzeLeague extends League{

	public BronzeLeague(String name) {
		super(name);
	}

	@Override
	public List<User> getAdvancedUsers() {
		this.getUsers().sort((user1, user2) -> user2.getTotalPoints() - user1.getTotalPoints());
		return this.getUsers().subList(0, Math.min(this.getUsers().size(), 15));
	}

}
