package Pigmap;
//向量坐标计算类

public class Vec2
{
	public double x;
	public double y;

	public Vec2(double x, double y)
	{
		this.x=x;
		this.y=y;
	}

	public Vec2 Rotate(double deg)
	{
		double nx = x*Math.cos(Math.toRadians(deg)) - y*Math.sin(Math.toRadians(deg));
		double ny = x*Math.sin(Math.toRadians(deg)) + y*Math.cos(Math.toRadians(deg));
		return new Vec2(nx, ny);
	}

	public Vec2 Normalize()
	{
		return new Vec2(x/Length(), y/Length());
	}

	public Vec2 Add(Vec2 o)
	{
		return new Vec2(x+o.x, y+o.y);
	}

	public Vec2 Sub(Vec2 o)
	{
		return new Vec2(x-o.x, y-o.y);
	}

	public Vec2 Multiply(double n)
	{
		return new Vec2(x*n, y*n);
	}

	public double Length()
	{
		return Math.sqrt(x*x+y*y);
	}
}