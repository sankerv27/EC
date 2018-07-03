package elss.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import elss.pojo.EntityData;
import elss.pojo.MFCompleteData;
import elss.pojo.MFVarianceData;
import elss.pojo.VarianceData;

public class MFDataCalculator {

	public Map<String, List<MFVarianceData>> compare(List<MFCompleteData> mfDataList) {
		Map<String, List<MFVarianceData>> mfNameToVarianceData = new HashMap<String, List<MFVarianceData>>();

		for(MFCompleteData mfData : mfDataList) {

			String currMfName = mfData.getMfName();
			
			if(!mfNameToVarianceData.containsKey(currMfName)) {
				mfNameToVarianceData.put(currMfName, new ArrayList<MFVarianceData>());
			}
			List<MFVarianceData> varDataList = mfNameToVarianceData.get(currMfName);
			
			Map<String, EntityData> investmentsData = mfData.getInvestmentsData();
			Map<String, EntityData> sectorData = mfData.getSectorData();
			
			for(MFCompleteData otherMfData : mfDataList ) {
				//skipping the same record
				String otherMfName = otherMfData.getMfName();
				if(!currMfName.equalsIgnoreCase(otherMfName)) {
					MFVarianceData currMfVarData = new MFVarianceData();
					currMfVarData.setMfName(currMfName);
					currMfVarData.setComparedMfName(otherMfName);
					Map<String, VarianceData> secVarData = getVarianceData(sectorData,otherMfData.getSectorData());
					currMfVarData.setSectorVarMap(secVarData);
					
					Map<String, VarianceData> investVarData = getVarianceData(investmentsData,otherMfData.getInvestmentsData());
					currMfVarData.setAllocVarMap(investVarData);
					varDataList.add(currMfVarData);
				}
				
			}
		}
		return mfNameToVarianceData;
	}
	
	private Map<String, VarianceData> getVarianceData(Map<String, EntityData> mfData, Map<String, EntityData> dataToCompare) {
		
		Map<String, VarianceData> mfNameToVarianceData = new HashMap<String, VarianceData>();
		
		for(Map.Entry<String, EntityData> mfEntry : mfData.entrySet()) {
			String mfKey = mfEntry.getKey();
			EntityData mfEntityData = mfEntry.getValue();
			double percentVar =  mfEntityData.getAllocPercentage();
			double valVar = mfEntityData.getValue();
			double quantityVar = mfEntityData.getQuantity();
			
			if(dataToCompare.containsKey(mfKey)) {

				EntityData compData = dataToCompare.get(mfKey);

				percentVar =  percentVar - compData.getAllocPercentage();
				valVar = valVar - compData.getValue();
				quantityVar = quantityVar - compData.getQuantity();
				
			}
			
			VarianceData varData = new VarianceData();
			varData.setComparedMfName(mfKey);
			varData.setPercentageDifference(percentVar);
			varData.setQuantityDifference(quantityVar);
			varData.setValueDifference(valVar);
			
			mfNameToVarianceData.put(mfKey, varData);
		}
		
		return mfNameToVarianceData;
		
	}
}
