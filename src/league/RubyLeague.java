package league;

import user.User;

import java.util.List;
import java.util.stream.Collectors;

public class RubyLeague extends League{

	public RubyLeague(String name) {
		super(name);
	}

	@Override
	public List<User> getAdvancedUsers() {
		return this.getUsers();
	}

}
