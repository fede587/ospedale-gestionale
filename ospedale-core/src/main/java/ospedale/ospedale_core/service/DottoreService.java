package ospedale.ospedale_core.service;

import java.util.List;

import ospedale.ospedale_core.entità.Dottore;

interface DottoreService {
    List<Dottore> findAll();
    <Dottore> void findById(Long id);
    Dottore save(Dottore m);
    void deleteById(Long id);

}
