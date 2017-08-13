package com.fi.jsondemo.bean;

import java.util.List;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/8/13 0013 21:35
 * 作用	      ${TODO}
 * <p/>
 * 版本       $$Rev$$
 * 更新者     $$Author$$
 * 更新时间   $$Date$$
 * 更新描述   ${TODO}
 */
public class FilmInfo {
    private int            code;
    private List<FilmBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<FilmBean> getList() {
        return list;
    }

    public void setList(List<FilmBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "FilmInfo{" +
                "code=" + code +
                ", list=" + list +
                '}';
    }

    public static class FilmBean{
        private String aid;
        private String author;
        private int coins;
        private String copyright;
        private String create;

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getCoins() {
            return coins;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCreate() {
            return create;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        @Override
        public String toString() {
            return "FilmBean{" +
                    "aid='" + aid + '\'' +
                    ", author='" + author + '\'' +
                    ", coins=" + coins +
                    ", copyright='" + copyright + '\'' +
                    ", create='" + create + '\'' +
                    '}';
        }
    }
}
