package frsl.extractor;

import frsl.metamodel.NavigableStep;

public class Context {
	// null: currently in basic flow
	// non-null: currently in alternate flow
	NavigableStep currentConditionStep = null;
	NavigableStep currentSequenceStep;
	NavigableStep preStep = null;
}
