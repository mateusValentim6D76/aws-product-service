package br.com.mv.cloud.aws.controller;

import br.com.mv.cloud.aws.domain.UrlResponse;
import br.com.mv.cloud.aws.service.InvoiceService;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<UrlResponse> createInvoiceUrl() {
        try {
            UrlResponse url = invoiceService.createInvoiceUrl();
            return ResponseEntity.ok(url);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
