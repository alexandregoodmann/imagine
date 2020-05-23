package br.com.goodmann.imagine.documento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goodmann.imagine.core.BaseController;

@RestController
@RequestMapping(value = "v1/pessoas/documentos")
public class DocumentoController extends BaseController<Documento, String> {

}
