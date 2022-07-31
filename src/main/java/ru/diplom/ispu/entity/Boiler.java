package ru.diplom.ispu.entity;


import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = "boiler")
public class Boiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rso")
    private String rso;

    @Column(name = "vid_resourсe")
    private String vidResourсe;

    @Column(name = "data_postroiki")
    private Integer dataPostroiki;

    @Column(name = "data_reconstruction")
    private Integer dataReconstruction;

//    @JsonSerialize(using = GeometrySerializer.class)
//    @JsonDeserialize(using = GeometryDeserializer.class)
//    @Column(name = "coordinate_boiler", columnDefinition = "geometry")
//    private Point coordinateBoiler;

    @Column(name = "coordinate_boiler")
    private String coordinateBoiler;

    @OneToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Boiler(String rso, String vidResourсe, Integer dataPostroiki, Integer dataReconstruction, String coordinateBoiler) {
        this.rso = rso;
        this.vidResourсe = vidResourсe;
        this.dataPostroiki = dataPostroiki;
        this.dataReconstruction = dataReconstruction;
        this.coordinateBoiler = coordinateBoiler;
    }
}
