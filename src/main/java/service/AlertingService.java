package service;

import config.Configurations;
import config.TimeDuration;
import lombok.Data;
import model.LogData;

import java.sql.Timestamp;
import java.util.*;

@Data
public class AlertingService {

    NotificationSevice notificationSevice = new NotificationSevice();

    public void triggerAlerts() {
        // read input data
        List<String> inputList = readInputData(new MyFileReader(new TextFileParser()));
        // Read config
        Configurations configurations = readConfigurations(new MyFileReader(new YmlFileParser()));

        if (inputList.isEmpty() || configurations == null) System.out.print("No alters to trigger");

        // populate Logd Type to Logdata Map
        Map<String, TreeSet<LogData>> logDataMap = populateLogsDetailsmap(inputList);
        System.out.print(logDataMap);

        triggerAllElgibleAlerts(logDataMap, configurations);

    }


    private void triggerAllElgibleAlerts(Map<String, TreeSet<LogData>> logDataMap, Configurations configurations) {

        for (Map.Entry<String, TreeSet<LogData>> entry : logDataMap.entrySet()) {
            int frequency = 0;
            TimeDuration timeDuration = configurations.getAlerttimeconfigmap().get(entry.getKey());
            if(entry.getValue().size() > timeDuration.getFrequency()) {

                int sec = 0;
                for (LogData logData : entry.getValue()) {
                    int currentDiff = logData.getTimestamp().getSeconds() - sec;
                }
            }
        }
    }

    private Map<String, TreeSet<LogData>> populateLogsDetailsmap(List<String> inputList) {
        Map<String, TreeSet<LogData>> logDataMap = new HashMap<String, TreeSet<LogData>>();
        TreeSet set;
        for (String input : inputList) {
            String[] logArr = input.split(" ");
            if (logArr.length > 3) {
                LogData logData = new LogData(Timestamp.valueOf(logArr[0] + " " + logArr[1]), logArr[3]);
                if (!logDataMap.containsKey(logArr[2])) {
                    set = new TreeSet<LogData>();
                    set.add(logData);
                    logDataMap.put(logArr[2], set);
                } else {
                    set = logDataMap.get(logArr[2]);
                    set.add(logData);
                    logDataMap.put(logArr[2], set);
                }
            }

        }
        return logDataMap;
    }

    private Configurations readConfigurations(MyFileReader myFileReader) {
        Configurations configurations = null;
        try {
            configurations = myFileReader.readYmlFile("application.yml");
        } catch (Exception e) {
            System.err.print("Unable to read yml file");
        }
        return configurations;
    }

    private List<String> readInputData(MyFileReader myFileReader) {
        List<String> inputList = new ArrayList<String>();
        try {
            inputList = myFileReader.readTextFile("input-file.txt");
        } catch (Exception e) {
            System.err.print("Unable to read input file");
        }
        return inputList;
    }
}
