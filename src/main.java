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
		SendMessage(XMLHead+"<request><requesttype>setmessage</requesttype><receiver>anders</receiver><message>Hello1</message><request>");
		SendMessage(XMLHead+"<request><requesttype>setmessage</requesttype><receiver>anders</receiver><message>Hello2</message><request>");
		SendMessage(XMLHead+"<request><requesttype>setmessage</requesttype><receiver>anders</receiver><message>Hello3</message><request>");
		SendMessage(XMLHead+"<request><requesttype>getmessages</requesttype><receiver>anders</receiver><request>");
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
