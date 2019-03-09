package wot.entity;

import javax.persistence.*;

@Entity
@Table(name = "cats_stat")
public class CatsStat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    @Column(name = "tail_length_mean")
    float tailLengthMean;

    @Column(name = "tail_length_median")
    float tailLengthMedian;

    @Column(name = "whiskers_length_mean")
    float whiskersLengthMean;

    @Column(name = "whiskers_length_median")
    float whiskersLengthMedian;
    public CatsStat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTailLengthMean() {
        return tailLengthMean;
    }

    public void setTailLengthMean(float tailLengthMean) {
        this.tailLengthMean = tailLengthMean;
    }

    public float getTailLengthMedian() {
        return tailLengthMedian;
    }

    public void setTailLengthMedian(float tailLengthMedian) {
        this.tailLengthMedian = tailLengthMedian;
    }

    public float getWhiskersLengthMean() {
        return whiskersLengthMean;
    }

    public void setWhiskersLengthMean(float whiskersLengthMean) {
        this.whiskersLengthMean = whiskersLengthMean;
    }

    public float getWhiskersLengthMedian() {
        return whiskersLengthMedian;
    }

    public void setWhiskersLengthMedian(float whiskersLengthMedian) {
        this.whiskersLengthMedian = whiskersLengthMedian;
    }

    public CatsStat(float tailLengthMean, float tailLengthMedian, float whiskersLengthMean, float whiskersLengthMedian) {
        this.tailLengthMean = tailLengthMean;
        this.tailLengthMedian = tailLengthMedian;
        this.whiskersLengthMean = whiskersLengthMean;
        this.whiskersLengthMedian = whiskersLengthMedian;
    }
}
