package model;

import java.awt.Color;

import model.decorators.ColorDecorator;
import model.decorators.FillDecorator;

public class ShapeReader {
	public Shape getShape(String s) throws Exception {
		if(s.charAt(0) != '(' || s.length() < 2) {
			throw new Exception("Error not valid shape string");
		}
		Shape returnShape = null;
		s = s.substring(1, s.length()-1);
		String type = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",")+1);
		switch(type) {
		case "color":
			String cStr = s.substring(0, s.indexOf(","));
			Color c = new Color(Integer.parseInt(cStr));
			s = s.substring(s.indexOf(",")+1);
			returnShape = new ColorDecorator(getShape(s), c);
			break;
		case "fill":
			returnShape = new FillDecorator(getShape(s));
			break;
		case "rectangle":
			String p1Str = s.substring(0, s.indexOf(')')+1);
			p1Str = p1Str.substring(1, p1Str.length()-1);
			s = s.substring(s.indexOf(')')+1);
			s = s.substring(s.indexOf('('));

			int x1 = Integer.parseInt(p1Str.substring(0, p1Str.indexOf(",")));
			p1Str = p1Str.substring(p1Str.indexOf(",")+1);
			int y1 = Integer.parseInt(p1Str.trim());
			
			String p2Str = s;
			p2Str = p2Str.substring(1, p2Str.length()-1);
			int x2 = Integer.parseInt(p2Str.substring(0, p2Str.indexOf(",")));
			p2Str = p2Str.substring(p2Str.indexOf(",")+1);
			int y2 = Integer.parseInt(p2Str.trim());
			returnShape = new Rectangle(new Point(x1,y1), new Point(x2, y2));
			break;
		case "circle":
			String center = s.substring(0, s.lastIndexOf(","));
			center = center.substring(1, center.length()-1);
			
			int x = Integer.parseInt(center.substring(0, center.indexOf(",")));
			center = center.substring(center.indexOf(",")+1);
			int y = Integer.parseInt(center.trim());
			
			s = s.substring(s.lastIndexOf(",")+1);
			int radius = Integer.parseInt(s.trim());
			returnShape = new Circle(new Point(x,y), radius);
			break;
		case "line":
			p1Str = s.substring(0, s.indexOf(')')+1);
			p1Str = p1Str.substring(1, p1Str.length()-1);
			s = s.substring(s.indexOf(')')+1);
			s = s.substring(s.indexOf('('));

			x1 = Integer.parseInt(p1Str.substring(0, p1Str.indexOf(",")));
			p1Str = p1Str.substring(p1Str.indexOf(",")+1);
			y1 = Integer.parseInt(p1Str.trim());
			
			p2Str = s;
			p2Str = p2Str.substring(1, p2Str.length()-1);
			x2 = Integer.parseInt(p2Str.substring(0, p2Str.indexOf(",")));
			p2Str = p2Str.substring(p2Str.indexOf(",")+1);
			y2 = Integer.parseInt(p2Str.trim());
			returnShape = new Line(new Point(x1,y1), new Point(x2, y2));
			break;
		case "freeLine":
			String p = "";
			FreeLine f = new FreeLine();
			while(s.indexOf(',', s.indexOf(',')+1) != -1) {
				p = s.substring(0, s.indexOf(',', s.indexOf(',')+1));
				s = s.substring(s.indexOf(',', s.indexOf(',')+1)+1);
				
				p1Str = p.substring(1, p.length()-1);

				x1 = Integer.parseInt(p1Str.substring(0, p1Str.indexOf(",")));
				p1Str = p1Str.substring(p1Str.indexOf(",")+1);
				y1 = Integer.parseInt(p1Str.trim());
				
				f.addPoint(new Point(x1,y1));
			}
			returnShape = f;
			break;
		default:
			System.out.println(type);
			throw new Exception("Error not a valid shape type");
		}
		return returnShape;
	}
}
