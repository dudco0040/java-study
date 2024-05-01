package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QeueTest {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();  // Linked List가 Queue 인터페이스를 
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		while(!q.isEmpty()) {  // q가 비어 있지 않은 경우, 반복
			String s = q.poll();
			System.out.println(s);
		}
		
		// 비어있을 경우, null을 반환
		System.out.println(q.poll());
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
	}

}
