package elss.pojo;

import java.util.Map;

public class MFCompleteData {

	private Map<String,EntityData> investmentsData;
	private Map<String,EntityData> sectorData;
	private String mfName;
	
	public MFCompleteData() {
		super();
	}

	public MFCompleteData(Map<String, EntityData> investmentsData, Map<String, EntityData> sectorData, String mfName) {
		super();
		this.investmentsData = investmentsData;
		this.sectorData = sectorData;
		this.mfName = mfName;
	}

	public Map<String, EntityData> getInvestmentsData() {
		return investmentsData;
	}

	public void setInvestmentsData(Map<String, EntityData> investmentsData) {
		this.investmentsData = investmentsData;
	}

	public Map<String, EntityData> getSectorData() {
		return sectorData;
	}

	public void setSectorData(Map<String, EntityData> sectorData) {
		this.sectorData = sectorData;
	}

	public String getMfName() {
		return mfName;
	}

	public void setMfName(String mfName) {
		this.mfName = mfName;
	}

	@Override
	public String toString() {
		return "MFCompleteData [investmentsData=" + investmentsData + ", sectorData=" + sectorData + ", mfName="
				+ mfName + "]";
	}
}
