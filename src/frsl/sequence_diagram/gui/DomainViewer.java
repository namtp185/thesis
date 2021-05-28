package frsl.sequence_diagram.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frsl.metamodel.Actor;
import frsl.metamodel.Entity;
import frsl.metamodel.Model;
import frsl.metamodel.ModelObserver;

//TODO: Utilize code that only render new entity created
public class DomainViewer extends JPanel implements ModelObserver {

	private static final long serialVersionUID = 1L;
	
	private Model model;
	private Selection selection;
	
	
	private void render() {
		removeAll();
		for(Entity entity: model.getEntities().values()) {
			String key = entity.getName();
			add(new JLabel(key));
			add(createDeleteButton(key));
		}
		for(Actor a: model.getActors().values()) {
			String key = a.getName();
			add(new JLabel(key));
			add(createDeleteButton(key));
		}
		repaint();
	}
	
	private JButton createDeleteButton(String key) {
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.removeEntity(key);
			}
		};
		JButton deleteBtn = new JButton("delete");
		deleteBtn.addActionListener(action);
		return deleteBtn;
	}
	
	@Override
	public void update(Model model) {
		this.model = model;
		render();
	}
	
	public DomainViewer() {

	}

}
