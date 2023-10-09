package ra.model;

import java.util.Date;
import java.util.Scanner;

public class MusicManagement {
    static Scanner scanner = new Scanner(System.in);

    static Singer[] singers = new Singer[100];

    static int indexSinger = 3;

    static {
        singers[0] = new Singer("Nguyễn A", 25, "Việt Nam", true, "Nhạc trẻ");
        singers[1] = new Singer("Nguyễn B", 28, "Hàn Quốc", false, "KPOP");
        singers[2] = new Singer("Nguyễn C", 31, "Việt Nam", true, "Nhạc cách mạng");
    }

    static Song[] songs = new Song[100];

    static int indexSong = 0;

//    static {
//        songs[0] = new Song("S103", "Bài hát 1", "mưa", singers[2], "Sáng tác 1", new Date(), true);
//        songs[1] = new Song("S230", "Bài hát 2", "nắng", singers[1], "Sáng tác 2", new Date(), true);
//        songs[2] = new Song("S492", "Bài hát 3", "gió", singers[0], "Sáng tác 3", new Date(), true);
//    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("*******MUSIC-MANAGEMENT********");
            System.out.println("1. Quản lý ca sĩ.");
            System.out.println("2. Quản lý bài hát.");
            System.out.println("3. Tìm kiếm.");
            System.out.println("4. Thoát");
            System.out.println("Nhập lựa chọn của bạn.");
            int choise = Integer.parseInt(scanner.nextLine());
            handleSelect(choise);
        }
    }

    private static void handleSelect(int choise) {
        switch (choise) {
            case 1:
                handleManagerSinger();
                break;
            case 2:
                handleManagerSong();
                break;
            case 3:
                handleSearch();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.err.println("Không có lựa chọn này");
                break;
        }
    }

    private static void handleSearch() {
        System.out.println("====== Manager Search ======");
        System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại.");
        System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại.");
        System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần.");
        System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất.");
        System.out.println("5. Thoát");
        System.out.println("Nhập lựa chọn của bạn: ");

        int choiseSearch = Integer.parseInt(scanner.nextLine());
        handleSelectSearch(choiseSearch);
    }

    private static void handleSelectSearch(int choiseSearch) {
        switch (choiseSearch) {
            case 1:
                findSong();
                break;
            case 2:
                findSinger();
                break;
            case 3:
                SortSongName();
                break;
            case 4:
                showNewSong();
                break;
            case 5:
                return;
            default:
                System.err.println("Không có lựa chọn này");
                break;
        }
    }

    private static void showNewSong() {
        for (int i = 0; i < indexSong; i++) {
            for (int j = i + 1; j < indexSong; j++) {
                if ((songs[i].getCreateDate().compareTo(songs[j].getCreateDate())) < 0) {
                    Song temp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = temp;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < indexSong; i++) {
            songs[i].displayData();
            count++;
            if (count == 3) {
                break;
            }
        }
    }

    private static void SortSongName() {
        for (int i = 0; i < indexSong - 1; i++) {
            for (int j = i + 1; j < indexSong; j++) {
                if ((songs[i].getSongName().compareTo(songs[j].getSongName())) > 0) {
                    Song temp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = temp;
                }
            }
        }
        showAllSong();
    }

    private static void findSinger() {
        System.out.println("Nhập tên ca sĩ");
        String inputFind = scanner.nextLine();

        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerName().toLowerCase().contains(inputFind.toLowerCase())) {
                singers[i].displayData();
            }
        }
    }

    private static void findSong() {
        System.out.println("Nhập tên ca sĩ ");
        String inputFind = scanner.nextLine();

        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSinger().getSingerName().toLowerCase().contains(inputFind.toLowerCase())) {
                songs[i].displayData();
            }
        }
    }

    private static void handleManagerSong() {
        System.out.println("====== Manager Song ======");
        System.out.println("1. Nhập số lượng và thông tin bài hát cần thêm mới.");
        System.out.println("2. Hiển thị danh sách bài hát.");
        System.out.println("3. Sửa thông tin bài hát theo ID.");
        System.out.println("4. Xóa bài hát.");
        System.out.println("5. Thoát");
        System.out.println("Nhập lựa chọn của bạn: ");

        int choiseSong = Integer.parseInt(scanner.nextLine());
        handleSelectSong(choiseSong);
    }

    private static void handleSelectSong(int choiseSong) {
        switch (choiseSong) {
            case 1:
                addNewSong();
                break;
            case 2:
                showAllSong();
                break;
            case 3:
                EditSong();
                break;
            case 4:
                DeleteSong();
                break;
            case 5:
                return;
            default:
                System.err.println("Không có lựa chọn này");
                break;
        }
    }

    private static void DeleteSong() {
        System.out.println("Nhập chuỗi ID bài hát bạn muốn xóa: ");
        String idDeleteSong = scanner.nextLine();

        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSongId().equalsIgnoreCase(idDeleteSong)) {
                for (int j = 0; j < indexSong; j++) {
                    songs[j] = songs[j + 1];
                }
            }
            indexSong--;
            break;
        }
    }

    private static void EditSong() {
        System.out.println("Nhập chuỗi ID bài hát bạn muốn sửa: ");
        String idEditSong = scanner.nextLine();
        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSongId().equalsIgnoreCase(idEditSong)) {
                songs[i].displayData();
                songs[i].inputData(singers, indexSinger);
            }
        }
    }

    private static void showAllSong() {
        for (int i = 0; i < indexSong; i++) {
            songs[i].displayData();
        }
        System.out.println("===============");
    }

    private static void addNewSong() {
        System.out.println("Nhập số lượng bài hát bạn muốn thêm mới: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho bài hát thứ " + i);
            Song song = new Song();
            song.inputData(singers, indexSinger);
            songs[indexSong++] = song;
        }
    }

    private static void handleManagerSinger() {
        System.out.println("====== Manager Singer ======");
        System.out.println("1. Nhập số lượng và thông tin ca sĩ cần thêm mới.");
        System.out.println("2. Hiển thị danh sách ca sĩ.");
        System.out.println("3. Sửa thông tin ca sĩ theo ID.");
        System.out.println("4. Xóa ca sĩ.");
        System.out.println("5. Thoát");
        System.out.println("Nhập lựa chọn của bạn: ");

        int choiseSinger = Integer.parseInt(scanner.nextLine());
        handleSelectSinger(choiseSinger);
    }

    private static void handleSelectSinger(int choiseSinger) {
        switch (choiseSinger) {
            case 1:
                addNewSinger();
                break;
            case 2:
                showAllSinger();
                break;
            case 3:
                EditSinger();
                break;
            case 4:
                DeleteSinger();
                break;
            case 5:
                return;
            default:
                System.err.println("Không có lựa chọn này");
                break;
        }
    }

    private static void DeleteSinger() {
        System.out.println("Nhập ID ca sĩ bạn muốn xóa");
        int idSingerDelete = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < indexSong; i++) {
            if ((songs[i] != null) && (songs[i].getSinger().getSingerId() == idSingerDelete)) {
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println("Ca sĩ có bài hát không được xóa");
        } else {
            for (int i = 0; i < indexSinger; i++) {
                if (singers[i].getSingerId() == idSingerDelete) {
                    for (int j = i; j < indexSinger - 1; j++) {
                        singers[j] = singers[j + 1];
                    }
                }
                indexSinger--;
                break;
            }
            showAllSinger();
        }

        System.out.println("Không tìm thấy mã ca sĩ bạn chọn");

    }

    private static void EditSinger() {
        System.out.println("Nhập ID ca sĩ bạn muốn xóa.");
        int idSingerDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerId() == idSingerDelete) {
                singers[i].displayData();
                singers[i].inputData();
            }
        }
    }

    private static void showAllSinger() {
        for (int i = 0; i < indexSinger; i++) {
            singers[i].displayData();
        }
        System.out.println("=========");
    }

    private static void addNewSinger() {
        System.out.println("Nhập số lượng ca sĩ muốn thêm mới");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho ca sĩ thứ " + i);
            Singer singer = new Singer();
            singer.inputData();
            singers[indexSinger++] = singer;
        }
    }
}
