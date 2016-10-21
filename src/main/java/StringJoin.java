import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by kjs850 on 2016. 10. 7..
 */
public class StringJoin {

	public static void main(String[] args) {

		//1. StringJoiner
		StringJoiner sj = new StringJoiner(",");
		sj.add("aa");
		sj.add("bb");
		sj.add("cc");


		System.out.println(sj.toString()); //aa,bb,cc
		System.out.println(sj.length()); //8

		StringJoiner sj1 = new StringJoiner(",","prefix-", "-subfix");
		sj1.add("aa");
		sj1.add("bb");
		sj1.add("cc");

		System.out.println(sj1.toString());  //prefix-aa,bb,cc-subfix

		//2. String.join
		String result = String.join("-", "2011", "11", "11");
		System.out.println(result); //2011-11-11

		List<String> list = Arrays.asList("a", "b", "c");
		String result1 = String.join(",", list);
		System.out.println(result1);  //a,b,c

		//3. Collectors.joining
		List<String> clist = Arrays.asList("java", "python", "nodejs", "ruby");
		String collResult = clist.stream().map(x -> x).collect(Collectors.joining("||"));
		List<String> collResultList = clist.stream().map(x -> x).collect(Collectors.toList());
		System.out.println(collResult);  //java||python||nodejs||ruby
		System.out.println(collResultList);  //[java, python, nodejs, ruby]


		List<Game> gameList = Arrays.asList(
				new Game("Dragon Blaze", 5),
				new Game("Angry Bird", 5),
				new Game("Candy Crush", 5)
		);

		//{Dragon Blaze, Angry Bird, Candy Crush}
		String resultGame = gameList.stream().map(x -> x.getName())
				.collect(Collectors.joining(", ", "{", "}"));

		System.out.println(resultGame);

	}
}

class Game{
	String name;
	int ranking;

	public Game(String name, int ranking) {
		this.name = name;
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
}