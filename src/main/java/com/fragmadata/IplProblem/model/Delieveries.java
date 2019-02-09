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
@JsonPropertyOrder({ "matchId", "inning", "battingTeam", "bowlingTeam", "over", "ball", "batsman", "bowler", "wideRuns",
		"byeRuns", "legbyeRuns", "noballRuns", "penaltyRuns", "batsmanRuns", "extraRuns", "totalRuns" })
public class Delieveries {

	@JsonProperty("matchId")
	private String matchId;
	@JsonProperty("inning")
	private String inning;
	@JsonProperty("battingTeam")
	private String battingTeam;
	@JsonProperty("bowlingTeam")
	private String bowlingTeam;

	@Override
	public String toString() {
		return "Delieveries [matchId=" + matchId + ", inning=" + inning + ", battingTeam=" + battingTeam
				+ ", bowlingTeam=" + bowlingTeam + ", over=" + over + ", ball=" + ball + ", batsman=" + batsman
				+ ", bowler=" + bowler + ", wideRuns=" + wideRuns + ", byeRuns=" + byeRuns + ", legbyeRuns="
				+ legbyeRuns + ", noballRuns=" + noballRuns + ", penaltyRuns=" + penaltyRuns + ", batsmanRuns="
				+ batsmanRuns + ", extraRuns=" + extraRuns + ", totalRuns=" + totalRuns + "]";
	}

	@JsonProperty("over")
	private String over;
	@JsonProperty("ball")
	private String ball;
	@JsonProperty("batsman")
	private String batsman;
	@JsonProperty("bowler")
	private String bowler;
	@JsonProperty("wideRuns")
	private String wideRuns;
	@JsonProperty("byeRuns")
	private String byeRuns;
	@JsonProperty("legbyeRuns")
	private String legbyeRuns;
	@JsonProperty("noballRuns")
	private String noballRuns;
	@JsonProperty("penaltyRuns")
	private String penaltyRuns;
	@JsonProperty("batsmanRuns")
	private String batsmanRuns;
	@JsonProperty("extraRuns")
	private String extraRuns;
	@JsonProperty("totalRuns")
	private String totalRuns;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("matchId")
	public String getMatchId() {
		return matchId;
	}

	@JsonProperty("inning")
	public String getInning() {
		return inning;
	}

	@JsonProperty("battingTeam")
	public String getBattingTeam() {
		return battingTeam;
	}

	@JsonProperty("bowlingTeam")
	public String getBowlingTeam() {
		return bowlingTeam;
	}

	@JsonProperty("over")
	public String getOver() {
		return over;
	}

	@JsonProperty("ball")
	public String getBall() {
		return ball;
	}

	@JsonProperty("batsman")
	public String getBatsman() {
		return batsman;
	}

	@JsonProperty("bowler")
	public String getBowler() {
		return bowler;
	}

	@JsonProperty("wideRuns")
	public String getWideRuns() {
		return wideRuns;
	}

	@JsonProperty("byeRuns")
	public String getByeRuns() {
		return byeRuns;
	}

	@JsonProperty("legbyeRuns")
	public String getLegbyeRuns() {
		return legbyeRuns;
	}

	@JsonProperty("noballRuns")
	public String getNoballRuns() {
		return noballRuns;
	}

	@JsonProperty("totalRuns")
	public String getTotalRuns() {
		return totalRuns;
	}

	@JsonProperty("penaltyRuns")
	public String getPenaltyRuns() {
		return penaltyRuns;
	}

	@JsonProperty("batsmanRuns")
	public String getBatsmanRuns() {
		return batsmanRuns;
	}

	@JsonProperty("extraRuns")
	public String getExtraRuns() {
		return extraRuns;
	}

	@JsonProperty("legbyeRuns")
	public void setLegbyeRuns(String legbyeRuns) {
		this.legbyeRuns = legbyeRuns;
	}

	@JsonProperty("byeRuns")
	public void setByeRuns(String byeRuns) {
		this.byeRuns = byeRuns;
	}

	@JsonProperty("bowler")
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}

	@JsonProperty("ball")
	public void setBall(String ball) {
		this.ball = ball;
	}

	@JsonProperty("matchId")
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	@JsonProperty("inning")
	public void setInning(String inning) {
		this.inning = inning;
	}

	@JsonProperty("battingTeam")
	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	@JsonProperty("bowlingTeam")
	public void setBowlingTeam(String bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}

	@JsonProperty("over")
	public void setOver(String over) {
		this.over = over;
	}

	@JsonProperty("batsman")
	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}

	@JsonProperty("wideRuns")
	public void setWideRuns(String wideRuns) {
		this.wideRuns = wideRuns;
	}

	@JsonProperty("noballRuns")
	public void setNoballRuns(String noballRuns) {
		this.noballRuns = noballRuns;
	}

	@JsonProperty("penaltyRuns")
	public void setPenaltyRuns(String penaltyRuns) {
		this.penaltyRuns = penaltyRuns;
	}

	@JsonProperty("batsmanRuns")
	public void setBatsmanRuns(String batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}

	@JsonProperty("totalRuns")
	public void setTotalRuns(String totalRuns) {
		this.totalRuns = totalRuns;
	}

	@JsonProperty("extraRuns")
	public void setExtraRuns(String extraRuns) {
		this.extraRuns = extraRuns;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}