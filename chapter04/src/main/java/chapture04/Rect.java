package chapture04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(h*w);  // 해시값 반환 시, rule이 바뀔 수도 있음 (수정가능해야함)
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return h * w == other.h * other.w;
	}

}
