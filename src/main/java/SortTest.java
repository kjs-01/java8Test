import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kjs850 on 2016. 10. 21..
 */
public class SortTest {

	public static void main(String[] args) {

		List<Apple> appleList = new ArrayList<>();
		appleList.add(new Apple("red", 10));
		appleList.add(new Apple("green", 30));
		appleList.add(new Apple("blue", 20));



		System.out.println("-- Color asc sort --");
		appleList.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));

		appleList.forEach(x -> System.out.println(x.toString()));

		System.out.println("-- Weight desc sort --");
		appleList.sort(Comparator.comparing(Apple::getWeight));
		appleList.forEach(x -> System.out.println(x.toString()));
	}

	private static class Apple{
		private String color;
		private int weight;


		public Apple(String color, int weight){
			this.color = color;
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public int getWeight() {
			return weight;
		}

		@Override
		public String toString(){
			return "color:" + color + " ,weight:" +weight;
		}
	}
}
