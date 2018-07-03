package elss.launch;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import elss.extractor.MFDataExtractor;
import elss.pojo.EntityData;
import elss.pojo.MFCompleteData;

public class ElssLauncher {
	
	private int displayLength = 30;
	private String SECTOR_STRING = "sector";
	private String INVESTMENT_STRING = "investment";

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
    
    private String getEmptyString(int length) {
    	StringBuffer buff = new StringBuffer();
		for(int i = 0; i< length; i++) {
			buff.append(" ");	
		}
    	return buff.toString();
    }
    
    private String getFormattedString(String string) {
    	
    	int remLength = displayLength;
    	if(string != null) {
    		remLength -= string.length();
    		if(string.length() > displayLength) {
    			string = string.substring(0, displayLength);
    		}
        	return getEmptyString(remLength)+string;
    	} else {
    		return getEmptyString(remLength);
    	}

    }
    
    private void drawHorizontalLine(int length) {
    	StringBuffer buff = new StringBuffer();
    	for(int i = 0; i < length; i ++) {
    		buff.append("-");
    	}
    	System.out.println(buff);
    }
    
    private void printData(Set<String> sectorKeys, List<MFCompleteData> mfDataList, String dataVal) {
    	StringBuffer buffer = new StringBuffer();
    	for(String key : sectorKeys) {
    		buffer.append(getFormattedString(key));
    		
        	for(MFCompleteData compData : mfDataList) {
        		Map<String, EntityData> secData = null;
        		if(dataVal.equalsIgnoreCase(SECTOR_STRING)) {
        			secData = compData.getSectorData();
        		} else if(dataVal.equalsIgnoreCase(INVESTMENT_STRING)) {
        			secData = compData.getInvestmentsData();
        		}

        		String value = "0";
        		if(secData.containsKey(key)) {
        			value = String.valueOf(secData.get(key).getAllocPercentage());
        		}
        		buffer.append(getFormattedString(value));
        	}
        	System.out.println(buffer.toString());
        	buffer.delete(0, buffer.length());
    	}
    }
    
    private void displayResults(List<MFCompleteData> mfDataList) {

    	StringBuffer buffer = new StringBuffer();
		buffer.append(getEmptyString(displayLength));	
		Set<String> sectorKeys = new HashSet<String>();
		Set<String> investKeys = new HashSet<String>();
		
    	for(MFCompleteData compData : mfDataList) {
    		String format = getFormattedString(compData.getMfName());
    		buffer.append(format);
    		sectorKeys.addAll(compData.getSectorData().keySet());
    		investKeys.addAll(compData.getInvestmentsData().keySet());
    		
    	}
    	System.out.println(buffer.toString());
    	drawHorizontalLine(buffer.length());
    	System.out.println("\n\n" + getEmptyString((buffer.length()/2) - (SECTOR_STRING.length()/2))
    	+ SECTOR_STRING + getEmptyString((buffer.length()/2) - (SECTOR_STRING.length()/2)) + "\n\n");
    	printData(sectorKeys,mfDataList, SECTOR_STRING);
    	drawHorizontalLine(buffer.length());
    	System.out.println("\n\n" + getEmptyString((buffer.length()/2) - (INVESTMENT_STRING.length()/2))
    	+ INVESTMENT_STRING + getEmptyString((buffer.length()/2) - (INVESTMENT_STRING.length()/2)) + "\n\n");
    	printData(investKeys, mfDataList, INVESTMENT_STRING);
    }
    
}
