package com.example.writeagain.controller;


import com.example.writeagain.utils.Download;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
public class DownloadController {

    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Download.downloadFile(request, response);
    }

}
