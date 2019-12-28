package com.schoen.hikingthrulife.services;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class S3Service {

    private AmazonS3 s3Client;

    public S3Service() {
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_WEST_2)
                .build();
    }

    public String getS3ObjectContent(String bucketName, String key) throws IOException {
        try (InputStream is = s3Client.getObject(new GetObjectRequest(bucketName, key)).getObjectContent()) {
            return StreamUtils.copyToString(is, StandardCharsets.UTF_8);
        }
    }
}
