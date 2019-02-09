package com.fragmadata.IplProblem.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "matchId", "season", "city", "date", "team1", "team2", "tossWinner", "tossDecision", "result",
		"winner" })
public class Matches {
	@JsonProperty("matchId")
	private String matchId;
	@JsonProperty("season")
	private String season;
	@JsonProperty("city")
	private String city;
	@JsonProperty("date")
	private String date;
	@JsonProperty("team1")
	private String team1;
	@JsonProperty("team2")
	private String team2;
	@JsonProperty("tossWinner")
	private String tossWinner;
	@JsonProperty("tossDecision")
	private String tossDecision;
	@JsonProperty("result")
	private String result;
	@JsonProperty("winner")
	private String winner;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("matchId")
	public String getMatchId() {
		return matchId;
	}

	@JsonProperty("season")
	public String getSeason() {
		return season;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("team1")
	public String getTeam1() {
		return team1;
	}

	@JsonProperty("team2")
	public String getTeam2() {
		return team2;
	}

	@JsonProperty("tossWinner")
	public String getTossWinner() {
		return tossWinner;
	}

	@JsonProperty("tossDecision")
	public String getTossDecision() {
		return tossDecision;
	}

	@JsonProperty("result")
	public String getResult() {
		return result;
	}

	@JsonProperty("winner")
	public String getWinner() {
		return winner;
	}

	@JsonProperty("winner")
	public void setWinner(String winner) {
		this.winner = winner;
	}

	@JsonProperty("result")
	public void setResult(String result) {
		this.result = result;
	}

	@JsonProperty("tossDecision")
	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}

	@JsonProperty("tossWinner")
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}

	@JsonProperty("team1")
	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("matchId")
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	@JsonProperty("season")
	public void setSeason(String season) {
		this.season = season;
	}

	@JsonProperty("team2")
	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@Override
	public String toString() {
		return "Matches [matchId=" + matchId + ", season=" + season + ", city=" + city + ", date=" + date + ", team1="
				+ team1 + ", team2=" + team2 + ", tossWinner=" + tossWinner + ", tossDecision=" + tossDecision
				+ ", result=" + result + ", winner=" + winner + "]";
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}