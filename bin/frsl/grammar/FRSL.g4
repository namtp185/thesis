grammar FRSL;   
metaModel  : useCaseName (NEWLINE useCaseDescription)? NEWLINE actors (NEWLINE precondition)? (NEWLINE postcondition)? (NEWLINE trigger)? (NEWLINE specialRequirement)? NEWLINE flows;
useCaseName: 'Use case:' use_case_name ;
useCaseDescription: 'Brief description:' use_case_description ;
actors: 'Actors:' actor_names;
precondition: 'Precondition:' pre_condition ;
postcondition: 'Postcondition:' post_condition ;
trigger: 'Trigger:' trigger_info ;
specialRequirement: 'Special requirement:' special_requirement ;
flows: basicFlow (NEWLINE alternativeFlows)?;
use_case_name: PHRASE;
use_case_description : STATEMENT;
actor_names: (','|actor_name)+;
actor_name: PHRASE;
pre_condition : STATEMENT;
post_condition : STATEMENT;
trigger_info : STATEMENT;
special_requirement : STATEMENT;
basicFlow: 'Basic flow:' NEWLINE (basicStep|NEWLINE)+;
alternativeFlows: 'Alternative flows:' NEWLINE (alternativeFlow|NEWLINE)+;
basicStep: step ':' STATEMENT;
alternativeFlow: aFlow ':' PHRASE (basicStep|NEWLINE)+;
step: 'Step ' LETTER ;
aFlow: 'Flow ' LETTER ;


// key
USECASE: 'Use case:';
DESCRIPTION: 'Brief description:';
ACTORS: 'Actors:';
FLOWS: 'Flows:';

// segment
NEWLINE: [\n]+;
STATEMENT: (PHRASE|'.'|',')+'.';
PHRASE : (' 'LETTER)+;
LETTER : [a-zA-Z0-9_]+ ;
NUMBER: [0-9];
WS : [ \t\r]+ -> skip ;