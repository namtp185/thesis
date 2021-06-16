package frsl.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import frsl.metamodel.SelectionObservable;
import frsl.metamodel.SelectionObserver;

public class Selection implements SelectionObservable {
	
	private List<SelectionObserver> observers;
	
	private String selected;
	
	private JTextPane parentPane;
	private JTextArea textArea;
	
	public void registerObserver(SelectionObserver observer) {
		observers.add(observer);
	}
	public void unregisterObserver(SelectionObserver observer) {
		observers.add(observer);
	}
	public void notifyObservers() {
		for(SelectionObserver ob: observers) {
			ob.update(this);
		}
	}
	
	private void internalStateChanged() {
		notifyObservers();
	}
	
	//TODO: Change selection mechanism to validate user input is correct
	private List<POSRange> nounRange = new ArrayList<>();
	private List<POSRange> verbRange = new ArrayList<>();
	private List<POSRange> prepRange = new ArrayList<>();
	
	private int nounIndexStart;
	private int nounIndexEnd;
	private int verbIndexStart;
	private int verbIndexEnd;
	private int prepIndexStart;
	private int prepIndexEnd;
	
	private void initIndex() {
		setNounIndexStart(-1);
		setNounIndexEnd(-1);
		setVerbIndexStart(-1);
		setVerbIndexEnd(-1);
		setPrepIndexStart(-1);
		setPrepIndexEnd(-1);
	}
	
	public Selection(JTextPane tPane) {
		this();
		this.parentPane = tPane;
	}
	
	public String getSelected() {
		return this.selected;
	}
	
	public void setSelected(String selected) {
		this.selected = selected;
		internalStateChanged();
	}
	
	public Selection(JTextArea textArea) {
		this();
		this.textArea = textArea;
	}
	
	public Selection() {
		this.initIndex();
		this.observers = new ArrayList<>();
	}
	
	private String getText() {
		return parentPane != null ? parentPane.getSelectedText() : textArea.getSelectedText();
	}
	
	public void getSVO() {
		if(nounIndexStart != -1 && nounIndexEnd != -1) {
			System.out.print("Noun: ");
			System.out.println(getText().substring(
					nounIndexStart, nounIndexEnd));
		}
		if(verbIndexStart != -1 && verbIndexEnd != -1) {
			System.out.print("Verb: ");
			System.out.println(getText().substring(
					verbIndexStart, verbIndexEnd));
		}
		if(prepIndexStart != -1 && prepIndexEnd != -1) {
			System.out.print("Preposition: ");
			System.out.println(getText().substring(
					prepIndexStart, prepIndexEnd));
		}
	}

	public int getNounIndexStart() {
		return nounIndexStart;
	}

	public void setNounIndexStart(int nounIndexStart) {
		this.nounIndexStart = nounIndexStart;
	}

	public int getNounIndexEnd() {
		return nounIndexEnd;
	}

	public void setNounIndexEnd(int nounIndexEnd) {
		this.nounIndexEnd = nounIndexEnd;
	}

	public int getVerbIndexStart() {
		return verbIndexStart;
	}

	public void setVerbIndexStart(int verbIndexStart) {
		this.verbIndexStart = verbIndexStart;
	}

	public int getVerbIndexEnd() {
		return verbIndexEnd;
	}

	public void setVerbIndexEnd(int verbIndexEnd) {
		this.verbIndexEnd = verbIndexEnd;
	}

	public int getPrepIndexStart() {
		return prepIndexStart;
	}

	public void setPrepIndexStart(int prepIndexStart) {
		this.prepIndexStart = prepIndexStart;
	}

	public int getPrepIndexEnd() {
		return prepIndexEnd;
	}

	public void setPrepIndexEnd(int prepIndexEnd) {
		this.prepIndexEnd = prepIndexEnd;
	}
	
}
