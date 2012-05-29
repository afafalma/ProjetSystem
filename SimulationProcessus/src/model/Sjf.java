/**
 * 
 */
package model;

import model.Processus;

/**
 * @author dienaba
 *
 */

// Algo : plus court d'abord 

public class Sjf extends Algo_lot {

	/**
	 * 
	 */
	public Sjf() {
		super();
	}

	public Sjf(int num, String nom) {
		super(num, nom);

	}

	//Methode pour la recherche des Process suceptible d'être executé
	private   ListProcessus Not_Yet_1(ListProcessus L1,int t){
		ListProcessus L =new ListProcessus();
		boolean No_Process=true;
		for(int i=0;i<L1.size();i++){
			if((t<((Processus)L1.get(i)).getT_arrive()) && (((Processus)L1.get(i)).isStat()==false)){
				L.add((Processus)L1.get(i));
			}
		}
		return L;
	}



	//Methode pour la recherche du T_Arrivé minimun parmis les Processus de la liste
	// a voir si modifier 
	private   Processus MinT_1(ListProcessus Vv1){
		Processus P_return_1=new Processus();
		if(Vv1.isEmpty()==false){
			int index=0;
			int min=((Processus)(Vv1.get(0))).getT_arrive();
			for(int i=0;i<Vv1.size();i++){
				if(min>((Processus)Vv1.get(i)).getT_arrive()){
					index=i;
					min=((Processus)Vv1.get(i)).getT_arrive();
				}
			}
			P_return_1=(Processus)Vv1.get(index);
		}
		return P_return_1;
	}




	//Methode pour la recherche des Processus suceptible d'être executé
	private   ListProcessus To_Do_1(ListProcessus L1,int t){
		ListProcessus L=new ListProcessus();
		boolean No_Process=true;
		for(int i=0;i<L1.size();i++){
			if((t>=((Processus)L1.get(i)).getT_arrive()) && (((Processus)L1.get(i)).isStat()==false)){
				No_Process=false;
				L.add((Processus)L1.get(i));
			}
		}
		if(No_Process){
			L.add(MinT_1(Not_Yet_1(L1,t)));
		}
		return L;
	}

	/*public  int minimum (int [] tab){
		int min= tab [0];

		for (int i=0; i<tab.length; i++){
			if(min> tab[i+1])
				min = tab[i+1];
		}
		return min ;
	}*/


	//Methode pour la recherche du Processus "P" a exectué a l'instant "t" a partir de la liste "V" SJF
	// a modifier pr avoir le tems de chaque liste d'actions de chaque processus pr pouvoir comparer
	public Processus SJF (ListProcessus V){

		Processus SJF = V.getProcessus(0);
		int total_duree = 0;
		int[] tab = null;
		int min = 0;
		//	int min = tab[0];

		for(int i=0; i< V.size(); i++){ // parcours la liste des processus
			int taille = V.getProcessus(i).getListAction().size(); 

			for (int j=0; j<taille; j++){// parcours la liste des actions
				int aux = V.getProcessus(i).getListAction().getAction(j).getDuree();
				total_duree = total_duree + aux;
			}
			tab[i]=total_duree;
		}

		min=tab[0];
		for(int k=0; k<tab.length;k++){
			if (min>tab[k+1]){
				min= tab[k+1];
				SJF = V.getProcessus(k);
			}
		}

		return SJF;

		//	SJF = V.getProcessus(i);
		/* int SJ=((Processus)V.get(0)).getT_arrive();
			    int index=0;
			    for(int i=0;i<V.size();i++){
			      if(((Processus)V.get(i)).getT_arrive()<=SJ){
			        index=i;
			        SJ=((Processus)V.get(i)).getT_arrive();
			      }
			    }
			    return ((Processus)V.get(index));
			  }*/
	}


	//Methode de verification pour la mise a jour de T_now
	private   int Time_Now_1(Processus P1,int t){
		int tn=t;
		if(P1.getT_arrive()>tn) 
			tn=P1.getT_arrive();

		return tn;
	}



	@Override
	public ListEvent simulation(Assignement Ass) {
		int length=Ass.getListProcess().size();//Longueur de la liste contenant tous les Processus
		ListProcessus L_Ok=new ListProcessus();//Liste dans laquelle on va stocké dans l'ordre les processus traiter
		int t_now=0;
		for(int i=0;i<length;i++){

			ListProcessus L_To_Do = new ListProcessus();
			Processus SJF_P=new Processus();
			//Choix des Processus suceptible d'etre executé
			L_To_Do=To_Do_1(Ass.getListProcess(),t_now);
			//Choix du Processus a executer
			SJF_P=SJF(L_To_Do);
			Ass.getAlgo().getListEv().addEvent("attente", SJF_P, t_now);
			t_now=Time_Now_1(SJF_P,t_now);
			SJF_P.setInstantDemarage(t_now);
			Ass.getAlgo().getListEv().addEvent("pret", SJF_P, t_now);
			//Mise à jour du temps actuel
			t_now=t_now+SJF_P.getTempsVie();
			//Mise à jour du Processus SJF_P
			SJF_P.setFin(t_now);
			SJF_P.setStat(true);
			Ass.getAlgo().getListEv().addEvent("éxécuté", SJF_P, t_now);
			//Mise à jour de la liste V_Total
			int index;
			index=SJF_P.getID();
			Ass.getListProcess().add(SJF_P);
			//Mise à jour de la liste V_Ok
			L_Ok.add(SJF_P);
		}
		return Ass.getAlgo().getListEv();
	}	

}
