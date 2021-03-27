package RESTAPI.DataAccess.Hibernate.Concrete;

import RESTAPI.DataAccess.Hibernate.Abstract.IGraphicService;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 */
@Repository
public class HibernateGraphDao implements IGraphicService {

    @Override
    public List<Log> readLogs(File file) {
        try {
            List<Log> logs = new ArrayList<>();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currentTime = new Date(System.currentTimeMillis());

            int start = 1;
            int end = 19;
            while ((line = br.readLine()) != null) {
//                parse line to obtain what you want

                Date lineDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(line.substring(1, 19));
                Date diff = new Date(currentTime.getTime() - lineDate.getTime());
                // TODO deprecated, find latest
                if (diff.getMinutes() < 60) {
                    // TODO set method space for writing method names in log file like 6 or 7 spaces
                    // TODO get substrings in log file and create new logs from it,later save it into logs arraylist
                    // and sketch the graph from it
//                    Log newLog = new Log(line.substring(22, 27),)
//                    logs.add()
                }
            }
            fileInputStream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return null;
    }
}
