package frsl.sequence_diagram.gui;

import frsl.metamodel.NavigableStep;

public class Context {
	// null: currently in basic flow
	// non-null: currently in alternate flow
	NavigableStep currentConditionStep = null;
	NavigableStep currentSequenceStep;
	NavigableStep preStep = null;
}
