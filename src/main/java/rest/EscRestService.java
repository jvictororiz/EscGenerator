package rest;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.TypeValue;
import util.ReplaceDocx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
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

    @RequestMapping(method = RequestMethod.POST)
    public HttpServletResponse downloadFile(HttpServletResponse response, @RequestBody EscDto escDto) throws Exception {
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

        String fileName = "teste.docx";
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        return response;
    }
}

