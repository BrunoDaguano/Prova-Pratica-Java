package catalago.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalago.com.controller.MidiaForm;
import catalago.com.entity.Midia;
import catalago.com.repository.MidiaDAO;
import exception.DataLancamentoInvalida;
import exception.MidiaNaoEncontrado;

@Service
public class MidiaService {

	@Autowired
	private MidiaDAO midiaDAO;

	public Midia save(MidiaForm form) throws DataLancamentoInvalida {

		if (form.getDataLancamento().after(new Date())) {
			throw new DataLancamentoInvalida("A data de lancamento está em um dia futuro");
		}

		Midia entity = null;

		if (form.getId() == null) {
			entity = new Midia();
		} else {
			entity = getMidiaDAO().getById(form.getId());
		}

		entity.setTitulo(form.getTitulo());
		entity.setDataLancamento(form.getDataLancamento());
		entity.setDescricao(form.getDescricao());
		entity.setGenero(form.getGenero());
		entity.setClassificacao(form.getClassificacao());
		entity.setNota(form.getNota());
		entity.setDuracao(entity.getDuracao());
		entity.setDiretor(entity.getDiretor());
		entity.setAtores(entity.getAtores());
		entity.setPlataforma(entity.getPlataforma());

		getMidiaDAO().save(entity);
		
		return entity;
	}
	
	public Midia getById(Integer id) throws MidiaNaoEncontrado {
	    return getMidiaDAO().findById(id)
	            .orElseThrow(() -> new MidiaNaoEncontrado("Filme/Serie não encontrado com ID: " + id));
	}

	public void deleteById(Integer id) throws MidiaNaoEncontrado {
	    if (!getMidiaDAO().existsById(id)) {
	        throw new MidiaNaoEncontrado("Filme/Serie não encontrado com ID: " + id);
	    }
	    getMidiaDAO().deleteById(id);
	}

	private MidiaDAO getMidiaDAO() {
		return this.midiaDAO;
	}

}
