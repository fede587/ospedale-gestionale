package ospedale_core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.repository.DottoreRepository;
import ospedale.ospedale_core.repository.RepartoRepository;
import ospedale.ospedale_core.service.DottoreService;

@Service
@Transactional
public class DottoreServiceImpl implements DottoreService {
	private final DottoreRepository dottori;
	private final RepartoRepository reparti;

	public DottoreServiceImpl(DottoreRepository dottori, RepartoRepository reparti) {
		this.dottori = dottori;
		this.reparti = reparti;
	}

	public List<Dottore> findAll() {
		return dottori.findAll();
	}

	public Optional<Dottore> findById(Long id) {
		return dottori.findById(id);
	}

	public Dottore save(Dottore dr) {
		return dottori.save(dr);
	}

	public void deleteById(Long id) {
		dottori.deleteById(id);
	}

	public List<Dottore> findByReparto(Long repartoId) {
		Reparto reparto = reparti.findById(repartoId).orElseThrow();
		return dottori.findByReparto(reparto);
	}
}
