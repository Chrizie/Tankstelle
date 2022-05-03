package function;

public class APIBeans 
{
	int price;
	int radius;
	String gasType;
	String town;
	
	public APIBeans()
	{}

	public void setPrice(int price) {this.price = price;}
	public int getPrice() {return price;}

	public void setRadius(int radius) {this.radius = radius;}
	public int getRadius() {return radius;}

	public void setGasType(String gasType) {this.gasType = gasType;}
	public String getGasType() {return gasType;}

	public void setTown(String town) {this.town = town;}
	public String getTown() {return town;}
	
}
