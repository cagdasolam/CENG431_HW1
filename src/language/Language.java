package language;

import league.BronzeLeague;
import league.GoldLeague;
import league.League;
import league.RubyLeague;
import league.SapphireLeague;
import league.SilverLeague;
import quiz.Quiz;
import unit.Unit;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Language implements ILanguage {

	private String languageName;

	private List<Unit> units;

	private League bronzeLeague;
	private League silverLeague;
	private League goldLeague;
	private League sapphireLeague;
	private League rubyLeague;

	public Language(String languageName, List<Unit> units) {
		this.languageName = languageName;
		this.units = units;
		this.bronzeLeague = new BronzeLeague("Bronze");
		this.silverLeague = new SilverLeague("Silver");
		this.goldLeague =  new GoldLeague("Gold");
		this.sapphireLeague = new SapphireLeague("Sapphire");
		this.rubyLeague = new RubyLeague("Ruby");
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public League getBronzeLeague() {
		return bronzeLeague;
	}

	public void setBronzeLeague(League bronzeLeague) {
		this.bronzeLeague = bronzeLeague;
	}

	public League getSilverLeague() {
		return silverLeague;
	}

	public void setSilverLeague(League silverLeague) {
		this.silverLeague = silverLeague;
	}

	public League getGoldLeague() {
		return goldLeague;
	}

	public void setGoldLeague(League goldLeague) {
		this.goldLeague = goldLeague;
	}

	public League getSapphireLeague() {
		return sapphireLeague;
	}

	public void setSapphireLeague(League sapphireLeague) {
		this.sapphireLeague = sapphireLeague;
	}

	public League getRubyLeague() {
		return rubyLeague;
	}

	public void setRubyLeague(League rubyLeague) {
		this.rubyLeague = rubyLeague;
	}


	@Override
	public int getTotalUnit() {
		return this.units.size();
	}

	@Override
	public int getTotalQuizzes() {
		return this.units.stream()
				.mapToInt(unit -> unit.getQuizzes().size())
				.sum();
	}

	public List<League> getAllLeagues(){
		return Stream.of(this.bronzeLeague, this.silverLeague, this.goldLeague, this.sapphireLeague, this.rubyLeague).toList();
	}

	public Unit findUnitOfQuiz(int qNumber){
		AtomicInteger totalQuiz = new AtomicInteger();
		return this.units.stream()
				.filter(unit -> {
					int unitQuizSize = unit.getQuizzes().size();
					totalQuiz.addAndGet(unitQuizSize);
					return totalQuiz.get() >= qNumber;
				})
				.findFirst()
				.orElse(this.units.get(this.units.size() - 1));
	}

	public Quiz findLastQuiz(int qNumber) {
		List<Quiz> allQuizzes = this.units.stream()
				.flatMap(unit -> unit.getQuizzes().stream()).toList();

		if (allQuizzes.isEmpty()) {
			return null;
		}

		int lastQuizNumber = Math.min(qNumber, allQuizzes.size());
		return allQuizzes.get(allQuizzes.size() - lastQuizNumber);
	}

	@Override
	public List<User> getAllUsers(){
		return Stream.of(this.bronzeLeague, this.silverLeague, this.goldLeague, this.sapphireLeague, this.rubyLeague)
				.flatMap(league -> league.getUsers().stream()).toList();
	}

	@Override
	public String toString() {
		return "Language{" +
				"languageName='" + languageName + '\'' +
				", units=" + units +
				", bronzeLeague=" + bronzeLeague +
				", silverLeague=" + silverLeague +
				", goldLeague=" + goldLeague +
				", sapphireLeague=" + sapphireLeague +
				", rubyLeague=" + rubyLeague +
				'}';
	}
}

