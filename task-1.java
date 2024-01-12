import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswer;

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

/**
 * The Quiz class represents a quiz that contains a list of questions.
 * It allows adding questions, starting the quiz, and calculating the score.
 */
class Quiz {
    private List<Question> questions;

    /**
     * Constructs a new Quiz object with an empty list of questions.
     */
    public Quiz() {
        this.questions = new ArrayList<>();
    }

    /**
     * Adds a question to the quiz.
     * 
     * @param question the question to be added
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Starts the quiz, prompts the user with each question, and calculates the score.
     * The user's answers are read from the console.
     */
    public void startQuiz() {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("Quiz completed! Your score is: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class OnlineQuiz {
    public static void main(String[] args) {
        // Create quiz questions
        Question question1 = new Question("What is the capital of France?",
                List.of("London", "Paris", "Berlin", "Madrid"), 2);
        Question question2 = new Question("Which planet is known as the Red Planet?",
                List.of("Mars", "Venus", "Jupiter", "Saturn"), 1);
        Question question3 = new Question("What is the largest ocean in the world?",
                List.of("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"), 4);

        // Create quiz and add questions
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);

        // Start the quiz
        quiz.startQuiz();
    }
}
