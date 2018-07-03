package elss.pojo;

import java.util.Map;

public class MFVarianceData {

	private String mfName;
	private String comparedMfName;
	private Map<String, VarianceData> sectorVarMap;
	private Map<String, VarianceData> allocVarMap;
	
	public MFVarianceData() {
		super();
	}

	public MFVarianceData(String mfName, String comparedMfName, Map<String, VarianceData> sectorVarMap,
			Map<String, VarianceData> allocVarMap) {
		super();
		this.mfName = mfName;
		this.comparedMfName = comparedMfName;
		this.sectorVarMap = sectorVarMap;
		this.allocVarMap = allocVarMap;
	}

	public String getMfName() {
		return mfName;
	}

	public void setMfName(String mfName) {
		this.mfName = mfName;
	}

	public Map<String, VarianceData> getSectorVarMap() {
		return sectorVarMap;
	}

	public void setSectorVarMap(Map<String, VarianceData> sectorVarMap) {
		this.sectorVarMap = sectorVarMap;
	}

	public Map<String, VarianceData> getAllocVarMap() {
		return allocVarMap;
	}

	public void setAllocVarMap(Map<String, VarianceData> allocVarMap) {
		this.allocVarMap = allocVarMap;
	}

	public String getComparedMfName() {
		return comparedMfName;
	}

	public void setComparedMfName(String comparedMfName) {
		this.comparedMfName = comparedMfName;
	}

	@Override
	public String toString() {
		return "MFVarianceData [mfName=" + mfName + ", comparedMfName=" + comparedMfName + ", sectorVarMap="
				+ sectorVarMap + ", allocVarMap=" + allocVarMap + "]";
	}

	
}
