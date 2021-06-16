package frsl.gui;

import javax.swing.JPanel;

import frsl.metamodel.Model;
import frsl.metamodel.ModelObserver;
import frsl.metamodel.UseCaseV2;

public abstract class PlantUMLEditor extends JPanel implements ModelObserver {

	protected Model model;
	protected UseCaseV2 usecase;

	protected abstract void render();

	@Override
	public void update(Model model) {
		this.model = model;
		render();
	}

}