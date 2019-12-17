package top.jianx.coolq.service;

public interface CMService {
    /**
     * 通过masterQQ命令授权群号
     * @param groupQQ
     * @param QQ
     * @return
     */
    String toGrantAuth(String groupQQ, String QQ);
}
