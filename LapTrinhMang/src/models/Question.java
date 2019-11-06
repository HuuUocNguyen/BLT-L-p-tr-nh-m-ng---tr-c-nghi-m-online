package models;

/**
 *
 * @author hung
 */
public class Question {

    private String question;
    private String A, B, C, D;
    private String answer;

    public Question(String question, String A, String B, String C, String D, String answer) {
        this.question = question;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.answer = answer;
    }

    public Question() {
    }

    @Override
    public String toString() {
        return question + ":" + A + ":" + B + ":"+ C + ":"+ D + ":" + answer;
    }

}
