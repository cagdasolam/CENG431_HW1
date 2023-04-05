package language;

import league.BronzeLeague;
import league.GoldLeague;
import league.League;
import league.RubyLeague;
import league.SapphireLeague;
import league.SilverLeague;
import unit.Unit;
import user.User;

import java.util.List;

public class Language {

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

	public void addUserToLeague(User user, String leagueName){

	}
}

