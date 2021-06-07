package main;

import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Objects;

public class JavaSE {

    // java -jar /tmp/simple-tests-1.0-SNAPSHOT-jar-with-dependencies.jar
    public static void main(String[] args) {
        // testHostName();
        String from = "OnLand";
        System.out.println((from.contains("OnLand")) ? "yes" : "no");
        URLEncoder.encode("null");

    }

    private static void testHostName() {
        String hostName = "MSS";
        String result = ((hostName.toLowerCase().contains("mrk") || hostName.toLowerCase().contains("mss")) ? hostName : "localhost");
        System.out.println(result);
        String host = System.getenv("HOSTNAME");
        System.out.println(Objects.nonNull(host) ? host : "localhost");
        System.out.println(getHostName());
    }

    private static String getHostName()  {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "localhost";
    }


}
