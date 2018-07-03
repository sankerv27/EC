package elss.extractor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import elss.pojo.MFCompleteData;
import elss.pojo.EntityData;

public class MFDataExtractor {
	
	private String getMFNameFromFile(String filePath) {
		if(filePath != null) {
			String[] chunks = filePath.split("/");
			return chunks[chunks.length - 1];
		}
		throw new IllegalArgumentException("Illegal filePath :: " + filePath);
	}
	
	private double convertStringToDouble(String value) {
		double val = 0;
		try {
			val = Double.parseDouble(value.trim());
		} catch(NumberFormatException e) {
//			e.printStackTrace();
		}
		return val;
	}

	private List<EntityData> getSectorAllocationDataList(String filePath) {
        BufferedReader br = null;
        String line = "";
        List<EntityData> dataList = new ArrayList<EntityData>();
        try {

            br = new BufferedReader(new FileReader(filePath));
            int count = 0;
            EntityData mfData = null;
            while ((line = br.readLine()) != null) {
            	switch(count % 4) {
            		case 0 :
            					mfData = new EntityData();
            					mfData.setName(line.trim());
            					break;
            		
            		case 2 :
            					if(!line.contains("--")) {
            						//skipping next two lines
            						br.readLine();
            						count = -1;
            					} else  {
            						mfData.setQuantity(0);
            					}
            					break;
            					
            		case 1 :
            					double value = convertStringToDouble(line);
            					mfData.setValue(value);
            					break;
            					
            		case 3 :
            					double percentage = convertStringToDouble(line);
            					mfData.setAllocPercentage(percentage);
            					dataList.add(mfData);
            	}
            	count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataList;
	}
	
	
	private Map<String,EntityData> getSectorAllocationDataMap(String filePath) {
        BufferedReader br = null;
        String line = "";
        Map<String,EntityData> dataMap = new HashMap<String, EntityData>();
        try {

            br = new BufferedReader(new FileReader(filePath));
            int count = 0;
            EntityData mfData = null;
            while ((line = br.readLine()) != null) {
            	switch(count % 4) {
            		case 0 :
            					mfData = new EntityData();
            					mfData.setName(line.trim());
            					break;
            		
            		case 2 :
            					if(!line.contains("--")) {
            						//skipping next two lines
            						br.readLine();
            						count = -1;
            					} else  {
            						mfData.setQuantity(0);
            					}
            					break;
            					
            		case 1 :
            					double value = convertStringToDouble(line);
            					mfData.setValue(value);
            					break;
            					
            		case 3 :
            					double percentage = convertStringToDouble(line);
            					mfData.setAllocPercentage(percentage);
            					dataMap.put(mfData.getName(),mfData);
            	}
            	count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataMap;
	}
	
	private List<EntityData> getInvestmentsDataList(String filePath) {
        BufferedReader br = null;
        String line = "";
        List<EntityData> dataList = new ArrayList<EntityData>();
        try {

            br = new BufferedReader(new FileReader(filePath));
            int count = 0;
            EntityData mfData = null;
            while ((line = br.readLine()) != null) {
            	switch(count % 4) {
            		case 0 :
            					mfData = new EntityData();
            					mfData.setName(line.trim());
            					break;
            		
            		case 2 :
            			
		    					if(line.contains("--")) {
		    						//skipping next two lines
		    						br.readLine();
		    						count = -1;
		    					} else  {
	    							double quantity = convertStringToDouble(line);
	    							mfData.setQuantity(quantity);
		    					}
		    					break;            					
            		case 1 :
            					double value = convertStringToDouble(line);
            					mfData.setValue(value);
            					break;
            					
            		case 3 :
            					double percentage = convertStringToDouble(line);
            					mfData.setAllocPercentage(percentage);
            					dataList.add(mfData);
            					break;
            	}
            	count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataList;
	}
	
	private Map<String,EntityData> getInvestmentsDataMap(String filePath) {
        BufferedReader br = null;
        String line = "";
        Map<String,EntityData> dataMap = new HashMap<String, EntityData>();
        try {

            br = new BufferedReader(new FileReader(filePath));
            int count = 0;
            EntityData mfData = null;
            while ((line = br.readLine()) != null) {
            	switch(count % 4) {
            		case 0 :
            					mfData = new EntityData();
            					mfData.setName(line.trim());
            					break;
            		
            		case 2 :
            			
		    					if(line.contains("--")) {
		    						//skipping next two lines
		    						br.readLine();
		    						count = -1;
		    					} else  {
	    							double quantity = convertStringToDouble(line);
	    							mfData.setQuantity(quantity);
		    					}
		    					break;            					
            		case 1 :
            					double value = convertStringToDouble(line);
            					mfData.setValue(value);
            					break;
            					
            		case 3 :
            					double percentage = convertStringToDouble(line);
            					mfData.setAllocPercentage(percentage);
            					dataMap.put(mfData.getName(), mfData);
            					break;
            	}
            	count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataMap;
	}
	
	private MFCompleteData getMFCompleteData(String filePath) {
		MFCompleteData completeData = new MFCompleteData();
		String mfName = getMFNameFromFile(filePath);
		completeData.setMfName(mfName);
		
		Map<String,EntityData> sectorData = getSectorAllocationDataMap(filePath);
		completeData.setSectorData(sectorData);
		
		Map<String,EntityData> investmentsData = getInvestmentsDataMap(filePath);
		completeData.setInvestmentsData(investmentsData);
		
		return completeData;
		
	}
	
	public List<MFCompleteData> readFilesFromFolder(final File folder) {

		Map<String,String> uploadPendingMap = new TreeMap<String, String>();
		List<MFCompleteData> mfCompleteDataList = new ArrayList<MFCompleteData>();
		String launchFilePath = null;

		for (File fileEntry : folder.listFiles()) {
			if(!(fileEntry.isHidden())) {
				if(!uploadPendingMap.containsKey(fileEntry.getName())) {
					launchFilePath = fileEntry.getAbsolutePath();
					MFCompleteData mfCompleteData = getMFCompleteData(launchFilePath);
					mfCompleteDataList.add(mfCompleteData);
					
				}
			}
		}
		
		return mfCompleteDataList;
	}
	
}
