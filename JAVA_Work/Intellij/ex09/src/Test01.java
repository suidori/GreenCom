class Student {
    int kor;
    int eng;
    int math;

    public Student(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getTotal() {
        return kor + eng + math;
    }

    public float getAverage() {
        float answer = (kor + eng + math) / 3f;
        int temp = (int) (answer * 100);
        answer = temp / 100f;
        return answer;
    }
}

class Song {
    String title;
    String artist;
    int year;
    String country;

    public Song() {
    }

    public Song(String title, String artist, int year, String country) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }

    public void show() {
        System.out.printf("%d년 %s의 %s가 부른 %s", year, country, artist, title);
    }

}

public class Test01 {
    public static void main(String[] args) {
        Student student = new Student(75, 90, 88);
        System.out.println(student.getTotal());
        System.out.println(student.getAverage());

        Song song = new Song("Dancing Queen", "ABBA", 1978, "Sweden");
        song.show();

    }
}
