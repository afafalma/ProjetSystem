package sauvegarde;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;
import model.Assignement;


/*
 * cette classe permet de sauvegarder un assignment
 */
public class SauvegardeAssignment
{
	
	public static void save(Vector<Assignement> vector) {

	
	try {
		FileOutputStream fos = new FileOutputStream("simulationProcessus/sauvegardeAssignement.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		try {
			
			for (Assignement ass : vector) {
				
				oos.writeObject(ass);
			}
			
			oos.flush();
		}

		catch (IOException ioe) {
		} finally {
			oos.close();

			fos.close();
		
		}
	} catch (Exception ex) {
	}
	}
}

