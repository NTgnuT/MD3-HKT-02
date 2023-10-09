package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId;

    private String singerName;

    private int age;

    private String nationality;

    private boolean gender;

    private String genre;

    private static int count = 1;

    public Singer() {
        this.singerId = Singer.count++;
    }

    public Singer(String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = Singer.count++;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public String getGenre() {
        return genre;
    }

    public static int getCount() {
        return count;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static void setCount(int count) {
        Singer.count = count;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tên ca sĩ: ");
        while (true) {
            this.singerName = scanner.nextLine();
            if (singerName.isEmpty()) {
                System.err.println("Tên ca sĩ không được để trống");
            } else {
                break;
            }
        }

        System.out.println("Nhập tuổi ca sĩ: ");
        while (true) {
            this.age = Integer.parseInt(scanner.nextLine());
            if (age < 1) {
                System.err.println("Tuổi ca sĩ không được nhỏ hơn 0");
            } else {
                break;
            }
        }

        System.out.println("Nhập quốc tịch: ");
        while (true) {
            this.nationality = scanner.nextLine();
            if (nationality.isEmpty()) {
                System.err.println("Quốc tịch không được để trống");
            } else {
                break;
            }
        }

        System.out.println("Nhập giới tính: ");
        this.gender = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Nhập thể loại nhạc: ");
        while (true) {
            this.genre = scanner.nextLine();
            if (genre.isEmpty()) {
                System.err.println("Thể loại nhạc không được để trống");
            } else {
                break;
            }
        }
    }


    public void displayData() {
        System.out.println(
                "Singer{" +
                        "singerId=" + singerId +
                        ", singerName='" + singerName + '\'' +
                        ", age=" + age +
                        ", nationality='" + nationality + '\'' +
                        ", gender=" + (gender ? "Nam" : "Nữ") +
                        ", genre='" + genre + '\'' +
                        '}'
        );
    }
}
