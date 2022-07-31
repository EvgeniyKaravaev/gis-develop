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
@Table(name = "thermal_camera_assembly")
public class ThermalCameraAssembly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "camera")
    private String camera;

    @Column(name = "verch_block")
    private Integer verch_block;

    @Column(name = "niz_block")
    private Integer niz_block;

    @Column(name = "sredniy_block")
    private Integer sredniy_block;

    @Column(name = "sredniy_panel")
    private Integer sredniy_panel;

    @Column(name = "data_postroiki_camera")
    private Integer dataPostroikiCamera;

    @Column(name = "data_reconstruction_camera")
    private Integer dataReconstructionCamera;

//    @JsonSerialize(using = GeometrySerializer.class)
//    @JsonDeserialize(using = GeometryDeserializer.class)
//    @Column(name = "coordinate_thermal_camera_assembly", columnDefinition = "geometry")
//    private Point coordinateCamera;

    @Column(name = "coordinate_thermal_camera_assembly")
    private String coordinateCamera;

    @OneToMany(mappedBy = "thermalCameraAssembly")
    private List<Section> sections;

    public ThermalCameraAssembly(String camera, Integer verch_block, Integer niz_block, Integer sredniy_block, Integer sredniy_panel, Integer dataPostroikiCamera, Integer dataReconstructionCamera, String coordinateCamera) {
        this.camera = camera;
        this.verch_block = verch_block;
        this.niz_block = niz_block;
        this.sredniy_block = sredniy_block;
        this.sredniy_panel = sredniy_panel;
        this.dataPostroikiCamera = dataPostroikiCamera;
        this.dataReconstructionCamera = dataReconstructionCamera;
        this.coordinateCamera = coordinateCamera;
    }
}

