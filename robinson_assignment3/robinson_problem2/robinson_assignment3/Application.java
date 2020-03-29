package robinson_assignment3;

public class Application {

	public static void main(String[] args) {
		DuplicateCounter d = new DuplicateCounter();
		d.count("problem2.txt");
		d.write("output.txt");
	}

}

