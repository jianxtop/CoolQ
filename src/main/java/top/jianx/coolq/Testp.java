package top.jianx.coolq;

import top.jianx.coolq.util.FileUtil;

public class Testp
{
    public static void main(String[] args) {
        String s = FileUtil.ReadFile("resources/LibraryDialogTemplate.json");
        System.out.println(s);
    }
}
