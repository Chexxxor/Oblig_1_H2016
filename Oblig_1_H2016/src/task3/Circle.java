package task3;

public class Circle implements Comparable<Circle>{
	private double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}

	@Override
	public int compareTo(Circle o) {
		if(radius == o.radius)
			return 0;
		if(radius < o.radius)
			return (int) Math.min(radius - o.radius, -1);
		else
			return (int) Math.max(radius - o.radius, 1);
	}

}
