package application;

public class Ingredient {
	
	private double amount;
	private MeasurementType type;
	private String name;
	
	public Ingredient(double amount, MeasurementType type, String name)
	{
		this.amount=amount;
		this.type=type;
		this.name=name;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public MeasurementType getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(amount + " " + type + "(s) " + name);
		return sb.toString();
	}

}
