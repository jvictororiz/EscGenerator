package rest;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.TypeValue;
import util.ReplaceDocx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/esc")
@Scope("request")
public class EscRestService {

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public ResponseEntity serverVersion(final HttpServletRequest httpServletRequest) {
        return new ResponseEntity("joao v", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpServletResponse downloadFile(HttpServletResponse response) throws Exception {

        EscDto escDto = new EscDto();
        escDto.setTitle("Teste nome");
        escDto.setModule("Nome do modulo");
        escDto.setObjctive("Nome do objetivo");
        escDto.setConteudo("Joao victor aqui e o conteudo entao pode dizer exatamente o que esta acontecendo porque eu ja estou ficando preocupado com voce /n/n/n/n/n/n/n/naqui quebre a linha");

        List<TypeValue> keys = new ArrayList<>();
        keys.add(new TypeValue(escDto.getTitle()));
        keys.add(new TypeValue(escDto.getModule()));
        keys.add(new TypeValue(escDto.getObjctive()));
        keys.add(new TypeValue(TypeValue.TIPO_TEXT, escDto.getConteudo()));
        XWPFDocument xwpfDocument = ReplaceDocx.donwloadEscCompleted(keys);
        OutputStream os = response.getOutputStream();
        if (xwpfDocument != null) {
            xwpfDocument.write(os);
        } else {
            throw new Exception("Nao foi possivel iniciar o download");
        }

        response.setContentType("application/doc");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "teste.docx" + "\"");
//        response.setHeader("Content-Disposition", "Attachment;filename=teste.docx");

        return response;
    }
}

