import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kjs850 on 2016. 10. 6..
 */
public class CollectToMap {

	public static void main(String[] args) {
		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", new Date()));
		list.add(new Hosting(2, "linode.com", new Date()));
		list.add(new Hosting(3, "digitalocean.com", new Date()));
	}

	static class Hosting{
		int a;
		String mail;
		Date date;

		public Hosting(int a, String mail, Date date){
			this.a=a;
			this.mail=mail;
			this.date=date;
		}
	}
}
