package connection;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {

    private final String host = "localhost";
    private final int port = 27017;
    private final String dataBaseName = "login";
    private final String tableName = "user";

    private final String userName = "";
    private final String password = "";

    MongoClient mongoclient;
    MongoDatabase db;
    MongoCollection<Document> collection;


    public void mongoDBJDBC() {

        try {
            //创建连接
            mongoclient = new MongoClient(host, port);
            //建立连接到库
            db = mongoclient.getDatabase(dataBaseName);

            System.out.println("database connected successfully!");

            collection = db.getCollection(tableName);

            System.out.println("table connection successfully！");


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean checkinfo(Document target) {
        try {

            FindIterable<Document> findIterable = collection.find(target);
            MongoCursor<Document> mongoCursor = findIterable.iterator();

            if (mongoCursor.hasNext()) {
                /* System.out.println("zhaodaole");*/
                return true;
            } else {
                /* System.out.println("meizhaodao");*/
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void addLoginfo(Document target) {

        collection.insertOne(target);
        System.out.println("insert one user name successful!!");

    }

}
