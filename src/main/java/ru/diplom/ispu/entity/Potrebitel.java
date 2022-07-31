package ru.diplom.ispu.entity;


import lombok.*;


import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = "potrebitel")
public class Potrebitel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number_dom")
    private String numberDom;

//    @Column(name = "coordinate_potrebitel", columnDefinition = "geometry")
//    private Point coordinatepotrebitel;

    @Column(name = "coordinate_potrebitel")
    private String coordinatepotrebitel;

    @OneToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Potrebitel(String street, String numberDom, String coordinatepotrebitel) {
        this.street = street;
        this.numberDom = numberDom;
        this.coordinatepotrebitel = coordinatepotrebitel;
    }
}
