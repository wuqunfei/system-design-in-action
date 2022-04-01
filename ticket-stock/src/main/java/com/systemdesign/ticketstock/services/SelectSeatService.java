package com.systemdesign.ticketstock.services;

import com.atomikos.icatch.jta.UserTransactionImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SelectSeatService {

    private PaymentService paymentService;

    public SelectSeatService(PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @Transactional(rollbackFor = Exception.class)
    public void selectSeat(Integer row, Integer column, Long userId) {
        UserTransactionImp utx = new UserTransactionImp();
        boolean rollback = false;
        try {
            utx.begin();
            paymentService.pay();

        } catch (Exception exception) {
            rollback = true;
        } finally {
            if (rollback) {
                utx.rollback();
            } else {
                utx.commit();
            }
        }


    }
}

/***
 * Advantages of the Saga pattern
 * One big advantage of the Saga pattern is its support for long-lived transactions. Because each microservice focuses only on its own local atomic transaction, other microservices are not blocked if a microservice is running for a long time. This also allows transactions to continue waiting for user input. Also, because all local transactions are happening in parallel, there is no lock on any object.
 *
 * Disadvantages of the Saga pattern
 * The Saga pattern is difficult to debug, especially when many microservices are involved. Also, the event messages could become difficult to maintain if the system gets complex. Another disadvantage of the Saga pattern is it does not have read isolation. For example, the customer could see the order being created, but in the next second, the order is removed due to a compensation transaction.
 */
