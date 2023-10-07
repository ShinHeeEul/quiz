package com.example.quiz.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.quiz.Exception.NotFoundImageException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3UploadService {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String saveFile(MultipartFile multipartFile, String name) {

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        System.out.println("sdiofvk");
        try {
            amazonS3.putObject(bucket, name, multipartFile.getInputStream(), metadata);
        } catch(IOException e) {
            throw new NotFoundImageException(HttpStatus.BAD_REQUEST, 10000, "파일 이상");
        }
        System.out.println("dkfsj");
        String s = amazonS3.getUrl(bucket, name).toString();
        System.out.println("xkc");
        return s;

    }
}
