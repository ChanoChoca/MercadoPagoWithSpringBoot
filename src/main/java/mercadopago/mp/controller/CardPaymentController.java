package mercadopago.mp.controller;

import jakarta.validation.Valid;
import mercadopago.mp.dto.CardPaymentDTO;
import mercadopago.mp.dto.PaymentResponseDTO;
import mercadopago.mp.service.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process_payment")
public class CardPaymentController {
    private final CardPaymentService cardPaymentService;

    @Autowired
    public CardPaymentController(CardPaymentService cardPaymentService) {
        this.cardPaymentService = cardPaymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> processPayment(@RequestBody @Valid CardPaymentDTO cardPaymentDTO) {
        PaymentResponseDTO payment = cardPaymentService.processPayment(cardPaymentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
