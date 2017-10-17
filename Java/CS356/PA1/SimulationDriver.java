import java.util.*;

public class SimulationDriver {

	public static void main(String[] args) {
		Random rand = new Random();
		int r = rand.nextInt(1000) + 100;		//generates 100 to 1000 students
		int r1 = 0;
		String[] str = {"A", "B", "C", "D"};		// answer choices for multiple choice
		String[] str2 = {"1. Right" , "2. Wrong"};		// answer choices for single choice
		Question q1 = new SingleChoiceQuestion(str2);
		Question q2 = new MultipleChoiceQuestion(str);
		Student[] stu = new Student[r];
		IVoteService vote = new IVoteService(q1); 
	
		System.out.println("Number of Students: " + r);
		System.out.println();
		System.out.println("Single Choice Question");
		for (int i = 0; i < r; i++){
			r1 = rand.nextInt(2);		// between 0 and 1
			stu[i] = new Student(UUID.randomUUID().toString(), q1.getCandidateAnswers().subList(r1, r1+1));		// generates unique ID and selects one answer to be used
			vote.getAnswer(stu[i]);
		}
		
		vote.displayAnswers();
		System.out.println();
		vote.setQuestion(q2);
		System.out.println("Multiple Choice Questions");
		
		for (int i = 0; i < r; i++){
			r1 = rand.nextInt(4) + 1;	// 1 to 4
			stu[i] = new Student(UUID.randomUUID().toString(), q2.getCandidateAnswers().subList(0, r1));		// generates unique ID and gives answer choice of substring of A B C D 
																															// to simulate multiple selection
			vote.getAnswer(stu[i]);
		}
		
		vote.displayAnswers();
		
		System.exit(0);
	}

}
