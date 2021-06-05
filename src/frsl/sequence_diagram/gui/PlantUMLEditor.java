package frsl.sequence_diagram.gui;

import javax.swing.JPanel;

import frsl.metamodel.Model;
import frsl.metamodel.ModelObserver;
import frsl.metamodel.UseCase;

public abstract class PlantUMLEditor extends JPanel implements ModelObserver {

	protected Model model;
	protected UseCase usecase;

	protected abstract void render();

	@Override
	public void update(Model model) {
		this.model = model;
		render();
	}

}