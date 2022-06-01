package core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="sales")
@Getter
@Setter
public class Sales {

    @Id
    //@Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Sales() {
    }

    public Sales(Integer id, int total, Date dateIn, Date dateOut) {
        this.id=id;
        this.total = total;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public Sales(int total, Date dateIn, Date dateOut) {
        this.total = total;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    @Column(name="total")
    private int total;

    @Column(name="datein")
    private Date dateIn;

    @Column(name="dateout")
    private Date dateOut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }



    @Override
    public String toString() {
        return "SalesPeriodJpa{" +
                "id=" + id +
                ", total=" + total +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }
}
