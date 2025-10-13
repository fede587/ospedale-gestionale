package ospedale_core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.repository.RepartoRepository;
import ospedale.ospedale_core.service.RepartoService;

@Service
@Transactional
public class RepartoServiceImpl implements RepartoService {
	private final RepartoRepository repository;

	public RepartoServiceImpl(RepartoRepository repo) {
		this.repository = repo;
	}

	public List<Reparto> findAll() {
		return repository.findAll();
	}

	public Optional<Reparto> findById(Long id) {
		return repository.findById(id);
	}

	public Reparto save(Reparto r) {
		return repository.save(r);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
