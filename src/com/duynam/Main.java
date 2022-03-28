package com.duynam;

import javax.security.auth.callback.LanguageCallback;
import java.lang.reflect.Member;
import java.util.*;

public class Main {
    public static SlangWordManagement slangWordList = new SlangWordManagement();

    public static void main(String[] args) {
        MENU();

    }

    public static void MENU() {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        String slag;
        String mean;
        ArrayList<String> means = new ArrayList<String>();

        while (true) {
            feature();
            System.out.print("Nhập chức năng muốn thực hiện: ");
            choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 0:
                {
                    return;
                }
                case 1:
                {
                    System.out.println("\tTìm kiếm theo slang word.");
                    System.out.print("Nhập vào slang word cần tìm: ");
                    slag = scan.nextLine();
                    SlangWord sl = slangWordList.findFollowSlag(slag);
                    if(sl == null) {
                        System.out.println("Không tìm thấy definition cho slang word");
                    }
                    else {
                        System.out.println("Definition: ");
                        for (String s : sl.get_mean()) {
                            System.out.println("\t - " + s);
                        }
                    }

                    means.clear();
                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 2:
                {
                    System.out.println("\tTìm kiếm theo definition.");
                    System.out.print("Nhập vào keyword cần tìm: ");
                    mean = scan.nextLine();

                    ArrayList<SlangWord> slangs = slangWordList.findFollowDefinition(mean.toLowerCase());
                    for (SlangWord sl : slangs) {
                        System.out.println(sl.show());
                    }

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 3:
                {
                    System.out.println("\tLịch sử tìm kiếm.");

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 4:
                {
                    System.out.println("\tThêm một slang word mới.");
                    System.out.print("Nhap vào slang word: ");
                    slag = scan.nextLine();
                    System.out.print("Nhập vào definition: ");
                    mean = scan.nextLine();

                    means.add(mean);
                    if (slangWordList.addSlag(new SlangWord(slag, means))) {
                        System.out.println("Thêm thành công");
                    }
                    else {
                        System.out.println("Thêm thất bại");
                    }

                    means.clear();
                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 5:
                {
                    System.out.println("\tSửa một slang word.");
                    System.out.print("Nhập vào slang word cần sửa: ");
                    slag = scan.nextLine();

                    while (!slangWordList.canFind(slag)) {
                        System.out.print("Nhập lại slang word cần sửa: ");
                        slag = scan.nextLine();
                    }

                    System.out.println("\t1. Sửa slang word.");
                    System.out.println("\t2. Sửa definition.");
                    System.out.print("Bạn muốn sửa:");
                    choice = Integer.parseInt(scan.nextLine());

                    if (choice == 1) {
                        System.out.print("Nhập vào slang word mới: ");
                        String newslag = scan.nextLine();
                        if (slangWordList.editSlag(slag, newslag)) {
                            System.out.println("Sửa thành công");
                        }
                        else {
                            System.out.println("Sửa thất bại");
                        }
                    }
                    else if (choice == 2) {
                        System.out.print("Nhập vào definition mới (Nếu slang word có nhiều definition thì nhập cách nhau bằng dấu '|'): ");
                        String defi = scan.nextLine();
                        if (defi.indexOf("|") != -1) {
                            String[] rowMean = defi.split("\\| ");
                            for(String s : rowMean) {
                                means.add(s.toLowerCase());
                            }
                        }
                        else {
                            means.add(defi.toLowerCase());
                        }

                        if (slangWordList.editMean(slag, means)) {
                            System.out.println("Sửa thành công");
                        }
                        else {
                            System.out.println("Sửa thất bại");
                        }
                    }

                    means.clear();
                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 6:
                {
                    System.out.println("\tXóa một slang word.");
                    System.out.print("Nhập vào slang word cần xóa: ");
                    slag = scan.nextLine();

                    while (!slangWordList.canFind(slag)) {
                        System.out.print("Nhập lại slang word cần xóa: ");
                        slag = scan.nextLine();
                    }

                    SlangWord delSlang = slangWordList.findFollowSlag(slag);
                    System.out.println("Slang word muốn xóa: ");
                    System.out.println(delSlang.show());

                    System.out.print("Bạn có muốn xóa slang word này ra khỏi danh sách? (Y/N): ");
                    String check = scan.nextLine();
                    if (check.equals("Y") || check.equals("y")) {
                        if (slangWordList.deleteSlag(delSlang.get_slag())) {
                            System.out.println("Xóa slang word thành công.");
                        }
                        else {
                            System.out.println("Xóa slang word thất bại.");
                        }
                    }
                    else {
                        System.out.println("Không xóa slang word khỏi danh sách");
                    }

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 7:
                {
                    System.out.println("\tReset sanh sách slang word gốc.");

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 8:
                {
                    System.out.println("\tRandom một slang word.");

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 9:
                {
                    System.out.println("\tĐố vui. Chọn definition cho slang word.");

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 10:
                {
                    System.out.println("\tĐố vui. Chọn slang word đúng với definition.");

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
    }

    private static void feature() {
        System.out.println("\t1. Tìm kiếm theo slang word.");
        System.out.println("\t2. Tìm kiếm theo definition.");
        System.out.println("\t3. Lịch sử tìm kiếm.");
        System.out.println("\t4. Thêm một slang word mới.");
        System.out.println("\t5. Sửa một slang word.");
        System.out.println("\t6. Xóa một slang word.");
        System.out.println("\t7. Reset sanh sách slang word gốc.");
        System.out.println("\t8. Random một slang word.");
        System.out.println("\t9. Đố vui. Chọn definition cho slang word.");
        System.out.println("\t10. Đố vui. Chọn slang word đúng với definition.");
        System.out.println("\t0. Thoát chương trình");
    }
}
