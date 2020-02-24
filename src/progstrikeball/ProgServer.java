package progstrikeball;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class ProgServer {
	public void start(){
		try{
			ServerSocket serverSocket = new ServerSocket(2000);
			for (;;){
				System.out.println("Server in attesa...");
				Socket socket = serverSocket.accept();
				System.out.println("3 Server socket"+ socket);
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
			}
		}
		catch (Exception e){
		System.out.println(e.getMessage());
		System.out.println("Errore istanza server");
		System.exit(1);
		}}
	
	}
