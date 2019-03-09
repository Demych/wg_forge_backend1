package wot.entity;

import javax.persistence.Table;

@Table(name = "cat_color")
public enum CatColor {
    black,
    white;

    CatColor() {
    }
}
