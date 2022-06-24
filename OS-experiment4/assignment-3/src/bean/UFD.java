package bean;

import java.util.ArrayList;
import java.util.List;

public class UFD {
    private String userName;
    private List<File> list;

    public UFD() {
        list = new ArrayList<>();
    }

    public UFD(String userName) {
        this.userName = userName;
        list = new ArrayList<>();
        list.add(new File(".", "110", 100, 0));
        list.add(new File("..", "110", 110, 0));
        list.add(new File("文档", "110", 120, 0));
        list.add(new File("下载", "110", 130, 0));
        list.add(new File("桌面", "110", 140, 0));
        list.add(new File("图片", "110", 150, 0));
        list.add(new File("a", "000", 160, 0));
        list.add(new File("b", "100", 170, 0));
        list.add(new File("c", "010", 180, 0));
        list.add(new File("d", "110", 190, 0));
    }

    public UFD(String userName, List<File> list) {
        this.userName = userName;
        this.list = list;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<File> getList() {
        return list;
    }

    public void setList(List<File> list) {
        this.list = list;
    }
}
