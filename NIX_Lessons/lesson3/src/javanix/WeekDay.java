package javanix;

public class WeekDay {

	public static void main(String[] args) {
		
		DayOfWeek day = DayOfWeek.THU;
		
		String nameDay = switch (day) {
				
					case MON ->"Понеділок";
					case TUE ->"Вівторок";
					case WED ->"Середа";
					case THU ->"Четвер";
					case FRI ->"П'ятниця";
					case SAT ->"Субота";
					case SUN ->"Неділя";
					default -> "Unknown day";
		};
		
		System.out.println(nameDay);

	}

}
