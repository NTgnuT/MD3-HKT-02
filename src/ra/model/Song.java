package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;

    private String songName;

    private String descriptions;

    private String songWriter;

    private Date createDate;

    private boolean songStatus;

    private Singer singer;

    public Song() {
        this.createDate = new Date();
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.songWriter = songWriter;
        this.createDate = new Date();
        this.songStatus = songStatus;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Singer [] singers, int indexSinger) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã bài hát (Bắt đầu bằng chữ S: )");
        while (true) {
            this.songId = scanner.nextLine();
            if (songId.length() < 4) {
                System.err.println("ID phải có ít nhất 4 ký tự");
            } else {
                if (songId.startsWith("S")) {
                    break;
                } else {
                    System.err.println("Mã bài hát phải bắt đầu bằng chữ 'S'");
                }
            }
        }

        System.out.println("Nhập tên bài hát: ");
        while (true) {
            this.songName = scanner.nextLine();
            if (songName.isEmpty()) {
                System.err.println("Tên bài hát không được để trống");
            } else {
                break;
            }
        }

        System.out.println("Nhập mô tả cho bài hát");
        this.descriptions = scanner.nextLine();

        System.out.println("Danh sách các ca sĩ, nhập ID để lựa chọn: ");
        for (int i = 0; i < indexSinger; i++) {
            singers[i].displayData();
        }
        System.out.println("Nhập ID ");
        boolean checkSinger = false;
        while (true) {
            int check = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < indexSinger; i++) {
                if (singers[i].getSingerId() == check) {
                    this.singer = singers[i];
                    checkSinger = true;
                    break;
                }
            }
            if(!checkSinger) {
                System.out.println("Không có ca sĩ này, nhập ca sĩ mới trước!");
                for (int i = 0; i < indexSinger; i++) {
                    singers[i].inputData();
                }
            }
            break;
        }


        System.out.println("Nhập người sáng tác: ");
        while (true) {
            this.songWriter = scanner.nextLine();
            if (songWriter.isEmpty()) {
                System.err.println("Người sáng tác không được để trống");
            } else {
                break;
            }
        }

        System.out.println("Nhập trạng thái");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.println(
                "Song{" +
                        "songId='" + songId + '\'' +
                        ", songName='" + songName + '\'' +
                        ", descriptions='" + descriptions + '\'' +
                        ", songWriter='" + songWriter + '\'' +
                        ", createDate=" + createDate +
                        ", songStatus=" + songStatus +
                        ", singer=" + singer.getSingerName() +
                        '}'
        );
    }

}
