/**
 * 
 */
package frsl.sequence_diagram.actions;

import javax.swing.JOptionPane;

import com.google.common.base.Optional;

import frsl.metamodel.UseCase;
import frsl.runtime.itf.IPluginAction;
import frsl.runtime.itf.IPluginActionDelegate;
import frsl.sequence_diagram.gui.BehavioralDiagramPluginEditor;
import frsl.util.IOUtil;
//import net.sourceforge.plantuml.Run;

/**
 * @author ntp28459hteam
 *
 */
public class GenerateBehavioralDiagramAction implements IPluginActionDelegate {

	public static String resultFileName;
	
	private static boolean firstTimeClick = true;
	
	private BehavioralDiagramPluginEditor secondaryWorkspace = null;
	
	@Override
	public void performAction(IPluginAction pluginAction) {		
		String debugFilePath = System.getProperty("user.dir") + "/debug.log";
		setResultFileName();
		UseCase metaModel = pluginAction.getParent().getMetaModel();
		if (metaModel == null) {
			JOptionPane.showMessageDialog(null, "You need to successfully compile FRSL first!",
					"Generate behavioral diagram", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(firstTimeClick) {
			secondaryWorkspace = new BehavioralDiagramPluginEditor(metaModel);
			pluginAction.getParent().getContentPane().add("Behavioral Diagram Editor", secondaryWorkspace);
			firstTimeClick = false;
		}
		
		secondaryWorkspace.updateTextArea();
		
//		IOUtil.writeFile(debugFilePath, metaModel.getFlowEdges().get(0).toString());
//		String path = System.getProperty("user.dir") + "/output_artifacts/" + resultFileName;
//		
//		String usecaseName = metaModel.getDescriptionInfo().getUseCaseName(); 
//		
//		StringBuilder sb = new StringBuilder();
//		
//		String primaryActor = "FIXME";
//		Optional<String> secondaryActor = Optional.absent();
//		String boundaryObject = new String(String.format("\"%s boundary\"", usecaseName));
//		String controlObject = new String(String.format("\"%s\"", usecaseName));
//		String entityObject = "FIXME2";
//		
//		// TODO
//		// If we detect need a support actor in a step, then create a secondary actor
//		secondaryActor = Optional.of("FIXME3");
//		
//		sb.append("@startuml\n");
//		sb.append(String.format("actor %s\n", primaryActor));
//		sb.append(String.format("boundary %s\n", boundaryObject));
//		sb.append(String.format("control %s\n", controlObject));
//		sb.append(String.format("entity %s\n", entityObject));
//		if(secondaryActor.isPresent()) {
//			sb.append(String.format("actor %s\n", secondaryActor.get()));
//		}
//		sb.append("@enduml\n");
//		
//		IOUtil.writeFile(path, sb.toString());
//		Thread t = new Thread(new GenerateGraphicDiagram());
//		t.start();
		
	}

	public static String getTemplatePath() {
		return System.getProperty("user.dir") + "/resource/template/sequence_template.txt";
	}

	public static void setResultFileName() {
		resultFileName = "sequence.txt";
	}
	
}

class GenerateGraphicDiagram implements Runnable {

	@Override
	public void run() {
//		String[] templateFilePath = new String[1]; 
//		templateFilePath[0] = new String(System.getProperty("user.dir") + "/output_artifacts/" + "sequence.txt");
//		try {
//			Run.main(templateFilePath);
//		} catch (IOException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}
}
