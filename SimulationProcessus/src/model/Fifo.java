/**
 * 
 */
package model;


import model.Processus;

/**
 * @author dienaba
 *
 */
public class Fifo extends Algo_lot {

	/**
	 * 
	 */
	public Fifo() {
		super();
	}


	//Methode pour la recherche des Process suceptible d'être executé
	private   ListProcessus Not_Yet_1(ListProcessus L1,int t){
		ListProcessus L =new ListProcessus();
		boolean No_Process=true;
		for(int i=0;i<L1.size();i++){
			if((t<((Processus)L1.get(i)).getInstantDemarage()) && (((Processus)L1.get(i)).isStat()==false)){
				L.add((Processus)L1.get(i));
			}
		}
		return L;
	}



	//Methode pour la recherche du T_Arrivé minimun parmis les Processus de la liste
	//a voir si modifer
	private   Processus MinT_1(ListProcessus Vv1){
		Processus P_return_1=new Processus();
		if(Vv1.isEmpty()==false){
			int index=0;
			int min=((Processus)(Vv1.get(0))).getID();
			for(int i=0;i<Vv1.size();i++){
				if(min>((Processus)Vv1.get(i)).getID()){
					index=i;
					min=((Processus)Vv1.get(i)).getID();
				}
			}
			P_return_1=(Processus)Vv1.get(index);
		}
		return P_return_1;
	}




	//Methode pour la recherche des Process suceptible d'être executé
	private   ListProcessus To_Do_1(ListProcessus L1,int t){
		ListProcessus L=new ListProcessus();
		boolean No_Process=true;
		for(int i=0;i<L1.size();i++){
			if((t>=((Processus)L1.get(i)).getInstantDemarage()) && (((Processus)L1.get(i)).isStat()==false)){
				No_Process=false;
				L.add((Processus)L1.get(i));
			}
		}
		if(No_Process){
			L.add(MinT_1(Not_Yet_1(L1,t)));
		}
		return L;
	}



	//Methode pour la recherche du Processus "P" a exectué a l'instant "t" a partir de la liste "V" FIFO
	private   Processus FIFO(ListProcessus Vv1){
		int F=((Processus)Vv1.get(0)).getInstantDemarage();
		int index=0;
		for(int i=0;i<Vv1.size();i++){
			if(((Processus)Vv1.get(i)).getInstantDemarage()<=F){
				index=i;
				F=((Processus)Vv1.get(i)).getInstantDemarage();
			}
		}
		return ((Processus)Vv1.get(index));
	}

	//Methode de verification pour la mise a jour de T_now
	private   int Time_Now_1(Processus P1,int t){
		int tn=t;
		//if(P1.getInstantDemarage()>tn)
		//tn=P1.getInstantDemarage();
		if(P1.getT_arrive()>tn)
			tn=P1.getT_arrive();
		return tn;
	}  



	@Override
	public ListEvent simulation(Assignement Ass) {
		int length=Ass.getListProcess().size();//Longueur de la liste contenant tous les Processus
		ListProcessus L_Ok_1=new ListProcessus();//Liste dans laquelle on va stocké dans l'ordre les processus traiter
		int t_now_1=0;
		for(int i=0;i<length;i++){
			ListProcessus L_To_Do_1=new ListProcessus();
			Processus FIFO_P=new Processus();	
			//Choix des Processus suceptible d'etre executé
			L_To_Do_1=To_Do_1(Ass.getListProcess(),t_now_1);
			//Choix du Processus a executer
			FIFO_P=FIFO(L_To_Do_1);
			Ass.getAlgo().getListEv().addEvent("attente", FIFO_P, t_now_1);
			//System.out.println(FIFO_P.getLabel_P());
			t_now_1=Time_Now_1(FIFO_P,t_now_1);
			FIFO_P.setInstantDemarage(t_now_1);
			Ass.getAlgo().getListEv().addEvent("pret",FIFO_P,t_now_1);
			//Mise à jour du temps actuel
			t_now_1=t_now_1+FIFO_P.getTempsVie();
			//Mise à jour du Processus SJF_P
			FIFO_P.setFin(t_now_1);
			FIFO_P.setStat(true);
			Ass.getAlgo().getListEv().addEvent("éxécuté", FIFO_P, t_now_1);
			//Mise à jour de la liste L_Total
			int index; 
			index=FIFO_P.getID();
			// V_Total_1.add(index,FIFO_P);
			Ass.getListProcess().add(FIFO_P);
			//Mise à jour la liste L_Ok
			L_Ok_1.add(FIFO_P);
		}
		return Ass.getAlgo().getListEv();
	}

}
