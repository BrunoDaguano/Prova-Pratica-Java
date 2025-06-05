package catalago.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import catalago.com.service.PlataformaService;


@RestController
@RequestMapping("plataforma")
public class PlataformaController {
	
	@Autowired
	private PlataformaService plataformaService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Result> save(@RequestBody PlataformaForm formPlataforma) {
		var result = new Result();

		var res = getPlataformaService().Save(formPlataforma);
		result.getData().put("result", res);
		result.setSuccess(Boolean.TRUE);

		return ResponseEntity.ok(result);
	}
	
	private PlataformaService getPlataformaService() {
		return plataformaService;
	}

}
