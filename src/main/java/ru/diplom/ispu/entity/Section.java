package ru.diplom.ispu.entity;



import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_section")
    private String startSection;

    @Column(name = "finish_section")
    private String finishSection;

    @Column(name = "length_section")
    private Integer lengthSection;

    @Column(name = "iznos_section")
    private Integer iznosSection;

    @Column(name = "diameter_trub")
    private Integer diameterTrub;

    @Column(name = "vid_teplonositel")
    private String vidTeplonositel;

    @Column(name = "data_postroiki")
    private Integer dataPostroiki;

    @Column(name = "data_reconstruction")
    private Integer dataReconstruction;

    @Column(name = "tip_truboprovoda")
    private String tipTruboprovoda;

//    @JsonSerialize(using = GeometrySerializer.class)
//    @JsonDeserialize(using = GeometryDeserializer.class)
//    @Column(name = "coordinate_section", columnDefinition = "geometry")
//    private Point coordinateSection;

    @Column(name = "coordinate_section")
    private String coordinateSection;

    @OneToOne(mappedBy = "section")
    private Potrebitel potrebitels;

    @OneToOne(mappedBy = "section")
    private Boiler boiler;

    @ManyToOne
    @JoinColumn(name = "thermalCameraAssembly_id")
    private ThermalCameraAssembly thermalCameraAssembly;

    public Section(String startSection, String finishSection, Integer lengthSection, Integer iznosSection, Integer diameterTrub, String vidTeplonositel, Integer dataPostroiki, Integer dataReconstruction, String tipTruboprovoda, String coordinateSection) {
        this.startSection = startSection;
        this.finishSection = finishSection;
        this.lengthSection = lengthSection;
        this.iznosSection = iznosSection;
        this.diameterTrub = diameterTrub;
        this.vidTeplonositel = vidTeplonositel;
        this.dataPostroiki = dataPostroiki;
        this.dataReconstruction = dataReconstruction;
        this.tipTruboprovoda = tipTruboprovoda;
        this.coordinateSection = coordinateSection;
    }
}
