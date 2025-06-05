package catalago.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import catalago.com.entity.Midia;
import catalago.com.service.MidiaService;
import catalago.com.service.PlataformaService;
import exception.DataLancamentoInvalida;
import exception.MidiaNaoEncontrado;

@RestController
@RequestMapping("midia")
public class MidiaController {

	@Autowired
	private MidiaService midiaService;

	@Autowired
	private PlataformaService plataformaService;

	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<Result> save(@RequestBody MidiaForm formPlataforma)
			throws DataLancamentoInvalida {
		var result = new Result();

		try {

			var res = getMidiaService().save(formPlataforma);
			result.getData().put("result", res);
			result.setSuccess(Boolean.TRUE);

		} catch (DataLancamentoInvalida e) {
			result.setMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
		}

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getById/{id}")
	public @ResponseBody ResponseEntity<Result> getById(@PathVariable("id") Integer id) throws MidiaNaoEncontrado {
		var result = new Result();

		try {
			Midia midia = getMidiaService().getById(id);
			result.getData().put("result", midia);
			result.setSuccess(Boolean.TRUE);

		} catch (MidiaNaoEncontrado e) {
			result.setMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
		}
		
		return ResponseEntity.ok(result);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Result> deleteById(@PathVariable("id") Integer id) throws MidiaNaoEncontrado {
		
		var result = new Result();

		try {
			getMidiaService().deleteById(id);
			result.setSuccess(Boolean.TRUE);

		} catch (MidiaNaoEncontrado e) {
			result.setMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
		}
		
		return ResponseEntity.ok(result);
	}

	private MidiaService getMidiaService() {
		return midiaService;
	}

	private PlataformaService getPlataformaService() {
		return plataformaService;
	}
}
