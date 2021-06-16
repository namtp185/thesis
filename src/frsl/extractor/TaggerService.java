package frsl.extractor;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import frsl.constant.StringProcess;
import frsl.metamodel.Actor;
import frsl.metamodel.Model;
import frsl.metamodel.SequenceMessage;


public class TaggerService {

	MaxentTagger tagger;
	
	private static TaggerService instance = null;
	
	public static TaggerService getInstance() {
		if(instance == null) {
			instance = new TaggerService();
		}
		return instance;
	}
	
	private TaggerService() {
		tagger = new MaxentTagger(
				"lib/stanford-postagger-full-2015-12-09/models/english-caseless-left3words-distsim.tagger");
	}
	
	public List<SequenceMessage> extractInfo(Model model, String sentence) {
		String tagged = tagger.tagString(sentence);
		List<String> actions = getActions(tagged);
		
		List<SequenceMessage> messages = new ArrayList<>();
		
		if(actions.size() == 0) {
			System.out.println("Please specify action in this step explicitly");
			messages.add(SecondarySentenceTypeChecker.check(sentence));
		} else if(actions.size() == 1) {
			SequenceMessage message = new SequenceMessage();
			String s = actions.get(0);
			String firstAction = StringProcess.processString(s);
			String subject = StringProcess.processString(sentence.split(s)[0]);
			subject = subject.replace("the ", "");
			message.setAction(SentenceTypeChecker.check(sentence, firstAction));
			message.setActor(new Actor(subject));
			message.setDescription(sentence);
			messages.add(message);
		} else {
			//concurrent action
			String s = actions.get(0);
			String firstAction = StringProcess.processString(s);
			String subject = StringProcess.processString(sentence.split(s)[0]);
			subject = subject.replace("the ", "");
			for(int i = 0; i < actions.size() - 1; i++) {
				SequenceMessage message = new SequenceMessage();
				
				int start = sentence.indexOf(actions.get((i)));
				int end = sentence.indexOf(actions.get(i + 1));
				String predicate = sentence.substring(start, end);
						
				message.setDescription(predicate);
				message.setActor(new Actor(subject));
				message.setAction(SentenceTypeChecker.check(predicate, firstAction));
				messages.add(message);
			}
			
			int i = actions.size() - 1;
			int start = sentence.indexOf(actions.get((i)));
			String predicate = sentence.substring(start);

			SequenceMessage message = new SequenceMessage();
			message.setDescription(predicate);
			message.setActor(new Actor(subject));
			message.setAction(SentenceTypeChecker.check(predicate, firstAction));
			messages.add(message);
		}
		return messages;
	}
	
	private List<String> getActions(String taggedSentence) {
		List<String> actions = new ArrayList<>();
		String[] tokens = taggedSentence.split(" +");
		for(String token: tokens) {
			if(token.endsWith("_VBZ") ||
//					token.endsWith("_VB") ||
//					token.endsWith("_VBD") ||
//					token.endsWith("_VBG") ||
//					token.endsWith("_VBN") ||
					token.endsWith("_VBP")
					) {
				actions.add(token.split("_VB")[0]);
			}
		}
		return actions;
	}
}
