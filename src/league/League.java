package league;

import user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class League {

	private String name;
	private List<User> users;

	public League(String name) {
		this.name = name;
		this.users = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public abstract List<User> getAdvancedUsers();

	public List<User> getTopThreeUsers(){
		return users.stream()
				.sorted(Comparator.comparing(User::getTotalPoints).reversed())
				.limit(3).toList();
	}


}
