package RESTAPI.DataAccess.Hibernate.Concrete;

import RESTAPI.DataAccess.Hibernate.Abstract.IGraphicDao;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 * <p>
 * This class will access the Log file to get last hour's logs.
 */
@Repository
public class HibernateGraphDao implements IGraphicDao {

    /**
     * This method reads all logs from given file.
     *
     * @param file is a file which will be read
     * @return List of List of Log whose are get, post and delete Logs
     */
    @Override
    public List<List<Log>> readLogs(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            Date currentTime = new Date(System.currentTimeMillis());
            String line;

            List<List<Log>> logs;
            List<Log> getLogs = new ArrayList<>();
            List<Log> postLogs = new ArrayList<>();
            List<Log> deleteLogs = new ArrayList<>();

            Date lineDate;
            long diff;
            int dateStartIndex = 1, dateEndIndex = 19, methodStartIndex = 22, methodEndIndex = 32, timeTakenStartIndex = 33,
                    timeTakenEndIndex = 43, timestampStartIndex = 44, timestampEndIndex = 54;

            while ((line = br.readLine()) != null) {
                // parse line to obtain what you want
                lineDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(line.substring(dateStartIndex, dateEndIndex));

                // subtraction gives millisecond and dividing it with 1000 gives seconds, 60 minutes
                diff = Math.abs(currentTime.getTime() - lineDate.getTime()) / (1000 * 60);

                // Only recording the last hour's logs
                if (diff < 60) {
                    Log newLog = new Log(lineDate,
                            line.substring(methodStartIndex, methodEndIndex),
                            line.substring(timeTakenStartIndex, timeTakenEndIndex),
                            line.substring(timestampStartIndex, timestampEndIndex));

                    if (newLog.getMethod().trim().equals(Method.GET.toString())) getLogs.add(newLog);
                    else if (newLog.getMethod().trim().equals(Method.POST.toString())) postLogs.add(newLog);
                    else if (newLog.getMethod().trim().equals(Method.DELETE.toString())) deleteLogs.add(newLog);

                }
            }
            fileInputStream.close();

            logs = Arrays.asList(getLogs, postLogs, deleteLogs);

            return logs;

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return null;
    }

    /**
     * Method types
     */
    enum Method {
        GET, POST, DELETE
    }
}
