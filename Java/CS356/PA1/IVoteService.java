import java.util.*;

public class IVoteService {
	private Question q;
	private Map<String,List<String>> answers;
	
	/**
	 * @param q makes a ivoteservice object with q as the question
	 */
	IVoteService(Question q) {
		this.q = q;
		answers = new HashMap<String, List<String>>();
	}
	
	/**
	 * resets hashmap to be used if the question changes
	 */
	public void resetAnswers(){
		answers = new HashMap<String, List<String>>();		
	}
	
	/**
	 * @param s gets answer from student s
	 * hashmap used to track if student s has made a previous submission
	 */
	public void getAnswer(Student s) {
		answers.put(s.getID(), s.getAnswer());
	}
	
	/**
	 * @param q used to change question, calls resetAnswers
	 */
	public void setQuestion(Question q) {
		this.q = q;
		resetAnswers();
	}
	
	/**
	 * creates another hashmap to count number of occurrences of each answer
	 * displays frequency of answers
	 */
	public void displayAnswers(){
		Map<String, Integer> counter = new HashMap<String, Integer>();
		for(List<String> l: answers.values()) {
			for(String s: l) {
				if(counter.containsKey(s)){
					counter.put(s, counter.get(s) + 1);
				}
				else
					counter.put(s, 1);
			}
		}
		
		for (String s: q.getCandidateAnswers()) {
			System.out.print(s + " : ");
			if (counter.get(s) != null) {
				System.out.print(counter.get(s));
			}
			else
				System.out.print("0");
			System.out.println();
		}
		
	}

}
