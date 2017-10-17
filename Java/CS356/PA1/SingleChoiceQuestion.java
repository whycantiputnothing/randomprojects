import java.util.Arrays;
import java.util.List;

public class SingleChoiceQuestion implements Question {
	
	private List<String> candidateAnswers;
	private int numAnswer;

	/**
	 * @param s
	 * here for easy testing of different strings
	 */
	SingleChoiceQuestion(String[] s) {
		candidateAnswers = Arrays.asList(s);
		numAnswer = s.length;
	}
	
	SingleChoiceQuestion(List<String> s) {
		candidateAnswers = s;
		numAnswer = s.size();
	}
	
	@Override
	public int getNumAnswer() {
		// TODO Auto-generated method stub
		return numAnswer;
	}

	@Override
	public List<String> getCandidateAnswers() {
		// TODO Auto-generated method stub
		return candidateAnswers;
	}
	

}
