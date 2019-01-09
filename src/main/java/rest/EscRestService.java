package rest;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import util.ReplaceDocx;

import java.io.*;

@RestController
@RequestMapping("/esc/donwload")
@Scope("request")
public class EscRestService {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile() throws IOException {

//        File file = new File("");
//
//        if (!file.exists()) {
//            String errorMessage = "Sorry. The file you are looking for does not exist";
//            System.out.println(errorMessage);
//            OutputStream outputStream = response.getOutputStream();
//            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
//            outputStream.close();
//            return;
//        }
//
//        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//        if (mimeType == null) {
//            System.out.println("mimetype is not detectable, will take default");
//            mimeType = "application/octet-stream";
//        }
//
//        response.setContentType(mimeType);
//        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
//        response.setContentLength((int) file.length());
//
//        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//
//        //Copy bytes from source to destination(outputstream in this example), closes both streams.
//        FileCopyUtils.copy(inputStream, response.getOutputStream());
//        ReplaceDocx.main();
    }
}

