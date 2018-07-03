package elss.pojo;

public class EntityData {

	protected String name;
	protected double value;
	protected double quantity;
	protected double allocPercentage;
	
	public EntityData() {
		super();
	}
	
	public EntityData(String name, double value, double quantity, double allocPercentage) {
		super();
		this.name = name;
		this.value = value;
		this.quantity = quantity;
		this.allocPercentage = allocPercentage;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getAllocPercentage() {
		return allocPercentage;
	}
	public void setAllocPercentage(double allocPercentage) {
		this.allocPercentage = allocPercentage;
	}

	@Override
	public String toString() {
		return "MFData [name=" + name + ", value=" + value + ", quantity=" + quantity + ", allocPercentage="
				+ allocPercentage + "]";
	}
	
}
