package trab_10_8;

public class Student {
    String name;

    String enrolment;

    Double firstTestGrade;

    Double secondTestGrade;

    Double homeWorkGrade;

    private static Double TEST_WEIGHT = 2.5;
    private static Double HOMEWORK_WEIGHT = 2.0;
    private static Double MIN_GRADE = 20d;
    private static Double MAX_GRADE = 100d;

    public Student(String name, String enrolment, Double firstTestGrade, Double secondTestGrade, Double homeWorkGrade) {
        this.name = name;
        this.enrolment = enrolment;
        this.firstTestGrade = firstTestGrade;
        this.secondTestGrade = secondTestGrade;
        this.homeWorkGrade = homeWorkGrade;
    }

    public Double calcAverageScore() {
        return (
            (this.firstTestGrade * TEST_WEIGHT) + (this.secondTestGrade * TEST_WEIGHT) + (this.homeWorkGrade * HOMEWORK_WEIGHT)
        ) / (TEST_WEIGHT + HOMEWORK_WEIGHT);
    }

    public Double missingForFinalTest() {
        Double totalScore = this.firstTestGrade + this.secondTestGrade + this.homeWorkGrade;

        if (totalScore < MIN_GRADE) {
            return 0d;
        }

        return MAX_GRADE - totalScore;
    }
}
