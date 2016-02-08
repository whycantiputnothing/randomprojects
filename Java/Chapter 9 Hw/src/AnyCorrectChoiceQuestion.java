public class AnyCorrectChoiceQuestion extends ChoiceQuestion {
    private String allAnswers;

    public AnyCorrectChoiceQuestion() {
        super();
    }

    public void setAnswer(String correctResponse) {
        allAnswers = correctResponse + " " + allAnswers;
    }

    public boolean checkAnswer(String response) {
        return allAnswers.contains(response);
    }
    
    public void display() {
        super.display();
    }
}