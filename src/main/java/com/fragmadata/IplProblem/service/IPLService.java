package com.fragmadata.IplProblem.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.fragmadata.IplProblem.model.Delieveries;
import com.fragmadata.IplProblem.model.Matches;

public class IPLService {
	static List<String> deliveriesLines = new ArrayList<String>();
	static List<String> matchesLines = new ArrayList<String>();
	static List<Matches> matchList = new ArrayList<Matches>();
	static List<Delieveries> delieversList = new ArrayList<Delieveries>();
	static Set<String> teams = new HashSet<String>();
	static Set<String> seasons = new HashSet<String>();
	private static String cvsSplitBy = ",";

	public String getResponse() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream delieveriesStream = classLoader.getResourceAsStream("deliveries.csv");
		InputStream matchesStream = classLoader.getResourceAsStream("matches.csv");

		Scanner scanner;
		try {
			scanner = new Scanner(delieveriesStream);
			while (scanner.hasNext()) {
				String test = "" + scanner.nextLine();
				deliveriesLines.add(test);
				// System.out.println(test);
			}
			scanner.close();
			// System.out.println("------------------------------------------");
			scanner = new Scanner(matchesStream);
			while (scanner.hasNext()) {
				String test = "" + scanner.nextLine();
				matchesLines.add(test);
				// System.out.println(test);
			}
			scanner.close();
			getDelievers();
			getMatchesList();
		} finally {

		}
		return "";

		// TODO Auto-generated method stub
	}

	private void getMatchesList() {
		// TODO Auto-generated method stub
		// for (String match : matchesLines) {
		for (int i = 1; i < matchesLines.size(); i++) {
			String match = matchesLines.get(i);
			String[] matchArray = match.split(cvsSplitBy);
			getMatches(matchArray);
		}

	}

	private void getDelievers() {
		// TODO Auto-generated method stub
		// for (String delivery : deliveriesLines) {

		for (int i = 1; i < deliveriesLines.size(); i++) {
			String delivery = deliveriesLines.get(i);
			String[] deliveryArray = delivery.split(cvsSplitBy);
			constructDeliveries(deliveryArray);
		}

	}

	private void constructDeliveries(String[] deliveryArray) {
		// MATCH_ID INNING BATTING_TEAM BOWLING_TEAM OVER BALL BATSMAN BOWLER WIDE_RUNS
		// BYE_RUNS LEGBYE_RUNS NOBALL_RUNS PENALTY_RUNS BATSMAN_RUNS EXTRA_RUNS
		// TOTAL_RUNS

		// TODO Auto-generated method stub
		Delieveries delivery = new Delieveries();

		String matchId = (null == deliveryArray[0]) ? "" : deliveryArray[0];
		String inning = (null == deliveryArray[1]) ? "" : deliveryArray[1];
		String battingTeam = (null == deliveryArray[2]) ? "" : deliveryArray[2];
		String bowlingTeam = (null == deliveryArray[3]) ? "" : deliveryArray[3];
		String over = (null == deliveryArray[4]) ? "" : deliveryArray[4];
		String ball = (null == deliveryArray[5]) ? "" : deliveryArray[5];
		String batsman = (null == deliveryArray[6]) ? "" : deliveryArray[6];
		String bowler = (null == deliveryArray[7]) ? "" : deliveryArray[7];
		String wideRuns = (null == deliveryArray[8]) ? "" : deliveryArray[8];
		String byeRuns = (null == deliveryArray[9]) ? "" : deliveryArray[9];
		String legbyeRuns = (null == deliveryArray[10]) ? "" : deliveryArray[10];
		String noballRuns = (null == deliveryArray[11]) ? "" : deliveryArray[11];
		String penaltyRuns = (null == deliveryArray[12]) ? "" : deliveryArray[12];
		String batsmanRuns = (null == deliveryArray[13]) ? "" : deliveryArray[13];
		String extraRuns = (null == deliveryArray[14]) ? "" : deliveryArray[14];
		String totalRuns = (deliveryArray.length >= 15 && null != deliveryArray[15]) ? deliveryArray[15] : "";

		if (battingTeam.equals("Rising Pune Supergiant")) {

			battingTeam = "Rising Pune Supergiants";
		}
		if (bowlingTeam.equals("Rising Pune Supergiant")) {

			bowlingTeam = "Rising Pune Supergiants";
		}

		delivery.setLegbyeRuns(legbyeRuns);
		delivery.setByeRuns(byeRuns);
		delivery.setBowler(bowler);
		delivery.setBall(ball);
		delivery.setMatchId(matchId);
		delivery.setInning(inning);
		delivery.setBattingTeam(battingTeam);
		delivery.setBowlingTeam(bowlingTeam);
		delivery.setOver(over);
		delivery.setBatsman(batsman);
		delivery.setWideRuns(wideRuns);
		delivery.setNoballRuns(noballRuns);
		delivery.setPenaltyRuns(penaltyRuns);
		delivery.setBatsmanRuns(batsmanRuns);
		delivery.setTotalRuns(totalRuns);
		delivery.setExtraRuns(extraRuns);
		// System.out.println(delivery.toString());
		delieversList.add(delivery);
		teams.add(battingTeam);
		teams.add(bowlingTeam);
	}

	private void getMatches(String[] matchArray) {
		// TODO Auto-generated method stub
		// MATCH_ID INNING BATTING_TEAM BOWLING_TEAM OVER BALL BATSMAN BOWLER WIDE_RUNS
		// BYE_RUNS LEGBYE_RUNS NOBALL_RUNS PENALTY_RUNS BATSMAN_RUNS EXTRA_RUNS
		// TOTAL_RUNS
		// MATCH_ID SEASON CITY DATE TEAM1 TEAM2 TOSS_WINNER TOSS_DECISION RESULT WINNER
		Matches matches = new Matches();

		String team1 = (null == matchArray[4]) ? "" : matchArray[4];
		String date = (null == matchArray[3]) ? "" : matchArray[3];
		String city = (null == matchArray[2]) ? "" : matchArray[2];
		String team2 = (null == matchArray[5]) ? "" : matchArray[5];
		String season = (null == matchArray[1]) ? "" : matchArray[1];
		String matchId = (null == matchArray[0]) ? "" : matchArray[0];
		String tossWinner = (null == matchArray[6]) ? "" : matchArray[6];
		String tossDecision = (null == matchArray[7]) ? "" : matchArray[7];
		String result = (null == matchArray[8]) ? "" : matchArray[8];
		String winner = (matchArray.length >= 10 && null != matchArray[9]) ? matchArray[9] : "";
		seasons.add(season);
		if (team1.equals("Rising Pune Supergiant")) {

			team1 = "Rising Pune Supergiants";
		}
		if (team2.equals("Rising Pune Supergiant")) {

			team2 = "Rising Pune Supergiants";
		}

		teams.add(team1);
		teams.add(team2);
		matches.setTeam1(team1);
		matches.setDate(date);
		matches.setCity(city);
		matches.setTeam2(team2);
		matches.setSeason(season);
		matches.setMatchId(matchId);
		matches.setTossWinner(tossWinner);
		matches.setTossDecision(tossDecision);
		matches.setResult(result);
		matches.setWinner(winner);
		// System.out.println(matches.toString());
		matchList.add(matches);

	}

	public String getQuestion1Response() {
		// TODO Auto-generated method stub

		Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
		for (Matches match : matchList) {
			// if (match.getTossDecision().equals("field") &&
			// match.getTossWinner().equals(match.getWinner())) {
			if (match.getTossDecision().equals("field")) {
				String year = match.getSeason();
				Map<String, Integer> listMap = map.get(year);
				if (null == listMap) {
					Map<String, Integer> listMaps = new HashMap<String, Integer>();
					listMaps.put(match.getTossWinner(), 1);
					map.put(year, listMaps);
				} else {
					if (null == listMap.get(match.getTossWinner())) {
						listMap.put(match.getTossWinner(), 1);
						map.put(year, listMap);
					} else {
						listMap.put(match.getTossWinner(), listMap.get(match.getTossWinner()) + 1);
						map.put(year, listMap);
						// map.get(year).put(match.getTossWinner(),
						// (map.get(year).get(match.getTossWinner())+1));
					}
				}
			}
		}

		Map<String, Integer> map2016 = map.get("2016");
		Map<String, Integer> map2017 = map.get("2017");

		// "duplicate" value
		List<Entry<String, Integer>> lis2016 = entriesSortedByValues(map2016);
		List<Entry<String, Integer>> lis2017 = entriesSortedByValues(map2017);

		String format = "|%1$-10s|%2$-30s|%3$-20s|\n";

		System.out.format(format, "__________", "__________", "__________");

		System.out.format(format, "YEAR", "TEAM", "COUNT");

		for (int i = 0; i < 4; i++) {
			Entry<String, Integer> entry = lis2016.get(i);
			System.out.format(format, "2016", entry.getKey(), entry.getValue());

		}
		for (int i = 0; i < 4; i++) {
			Entry<String, Integer> entry = lis2017.get(i);
			System.out.format(format, "2017", entry.getKey(), entry.getValue());
		}

		System.out.format(format, "__________", "__________", "__________");

		return "";
	}

	public String getQuestion2Response() {
		// TODO Auto-generated method stub
		String format = "|%1$-10s|%2$-30s|%3$-20s|%4$-20s|%5$-20s|\n";
		System.out.format(format, "__________", "__________", "__________","__________","__________");

		System.out.format(format, "YEAR", "TEAM_NAME", "FOURS_COUNT", "SIXES_COUNT", "TOTAL_SCORE");
		for (String season : seasons) {
			Set<String> seasonTeams = new HashSet<String>();
			Set<String> matid = new HashSet<String>();
			for (Matches match : matchList) {
				if (match.getSeason().equals(season)) {
					seasonTeams.add(match.getTeam1());
					seasonTeams.add(match.getTeam2());
					matid.add(match.getMatchId());
				}
			}
			for (String team : seasonTeams) {
				int fourCount = 0;
				int sixCount = 0;
				int totalCount = 0;
				for (String matL : matid) {
					for (Delieveries delo : delieversList) {
						if (delo.getMatchId().equals(matL) && delo.getBattingTeam().equals(team)) {
							if (delo.getBatsmanRuns().equals("4")) {
								fourCount++;
							}
							if (delo.getBatsmanRuns().equals("6")) {
								sixCount++;
							}
							totalCount = totalCount + Integer.parseInt(delo.getTotalRuns());
						}
					}
				}
				System.out.format(format, season, team, fourCount, sixCount, totalCount);
			}

		}
		// List<User> males = users.stream().filter(u ->
		// u.getSex().equals("Male")).collect(Collectors.toList());
		System.out.format(format, "__________", "__________", "__________","__________","__________");
		return "";
	}

	public String getQuestion3Response() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String format = "|%1$-10s|%2$-30s|%3$-20s|\n";
		System.out.format(format, "__________", "__________", "__________");
		System.out.format(format, "YEAR", "PLAYER", "ECONOMY");
		/*
		 * Map<String, List<Delieveries>> delieveriesByMatchId = null;
		 * delieveriesByMatchId =
		 * delieversList.stream().collect(Collectors.groupingBy(Delieveries::getMatchId)
		 * ); Map<String, List<Matches>> matchesByMatchID = null; matchesByMatchID =
		 * matchList.stream().collect(Collectors.groupingBy(Matches::getMatchId));
		 */
		Map<String, Set<String>> seasonToMatchId = new HashMap<String, Set<String>>();
		for (String season : seasons) {
			// Set<String> seasonBowlers = new HashSet<String>();
			Set<String> matid = new HashSet<String>();
			Set<Delieveries> delBolList = new HashSet<Delieveries>();
			Set<String> bowlers = new HashSet<String>();
			Set<String> bowlersMatchIdtoOvers = new HashSet<String>();
			Map<String, Integer> bowlerTORunsGiven = new HashMap<String, Integer>();
			for (Matches match : matchList) {
				if (match.getSeason().equals(season)) {
					matid.add(match.getMatchId());
					for (Delieveries delo : delieversList) {
						if (delo.getMatchId().equals(match.getMatchId())) {
							delBolList.add(delo);
							bowlers.add(delo.getBowler());
							bowlersMatchIdtoOvers
									.add(delo.getMatchId() + "," + delo.getBowler() + "," + delo.getOver());

						}
					}
				}
			}

			Map<String, List<Delieveries>> mapBowlers = delBolList.stream()
					.collect(Collectors.groupingBy(Delieveries::getBowler));
			for (String bowls : bowlers) {
				List<Delieveries> lis = mapBowlers.get(bowls);
				int runs = (null == bowlerTORunsGiven.get(bowls)) ? 0 : bowlerTORunsGiven.get(bowls);
				for (Delieveries singleDelievery : lis) {
					runs = runs + Integer.parseInt(singleDelievery.getTotalRuns())
							- Integer.parseInt(singleDelievery.getLegbyeRuns())
							- Integer.parseInt(singleDelievery.getByeRuns());
				}
				bowlerTORunsGiven.put(bowls, runs);
			}
			seasonToMatchId.put(season, matid);
			Map<String, Integer> bowlerTOOvers = new HashMap<String, Integer>();

			for (String bowls : bowlers) {
				int totalOversBowledByBowlerInSeason = 0;
				for (String bow : bowlersMatchIdtoOvers) {
					if (bow.contains(bowls)) {
						totalOversBowledByBowlerInSeason++;
					}
				}
				bowlerTOOvers.put(bowls, totalOversBowledByBowlerInSeason);
			}
			HashMap<String, Double> hm = new HashMap<String, Double>();
			for (String bowl : bowlers) {
				double economy = 0.0;
				if (bowlerTOOvers.get(bowl) >= 10) {
					economy = bowlerTORunsGiven.get(bowl) / bowlerTOOvers.get(bowl);
					hm.put(bowl, economy);
				}
			}
			Map<String, Double> hm1 = sortByValue(hm);
			int count = 0;
			for (Map.Entry<String, Double> en : hm1.entrySet()) {
				if (count < 10) {
					System.out.format(format, season, en.getKey(), en.getValue());
					count++;
				} else {
					break;
				}

				/*
				 * System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
				 */
			}

		}
		System.out.format(format, "__________", "__________", "__________");
		// List<User> males = users.stream().filter(u ->
		// u.getSex().equals("Male")).collect(Collectors.toList());
		return "";
	}

	public String getQuestion4Response() {
		String format = "|%1$-10s|%2$-30s|%3$-20s|\n";
		System.out.format(format, "__________", "__________", "__________");
		System.out.format(format, "YEAR", "PLAYER", "NRR");
		for (String season : seasons) {
			// Set<String> seasonBowlers = new HashSet<String>();
			Set<String> matid = new HashSet<String>();
			Set<Delieveries> delBolList = new HashSet<Delieveries>();
			Set<String> bowlersMatchIdtoOvers = new HashSet<String>();
			Set<String> battingMatchIdtoOvers = new HashSet<String>();
			Map<String, Integer> seasonTeamBattingTotalScore = new HashMap<String, Integer>();
			Map<String, Integer> seasonTeamBowlingTotalScore = new HashMap<String, Integer>();
			for (Matches match : matchList) {
				if (match.getSeason().equals(season)) {
					matid.add(match.getMatchId());
					for (Delieveries delo : delieversList) {
						if (delo.getMatchId().equals(match.getMatchId())) {
							delBolList.add(delo);
							battingMatchIdtoOvers
									.add(delo.getMatchId() + "," + delo.getBattingTeam() + "," + delo.getOver());
							bowlersMatchIdtoOvers
									.add(delo.getMatchId() + "," + delo.getBowlingTeam() + "," + delo.getOver());
							int runs = (null == seasonTeamBattingTotalScore.get(season + "," + delo.getBattingTeam()))
									? 0
									: seasonTeamBattingTotalScore.get(season + "," + delo.getBattingTeam());
							seasonTeamBattingTotalScore.put(season + "," + delo.getBattingTeam(),
									(runs = runs + Integer.parseInt(delo.getTotalRuns())));
							runs = (null == seasonTeamBowlingTotalScore.get(season + "," + delo.getBowlingTeam())) ? 0
									: seasonTeamBowlingTotalScore.get(season + "," + delo.getBowlingTeam());
							seasonTeamBowlingTotalScore.put(season + "," + delo.getBowlingTeam(),
									(runs = runs + Integer.parseInt(delo.getTotalRuns())));
						}
					}
				}
			}

			double maxRunRateScore = 0;
			String teamOfYear = "";
			for (String team : teams) {
				int totalBatOvers = 0;
				int totalBowlOvers = 0;

				for (String battingMatchIdtoOver : battingMatchIdtoOvers) {
					if (battingMatchIdtoOver.contains(team)) {
						totalBatOvers++;
					}
				}
				for (String bowlersMatchIdtoOver : bowlersMatchIdtoOvers) {
					if (bowlersMatchIdtoOver.contains(team)) {
						totalBowlOvers++;
					}
				}

				if (null != seasonTeamBattingTotalScore.get(season + "," + team)
						|| null != seasonTeamBowlingTotalScore.get(season + "," + team)) {
					double totalBatScore = seasonTeamBattingTotalScore.get(season + "," + team);
					double totalBowlScore = seasonTeamBowlingTotalScore.get(season + "," + team);
					double nRR = (totalBatScore / totalBatOvers) - (totalBowlScore / totalBowlOvers);
					if (Double.compare(nRR, maxRunRateScore) >= 0) {
						maxRunRateScore = nRR;
						teamOfYear = team;
					}

				}

			}
			System.out.format(format, season, teamOfYear, maxRunRateScore);

		}
		System.out.format(format, "__________", "__________", "__________");
		// List<User> males = users.stream().filter(u ->
		// u.getSex().equals("Male")).collect(Collectors.toList());
		return "";
	}

	public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
		for (Map.Entry<String, Double> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		return sortedEntries;
	}
}
