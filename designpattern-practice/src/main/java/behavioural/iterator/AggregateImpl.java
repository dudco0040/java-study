package behavioural.iterator;

public class AggregateImpl<E> implements Aggregate<E> {
	private E[] data = null;
	
	public AggregateImpl(E[] data) {
		this.datas = datas;
		
	}
	
	@Override
	public Iterator<E> createIterator(){
		return new IteratorImp();
	}
}
