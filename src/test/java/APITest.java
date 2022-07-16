import io.restassured.internal.util.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

public class APITest {
    @Test
    public void apiSimpleTest() {

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(new HttpGet("http://4pda.ru/"))
        ) {
            Assert.assertEquals(response.getStatusLine().getStatusCode(),200);
        } catch (Throwable cause) {
            cause.printStackTrace();
        }
    }

}
