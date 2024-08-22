import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import com.couchbase.spark.sql.CouchbaseSparkSession;
import static com.couchbase.spark.sql.DefaultSource.*;

public class CouchbaseSparkConnector {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
            .appName("CouchbaseSparkConnector")
            .master("local[*]")
            .config("spark.couchbase.connectionString", "couchbase://localhost")
            .config("spark.couchbase.username", "username")
            .config("spark.couchbase.password", "password")
            .config("spark.couchbase.bucket.your_bucket_name", "")
            .getOrCreate();

        Dataset<String> couchbaseData = spark.read()
            .format("couchbase")
            .option("bucket", "your_bucket_name")
            .option("scope", "your_scope_name")
            .option("collection", "your_collection_name")
            .load();

        couchbaseData.show();
        
        spark.stop();
    }
}
