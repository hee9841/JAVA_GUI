/* Java 샘플 코드 */


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/getPEList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=dMKKGpyzoaDNAdzXY3sVmylumUKr0YfRc09yUw%2BdnhdoYQjp2SjxJTb2sioHcc8kVlC3vgyY4VfAg%2B%2B7s3cA3Q%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("dMKKGpyzoaDNAdzXY3sVmylumUKr0YfRc09yUw%2BdnhdoYQjp2SjxJTb2sioHcc8kVlC3vgyY4VfAg%2B%2B7s3cA3Q%3D%3D", "UTF-8")); /*발급받은 인증키*/
       
        // urlBuilder.append("&_type=json"); 주석 해제 시 json 형식으로 받아옴, 기본 XML 형식
      
       URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    
    }
}
