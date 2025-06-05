package catalago.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import catalago.com.controller.PlataformaForm;
import catalago.com.entity.Plataforma;
import catalago.com.repository.PlataformaDAO;

@Service
public class PlataformaService {
	
	@Autowired
	private PlataformaDAO plataformaDAO;
	
	public Plataforma Save(PlataformaForm form) {
				
		Plataforma entity = null;
		
		if(form.getId() == null) {
			entity = new Plataforma();
		}else {
			entity = getPlataformaDAO().getById(form.getId());
		}
		
		entity.setNome(form.getName());
		entity.setDescricao(form.getDescription());
		entity.setPaisOrigem(form.getCountryOrigin());
		entity.setUrl(form.getUrl());
		
		getPlataformaDAO().save(entity);
		
		return entity;
		
	}
	
	private PlataformaDAO getPlataformaDAO() {
		return this.plataformaDAO;
	}

}
