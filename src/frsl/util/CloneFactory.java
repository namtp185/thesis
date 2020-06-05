package frsl.util;

import frsl.metamodel.AlternateFlowEdge;
import frsl.metamodel.BasicFlowEdge;
import frsl.metamodel.FlowEdge;
import frsl.metamodel.FlowStep;
import frsl.metamodel.flow_step.ActorStep;
import frsl.metamodel.flow_step.SystemStep;

public class CloneFactory {
	@SuppressWarnings("deprecation")
	public static FlowStep fromFlowStep(Class<?> targetClass, FlowStep instance) {
		try {
			FlowStep newInstance = (FlowStep) targetClass.newInstance();
			newInstance.setName(instance.getName());
			newInstance.setType(instance.getType());
			newInstance.setDescription(instance.getDescription());
			newInstance.setMaxloop(instance.getMaxloop());
			newInstance.setValid(instance.isValid());
			newInstance.setId(instance.getId());
			newInstance.setActionDescription(instance.getActionDescription());
			newInstance.setActions(instance.getActions());
			return newInstance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ActorStep fromActorStep(Class<?> targetClass, ActorStep instance) {
		try {
			ActorStep newInstance = (ActorStep) targetClass.newInstance();
			newInstance.setName(instance.getName());
			newInstance.setType(instance.getType());
			newInstance.setDescription(instance.getDescription());
			newInstance.setMaxloop(instance.getMaxloop());
			newInstance.setValid(instance.isValid());
			newInstance.setId(instance.getId());
			newInstance.setActionDescription(instance.getActionDescription());
			newInstance.setActions(instance.getActions());
			newInstance.setActorName(instance.getActorName());
			return newInstance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static SystemStep fromSystemStep(Class<?> targetClass, SystemStep instance) {
		try {
			SystemStep newInstance = (SystemStep) targetClass.newInstance();
			newInstance.setName(instance.getName());
			newInstance.setType(instance.getType());
			newInstance.setDescription(instance.getDescription());
			newInstance.setMaxloop(instance.getMaxloop());
			newInstance.setValid(instance.isValid());
			newInstance.setId(instance.getId());
			newInstance.setActionDescription(instance.getActionDescription());
			newInstance.setActions(instance.getActions());
			return newInstance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static FlowEdge validateFlowEdgeType(FlowEdge fe) {
		int type = 1;
		String label = null;
		if (fe.getSource() instanceof FlowStep) {
			if (!((FlowStep) fe.getSource()).getType().equalsIgnoreCase("Basic Flow")) {
				label = ((FlowStep) fe.getSource()).getType();
				type = 2;
			}
		}
		if (fe.getTarget() instanceof FlowStep) {
			if (!((FlowStep) fe.getTarget()).getType().equalsIgnoreCase("Basic Flow")) {
				label = ((FlowStep) fe.getTarget()).getType();
				type = 2;
			}
		}
		if (type == 1) {
			BasicFlowEdge rs = new BasicFlowEdge();
			rs.setSource(fe.getSource());
			rs.setTarget(fe.getTarget());
			rs.setGuard(fe.getGuard());
			rs.setId("BasicFlowEdge_" + rs.getSource().getId() + "_to_" + rs.getTarget().getId());
			return rs;
		} else {
			AlternateFlowEdge rs = new AlternateFlowEdge();
			rs.setSource(fe.getSource());
			rs.setTarget(fe.getTarget());
			rs.setGuard(fe.getGuard());
			rs.setLabel(label);
			rs.setId("AlternateFlowEdge_" + rs.getSource().getId() + "_to_" + rs.getTarget().getId());
			return rs;
		}
	}
}
