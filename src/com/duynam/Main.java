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
                    means = slangWordList.findFollowSlag(slag);
                    if(means.isEmpty()) {
                        System.out.println("Không tìm thấy definition cho slang word");
                    }
                    else {
                        System.out.println("Definition: ");
                        for (String s : means) {
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

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 5:
                {
                    System.out.println("\tSửa một slang word.");

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 6:
                {
                    System.out.println("\tXóa một slang word.");

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
