package sauvegarde;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.util.Vector;

import model.Assignement;


/*
 * cette classe permet de charger les informations sur les assignements sauvegardés
 */

public class ChargementAssignment {

	
	public static void load(Vector<Assignement> vector)
	{

		try {
			
			
			File f = new File("simulationProcessus");
			
			
			try {
				if (!f.exists())
				
					f.mkdirs();
				

			} catch (Exception e) {
			}
			FileInputStream fis = new FileInputStream("simulationProcessus/sauvegardeAssignement.dat");
		
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
		
			try {
				
				while (true) {
					try {
						
						Assignement ass = (Assignement) ois.readObject();
						vector.add(ass);
						

					} catch (ObjectStreamException ose) {
						return;
					} catch (ClassNotFoundException cnfe) {
						return;
					}
				}
			} catch (EOFException eof) {
			}
			ois.close();
			fis.close();

		} catch (Exception ex) {
			return;
		}
		
		

	}
}
