package ru.diplom.ispu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diplom.ispu.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {

    Iterable<Section> findByVidTeplonositel (String vidTeplonositel);

}
