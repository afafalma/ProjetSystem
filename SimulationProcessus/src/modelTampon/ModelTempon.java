package modelTampon;

import java.util.ArrayList;

import controller.NewProcessus;
import controller.ProcessusListener;

import model.Event;
import model.ListAction;
import model.ListEvent;
import model.ListProcessus;
import model.Processus;

public class ModelTempon {

	private ListAction list_action;
	private ListEvent list_event;
	private ListProcessus list_process;
	private ArrayList<ProcessusListener> process_listener;
	/**
	 * @param list_action
	 * @param list_event
	 * @param list_process
	 */
	public ModelTempon(ListAction list_action, ListEvent list_event,
			ListProcessus list_process) {
		super();
		this.list_action = list_action;
		this.list_event = list_event;
		this.list_process = list_process;
		this.process_listener = new ArrayList<ProcessusListener>();
	}
	/**
	 * @return the list_action
	 */
	public ListAction getList_action() {
		return list_action;
	}
	/**
	 * @param list_action the list_action to set
	 */
	public void setList_action(ListAction list_action) {
		this.list_action = list_action;
	}
	/**
	 * @return the list_event
	 */
	public ListEvent getList_event() {
		return list_event;
	}
	/**
	 * @param list_event the list_event to set
	 */
	public void setList_event(ListEvent list_event) {
		this.list_event = list_event;
	}
	/**
	 * @return the list_process
	 */
	public ListProcessus getList_process() {
		return list_process;
	}
	/**
	 * @param list_process the list_process to set
	 */
	public void setList_process(ListProcessus list_process) {
		this.list_process = list_process;
	}
	/**
	 * @return the event_listener
	 */
	public ArrayList<ProcessusListener> getProcess_listener() {
		return process_listener;
	}
	/**
	 * @param event_listener the event_listener to set
	 */
	public void setEvent_listener(ArrayList<ProcessusListener> process_listener) {
		this.process_listener = process_listener;
	}
	
	public void addProcess(Processus p){
		this.list_process.ajouterProcessus(list_process.getID(), p.getNom(), p.getListAction(), p.getInstantDemarage(), p.isRepetition(), p.getPriority(), p.getTempsVie(), p.getTempsAttente());
		fireNewEvent(this.list_event.getID());
		
	}
	private void fireNewEvent(int n) {
		for (ProcessusListener  p : process_listener) {
			p.newProcessus(new NewProcessus(this, n));
		}
	}
	
	
}
