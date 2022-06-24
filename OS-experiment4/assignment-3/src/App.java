import bean.AFD;
import bean.File;
import bean.MDF;
import bean.UFD;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MDF mdf = new MDF();
        AFD afd = new AFD();
        System.out.println("请输入登录用户名:");
        while (true) {
            String user = sc.next();
            int login_success = 0;
            UFD loginUser = null;
            for (UFD ufd : mdf.getList()) {
                if (ufd.getUserName().equals(user)) {
                    login_success = 1;
                    loginUser = ufd;
                    break;
                }
            }
            if (login_success == 0) {
                System.out.println("用户不存在！");
                continue;
            }
            while (true) {
                List<File> files = loginUser.getList();
                List<File> openedFiles = afd.getList();
                printFiles(files, -1);
                System.out.println("请选择操作：");
                System.out.println("1.Create\t2.Delete");
                System.out.println("3.Open\t4.Close");
                System.out.println("5.Read\t6.Write");
                System.out.println("7.Dir\t8.Bye");
                int choose = sc.nextInt();
                int f;
                File file;
                String name;
                switch (choose) {
                    case 1:
                        System.out.println("请输入文件名、保护码、长度(空格分割)");
                        file = new File();
                        file.setFileName(sc.next());
                        file.setProtectionCode(sc.next());
                        file.setSize(sc.nextInt());
                        file.setCursor(0);
                        f = 0;
                        for (File file1 : files) {
                            if (file1.getFileName().equals(file.getFileName())) {
                                f = 1;
                                break;
                            }
                        }
                        if (f == 0) {
                            files.add(file);
                            System.out.println("添加成功!");
                        } else {
                            System.out.println("添加失败，已有相同名称文件!");
                        }
                        break;
                    case 2:
                        System.out.println("请输入文件名");
                        name = sc.next();
                        f = 0;
                        for (File file1 : files) {
                            if (file1.getFileName().equals(name)) {
                                f = 1;
                                for (File openedFile : openedFiles) {
                                    if (openedFile.getFileName().equals(name)) {
                                        f = -1;
                                        break;
                                    }
                                }
                                if (f == 1) {
                                    files.remove(file1);
                                }
                                break;
                            }
                        }
                        if (f == 0) {
                            System.out.println("删除失败，未找到文件!");
                        } else if (f == -1) {
                            System.out.println("删除失败，文件正在运行!");
                        } else {
                            System.out.println("删除成功!");
                        }
                        break;
                    case 3:
                        System.out.println("请输入打开文件名");
                        name = sc.next();
                        f = 0;
                        for (File file1 : files) {
                            if (file1.getFileName().equals(name)) {
                                f = 1;
                                for (File openedFile : openedFiles) {
                                    if (openedFile.getFileName().equals(name)) {
                                        f = -1;
                                        break;
                                    }
                                }
                                if (f == 1) {
                                    openedFiles.add(file1);
                                }
                                break;
                            }
                        }
                        if (f == 0) {
                            System.out.println("打开失败，未找到文件!");
                        } else if (f == -1) {
                            System.out.println("打开失败，文件正在运行!");
                        } else {
                            System.out.println("打开文件成功!");
                        }
                        break;
                    case 4:
                        System.out.println("请输入关闭文件名");
                        name = sc.next();
                        f = 0;
                        for (File openedFile : openedFiles) {
                            if (openedFile.getFileName().equals(name)) {
                                f = 1;
                                openedFiles.remove(openedFile);
                                break;
                            }
                        }
                        if (f == 0) {
                            System.out.println("关闭失败，该文件并未运行!");
                        }  else {
                            System.out.println("关闭文件成功!");
                        }
                        break;
                    case 5:
                        System.out.println("请从下列表中选择您想读取的文件：");
                        printFiles(openedFiles, 0);
                        name = sc.next();
                        f = 0;
                        for (File openedFile : openedFiles) {
                            if (openedFile.getFileName().equals(name) &&
                                    openedFile.getProtectionCode().charAt(0) == '1') {
                                f = 1;
                                openedFile.setCursor(openedFile.getCursor() + 1);
                            }
                        }
                        if (f == 0) {
                            System.out.println("读取失败，该文件并未运行或无读取权限!");
                        }  else {
                            System.out.println("读取文件成功!");
                        }
                        break;
                    case 6:
                        System.out.println("请从下列表中选择您想写入的文件：");
                        printFiles(openedFiles, 1);
                        name = sc.next();
                        f = 0;
                        for (File openedFile : openedFiles) {
                            if (openedFile.getFileName().equals(name) &&
                                    openedFile.getProtectionCode().charAt(1) == '1') {
                                f = 1;
                                openedFile.setCursor(openedFile.getCursor() + 1);
                            }
                        }
                        if (f == 0) {
                            System.out.println("写入失败，该文件并未运行或无写入权限!");
                        }  else {
                            System.out.println("写入文件成功!");
                        }
                        break;
                    case 7:
                        printFiles(files, -1);
                        break;
                    case 8:
                        System.out.println("退出！");
                        printFiles(files, -1);
                        return;
                    default:
                        System.out.println("请输入正确的选项！");
                }
            }
        }
    }
    public static void printFiles(List<File> files, int status) {
        System.out.println("文件名\t地址\t\t\t\t\t\t保护码\t文件长度");
        if (status == -1) {
            for (File file : files) {
                System.out.println(file.getFileName() + "\t\t" + file + "\t\t" + file.getProtectionCode()
                        + "\t\t" + file.getSize());
            }
        }
        else {
            for (File file : files) {
                if (file.getProtectionCode().charAt(status) == '1')
                System.out.println(file.getFileName() + "\t\t" + file + "\t\t" + file.getProtectionCode()
                        + "\t\t" + file.getSize());
            }
        }
    }
}
