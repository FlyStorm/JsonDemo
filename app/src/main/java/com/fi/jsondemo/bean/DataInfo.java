package com.fi.jsondemo.bean;

import java.util.List;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/8/12 0012 14:27
 * 作用	      ${TODO}
 * <p/>
 * 版本       $$Rev$$
 * 更新者     $$Author$$
 * 更新时间   $$Date$$
 * 更新描述   ${TODO}
 */
public class DataInfo {

    /**
     * rs_code : 1000
     * rs_msg : success
     * data : {"count":5,"items":[{"id":45,"title":"坚果"},{"id":132,"title":"炒货"},{"id":166,"title":"蜜饯"},{"id":195,"title":"果脯"},{"id":196,"title":"礼盒"}]}
     */
    private String rs_code;
    private String     rs_msg;
    private DataEntity data;

    @Override
    public String toString() {
        return "DataInfo{" +
                "data=" + data +
                ", rs_code='" + rs_code + '\'' +
                ", rs_msg='" + rs_msg + '\'' +
                '}';
    }

    public void setRs_code(String rs_code) {
        this.rs_code = rs_code;
    }

    public void setRs_msg(String rs_msg) {
        this.rs_msg = rs_msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getRs_code() {
        return rs_code;
    }

    public String getRs_msg() {
        return rs_msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * count : 5
         * items : [{"id":45,"title":"坚果"},{"id":132,"title":"炒货"},{"id":166,"title":"蜜饯"},{"id":195,"title":"果脯"},{"id":196,"title":"礼盒"}]
         */
        private int count;
        private List<ItemsEntity> items;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "count=" + count +
                    ", items=" + items +
                    '}';
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setItems(List<ItemsEntity> items) {
            this.items = items;
        }

        public int getCount() {
            return count;
        }

        public List<ItemsEntity> getItems() {
            return items;
        }

        public static class ItemsEntity {
            /**
             * id : 45
             * title : 坚果
             */
            private int id;
            private String title;

            @Override
            public String toString() {
                return "ItemsEntity{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        '}';
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}
