package frsl.sequence_diagram.actions;

import frsl.metamodel.FlowStep;
import frsl.metamodel.USLNode;
import frsl.metamodel.UseCase;
import frsl.runtime.itf.IPluginAction;
import frsl.runtime.itf.IPluginActionDelegate;

public class GenerateActivityDiagramAction implements IPluginActionDelegate {
	@Override
	public void performAction(IPluginAction pluginAction) {
		UseCase model = pluginAction.getParent().getMetaModel();
		for(USLNode node: model.getUslNodes()) {
			if(node instanceof FlowStep) {
				FlowStep fs = (FlowStep)node;
				System.out.println(fs.getDescription());
			}
		}
	}
}
