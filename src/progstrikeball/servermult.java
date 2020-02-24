/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progstrikeball;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author informatica
 */
public class servermult extends Thread {
	servermult server = null;
	Socket client = null;
	String stringRicevuta = null;
	String stringModificata = null;
	BufferedReader inDalClient;
	DataOutputStream outVersoClient;
	
	public servermult(Socket socket){
		this.client = socket;
	}
	@Override
	public void run(){
		try{
			comunica();
	}catch (Exception e){
		e.printStackTrace(System.out);
	}}

	private void comunica() throws Exception{
		inDalClient = new BufferedReader(new InputStreamReader (client.getInputStream()));
		outVersoClient = new DataOutputStream(client.getOutputStream());
		for (;;){
			stringRicevuta = inDalClient.readLine();
			if (stringRicevuta == null || stringRicevuta.equals("FINE")){
				outVersoClient.writeBytes(stringRicevuta+" (=>server in chiusura..)" + '\n');
				System.out.println("Echo sul server in chiusura :" + stringRicevuta);
				break;
			}else{
				outVersoClient.writeBytes(stringRicevuta+ "(ricevuta e ritrasmessa)"+ '\n');
				System.out.println("6 Echo sul server :" + stringRicevuta);
			}
			
		}
		outVersoClient.close();
		inDalClient.close();
		System.out.println("9 Chiusura socket" + client);
		client.close();
	}
}