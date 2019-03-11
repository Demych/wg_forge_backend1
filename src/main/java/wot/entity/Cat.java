package wot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @NotNull
    private String name;

    @Column(name = "color")
    String color;

    @NotNull(message = "Возраст кота должен Zбыть")
    @Column(name = "tail_length")
    private int tailLength;

    @Column(name = "whiskers_length")
    private int whiskersLength;
    public Cat() {
    }

    public Cat(@NotNull String name, String color, @NotNull(message = "Возраст кота должен Zбыть") int tailLength, int whiskersLength) {
        this.name = name;
        this.color = color;
        this.tailLength = tailLength;
        this.whiskersLength = whiskersLength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWhiskersLength() {
        return whiskersLength;
    }

    public void setWhiskersLength(int whiskersLength) {
        this.whiskersLength = whiskersLength;
    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }
}
