public class Student {

    private String name;
    private String surname;
    private int studentBook;
    private int semester;
    private int year;
    private int listPoints;
    private int sumOfPoints;
    private double grade;
    static final int numberOfLists = 15;

    public Student() {
    }

    public Student(String name, String surname, int studentBook, int semester, int year, int listPoints, int sumOfPoints, double grade) {
        this.name = name;
        this.surname = surname;
        this.studentBook = studentBook;
        this.semester = semester;
        this.year = year;
        this.listPoints = listPoints;
        this.sumOfPoints = sumOfPoints;
        this.grade = grade;
    }

    public Student(String name, String surname, int studentBook, int semester, int year, int listPoints, int sumOfPoints) {
        this.name = name;
        this.surname = surname;
        this.studentBook = studentBook;
        this.semester = semester;
        this.year = year;
        this.listPoints = listPoints;
        this.sumOfPoints = sumOfPoints;
    }

    //getttery
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getStudentBook() {
        return studentBook;
    }

    public int getSemester() {
        return semester;
    }

    public int getYear() {
        return year;
    }

    public int getListPoints() {
        return listPoints;
    }

    public int getSumOfPoints() {
        return sumOfPoints;
    }

    public double getGrade() {
        return grade;
    }

    //settery
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStudentBook(int studentBook) {
        this.studentBook = studentBook;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setListPoints(int listPoints) {
        this.listPoints = listPoints;
    }

    //przeciÄ…ĹĽenie metody
    public void setListpoints(int addPoints) {
        this.listPoints = listPoints + addPoints;
    }

    public void setSumOfPoints(int sumOfPoints) {
        this.sumOfPoints = sumOfPoints;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setGrade() {
        double result = (double) (sumOfPoints) / ((double) (numberOfLists * listPoints));
        if (result <= 0.5)
            this.grade = 2.0;
        else if (result > 0.5 && result <= 0.6)
            this.grade = 3.0;
        else if (result > 0.6 && result <= 0.7)
            this.grade = 3.5;
        else if (result > 0.7 && result <= 0.8)
            this.grade = 4.0;
        else if (result > 0.8 && result <= 0.9)
            this.grade = 4.5;
        else if (result > 0.9 && result <= 1)
            this.grade = 5.0;
    }

    public String toString(Student student) {
        return student.getName() + " " + student.getSurname() + ": " + student.getStudentBook() +
                " Semestr: " + student.getSemester() + " Rok: " + student.getYear() + " Ocena: " + student.getGrade();
    }
}
