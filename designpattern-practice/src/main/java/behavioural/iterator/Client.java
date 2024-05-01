package behavioural.iterator;

public class Client {

	public static void main(String[] args) {
		Aggregate<String> fruits = new AggreGateImpl<>(new String[] {"apple","banana","mongo","orange");
		Iterator<String> it = fruits.createIterator();
		
		
		while(it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}

	}

}
