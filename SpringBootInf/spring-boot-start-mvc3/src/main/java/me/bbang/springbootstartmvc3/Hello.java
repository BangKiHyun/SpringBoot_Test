package me.bbang.springbootstartmvc3;

public class Hello {

    @Override
    public String toString() {
        return "Hello{" +
                "prefix='" + prefix + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private String prefix;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
