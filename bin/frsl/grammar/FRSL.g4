grammar FRSL;   
metaModel  : useCaseName (NEWLINE useCaseDescription)? NEWLINE actors (NEWLINE precondition)? (NEWLINE postcondition)? (NEWLINE trigger)? (NEWLINE specialRequirement)? NEWLINE flows;
useCaseName: 'Use case:' use_case_name ;
useCaseDescription: 'Brief description:' use_case_description ;
actors: 'Actors:' actor_names;
precondition: 'Precondition:' pre_condition ;
postcondition: 'Postcondition:' post_condition ;
trigger: 'Trigger:' trigger_info ;
specialRequirement: 'Special requirement:' special_requirement ;
flows: 'Flows:' NEWLINE basicFlows (NEWLINE specificAlternativeFlows)? (NEWLINE globalAlternativeFlows)? (NEWLINE boundedAlternativeFlows)?;
use_case_name: PHRASE;
use_case_description : STATEMENT;
actor_names: (','|actor_name)+;
actor_name: PHRASE;
pre_condition : STATEMENT;
post_condition : STATEMENT;
trigger_info : STATEMENT;
special_requirement : STATEMENT;
basicFlows: 'Basic flows:' NEWLINE (basicStep|NEWLINE)+;
specificAlternativeFlows: 'Specific alternative flows:' NEWLINE (specificAlternativeFlow|NEWLINE)+;
globalAlternativeFlows: 'Global alternative flows:' NEWLINE (globalAlternativeFlow|NEWLINE)+;
boundedAlternativeFlows: 'Bounded alternative flows:' NEWLINE (boundedAlternativeFlow|NEWLINE)+;
basicStep: step ':' STATEMENT;
specificAlternativeFlow: aFlow ':' PHRASE (basicStep|NEWLINE)+;
globalAlternativeFlow: aFlow ':' PHRASE (basicStep|NEWLINE)+;
boundedAlternativeFlow: aFlow ':' PHRASE (basicStep|NEWLINE)+;
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