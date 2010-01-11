import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Connexion {

	private String host;
	private int port;
	private Socket sock;
	
	private BufferedReader socketReader;
	private PrintWriter socketWriter;
	
	private static final String DEFAULT_HOST = "localhost";
	private static final int DEFAULT_PORT = 10000;
	
	public Connexion()
	{
		this(DEFAULT_HOST, DEFAULT_PORT);
	}
	
	public Connexion(String host)
	{
		if(host.contains(":")) {
			StringTokenizer st = new StringTokenizer(host, ":");
			this.host = st.nextToken();
			this.port = Integer.parseInt(st.nextToken());
		} else {
			this.host = host;
			this.port = DEFAULT_PORT;
		}
	}
	
	public Connexion(String host, int port)
	{
		this(host + ":" + Integer.toString(port));
	}

	public void Connect() throws UnknownHostException, IOException
	{
		this.sock = new Socket(host, port);
		this.socketReader = new BufferedReader(
				new InputStreamReader(this.sock.getInputStream()));
		this.socketWriter = new PrintWriter(
				new OutputStreamWriter(this.sock.getOutputStream()), true);
		System.out.println(socketReader.readLine());

	}
	
	public void SendGet()
	{
		System.out.println("SEND GET!");
		socketWriter.println("GET");
	}
	
	public String listen()
	{
		String returnValue = "";
		try {
			while((returnValue = socketReader.readLine()) == "commande>");
			System.out.println("returnValue: " + returnValue);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		
		return returnValue;		
	}
	
	public void EndConnection()
	{
		
		socketWriter.write("END");
		try {
			sock.close();
			socketReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		socketWriter.close();
	}
	
}
