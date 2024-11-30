package io.kr.inu.infra.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InputOutputS3Repository {
    private final AmazonS3 amazonS3;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public void insertTestCases(String name, MultipartDto multipartDto) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartDto.getFileSize());
        metadata.setContentType(multipartDto.getContentType());

        amazonS3.putObject(bucket, name, multipartDto.getInputStream(), metadata);
    }
}
