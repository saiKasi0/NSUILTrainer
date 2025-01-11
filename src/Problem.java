public class Problem {
    private String question;
    private double answer;
    private String explanation;
    private int difficulty;
    private String category;

    public Problem(String question, double answer, String explanation, int difficulty, String category) {
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.difficulty = difficulty;
        this.category = category;
    }

    public String getQuestion() { return question; }
    public double getAnswer() { return answer; }
    public String getExplanation() { return explanation; }
    public int getDifficulty() { return difficulty; }
    public String getCategory() { return category; }
}