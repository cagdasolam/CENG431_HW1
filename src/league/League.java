package league;

import user.User;

import java.util.ArrayList;
import java.util.List;

public abstract class League {

	private List<User> userList = new ArrayList<>();

	public League(List<User> userList) {
		this.userList = userList;
	}
}
