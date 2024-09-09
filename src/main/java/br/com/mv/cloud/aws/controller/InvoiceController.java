package br.com.mv.cloud.aws.controller;

import br.com.mv.cloud.aws.model.Invoice;
import br.com.mv.cloud.aws.model.UrlResponse;
import br.com.mv.cloud.aws.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping()
    public ResponseEntity<Iterable<Invoice>> findAll() {
        Iterable<Invoice> response = invoiceService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/bycustomername")
    public ResponseEntity<Iterable<Invoice>> findByCustomerName(@RequestParam String customerName) {
        Iterable<Invoice> response = invoiceService.findAllByCustomerName(customerName);
        return ResponseEntity.ok(response);
    }
}
