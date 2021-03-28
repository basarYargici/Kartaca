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
 */
@Repository
public class HibernateGraphDao implements IGraphicDao {

    enum Method {
        GET, POST, DELETE
    }

    @Override
    public List<List<Log>> readLogs(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            Date currentTime = new Date(System.currentTimeMillis());

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

                // subtraction gives second and dividing it with 1000 gives seconds, 60 minutes
                diff = Math.abs(currentTime.getTime() - lineDate.getTime()) / (1000 * 60);

                if (diff < 60) {
                    Log newLog = new Log(line.substring(methodStartIndex, methodEndIndex),
                            line.substring(timeTakenStartIndex, timeTakenEndIndex),
                            line.substring(timestampStartIndex, timestampEndIndex));
                    if (newLog.getMethod().trim().equals(Method.GET.toString())) {
                        getLogs.add(newLog);
                    } else if (newLog.getMethod().trim().equals(Method.POST.toString())) {
                        postLogs.add(newLog);
                    } else if (newLog.getMethod().trim().equals(Method.DELETE.toString())) {
                        deleteLogs.add(newLog);
                    }
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
}
