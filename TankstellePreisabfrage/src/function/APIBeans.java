package function;

public class APIBeans 
{
	int price;
	String radius;
	String gasType;
	String town;
	
	public APIBeans()
	{}

	public void setPrice(int price) {this.price = price;}
	public int getPrice() {return price;}

	public void setRadius(String radius) {this.radius = radius;}
	public String getRadius() {return radius;}

	public void setGasType(String gasType) {this.gasType = gasType;}
	public String getGasType() {return gasType;}

	public void setTown(String town) {this.town = town;}
	public String getTown() {return town;}
	
}
