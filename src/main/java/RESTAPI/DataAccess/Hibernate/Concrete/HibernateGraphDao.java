package RESTAPI.DataAccess.Hibernate.Concrete;

import RESTAPI.DataAccess.Hibernate.Abstract.IGraphicService;
import RESTAPI.Entity.Concrete.Log;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 26.03.2021
 */
@Repository
public class HibernateGraphDao implements IGraphicService {

    @Override
    public List<Log> readLogs(File file) {
//        List<Log> logs = new ArrayList<>();
//        try {
//            FileInputStream fstream = new FileInputStream(file);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//            String strLine;
//            /* read log line by line */
//            while ((strLine = br.readLine()) != null) {
//                /* parse strLine to obtain what you want */
//                System.out.println(strLine);
//            }
//            fstream.close();
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//        }

        return null;
    }
}
