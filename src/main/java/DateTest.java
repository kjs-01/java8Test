import java.time.*;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;


/**
 * http://starplatina.tistory.com/entry/Java-8-%EC%83%88%EB%A1%9C%EC%9A%B4-Date-Time-API
 */
public class DateTest {

	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		System.out.println(LocalDate.of(2012, Month.DECEMBER, 12));

		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		System.out.println(LocalTime.of(17,18));
		System.out.println(LocalTime.parse("10:15:30"));

//		2016-10-10T14:46:28.412
//		2016-10-10
//		2012-12-12
//		14:46:28.414
//		17:18
//		10:15:30

		System.out.println("=========");
		LocalDateTime timePoint = LocalDateTime.now();
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);

		Month month = timePoint.getMonth();
		System.out.println(month);

		int day = timePoint.getDayOfMonth();
		System.out.println(day);

		int hour = timePoint.getHour();
		System.out.println(hour);

//		=========
//		2016-10-10
//		OCTOBER
//		10
//		14

		System.out.println("=========");
		//날짜를 변경할 때 오브젝트의 값을 변경해야 되는데 신규 API는 불변 클래스이기 때문에 사용할때 새로운 오브젝트로 생성되서 값을 리턴해준다. 아래 setter 사용하는것을 참조 하라.
		//서로 다른 값들을 가지고 날짜를 수정하는 방법역시 제공한다.
		LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);
		System.out.println(thePast);

		LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.DAYS);
		System.out.println(yetAnother);

		System.out.println("timePoint:" + timePoint);
		System.out.println(timePoint.with(lastDayOfMonth()));

		System.out.println("=========");
		LocalTime truncatedTime = LocalTime.now();
		System.out.println(truncatedTime);
		System.out.println(truncatedTime.truncatedTo(ChronoUnit.SECONDS));
		System.out.println(truncatedTime.truncatedTo(ChronoUnit.MINUTES));

//		10:52:50.686
//		10:52:50
//		10:52

		//Periods
 		LocalDate oldDate = LocalDate.now();
		ZonedDateTime oldDateTime = ZonedDateTime.now();

		System.out.println("oldDate:" + oldDate);
		System.out.println("oldDateTime" + oldDateTime);

		Period period = Period.of(1,1,0);

		LocalDate newDate = oldDate.plus(period);
		ZonedDateTime newDateTime = oldDateTime.minus(period);

		System.out.println(newDate);
		System.out.println(newDateTime);

//		oldDate:2016-10-11
//		oldDateTime2016-10-11T10:52:50.687+09:00[Asia/Seoul]
//		2017-11-11
//		2015-09-11T10:52:50.687+09:00[Asia/Seoul]

	}
}
