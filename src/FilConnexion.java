
public class FilConnexion extends Thread {

	private Connexion connexion;
	
	public FilConnexion(Connexion conn)
	{
		connexion = conn;
	}
	
	@Override
	public void run() {
		while(!isInterrupted()){
			System.out.println(connexion.listen());
		}

	}

	
}
