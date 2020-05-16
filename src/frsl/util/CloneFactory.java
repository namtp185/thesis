package frsl.util;

import frsl.metamodel.FlowStep;
import frsl.metamodel.flow_step.ActorStep;
import frsl.metamodel.flow_step.SystemStep;

public class CloneFactory {
	@SuppressWarnings("deprecation")
	public static FlowStep fromFlowStep(Class<?> targetClass, FlowStep instance) {
		try {
			FlowStep newInstance = (FlowStep)targetClass.newInstance();
			newInstance.setName(instance.getName());
			newInstance.setType(instance.getType());
			newInstance.setDescription(instance.getDescription());
			newInstance.setMaxloop(instance.getMaxloop());
			newInstance.setValid(instance.isValid());
			return newInstance;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ActorStep fromActorStep(Class<?> targetClass, ActorStep instance) {
		try {
			ActorStep newInstance = (ActorStep)targetClass.newInstance();
			newInstance.setName(instance.getName());
			newInstance.setType(instance.getType());
			newInstance.setDescription(instance.getDescription());
			newInstance.setMaxloop(instance.getMaxloop());
			newInstance.setValid(instance.isValid());
			newInstance.setActorName(instance.getActorName());
			return newInstance;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static SystemStep fromSystemStep(Class<?> targetClass, SystemStep instance) {
		try {
			SystemStep newInstance = (SystemStep)targetClass.newInstance();
			newInstance.setName(instance.getName());
			newInstance.setType(instance.getType());
			newInstance.setDescription(instance.getDescription());
			newInstance.setMaxloop(instance.getMaxloop());
			newInstance.setValid(instance.isValid());
			return newInstance;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
