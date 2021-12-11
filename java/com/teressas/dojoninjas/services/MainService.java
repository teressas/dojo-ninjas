package com.teressas.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.dojoninjas.models.Dojo;
import com.teressas.dojoninjas.models.Ninja;
import com.teressas.dojoninjas.repositories.DojoRepository;
import com.teressas.dojoninjas.repositories.NinjaRepository;

@Service
public class MainService {
	
	// OPTION 1
//	private DojoRepository dojoRepo;
//	private NinjaRepository ninjaRepo;
//	
//	public MainService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
//		this.dojoRepo = dojoRepo;
//		this.ninjaRepo = ninjaRepo;
//	}
	
	// OPTION 2
	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Dojo findOneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
