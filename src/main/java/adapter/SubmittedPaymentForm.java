package adapter;

public class SubmittedPaymentForm implements PaymentForm {

    private Payment payment;

    private PaymentFormUI paymentFormUI;

    public SubmittedPaymentForm(Payment payment, PaymentFormUI paymentFormUI) {
        this.payment = payment;
        this.paymentFormUI = paymentFormUI;
    }

    @Override
    public Payment getBooking() {
        return payment;
    }

    @Override
    public PaymentFormUI getFormUI() {
        return paymentFormUI;
    }
}
