package elss.pojo;

public class VarianceData {

	private String comparedMfName;
	private double valueDifference;
	private double quantityDifference;
	private double percentageDifference;
	
	public VarianceData() {
		super();
	}

	public VarianceData(String comparedMfName, double valueDifference, double quantityDifference,
			double percentageDifference) {
		super();
		this.comparedMfName = comparedMfName;
		this.valueDifference = valueDifference;
		this.quantityDifference = quantityDifference;
		this.percentageDifference = percentageDifference;
	}

	public String getComparedMfName() {
		return comparedMfName;
	}

	public void setComparedMfName(String comparedMfName) {
		this.comparedMfName = comparedMfName;
	}

	public double getValueDifference() {
		return valueDifference;
	}

	public void setValueDifference(double valueDifference) {
		this.valueDifference = valueDifference;
	}

	public double getQuantityDifference() {
		return quantityDifference;
	}

	public void setQuantityDifference(double quantityDifference) {
		this.quantityDifference = quantityDifference;
	}

	public double getPercentageDifference() {
		return percentageDifference;
	}

	public void setPercentageDifference(double percentageDifference) {
		this.percentageDifference = percentageDifference;
	}

	@Override
	public String toString() {
		return "VarianceData [comparedMfName=" + comparedMfName + ", valueDifference=" + valueDifference
				+ ", quantityDifference=" + quantityDifference + ", percentageDifference=" + percentageDifference + "]";
	}
	
}
