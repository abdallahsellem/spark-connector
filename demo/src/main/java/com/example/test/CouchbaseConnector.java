import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;

public class CouchbaseConnector {
    public static void main(String[] args) {
        Cluster cluster = Cluster.connect("couchbase://localhost", "username", "password");
        Collection collection = cluster.bucket("your_bucket_name").scope("your_scope_name").collection("your_collection_name");

        // Example query
        GetResult getResult = collection.get("document_id");
        System.out.println(getResult.contentAsObject());
        
        cluster.disconnect();
    }
}
