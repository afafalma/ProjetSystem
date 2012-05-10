package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("rawtypes")
public class ListAlgorithme implements Map{

	
	public static int ID;
	
	
	public enum type {
		LOT, ITERATIF;
		public String toString(){
			switch (this){
				case LOT : return "traitement par lot";
				case ITERATIF : return "traitement itératif";
			default: return "";
			}
		}
	}
	
	private Map<type,ArrayList<Algorithme>> listAlgo;
	
	public ListAlgorithme(){
		listAlgo = new TreeMap<type, ArrayList<Algorithme>>();
	}
	
	/**
	 * @return the iD
	 */
	public static int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public static void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the listAlgorithmes
	 */
	public Map<type, ArrayList<Algorithme>> getListAlgo() {
		return listAlgo;
	}

	/**
	 * @param listAlgorithmes the listAlgorithmes to set
	 */
	public void setListAlgorithmes(Map<type, ArrayList<Algorithme>> listAlgo) {
		this.listAlgo = listAlgo;
	}
	 /********************************************************************/
	
	
	public void ajoutAlgo(Algorithme a){
		Algorithme nouvelle = a;
		type t = nouvelle.getT();
		ArrayList<Algorithme> l;
		
		if(listAlgo.containsKey(t)){
			l=listAlgo.get(t);
		}else{
			l=new ArrayList<Algorithme>();
		}
		nouvelle.setNum(ID);
		l.add(nouvelle);
		listAlgo.put(t, l);
		ID++;
	}
	
	public Algorithme getAlgorithme(int id){
		Algorithme Algorithme = null;
		Collection<ArrayList<Algorithme>> a = listAlgo.values();
		Iterator<ArrayList<Algorithme>> i = a.iterator();
		
		while(i.hasNext()){
			ArrayList<Algorithme> l = i.next();
			for(Algorithme aa : l){
				if(aa.getNum()==id){
					Algorithme=aa;
				}
			}
		}
		return Algorithme;
	}
	
	
	public ArrayList<Algorithme> getAlgorithme(type t){
		return this.listAlgo.get(t);
	}
	
	public void setListAlgorithme(Map<type, ArrayList<Algorithme>> l){
		listAlgo = l;
	}
	
	/**
	 * retourne les types d'Algorithmes presents dans la liste des Algorithmes
	 */
	public type[] getTypeAlgorithmeUtilises(){
		Set<type> s = listAlgo.keySet();
		Iterator<type> i = s.iterator();
		
		type[] t = new type[s.size()];
		int j=0;
		while (i.hasNext()){
			t[j] = i.next();
			j++;
		}
		return t;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String sortie = "";
		Set<type> s = listAlgo.keySet();
		Iterator<type> i = s.iterator();
		
		while (i.hasNext()) {
			type t = i.next();
			ArrayList<Algorithme> l = listAlgo.get(t);
			
			String a = "";
			for(Algorithme algo : l) {
				a+=algo + "\n";
			
			}
			sortie+= "======" + t + "======\n\n" + a + "\n\n";
		}
				return sortie;
	}
	
	/*********************************************************************/
	/************SURCHARGE DES METHODES DE LA MAP*************************/

	@Override
	public void clear() {
		listAlgo.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return listAlgo.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return listAlgo.containsKey(value);
	}

	@Override
	public Set<?> entrySet() {
		return listAlgo.entrySet();
	}

	@Override
	public Object get(Object key) {
		return listAlgo.get(key);
	}

	@Override
	public boolean isEmpty() {
		return listAlgo.isEmpty();
	}

	@Override
	public Set<?> keySet() {
		return listAlgo.keySet();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		ArrayList<Algorithme> previous = null;
		if (listAlgo.containsKey(key)){
			previous=listAlgo.get(key);
		}
		listAlgo.put( (type)key, (ArrayList<Algorithme>)value);
		return previous;
	}

	@SuppressWarnings("all")
	@Override
	public void putAll(Map m) {
		listAlgo = m;
	}

	@Override
	public Object remove(Object key) {
		ArrayList<Algorithme> previous = null;
		
		if(listAlgo.containsKey(key)){
			previous=listAlgo.get(key);
			listAlgo.remove((type)key);
		}
		
		return previous;
	}

	@Override
	public int size() {
		return listAlgo.keySet().size();
	}

	@Override
	public Collection<ArrayList<Algorithme>> values() {
		return listAlgo.values();
	}
	
	/*********************************************************************/
	/*********************************************************************/
	
}
