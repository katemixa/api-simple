import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.junit.Test;

public class APITest {
    @Test
    public void apiSimpleTest() {
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(new HttpGet("http://4pda.ru/"))
        ) {
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String data = IOUtils.toString(entity.getContent(), "cp1251");
                System.out.println("Data: " + data);
            }
            for (Header header : response.getAllHeaders()) {
                System.out.println(header.getName() + " : " + header.getValue());
            }

            System.out.println("Protocol version: " + response.getProtocolVersion());
            System.out.println("Status code: " + response.getStatusLine().getStatusCode());
            System.out.println("Reason phrase: " + response.getStatusLine().getReasonPhrase());
            System.out.println("Status line: " + response.getStatusLine().toString());
        } catch (Throwable cause) {
            cause.printStackTrace();
        }
    }

}
