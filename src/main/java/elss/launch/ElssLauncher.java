package elss.launch;

import java.io.File;
import java.util.List;
import java.util.Map;

import elss.calculator.MFDataCalculator;
import elss.extractor.MFDataExtractor;
import elss.pojo.MFCompleteData;
import elss.pojo.MFVarianceData;
import elss.pojo.VarianceData;

public class ElssLauncher {

    public static void main(String[] args )
    {
		String folderPath = args[0];
		File folder = new File(folderPath);
		ElssLauncher launch = new ElssLauncher();
		launch.initiate(folder);
    }
    
    private void initiate(final File folder) {
    	List<MFCompleteData> mfDataList = initiateDataExtractor(folder);
    	displayResults(mfDataList);
    }
    
    private List<MFCompleteData> initiateDataExtractor(final File folder) {
    	MFDataExtractor mfDataExtractor = new MFDataExtractor();
    	return mfDataExtractor.readFilesFromFolder(folder);
    }
    
    private void displayResults(List<MFCompleteData> mfDataList) {
    	MFDataCalculator mfCalculator = new MFDataCalculator();
    	Map<String, List<MFVarianceData>> result = mfCalculator.compare(mfDataList);
    	for(Map.Entry<String, List<MFVarianceData>> entry : result.entrySet()) {
    		System.out.println(entry.getKey());
    		List<MFVarianceData> varianceData = entry.getValue();
    		for(MFVarianceData varData : varianceData) {
    			System.out.println("\n\n\n Sector allocation \n");
    			for(Map.Entry<String, VarianceData> data : varData.getSectorVarMap().entrySet()) {
    				System.out.println(data.getKey() + "\n\t\t\t--\t\t\t" + Math.round(data.getValue().getPercentageDifference() * 100.0)/100.0 + "\t\t\t--\t\t\t" + Math.round(data.getValue().getValueDifference() * 100.0)/100.0);
    			}
    			System.out.println("\n\n\n Investment allocation \n");    			
    			for(Map.Entry<String, VarianceData> data : varData.getAllocVarMap().entrySet()) {
    				System.out.println(data.getKey() + "\n\t\t\t--\t" + Math.round(data.getValue().getPercentageDifference() * 100.0)/100.0 + "\t\t\t--\t" + Math.round(data.getValue().getValueDifference() * 100.0)/100.0);
    			}
    		}
    	}
    }
}
