package br.com.mv.cloud.aws.service.impl;

import br.com.mv.cloud.aws.model.Invoice;
import br.com.mv.cloud.aws.model.UrlResponse;
import br.com.mv.cloud.aws.repository.InvoiceRepository;
import br.com.mv.cloud.aws.service.InvoiceService;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Value("${aws.s3.bucket.invoice.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 amazonS3;
    @Override
    public UrlResponse createInvoiceUrl() {
        UrlResponse urlResponse = new UrlResponse();
        Instant expiration = Instant.now().plus(Duration.ofMinutes(5));
        String processId = UUID.randomUUID().toString();

        GeneratePresignedUrlRequest generateS3PresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, processId)
                        .withMethod(HttpMethod.PUT)
                        .withExpiration(Date.from(expiration));

        urlResponse.setExpirationTime(expiration.getEpochSecond());
        urlResponse.setUrl(amazonS3.generatePresignedUrl(generateS3PresignedUrlRequest).toString());

        return urlResponse;
    }

    @Override
    public List<Invoice> findAllByCustomerName(String customerName) {
        return invoiceRepository.findAllByCustomerName(customerName);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }
}