/* Java 샘플 코드 */


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Cdata {
 
      public String getdata(String geturl) throws IOException, Exception {// url을 받아서 api데이터 가져옴

        StringBuilder urlBuilder = new StringBuilder(geturl);
        
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=dMKKGpyzoaDNAdzXY3sVmylumUKr0YfRc09yUw%2BdnhdoYQjp2SjxJTb2sioHcc8kVlC3vgyY4VfAg%2B%2B7s3cA3Q%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("dMKKGpyzoaDNAdzXY3sVmylumUKr0YfRc09yUw%2BdnhdoYQjp2SjxJTb2sioHcc8kVlC3vgyY4VfAg%2B%2B7s3cA3Q%3D%3D", "UTF-8")); /*발급받은 인증키*/
       
        urlBuilder.append("&_type=json"); //주석 해제 시 json 형식으로 받아옴, 기본 XML 형식
      
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        

        JSONParser jp = new JSONParser();            
        JSONObject jo = (JSONObject) jp.parse(rd);//받아온 데이터를 json형식으로 변환

        rd.close();
        
        conn.disconnect();

      return jo.toString();
    }
    
}
