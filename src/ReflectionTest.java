import java.lang.reflect.Field;

public class ReflectionTest {

	public static void main(String[] args) {
		// a class with a private value
		//Dit is een zelfgeschreven klasse, te vinden eveneens in dit mapje
		MyClass myclass = new MyClass(31415);

		// zie verder...

		try {
			Field field = MyClass.class.getDeclaredField("myInt");
			field.setAccessible(true); // security uitschakelen

			// waarde opvragen
			int value = (int) field.get(myclass);
			System.out.println("The private value in the class: " + value);

			// zie verder...

			// waarde wijzigen
			field.setInt(myclass, 69);

			value = (int) field.get(myclass);
			System.out.println("The private value in the class: " + value);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
