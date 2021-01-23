package pw.react.backend.model;

import com.sun.istack.NotNull;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "flats")
public class Flat implements Serializable
{
    private static final long serialVersionUID = -6783504532088859179L;

    public static Flat Empty;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int maxGuests;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false) @Enumerated(EnumType.STRING)

    private FlatType flatType;
    @NotNull @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "flat")
    @JsonBackReference
    private List<Booking> bookings;
}