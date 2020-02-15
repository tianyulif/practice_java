package net.easipay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private  static  String UPLOADED_FOLDER = "D://tmp//";

    @GetMapping("/")
    public String index(){
        return "upload/upload";
    }

    @GetMapping("/more")
    public String uploadMore() {
        return "upload/uploadMore";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "upload/uploadStatus";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "please select a upload file!");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "upload successfully!");
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:uploadStatus";
    }


}
