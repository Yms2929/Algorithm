package gazua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PointSort {

	public static void main(String[] args) {
		List<Point> pointList = new ArrayList<Point>();
		int x = 0;
		int y = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			Point point = new Point(x, y);
			pointList.add(point);
		}
		
		Collections.sort(pointList, new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (p1.getX() > p2.getX()) {
					return 1;
				}
				else if (p1.getX() < p2.getX()) {
					return -1;
				}
				else if (p1.getX() == p2.getX()) {
					if (p1.getY() > p2.getY()) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else {
					return 0;
				}
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(pointList.get(i).getX() + " " + pointList.get(i).getY());
		}
	}

}

class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

}