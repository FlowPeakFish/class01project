package cn.fengyu.class01project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
public class Stu {
    private int id;
    private String name;

    private int age;

    public Stu(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;

        public Builder() {
            this.id = 0;
            this.name = "空";
            this.age = 18;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Stu build() {
            return new Stu(this.id, this.name, this.age);
        }
    }
}
