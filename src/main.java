import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class main {
	static String XMLHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	static int Port = 22000;
	static String IP = "127.0.0.1";
	
	public static void main(String[] args) {
		SendMessage(XMLHead+"<request><requesttype>adduser</requesttype><username>anders1</username><publickey>ertewrtertwetw</publickey><request>");
		SendMessage(XMLHead+"<request><requesttype>adduser</requesttype><username>anders2</username><publickey>3twertewt34</publickey><request>");
		SendMessage(XMLHead+"<request><requesttype>adduser</requesttype><username>anders3</username><publickey>gjhgjfgghjj</publickey><request>");
		
		SendMessage(XMLHead+"<request><requesttype>getusers</requesttype><request>");
		
		SendMessage(XMLHead+"<request><requesttype>addmessage</requesttype><receiver>anders1</receiver><message>Hello1</message><request>");
		SendMessage(XMLHead+"<request><requesttype>addmessage</requesttype><receiver>anders1</receiver><message>Hello2</message><request>");
		SendMessage(XMLHead+"<request><requesttype>addmessage</requesttype><receiver>anders3</receiver><message>Hello3</message><request>");
		
		SendMessage(XMLHead+"<request><requesttype>getmessages</requesttype><receiver>anders1</receiver><request>");
		SendMessage(XMLHead+"<request><requesttype>getmessages</requesttype><receiver>anders3</receiver><request>");
	}
	
	private static void SendMessage(String string) {
		try {
			Socket s = new Socket(IP, Port);
			DataOutputStream DataOut = new DataOutputStream(s.getOutputStream());
			DataInputStream DataIn = new DataInputStream(s.getInputStream());
			System.out.println("Sending: "+string);
			DataOut.writeUTF(string);
			String response = DataIn.readUTF();
			System.out.println("Received: "+response);
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
