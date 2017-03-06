import java.util.List;

/**
 * Created by kjs850 on 2016. 10. 26..
 */
public class Student {

	private String name;
	private int age;
	private List<String> language;

	public static class Builder {

		private String name;
		private int age;
		private List<String> language;

		public Builder name(String name){
			this.name = name;
			return this;
		}

		public Builder age(int age){
			this.age = age;
			return this;
		}

		public Builder language(List<String> language){
			this.language = language;
			return this;
		}

		public Student build(){
			return new Student(this);
		}
	}

	private Student(Builder builder){
		this.name = builder.name;
		this.age = builder.age;
		this.language = builder.language;
	}

	public String toString(){
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				", language=" + language +
				'}';
	}


}
