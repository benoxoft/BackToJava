import java.awt.Graphics;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;

public class BackToJava extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connexion conn = new Connexion();
			conn.Connect();
			FilConnexion fil = new FilConnexion(conn);
			fil.start();
			for(int i=0;i<5;i++){
				conn.SendGet();
				System.out.println("GET SENT!");
				Thread.sleep(500);				
			}
			fil.interrupt();
			conn.EndConnection();
			System.out.println("FINI!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//new BackToJava();
 catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public BackToJava()
	{
		super();
		build();
	}
	
	private void build()
	{
		this.setTitle("Back To Java!");
		this.setVisible(true);
		this.setSize(320, 240);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
}
