/**
 * 
 */
package frsl.sequence_diagram.actions;

import javax.swing.JOptionPane;

import com.google.common.base.Optional;

import frsl.gui.BehavioralDiagramPluginEditor;
import frsl.metamodel.UseCase;
import frsl.metamodel.UseCaseV2;
import frsl.runtime.itf.IPluginAction;
import frsl.runtime.itf.IPluginActionDelegate;
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
		UseCaseV2 metaModel = pluginAction.getParent().getMetaModel();
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
		
	}

	public static String getTemplatePath() {
		return System.getProperty("user.dir") + "/resource/template/sequence_template.txt";
	}

	public static void setResultFileName() {
		resultFileName = "sequence.txt";
	}
	
}

