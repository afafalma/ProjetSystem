/**
 * 
 */
package model;

/**
 * @author dienaba
 *
 */
public class MoreF extends Algo_lot {

	/**
	 * 
	 */
	public MoreF() {
		super();
	}

	public MoreF(int num, String nom) {
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


	//Methode pour la recherche du Processus "P" a exectué a l'instant "t" a partir de la liste "V" MoreF
	// a modifier pr avoir le tems de chaque liste d'actions de chaque processus pr pouvoir comparer
	public   Processus MF(ListProcessus V){
		Processus MF = V.getProcessus(0);
		int [] tab = null;
		int time_last = 0;
		int min = 0;
		
		for(int i=0; i< V.size(); i++){ // parcours la liste des processus
			int taille = V.getProcessus(i).getListAction().size(); 

			for (int j=0; j<taille; j++){// parcours la liste des actions
				Boolean act = V.getProcessus(i).getListAction().getAction(j).isExec();
				if (!act) {
					int aux = V.getProcessus(i).getListAction().getAction(j).getDuree();
					time_last = time_last + aux;
				}
				tab[i]=time_last;
			}
			
			min=tab[0];
			for(int k=0; k<tab.length;k++){
				if (min>tab[k+1]){
					min= tab[k+1];
					MF = V.getProcessus(k);
				}
			}

		}
			return MF;
		
	}

		/*	int SJ=((Processus)V.get(0)).getT_arrive();
		int index=0;
		for(int i=0;i<V.size();i++){
			if(((Processus)V.get(i)).getT_arrive()<=SJ){
				index=i;
				SJ=((Processus)V.get(i)).getT_arrive();
			}
		}
		return ((Processus)V.get(index));
	}*/




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
			ListProcessus L_Ok_1=new ListProcessus();//Liste dans laquelle on va stocké dans l'ordre les processus traiter
			int t_now_1=0;
			for(int i=0;i<length;i++){
				ListProcessus L_To_Do_1=new ListProcessus();
				Processus MF_P=new Processus();	
				//Choix des Processus suceptible d'etre executé
				L_To_Do_1=To_Do_1(Ass.getListProcess(),t_now_1);
				//Choix du Processus a executer
				MF_P=MF(L_To_Do_1);
				Ass.getAlgo().getListEv().addEvent("attente", MF_P, t_now_1);
				//System.out.println(FIFO_P.getLabel_P());
				t_now_1=Time_Now_1(MF_P,t_now_1);
				MF_P.setInstantDemarage(t_now_1);
				Ass.getAlgo().getListEv().addEvent("pret",MF_P,t_now_1);
				//Mise à jour du temps actuel
				t_now_1=t_now_1+MF_P.getTempsVie();
				//Mise à jour du Processus SJF_P
				MF_P.setFin(t_now_1);
				MF_P.setStat(true);
				Ass.getAlgo().getListEv().addEvent("éxécuté", MF_P, t_now_1);
				//Mise à jour de la liste L_Total
				int index; 
				index=MF_P.getID();
				// V_Total_1.add(index,FIFO_P);
				Ass.getListProcess().add(MF_P);
				//Mise à jour la liste L_Ok
				L_Ok_1.add(MF_P);
			}
			return Ass.getAlgo().getListEv();
		}
	}




