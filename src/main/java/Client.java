import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int port = 8989;
        String host = "localhost";

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("бизнес");
            final String response = in.readLine();
            String responseJson = prettyOutput(response);
            System.out.print(responseJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String prettyOutput(String output) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(output);
        return gson.toJson(je);
    }
}
