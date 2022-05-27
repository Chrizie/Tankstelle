package function;

public class APIBeans 
{
	int price;
	String radius;
	String gasType;
	String stadt;
	double lat;
	double lng;
	
	
	public APIBeans()
	{}

	public void setPrice(int price) {this.price = price;}
	public int getPrice() {return price;}

	public void setRadius(String radius) {this.radius = radius;}
	public String getRadius() {return radius;}

	public void setGasType(String gasType) {this.gasType = gasType;}
	public String getGasType() {return gasType;}

	public String getStadt() {return stadt;}
	public void setStadt(String stadt) {this.stadt = stadt;}

	public double getLat() {return lat;}
	public void setLat(double lat) {this.lat = lat;}

	public double getLng() {return lng;}
	public void setLng(double lng) {this.lng = lng;}
}
